package com.mst;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;

import org.freehep.graphicsio.emf.EMFInputStream;
import org.freehep.graphicsio.emf.EMFRenderer;

public class EmfToPng {
	
	public static void main(String[] args) {
		File f = new File("C:\\Users\\MST-KKL\\Desktop\\image50.emf");
		String s = "C:\\Users\\MST-KKL\\Desktop\\image50.png";
		try {
		FileInputStream fis = new FileInputStream(f);
		byte[] data = emfToPng(fis);
		
		FileImageOutputStream imageOutput = new FileImageOutputStream(new File(s));
	      imageOutput.write(data, 0, data.length);
	      imageOutput.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static byte[] emfToPng(InputStream is) {
		// InputStream inputStream=null;
		byte[] by = null;
		EMFInputStream emf = null;
		EMFRenderer emfRenderer = null;
		// 创建储存图片二进制流的输出流
		ByteArrayOutputStream baos = null;
		// 创建ImageOutputStream流
		ImageOutputStream imageOutputStream = null;
		try {
			emf = new EMFInputStream(is, EMFInputStream.DEFAULT_VERSION);
			emfRenderer = new EMFRenderer(emf);
			final int width = (int) emf.readHeader().getBounds().getWidth();
			final int height = (int) emf.readHeader().getBounds().getHeight();
			final BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = (Graphics2D) result.createGraphics();
			emfRenderer.paint(g2);

			// 创建储存图片二进制流的输出流
			baos = new ByteArrayOutputStream();
			// 创建ImageOutputStream流
			imageOutputStream = ImageIO.createImageOutputStream(baos);
			// 将二进制数据写进ByteArrayOutputStream
			ImageIO.write(result, "png", imageOutputStream);
			// inputStream = new ByteArrayInputStream(baos.toByteArray());
			by = baos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (imageOutputStream != null) {
					imageOutputStream.close();
				}
				if (baos != null) {
					baos.close();
				}
				if (emfRenderer != null) {
					emfRenderer.closeFigure();
				}
				if (emf != null) {
					emf.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return by;
	}
}
