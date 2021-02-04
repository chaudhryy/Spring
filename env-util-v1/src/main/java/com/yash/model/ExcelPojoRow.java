package com.yash.model;

import org.apache.poi.ss.usermodel.IndexedColors;

public class ExcelPojoRow {

    int colSize =11;
    IndexedColors color;
    short size;
    boolean isBold;
    String valueList[];


    public ExcelPojoRow(String ... args){
            valueList = new String[colSize];
            int i = 0;
            for(String arg : args){
                valueList[i] =arg;
                i++;
            }
    }

    public int getColSize() {
        return colSize;
    }

      public IndexedColors getColor() {
        return color;
    }

    public void setColor(IndexedColors color) {
        this.color = color;
    }

    public short getSize() {
        return size;
    }

    public void setSize(short size) {
        this.size = size;
    }

    public boolean isBold() {
        return isBold;
    }

    public void setBold(boolean bold) {
        isBold = bold;
    }

    public String[] getValueList() {
        return valueList;
    }
}
