package com.vo;

import java.util.Date;

public class Message {
    private int messageID;
    private String title;
    private String content;
    private String writer;
    private Date writeDate;

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writerDate) {
        this.writeDate = writerDate;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

}
