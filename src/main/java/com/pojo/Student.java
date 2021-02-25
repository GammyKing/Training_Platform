package com.pojo;

public class Student {
    private int id;
    private String pwd;
    private String stuname;
    private int iscommit;
    private String company;
    private int score;
    private int companyscore;
    private String tutor;
    private String createtime;
    private int isdelete;

    public Student(int id, String pwd, String stuname, int iscommit, String company, int score, int companyscore, String tutor, String createtime, int isdelete) {
        this.id = id;
        this.pwd = pwd;
        this.stuname = stuname;
        this.iscommit = iscommit;
        this.company = company;
        this.score = score;
        this.companyscore = companyscore;
        this.tutor = tutor;
        this.createtime = createtime;
        this.isdelete = isdelete;
    }

    public Student() {
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

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public int getIscommit() {
        return iscommit;
    }

    public void setIscommit(int iscommit) {
        this.iscommit = iscommit;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCompanyscore() {
        return companyscore;
    }

    public void setCompanyscore(int companyscore) {
        this.companyscore = companyscore;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
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
        return "Student{" +
                "id=" + id +
                ", pwd='" + pwd + '\'' +
                ", stuname='" + stuname + '\'' +
                ", iscommit=" + iscommit +
                ", company='" + company + '\'' +
                ", score=" + score +
                ", companyscore=" + companyscore +
                ", tutor='" + tutor + '\'' +
                ", createtime='" + createtime + '\'' +
                ", isdelete=" + isdelete +
                '}';
    }
}
