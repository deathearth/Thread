package com.chl.office;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;

/**
*
*
* @author By chl
* @date 2020年9月8日-下午4:57:14
*/
public class OfficeSpire {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Document document = new Document();
        document.loadFromFile("C:\\Users\\MST-KKL\\Desktop\\origion.docx", FileFormat.Docx);

        //保存结果文件
        document.saveToFile("C:\\Users\\MST-KKL\\Desktop\\spire.pdf", FileFormat.PDF);
	}

}
