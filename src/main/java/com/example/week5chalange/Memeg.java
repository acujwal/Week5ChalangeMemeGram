package com.example.week5chalange;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Memeg {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String caption;

    private String captionTwo;

    private String memegname;

    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCaptionTwo() {
        return captionTwo;
    }

    public void setCaptionTwo(String captionTwo) {
        this.captionTwo = captionTwo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMemegname() {
        return memegname;
    }

    public void setMemegname(String memegname) {
        this.memegname = memegname;
    }
}
