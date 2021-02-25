package com.utils;

import java.util.List;

public class PageUtils {
    private static final long serialVersionUID = 1L;
    private int total;
    private List<?> rows;

    public PageUtils(List<?> list, int total){
        this.rows = list;
        this.total = total;
    }

    public int getTotal(){
        return total;
    }
    public void getTotal(int total){this.total = total;}

    public List<?> getRows() {return rows;}

    public void setRows(List<?> rows){this.rows = rows;}
}
