package nz.co.spark.intg.ocp.utility.model;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;

public class ExcelPojoRow {

    int colSize =11;
    IndexedColors color;
    short size =11;
    boolean isBold;

    BorderStyle style = BorderStyle.THIN;
    HorizontalAlignment hAllignment = HorizontalAlignment.LEFT;


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

    public BorderStyle getStyle() {
        return style;
    }

    public void setStyle(BorderStyle style) {
        this.style = style;
    }

    public HorizontalAlignment gethAllignment() {
        return hAllignment;
    }

    public void sethAllignment(HorizontalAlignment hAllignment) {
        this.hAllignment = hAllignment;
    }
}
