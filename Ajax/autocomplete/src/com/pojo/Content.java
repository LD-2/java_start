package com.pojo;

public class Content {
    private String content;

    @Override
    public String toString() {
        return "Content{" +
                "content='" + content + '\'' +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Content() {
    }

    public Content(String content) {
        this.content = content;
    }
}
