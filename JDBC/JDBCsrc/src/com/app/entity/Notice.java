package com.app.entity;

import java.sql.Date;

public class Notice {
    private int id;
    private String title;
    private String writerid;
    private Date regDate;
    private String content;
    private int hit;
    private String files;

    public Notice() { }

    public Notice(int id, String title, String writerid, Date regDate, String content, int hit, String files) {
        this.id = id;
        this.title = title;
        this.writerid = writerid;
        this.regDate = regDate;
        this.content = content;
        this.hit = hit;
        this.files = files;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriterid() {
        return writerid;
    }

    public void setWriterid(String writerid) {
        this.writerid = writerid;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }
}
