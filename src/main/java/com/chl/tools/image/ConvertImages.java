package com.chl.tools.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 灰度化，二值化图片
 * 
 * @author chenhailong 参考：https://blog.csdn.net/lazy_p/article/details/7165999
 */
public class ConvertImages {

	public static void main(String[] args) {
		String path = "/Users/chenhailong/Desktop/h.png";

		try {
			binaryImage(path);
			grayImage(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 二值化图片
	 * 二值图像是指在图像中，灰度等级只有两种，也就是说，图像中的任何像素点的灰度值均为0或者255，分别代表黑色和白色。
	 * @param path
	 * @throws IOException
	 */
	public static void binaryImage(String path) throws IOException {
		File file = new File(path);
		String[] fileInfo = path.split("\\.");
		BufferedImage image = ImageIO.read(file);
		int width = image.getWidth();
		int height = image.getHeight();
		BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);// 重点，技巧在这个参数BufferedImage.TYPE_BYTE_BINARY
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int rgb = image.getRGB(i, j);
				grayImage.setRGB(i, j, rgb);
			}
		}
		File newFile = new File(fileInfo[0]+"-binary."+fileInfo[1]);
		ImageIO.write(grayImage, "jpg", newFile);
	}

	/**
	 * 灰度化图片
	 * 使用黑色调表示物体，即用黑色为基准色，不同的饱和度的黑色来显示图像。
	 * @param path
	 * @throws IOException
	 */
	public static void grayImage(String path) throws IOException {
		File file = new File(path);
		String[] fileInfo = path.split("\\.");
		BufferedImage image = ImageIO.read(file);
		int width = image.getWidth();
		int height = image.getHeight();
		BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);// 重点，技巧在这个参数BufferedImage.TYPE_BYTE_GRAY
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int rgb = image.getRGB(i, j);
				grayImage.setRGB(i, j, rgb);
			}
		}
		File newFile = new File(fileInfo[0]+"-grey."+fileInfo[1]);
		ImageIO.write(grayImage, "jpg", newFile);
	}

}
