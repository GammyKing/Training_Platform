package com.pojo;

public class PaperText {
    private int id;
    private String papertext;
    private String createtime;
    private String tutor;
    private int isdelete;

    public PaperText(int id, String papertext, String createtime, String tutor, int isdelete) {
        this.id = id;
        this.papertext = papertext;
        this.createtime = createtime;
        this.tutor = tutor;
        this.isdelete = isdelete;
    }

    public PaperText() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPapertext() {
        return papertext;
    }

    public void setPapertext(String papertext) {
        this.papertext = papertext;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    @Override
    public String toString() {
        return "PaperText{" +
                "id=" + id +
                ", papertext='" + papertext + '\'' +
                ", createtime='" + createtime + '\'' +
                ", tutor='" + tutor + '\'' +
                ", isdelete=" + isdelete +
                '}';
    }
}
