package com.boot.wego.util.excel;

import com.boot.wego.util.excel.eventmode.Excel2003Reader;
import com.boot.wego.util.excel.eventmode.Excel2007Reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author YanC
 * @description Excel处理类
 * @date 2019/7/29
 */
public class DealExcel {

    /**
     * excel2003扩展名
     */
    public static final String EXCEL03_EXTENSION = ".xls";

    /**
     * excel2007扩展名
     */
    public static final String EXCEL07_EXTENSION = ".xlsx";

    /**
     * 解析EXCEL数据为 List<String[]>
     *
     * @param excelFile 要解析的上传EXCEL文件
     * @return List<String [ ] ) 行 （ 列 ）
     */
    public static List<String[]> getExcelData07(File excelFile) throws Exception {
        List<String[]> resultList = null;

        if (null == excelFile || !excelFile.exists()) {
            throw new Exception("文件内容为空！");

        }

        Excel2007Reader excel07 = new Excel2007Reader();
        try {
            excel07.process(new FileInputStream(excelFile), false);
        } catch (Exception e) {
            throw new Exception("excel解析失败！");
        }
        resultList = excel07.getSheetData(0);

        return resultList;
    }

    /**
     * 解析EXCEL数据为 List<String[]>
     *
     * @param excelFile 要解析的上传EXCEL文件
     * @return List<String [ ] ) 行 （ 列 ）
     */
    public static List<String[]> getExcelData03(File excelFile) throws Exception {
        List<String[]> resultList = null;

        if (null == excelFile || !excelFile.exists()) {
            throw new Exception("文件内容为空！");

        }

        Excel2003Reader excel03 = new Excel2003Reader();// 实例化excel处理对象
        try {
            excel03.process(new FileInputStream(excelFile));
        } catch (IOException e) {
            throw new Exception("excel解析失败！");
        }
        resultList = excel03.getSheetData(0);

        return resultList;
    }

    /**
     * 通过解析File对象获取excel内容，并且将其拼装为List<String[]>对象返回
     *
     * @param excelFile
     * @return
     * @throws Exception
     */
    public static List<String[]> getExcelData(File excelFile)
            throws Exception {
        List<String[]> resultList = null;

        if (excelFile.exists()) {// 上传的文件不能为空
            String excelFileName = excelFile.getName();// 文件名（带后缀）
            if (excelFileName.toLowerCase().endsWith(EXCEL03_EXTENSION)) {// 如果文件是以.xls为后缀
                Excel2003Reader excel03 = new Excel2003Reader();// 实例化excel处理对象
                try {
                    excel03.process(new FileInputStream(excelFile));
                } catch (IOException e) {
                    throw new Exception("excel解析失败！");
                }
                resultList = excel03.getSheetData(0);
            } else if (excelFileName.toLowerCase().endsWith(EXCEL07_EXTENSION)) {// 如果文件是以.xlsx为后缀
                Excel2007Reader excel07 = new Excel2007Reader();
                try {
                    excel07.process(new FileInputStream(excelFile), false);
                } catch (Exception e) {
                    throw new Exception("excel解析失败！");
                }
                resultList = excel07.getSheetData(0);
            }
        }

        return resultList;
    }

    /**
     * 通过解析File对象获取excel内容，并且将其拼装为Map<Integer, List<String[]>>对象返回
     *
     * @param excelFile
     * @return
     * @throws Exception
     */
    public static Map<Integer, List<String[]>> getExcelDataAll(File excelFile)
            throws Exception {
        Map<Integer, List<String[]>> result = null;

        if (excelFile.exists()) {// 上传的文件不能为空
            String excelFileName = excelFile.getName();// 文件名（带后缀）
            if (excelFileName.toLowerCase().endsWith(EXCEL03_EXTENSION)) {// 如果文件是以.xls为后缀
                Excel2003Reader excel03 = new Excel2003Reader();// 实例化excel处理对象
                try {
                    excel03.process(new FileInputStream(excelFile));
                } catch (IOException e) {
                    throw new Exception("excel解析失败！");
                }
                result = excel03.getSheetData();
            } else if (excelFileName.toLowerCase().endsWith(EXCEL07_EXTENSION)) {// 如果文件是以.xlsx为后缀
                Excel2007Reader excel07 = new Excel2007Reader();
                try {
                    excel07.process(new FileInputStream(excelFile), true);
                } catch (Exception e) {
                    throw new Exception("excel解析失败！");
                }
                result = excel07.getSheetData();
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\YanC\\Desktop\\OM00_QA管理表_鄭州_BAK.xls"); // Map<Integer, List<String[]>> integer
//        file = new File("C:\\Users\\YanC\\Desktop\\OM00_QA管理表_鄭州_BAK 的副本.xlsx");
        Map<Integer, List<String[]>> dataAll = getExcelDataAll(file);

        System.out.printf(dataAll.toString());
    }
}
