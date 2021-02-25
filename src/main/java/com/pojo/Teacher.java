package com.pojo;

public class Teacher {
    private int id;
    private String tname;
    private String tcollege;
    private String tclass;
    private String createtime;
    private int isdelete;

    public Teacher(int id, String tname, String tcollege, String tclass, String createtime, int isdelete) {
        this.id = id;
        this.tname = tname;
        this.tcollege = tcollege;
        this.tclass = tclass;
        this.createtime = createtime;
        this.isdelete = isdelete;
    }

    public Teacher() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTcollege() {
        return tcollege;
    }

    public void setTcollege(String tcollege) {
        this.tcollege = tcollege;
    }

    public String getTclass() {
        return tclass;
    }

    public void setTclass(String tclass) {
        this.tclass = tclass;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", tname='" + tname + '\'' +
                ", tcollege='" + tcollege + '\'' +
                ", tclass='" + tclass + '\'' +
                ", createtime='" + createtime + '\'' +
                ", isdelete=" + isdelete +
                '}';
    }
}
