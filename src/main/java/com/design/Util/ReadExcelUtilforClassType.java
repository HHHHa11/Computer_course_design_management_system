package com.design.Util;

import com.design.entity.ClassType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
//import com.qcbylearn.entitys.Student;

public class ReadExcelUtilforClassType {
    //总行数
    private int totalRows = 0;
    //总条数
    private int totalCells = 0;
    //错误信息接收器
    private String errorMsg;

    //构造方法
    public ReadExcelUtilforClassType() {
    }

    //获取总行数
    public int getTotalRows() {
        return totalRows;
    }

    //获取总列数
    public int getTotalCells() {
        return totalCells;
    }

    //获取错误信息
    public String getErrorInfo() {
        return errorMsg;
    }

    /**
     * 读EXCEL文件，获取信息集合
     *
//     * @param fielName
     * @return
     */
    public List<ClassType> getExcelInfo(MultipartFile mFile) {
        String fileName = mFile.getOriginalFilename();//获取文件名
        System.out.println("文件名" + fileName);
        List<ClassType> semList = null;
        try {
            if (!validateExcel(fileName)) {// 验证文件名是否合格
                return null;
            }
            boolean isExcel2003 = true;// 根据文件名判断文件是2003版本还是2007版本
            if (isExcel2007(fileName)) {
                isExcel2003 = false;
            }
//            core code
            semList = createExcel(mFile.getInputStream(), isExcel2003);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return semList;
    }

    /**
     * 根据excel里面的内容读取客户信息
     *
     * @param is          输入流
     * @param isExcel2003 excel是2003还是2007版本
     * @return
     * @throws IOException
     */
    public List<ClassType> createExcel(InputStream is, boolean isExcel2003) {
        List<ClassType> semList = null;
        try {
            Workbook wb = null;
            if (isExcel2003) {// 当excel是2003时,创建excel2003
//                将输入流转化成excel表格wb
                wb = new XSSFWorkbook(is);
            } else {// 当excel是2007时,创建excel2007
                wb = new XSSFWorkbook(is);
            }
//            读取Excel
            semList = readExcelValue(wb);// 读取Excel里面客户的信息
        } catch (IOException e) {
            e.printStackTrace();
        }
        return semList;
    }

    /**
     * 读取Excel里面客户的信息
     *
     * @param wb
     * @return
     */
    private List<ClassType> readExcelValue(Workbook wb) {
        // 得到第一个shell
        Sheet sheet = wb.getSheetAt(0);
        System.out.println("gaolei dayin============" + sheet);
        // 得到Excel的行数
        this.totalRows = sheet.getPhysicalNumberOfRows();
        System.out.println("行数=======" + this.totalRows);
        // 得到Excel的列数(前提是有行数)
        if (totalRows > 1 && sheet.getRow(0) != null) {
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
            System.out.println("总列数==========" + this.totalCells);
        }
        List<ClassType> semList = new ArrayList<ClassType>();
        // 循环Excel行数
        for (int r = 1; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            ClassType classType = new ClassType();
            // 循环Excel的列
            for (int c = 0; c < this.totalCells; c++) {
                Cell cell = row.getCell(c);
                if (null != cell) {

//                    if (c == 0) {
//                        //如果是纯数字,比如你写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25
//                        if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
//                            try {
//                                //String studentNumber = String.valueOf(cell.getNumericCellValue());
//                                //String x =studentNumber.substring(0, studentNumber.length()-2>0?studentNumber.length()-2:1);//年龄
//                                student.setId(Integer.valueOf((int) cell.getNumericCellValue()));
//                            } catch (NumberFormatException e) {
//                                // TODO Auto-generated catch block
//                                e.printStackTrace();
//                                System.out.println("if false");
//                            }
//                        } else {
//                            try {
//                                student.setId(Integer.valueOf(cell.getStringCellValue()));
//                            } catch (Exception e) {
//                                // TODO Auto-generated catch block
//                                e.printStackTrace();
//                                System.out.println("类型不匹配");
//                            }
//                        }
//                    } else
                    if (c == 0) {
                        if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
                            String classs = String.valueOf(cell.getNumericCellValue());
//                            String x = appUserId.substring(0, appUserId.length() - 2 > 0 ? appUserId.length() - 2 : 1);//性别
                            classType.setClassName(classs);
                        }else{
                            classType.setClassName(cell.getStringCellValue());
                        }
                    }
                }
            }
            // 添加到list
            semList.add(classType);
        }
        return semList;
    }

    /**
     * 验证EXCEL文件
     *
     * @param filePath
     * @return
     */
    public boolean validateExcel(String filePath) {
        if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
            errorMsg = "文件名不是excel格式";
            return false;
        }
        return true;
    }

    // @描述：是否是2003的excel，返回true是2003
    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    //@描述：是否是2007的excel，返回true是2007
    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }
}