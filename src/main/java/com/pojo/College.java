package com.pojo;

public class College {
    private String id;
    private String collegename;

    public College(String id, String collegename) {
        this.id = id;
        this.collegename = collegename;
    }

    public College() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    @Override
    public String toString() {
        return "College{" +
                "id='" + id + '\'' +
                ", collegename='" + collegename + '\'' +
                '}';
    }
}
