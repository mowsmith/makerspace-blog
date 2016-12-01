
package com.tsguild.lvl2.dto;

import java.util.Objects;

public class StaticPage {
    
    private int id;
    private String title;
    private String content;
    private int status;
    
    // Constructors
    public StaticPage(){
        
    }
    
    public StaticPage(String title, String content, int status) {
        this.title = title;
        this.content = content;
        this.status = status;
    }

    public StaticPage(int id, String title, String content, int status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
    }
    
    // Getters and Setters
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
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.title);
        hash = 13 * hash + Objects.hashCode(this.content);
        hash = 13 * hash + this.status;
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
        final StaticPage other = (StaticPage) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.content, other.content)) {
            return false;
        }
        return true;
    }
      
    
}
