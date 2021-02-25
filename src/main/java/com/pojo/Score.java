package com.pojo;

public class Score {
   private int id;
   private String score;
   private String companyscore;

    public Score(int id, String score, String companyscore) {
        this.id = id;
        this.score = score;
        this.companyscore = companyscore;
    }

    public Score() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCompanyscore() {
        return companyscore;
    }

    public void setCompanyscore(String companyscore) {
        this.companyscore = companyscore;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", score='" + score + '\'' +
                ", companyscore='" + companyscore + '\'' +
                '}';
    }
}
