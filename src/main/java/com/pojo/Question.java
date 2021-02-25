package com.pojo;

public class Question {
    private int id;
    private String question;
    private String tutor;
    private String answer;
    private String createtime;
    private int isdelete;

    public Question(int id, String question, String tutor, String answer, String createtime, int isdelete) {
        this.id = id;
        this.question = question;
        this.tutor = tutor;
        this.answer = answer;
        this.createtime = createtime;
        this.isdelete = isdelete;
    }

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", tutor='" + tutor + '\'' +
                ", answer='" + answer + '\'' +
                ", createtime='" + createtime + '\'' +
                ", isdelete=" + isdelete +
                '}';
    }
}
