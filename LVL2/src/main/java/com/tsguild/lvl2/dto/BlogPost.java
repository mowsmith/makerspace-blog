
package com.tsguild.lvl2.dto;

import java.util.ArrayList;
import java.util.Objects;

public class BlogPost {
    private int id;
    private String title;
    private String author;
    private String datePosted;
    private String content;
    private int status;
    private final ArrayList<Comment> comments;
    private final ArrayList<String> tags;

    public BlogPost() {
        this.comments = new ArrayList<>();
        this.tags = new ArrayList<>();
    }
    
    

    public BlogPost(int id, String title, String author, String datePosted, String content, int status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.datePosted = datePosted;
        this.content = content;
        this.status = status;
        this.comments = new ArrayList<>();
        this.tags = new ArrayList<>();
    }

    public BlogPost(String title, String author, String datePosted, String content, int status) {
        this.title = title;
        this.author = author;
        this.datePosted = datePosted;
        this.content = content;
        this.status = status;
        this.comments = new ArrayList<>();
        this.tags = new ArrayList<>();
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.id;
        hash = 43 * hash + Objects.hashCode(this.title);
        hash = 43 * hash + Objects.hashCode(this.author);
        hash = 43 * hash + Objects.hashCode(this.datePosted);
        hash = 43 * hash + Objects.hashCode(this.content);
        hash = 43 * hash + this.status;
        hash = 43 * hash + Objects.hashCode(this.comments);
        hash = 43 * hash + Objects.hashCode(this.tags);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BlogPost other = (BlogPost) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.datePosted, other.datePosted)) {
            return false;
        }
        if (!Objects.equals(this.content, other.content)) {
            return false;
        }
        if (!Objects.equals(this.comments, other.comments)) {
            return false;
        }
        if (!Objects.equals(this.tags, other.tags)) {
            return false;
        }
        return true;
    }
    
    
}
