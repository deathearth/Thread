package com.chl.office;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;

import com.artofsolving.jodconverter.DefaultDocumentFormatRegistry;
import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.DocumentFormat;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.sun.star.io.ConnectException;

/**
*
*
* @author By chl
* @date 2020年9月8日-下午3:59:48
*/
class OfficeOpenOffice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 /**
     * 把ppt word excel等文件生成图片文件
     * @param docPath 文件路径
     * @param imgDirPath 图片保存文件夹
     * @param fileName 文件名称点的前部分
     */
    public static void doc2Imags(String docPath, String imgDirPath,String fileName){
        String pdfPath =String.format("%s%s.pdf",  FilenameUtils.getFullPath(docPath), FilenameUtils.getBaseName(docPath));
        try {
            doc2Pdf(docPath, pdfPath);
            pdf2Imgs(pdfPath, imgDirPath,fileName);
            File pdf =  new File(pdfPath);
            if(pdf.isFile()){
                pdf.delete();
            }

        } catch (ConnectException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void doc2Pdf(String docPath, String pdfPath) throws ConnectException {
        File inputFile = new File(docPath);
        File outputFile = new File(pdfPath);
        OpenOfficeConnection connection = startOpenOffice();
        try {
			connection.connect();
		} catch (java.net.ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
        //converter.convert(inputFile, outputFile);
        DefaultDocumentFormatRegistry formatReg = new DefaultDocumentFormatRegistry();   
        DocumentFormat txt = formatReg.getFormatByFileExtension("odt") ;
        DocumentFormat pdf = formatReg.getFormatByFileExtension("pdf") ;
        converter.convert(inputFile, txt, outputFile, pdf);
        connection.disconnect();
    }
    
    private static OpenOfficeConnection startOpenOffice(){
        //openOfficePath="C:\\Program Files (x86)\\OpenOffice 4\\program\\soffice.exe"

        //opt/openoffice4/program/soffice -headless -accept="socket,host=127.0.0.1,port=8100;urp;" -nofirststartwizard &

       //ip=127.0.0.1

        //port=8100
        //OpenOffice的安装目录，linux环境下需要手动启动openoffice服务
        String OpenOffice_HOME = PropertiesUtil.getOpenOfficeParam("openOfficePath");
        String OpenOffice_IP = PropertiesUtil.getOpenOfficeParam("ip");
        int OpenOffice_Port = Integer.parseInt(PropertiesUtil.getOpenOfficeParam("port"));
        // 启动OpenOffice的服务
        String command = OpenOffice_HOME+ " -headless -accept=\"socket,host="+OpenOffice_IP+",port="+OpenOffice_Port+";urp;\"";
        try {
            Process pro = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建连接
        OpenOfficeConnection connection = new SocketOpenOfficeConnection(OpenOffice_IP, OpenOffice_Port);
        return connection;
    }
}
