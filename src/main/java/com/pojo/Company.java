package com.pojo;

public class Company {
    private int id;
    private String pwd;
    private String company;
    private int isdelete;


    public Company() {
    }

    public Company(int id, String pwd, String company, int isdelete) {
        this.id = id;
        this.pwd = pwd;
        this.company = company;
        this.isdelete = isdelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", pwd='" + pwd + '\'' +
                ", company='" + company + '\'' +
                ", isdelete=" + isdelete +
                '}';
    }
}
