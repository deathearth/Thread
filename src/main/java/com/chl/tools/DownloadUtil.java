package com.chl.tools;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * 下载文件工具类
 * @author chenhailong
 * @date 2019年7月16日 下午1:25:53 
 */
public class DownloadUtil {

//  private static final Logger logger = LoggerFactory.getLogger(DownloadUtil.class);

  /**基础目录, 使用时请多加一层文件夹,baseDir + 业务目录。防止重名，覆盖等异常 */
  public static final String baseDir = System.getProperty("user.dir");
  
  
  /**
   * 下载PDF文件
   * @param fileUrl  网络文件地址
   * @param localDir 本地目录
   * @return
   */
  public static String downLoadPDF(String fileUrl,String localDir) {
    return downLoadFile(fileUrl,localDir,"pdf");
  }
  
  /**
   * 下载DOC文件
   * @param fileUrl  网络文件地址
   * @param localDir 本地目录
   * @return
   */
  public static String downLoadDOC(String fileUrl,String localDir) {
    return downLoadFile(fileUrl,localDir,"doc");
  }
  
  /**
   * 下载DOCX文件
   * @param fileUrl  网络文件地址
   * @param localDir 本地目录
   * @return
   */
  public static String downLoadDOCX(String fileUrl,String localDir) {
    return downLoadFile(fileUrl,localDir,"docx");
  }
  
  /**
   * 下载XLS文件
   * @param fileUrl  网络文件地址
   * @param localDir 本地目录
   * @return
   */
  public static String downLoadXLS(String fileUrl,String localDir) {
    return downLoadFile(fileUrl,localDir,"xls");
  }
  
  /**
   * 下载XLSX文件
   * @param fileUrl  网络文件地址
   * @param localDir 本地目录
   * @return
   */
  public static String downLoadXLSX(String fileUrl,String localDir) {
    return downLoadFile(fileUrl,localDir,"xlsx");
  }
  
  
  /**
   * 根据文件的网络url地址进行下载，并返回下载后的本地地址
   * 这里重命名取  System.currentTimeMillis() + "." + suffix
   * @param fileUrl 文件的url地址
   * @param localDir 下载到的本地目录地址
   * @param 
   * @return
   */
  public static String downLoadFile(String fileUrl,String localDir, String suffix) {
    String localPath = "";
    FileOutputStream fos = null;
    InputStream is = null;
    try {
      URL url = new URL(fileUrl);
      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
      conn.setConnectTimeout(3*1000);//设置超时间为3秒
      
      //文件保存位置创建对应目录
      File saveDir = new File(localDir);
      if(!saveDir.exists()){
          saveDir.mkdir();
      }
      //读取文件流信息
      is = conn.getInputStream();
      byte[] bys = readInputStream(is);
      //拼接本地地址
      String fileName = System.currentTimeMillis() + "." + suffix;
      localPath = localDir + File.separator + fileName;
      //输出文件
      File file = new File(localPath);
      fos = new FileOutputStream(file);
      fos.write(bys);
    }catch (MalformedURLException e1) {
//      logger.error("合同文件下载失败!,{}",e1);
      e1.printStackTrace();
    } catch (IOException e) {
//      logger.error("合同文件下载失败!,{}",e);
      e.printStackTrace();
    }finally {
      try {
        if(fos != null) {
          fos.close();
        }
        if(is != null) {
          is.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return localPath;
  }
  
  
  /**
   * 从输入流中获取字节数组
   * @param inputStream
   * @return
   * @throws IOException
   */
  public static  byte[] readInputStream(InputStream inputStream) throws IOException {
      byte[] buffer = new byte[4096];
      int len = 0;
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      while((len = inputStream.read(buffer)) != -1) {
          bos.write(buffer, 0, len);
      }
      bos.close();
      return bos.toByteArray();
  }
}
