package com.yash.ocp.utils;

import com.yash.model.ExcelPojoRow;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PoiStyleUtil {

    public static CellStyle defaultTitleCellStyle( Workbook wb) {
        CellStyle style;
        Font titleFont = wb.createFont();
        titleFont.setFontHeightInPoints((short) 20);
        titleFont.setBold(true);
        style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFont(titleFont);
        style.setBorderBottom(BorderStyle.THICK);
        style.setBorderTop(BorderStyle.THICK);
        style.setBorderLeft(BorderStyle.THICK);
        style.setBorderRight(BorderStyle.THICK);

        style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        return style;
    }

    public static CellStyle defaultHeaderCellStyle(XSSFWorkbook wb,int size ,boolean isHeader,boolean isFill) {
        CellStyle style;
        Font titleFont = wb.createFont();
        titleFont.setFontHeightInPoints((short) size);
        if (isHeader) {
            titleFont.setBold(true);
        }
        style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        style.setFont(titleFont);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);

        if (isFill) {
            style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return style;
    }

    public static CellStyle getStyle(XSSFWorkbook wb, ExcelPojoRow pojoRow) {
            CellStyle style;
            Font titleFont = wb.createFont();

            titleFont.setFontHeightInPoints((short) pojoRow.getSize());
            if(pojoRow.isBold()) {
                titleFont.setBold(true);
            }
            style = wb.createCellStyle();
            style.setAlignment(pojoRow.gethAllignment());
            style.setVerticalAlignment(VerticalAlignment.CENTER);
            style.setFont(titleFont);

            style.setBorderBottom(pojoRow.getStyle());
            style.setBorderTop(pojoRow.getStyle());
            style.setBorderLeft(pojoRow.getStyle());
            style.setBorderRight(pojoRow.getStyle());

            if(pojoRow.getColor() != null) {
                style.setFillForegroundColor(pojoRow.getColor().getIndex());
                style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            }
            return style;
        }
    }

