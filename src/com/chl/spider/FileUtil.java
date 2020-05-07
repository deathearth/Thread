package com.chl.spider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

import javax.imageio.stream.ImageInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.BASE64Decoder;

@SuppressWarnings("restriction")
public class FileUtil {

  private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

  // base64字符串转化成图片
  public static boolean generateImage(String imgStr, String targetPath) { // 对字节数组字符串进行Base64解码并生成图片
    if (imgStr == null) // 图像数据为空
      return false;
    BASE64Decoder decoder = new BASE64Decoder();
    try {
      // Base64解码
      byte[] b = decoder.decodeBuffer(imgStr);
      for (int i = 0; i < b.length; ++i) {
        if (b[i] < 0) {// 调整异常数据
          b[i] += 256;
        }
      }
      // 生成jpeg图片
      OutputStream out = new FileOutputStream(targetPath);
      out.write(b);
      out.flush();
      out.close();
      return true;
    } catch (Exception e) {
      return false;
    }
  }

//  public static String saveRandomImagePath(String base64) {
//    String deskPath = config.getCrawlerOutputPath();
//    String imagePath = deskPath + UUID.randomUUID().toString().replace("-", "") + ".gif";
//    generateImage(base64, imagePath);
//    return imagePath;
//  }

  public static void deleteFile(String filePath) {
    File file = new File(filePath);
    file.delete();
  }

  /**
   * 传入要下载的图片的url，将url所对应的图片下载到本地
   * 
   * @param urlList
   */
  public static void downloadPicture(String urlStr, String filePath, String cookie) {
    URL url = null;
    try {
      url = new URL(urlStr);
      URLConnection conn = url.openConnection();
      conn.setRequestProperty("Cookie", cookie);
      conn.setRequestProperty("User-Agent",
          "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36\")");
      InputStream dataInputStream = conn.getInputStream();
      File f = new File(filePath);
//      if(!f.exists()) {
        FileOutputStream fileOutputStream = new FileOutputStream(f);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = dataInputStream.read(buffer)) > 0) {
          fileOutputStream.write(buffer, 0, length);
        }
        dataInputStream.close();
        fileOutputStream.close();
//      }
    } catch (Exception e) {
      logger.error("Download picture error!");
    }
  }
  
	/**
	 * 下载图片至本地
	 * @param dataInputStream
	 * @param filePath
	 * @param cookie
	 */
	public static void downloadPicture(ImageInputStream dataInputStream, String filePath, String cookie) {
		URL url = null;
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
			
			byte[] buffer = new byte[1024];
			int length;
			while ((length = dataInputStream.read(buffer)) > 0) {
				fileOutputStream.write(buffer, 0, length);
			}
			dataInputStream.close();
			fileOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
