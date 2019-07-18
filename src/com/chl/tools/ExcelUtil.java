package com.chl.tools;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;

import com.sojourn.common.DateUtil;
import com.sojourn.exception.BizException;

/**
 * Excel工具整理
 * @author chenhailong
 *
 */
public class ExcelUtil {

    private ExcelUtil() {

    }

    /**
     * 构建Excel并写入HttpResponse
     *
     * @param response  HttpServletResponse
     * @param fileName  文件名
     * @param sheetName Excel sheet名
     * @param head      Excel头（第一行，可传空）
     * @param list      正文list，一行/条记录为一个小list
     */
    public static void buildExcel(HttpServletResponse response, String fileName, String sheetName,
                                  List<String> head, List<List<Object>> list) {

        // 写入HttpResponse
        try {
            byte[] bytes = buildExcelToByte(sheetName, head, list);
            response.setContentType("application/x-excel;charset=utf-8");
            response.setContentLength(bytes.length);
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.getOutputStream().write(bytes);
        } catch (Exception e) {
            throw new BizException("构建Excel失败！");
        }
    }

    /**
     * 构建Excel
     *
     * @param sheetName Excel sheet名
     * @param head      Excel头（第一行，可传空）
     * @param list      正文list，一行/条记录为一个小list
     * @return byte[]
     */
    public static byte[] buildExcelToByte(String sheetName, List<String> head,
                                          List<List<Object>> list) {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet(sheetName);
        XSSFRow row = sheet.createRow(0);
        XSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);

        // 设置表头
        if (head != null) {
            XSSFCell cell = null;
            for (int i = 0; i < head.size(); i++) {
                cell = row.createCell(i);
                cell.setCellValue(head.get(i));
                cell.setCellStyle(style);
            }
        }

        // 拼装excel内容
        List<Object> record = null;
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow(i + 1);
            record = list.get(i);
            for (int j = 0; j < record.size(); j++) {
                insertCell(row, j, record.get(j));
            }
        }
        // 设置列宽度自适应
        int rowNum = list.get(0).size();
        for (int i = 0; i < rowNum; i++)
            sheet.autoSizeColumn(i);

        try {
            wb.write(out);
            out.close();
        } catch (IOException e) {
            throw new BizException("构建Excel失败！");
        }
        return out.toByteArray();
    }

    /**
     * 插入数据
     */
    private static void insertCell(XSSFRow row, int i, Object obj) {

        String param;
        if (obj == null) {
            param = "";
        } else if (obj instanceof Date) {
            param = DateUtil.format((Date) obj, DateUtil.YYYYMMDD);
        } else {
            param = obj.toString();
        }
        row.createCell(i).setCellValue(param);
    }

    @SuppressWarnings({"resource", "unused"})
    public static List<Map<String, Object>> readExcelData(String dataPath) throws IOException {
        //读取xlsx文件
        XSSFWorkbook xssfWorkbook = null;
        //寻找目录读取文件
        File excelFile = new File(dataPath);
        InputStream is = new FileInputStream(excelFile);
        xssfWorkbook = new XSSFWorkbook(is);

        if (xssfWorkbook == null) {
            return null;
        }

//        ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
        List<Map<String, Object>> ans = new ArrayList<>();
        XSSFRow xssTitle = null;
        //遍历xlsx中的sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // 对于每个sheet，读取其中的每一行
            for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (0 == rowNum) {
                    xssTitle = xssfRow;
                    continue;
                }
                Map<String, Object> cloumnMap = new HashMap<>();
                if (xssfRow == null) {
                    continue;
                }
                for (int columnNum = 0; columnNum < xssfRow.getLastCellNum(); columnNum++) {
                    XSSFCell cell = xssfRow.getCell(columnNum);
                    cloumnMap.put(xssTitle.getCell(columnNum).toString(), Trim_str(getValue(cell)));
                }
                ans.add(cloumnMap);
            }
        }
        return ans;
    }

    @SuppressWarnings("resource")
    public static void writer(String path, List<Map<String, Object>> list, List<String> titleRow) throws IOException {
        Workbook wb = null;
//        String excelPath = path + File.separator + fileName + "." + fileType;
        File file = new File(path);
        // 获取文件类型
//        String fileType = Magic.getMagicMatch(file, false).getMimeType();
        String fileType = path.substring(path.lastIndexOf(".") + 1);
        Sheet sheet = null;
        //创建工作文档对象
        if (!file.exists()) {
            if (fileType.equals("xls")) {
                wb = new HSSFWorkbook();
            } else if (fileType.equals("xlsx")) {
                wb = new XSSFWorkbook();
            } else {
                throw new BizException("文件格式不正确");
            }
            //创建sheet对象
            sheet = (Sheet) wb.createSheet("sheet1");
            OutputStream outputStream = new FileOutputStream(path);
            wb.write(outputStream);
            outputStream.flush();
            outputStream.close();

        } else {
            if (fileType.equals("xls")) {
                wb = new HSSFWorkbook();
            } else if (fileType.equals("xlsx")) {
                InputStream is = new FileInputStream(path);
                wb = new XSSFWorkbook(is);
                is.close();
            } else {
                throw new BizException("文件格式不正确");
            }
        }
        //创建sheet对象
        if (sheet == null) {
            Sheet processing = wb.getSheet("processing");
            if (null == processing) {
                sheet = (Sheet) wb.createSheet("processing");
            } else {
                sheet = processing;
            }
        }

        /**
         * 设置标题
         */
        Row row = sheet.createRow(0);
        for (int i = 0; i < titleRow.size(); i++) {
            row.createCell(i).setCellValue(titleRow.get(i));
        }
        int dataNum = 0;
        for (Map<String, Object> map : list) {
            dataNum++;
            row = sheet.createRow(dataNum);
            for (int i = 0; i < titleRow.size(); i++) {
                row.createCell(i).setCellValue(String.valueOf(map.get(titleRow.get(i))));
            }
        }



        //创建文件流
        OutputStream stream = new FileOutputStream(path);
        //写入数据
        wb.write(stream);
        //关闭文件流
        stream.close();
    }


    //判断后缀为xlsx的excel文件的数据类
    @SuppressWarnings("deprecation")
    private static String getValue(XSSFCell xssfRow) {
        if (xssfRow == null) {
            return "---";
        }
        if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfRow.getBooleanCellValue());
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
            double cur = xssfRow.getNumericCellValue();
            long longVal = Math.round(cur);
            Object inputValue = null;
            if (Double.parseDouble(longVal + ".0") == cur)
                inputValue = longVal;
            else
                inputValue = cur;
            return String.valueOf(inputValue);
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BLANK || xssfRow.getCellType() == xssfRow.CELL_TYPE_ERROR) {
            return "---";
        } else {
            return String.valueOf(xssfRow.getStringCellValue());
        }
    }

    //判断后缀为xls的excel文件的数据类型
    @SuppressWarnings("deprecation")
    private static String getValue(HSSFCell hssfCell) {
        if (hssfCell == null) {
            return "---";
        }
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            double cur = hssfCell.getNumericCellValue();
            long longVal = Math.round(cur);
            Object inputValue = null;
            if (Double.parseDouble(longVal + ".0") == cur)
                inputValue = longVal;
            else
                inputValue = cur;
            return String.valueOf(inputValue);
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BLANK || hssfCell.getCellType() == hssfCell.CELL_TYPE_ERROR) {
            return "---";
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }

    //字符串修剪  去除所有空白符号 ， 问号 ， 中文空格
    static private String Trim_str(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll("[\\s\\?]", "").replace("　", "");
    }
}
