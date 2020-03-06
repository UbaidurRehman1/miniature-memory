package com.codemaster.todoms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Todo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String title;
    @Column
    private String detail;
    @Column
    private Date date;
    @Column
    private Boolean isDone;

    public Todo(Long id, String title, String detail, Date date, Boolean isDone) {
        this.id = id;
        this.title = title;
        this.detail = detail;
        this.date = date;
        this.isDone = isDone;
    }

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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof  Todo) {
            Todo todo = (Todo) obj;
            return todo.id.equals(this.id) && todo.title.equals(this.title);
        }
        return false;
    }
}