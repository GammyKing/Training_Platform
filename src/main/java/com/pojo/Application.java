package com.pojo;

public class Application {
    private int id;
    private String stuname;
    private String company;
    private String createtime;
    private int isdelete;

    public Application(int id, String stuname, String company, String createtime, int isdelete) {
        this.id = id;
        this.stuname = stuname;
        this.company = company;
        this.createtime = createtime;
        this.isdelete = isdelete;
    }

    public Application() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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
        return "Application{" +
                "id=" + id +
                ", stuname='" + stuname + '\'' +
                ", company='" + company + '\'' +
                ", createtime='" + createtime + '\'' +
                ", isdelete=" + isdelete +
                '}';
    }
}
