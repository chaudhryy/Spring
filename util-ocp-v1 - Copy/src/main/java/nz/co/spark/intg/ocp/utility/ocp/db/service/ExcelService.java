package nz.co.spark.intg.ocp.utility.ocp.db.service;

import nz.co.spark.intg.ocp.utility.model.ExcelPojoRow;
import nz.co.spark.intg.ocp.utility.ocp.utils.PoiStyleUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {


    public void createExcel(List<ExcelPojoRow> pojoRowList, String release) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Statistics");
        int rowCnt =0;
        for(ExcelPojoRow pojoRow : pojoRowList){
            Row row = sheet.createRow(rowCnt);
            CellStyle cellStyle =     PoiStyleUtil.getStyle(workbook,pojoRow);
               String[] arrList = pojoRow.getValueList();
               int colCnt = 0;
               String prevVal=null;
               int startCollCnt = 0;
               int prevCollCnt = 0;
                String lastVal= null;
               for(String val : arrList){
                   Cell ncell = row.createCell(colCnt);
                   ncell.setCellStyle(cellStyle);
                   ncell.setCellValue(val);

                   if(prevVal != null && prevVal.equals(val)){
                        prevCollCnt = colCnt;
//                       CellRangeAddress headerAddress = new CellRangeAddress(rowCnt,rowCnt,prevCollCnt,colCnt);
//                       sheet.addMergedRegion(headerAddress);
//                       prevVal = null;
                   }else if (prevVal != null && !prevVal.equals(val) && (prevCollCnt-startCollCnt)>0){
                       CellRangeAddress headerAddress = new CellRangeAddress(rowCnt,rowCnt,startCollCnt,prevCollCnt);
                       sheet.addMergedRegion(headerAddress);
                       prevVal = val;
                       startCollCnt=colCnt;
                       prevCollCnt =colCnt;
                   }else if(prevVal != null && !prevVal.equals(val)){
                       prevVal = val;
                       startCollCnt=colCnt;
                       prevCollCnt =colCnt;
                   }

                   if(prevVal == null){
                       startCollCnt =colCnt;
                       prevVal=val;
                   }

                    lastVal = val;
                   colCnt++;
               }
            if (prevVal != null && prevVal.equals(lastVal) && (prevCollCnt-startCollCnt)>0){
                colCnt--;
                CellRangeAddress headerAddress = new CellRangeAddress(rowCnt,rowCnt,startCollCnt,colCnt);
                sheet.addMergedRegion(headerAddress);

            }
               rowCnt ++;
        }
        for(int i = 0 ;i<11;i++){
            sheet.autoSizeColumn(i);
        }
        try (FileOutputStream outputStream = new FileOutputStream("Fuse_"+release+".xlsx")) {
            workbook.write(outputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public void generateReportO(String release) {
//        XSSFWorkbook workbook = new XSSFWorkbook();
//        XSSFSheet sheet = workbook.createSheet("Statistics");
//        int rowCount = createHeader(workbook,sheet,0,release + "report");
//        rowCount= addMergedRow(null, sheet, rowCount, null);
//        addMergedRowCol(sheet,rowCount,(rowCount+3),0,1);
//        addMergedRowCol(sheet,rowCount,(rowCount+3),8,10);
//
//        rowCount= createStatistics(workbook,sheet, rowCount);
//        rowCount= addMergedRow(null, sheet, rowCount+4, null);
//        rowCount= addMergedRow(null, sheet, rowCount, null);
//        rowCount= addMergedRow(workbook,sheet, rowCount,"Configuration Statistics");
//        rowCount= addMergedRow(null, sheet, rowCount, null);
//
//        rowCount= createMemCpuStats(workbook,sheet,rowCount);
//
//
//
//        for(int i = 0 ;i<11;i++){
//            sheet.autoSizeColumn(i);
//        }
//        try (FileOutputStream outputStream = new FileOutputStream("Fuse_"+release+".xlsx")) {
//            workbook.write(outputStream);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private int createMemCpuStats(XSSFWorkbook workbook, XSSFSheet sheet, int rowCount) {
//
//
//        String[] arrValueArray = new String[11];
//        arrValueArray[0]="";
//        arrValueArray[1]= "Total Cpu Used";
//        int newrowcount= fillMemCpuRow(workbook,sheet,rowCount,arrValueArray);
//
//        return newrowcount;
//    }
//
//    private int fillMemCpuRow(XSSFWorkbook workbook, XSSFSheet sheet, int rowCount, String[] arrValueArray) {
//// Fill the header Column 0-5
//        // fill Value as Total Cpu Used 1,2
//        // Merge the Column 1-2
//        // fill Value as Max CPU
//        // fill Value as Mem Used
//        // Fill Value as Max Mem
//
//        // Merge Column 6 for row 8, 10
//
//        // fill Value as Large
//        // Fill Value as Medium
//        // fill Value as Small
//        rowCount++;
//
//        return  rowCount;
//    }
//
//    private int createStatistics(XSSFWorkbook workbook, XSSFSheet sheet, int rowCount) {
//        {
//            Row row = sheet.createRow(rowCount);
//            Cell ncell = row.createCell(2);
//            CellStyle nheaderStyle = PoiStyleUtil.defaultHeaderCellStyle(workbook, 12, true, true);
//            ncell.setCellStyle(nheaderStyle);
//            ncell.setCellValue("Total Deployed");
//            Cell ncell2 = row.createCell(3);
//            ncell2.setCellStyle(nheaderStyle);
//            ncell2.setCellValue("Total Deployed");
//            addMergedRowCol(sheet, rowCount, rowCount, 2, 3);
//
//            Cell vcell = row.createCell(4);
//            Cell vcell1 = row.createCell(5);
//            Cell vcell2 = row.createCell(6);
//            Cell vcell3 = row.createCell(7);
//            String cellValue = (podCache.getNewDeploy().size()+podCache.getBothChange().size() + podCache.getBuildChange().size() + podCache.getConfigChange().size() + podCache.getNoChange().size()) + "";
//            vcell.setCellValue(cellValue);
//            vcell1.setCellValue(cellValue);
//            vcell2.setCellValue(cellValue);
//            vcell3.setCellValue(cellValue);
//            vcell.setCellStyle(nheaderStyle);
//            vcell1.setCellStyle(nheaderStyle);
//            vcell2.setCellStyle(nheaderStyle);
//            vcell3.setCellStyle(nheaderStyle);
//            addMergedRowCol(sheet, rowCount, rowCount, 4, 7);
//        }
//        rowCount++;
//        {
//            Row row = sheet.createRow(rowCount);
//            Cell ffcell1 = row.createCell(2);
//            Cell ffcell2 = row.createCell(3);
//            Cell ffcell3 = row.createCell(4);
//            Cell ffcell4 = row.createCell(5);
//            Cell ffcell5 = row.createCell(6);
//            Cell ffcell6 = row.createCell(7);
//
//            CellStyle nheaderStyle2 = PoiStyleUtil.defaultHeaderCellStyle(workbook, 11, true, false);
//            ffcell1.setCellStyle(nheaderStyle2);
//            ffcell2.setCellStyle(nheaderStyle2);
//            ffcell3.setCellStyle(nheaderStyle2);
//            ffcell4.setCellStyle(nheaderStyle2);
//            ffcell5.setCellStyle(nheaderStyle2);
//            ffcell6.setCellStyle(nheaderStyle2);
//            ffcell1.setCellValue("Break Up");
//            ffcell2.setCellValue("Total");
//            ffcell3.setCellValue("Build Change");
//            ffcell4.setCellValue("Config Change");
//            ffcell5.setCellValue("Both");
//            ffcell6.setCellValue("None");
//        }
//        rowCount ++;
//        {
//            Row row = sheet.createRow(rowCount);
//            Cell ffcell1 = row.createCell(2);
//            CellStyle nheaderStyle2 = PoiStyleUtil.defaultHeaderCellStyle(workbook, 11, false, false);
//            ffcell1.setCellStyle(nheaderStyle2);
//            ffcell1.setCellValue("New Deploy");
//            Cell ffcell2 = row.createCell(3);
//            Cell ffcell3 = row.createCell(4);
//            Cell ffcell4 = row.createCell(5);
//            Cell ffcell5 = row.createCell(6);
//            Cell ffcell6 = row.createCell(7);
//            ffcell1.setCellStyle(nheaderStyle2);
//            ffcell2.setCellStyle(nheaderStyle2);
//            ffcell3.setCellStyle(nheaderStyle2);
//            ffcell4.setCellStyle(nheaderStyle2);
//            ffcell5.setCellStyle(nheaderStyle2);
//            ffcell6.setCellStyle(nheaderStyle2);
//            ffcell3.setCellValue(""+podCache.getNewDeploy().size()+"");
//            ffcell5.setCellValue(""+podCache.getNewDeploy().size()+"");
//        }
//
//        rowCount ++;
//        {
//            Row row = sheet.createRow(rowCount);
//            Cell ffcell1 = row.createCell(2);
//            CellStyle nheaderStyle2 = PoiStyleUtil.defaultHeaderCellStyle(workbook, 11, false, false);
//            ffcell1.setCellStyle(nheaderStyle2);
//            ffcell1.setCellValue("Re Deployed");
//            Cell ffcell2 = row.createCell(3);
//            Cell ffcell3 = row.createCell(4);
//            Cell ffcell4 = row.createCell(5);
//            Cell ffcell5 = row.createCell(6);
//            Cell ffcell6 = row.createCell(7);
//            ffcell1.setCellStyle(nheaderStyle2);
//            ffcell2.setCellStyle(nheaderStyle2);
//            ffcell3.setCellStyle(nheaderStyle2);
//            ffcell4.setCellStyle(nheaderStyle2);
//            ffcell5.setCellStyle(nheaderStyle2);
//            ffcell6.setCellStyle(nheaderStyle2);
//            String totalCellVal = ""+podCache.getBothChange().size() + podCache.getBuildChange().size() + podCache.getConfigChange().size() + podCache.getNoChange().size();
//            ffcell2.setCellValue(totalCellVal);
//            ffcell3.setCellValue(podCache.getBuildChange().size());
//            ffcell4.setCellValue(podCache.getConfigChange().size());
//            ffcell5.setCellValue(podCache.getBothChange().size());
//            ffcell6.setCellValue(podCache.getNoChange().size());
//        }
//        return rowCount;
//    }
//
//    private int addMergedRow(XSSFWorkbook workbook, XSSFSheet sheet, int rowCount, String value) {
//        if(StringUtils.isNotBlank(value) && workbook != null){
//            Row row = sheet.createRow(rowCount);
//            CellStyle nheaderStyle = PoiStyleUtil.defaultHeaderCellStyle(workbook, 12, true, true);
//            for(int i =0;i<11;i++){
//                Cell ncell = row.createCell(i);
//                ncell.setCellStyle(nheaderStyle);
//                ncell.setCellValue(value);
//            }
//        }
//        CellRangeAddress headerAddress = new CellRangeAddress(rowCount,rowCount,0,10);
//        sheet.addMergedRegion(headerAddress);
//        rowCount++;
//        return rowCount;
//    }
//
//    private void addMergedRowCol(XSSFSheet sheet, int rowCount,int endRowCount,int startCol,int endCol) {
//        CellRangeAddress headerAddress = new CellRangeAddress(rowCount,endRowCount,startCol,endCol);
//        sheet.addMergedRegion(headerAddress);
//    }
//    private int createHeader(XSSFWorkbook workbook, XSSFSheet sheet, int rowCount, String headerVal) {
//        Row row = sheet.createRow(rowCount);
//        Cell ncell = row.createCell(0);
//        CellStyle nheaderStyle = PoiStyleUtil.defaultTitleCellStyle(workbook);
//        ncell.setCellStyle(nheaderStyle);
//        ncell.setCellValue(headerVal);
//        for(int t=1;t<11;t++) {
//            Cell cell = row.createCell(t);
//            CellStyle headerStyle = PoiStyleUtil.defaultTitleCellStyle(workbook);
//            cell.setCellStyle(headerStyle);
////                cell.setCellValue(release.toUpperCase() + " Post Deployment Report");
//
//        }
//
//        return addMergedRow(null, sheet,rowCount, null);
//    }
}
