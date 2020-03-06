package com.codemaster.api.entity;

import java.util.Date;

public class Todo
{
    private Long id;
    private String title;
    private String detail;
    private Date date;
    private Boolean isDone;

    public Todo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return "Todo [date=" + date + ", detail=" + detail + ", id=" + id + ", isDone=" + isDone + ", title=" + title
                + "]";
    }
    
}