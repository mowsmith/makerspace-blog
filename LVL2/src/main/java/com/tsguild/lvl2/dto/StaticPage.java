
package com.tsguild.lvl2.dto;

import java.util.ArrayList;
import java.util.Objects;

public class StaticPage {

    private int id;
    private String title;
    private String content1;
    private String content2;
    private String content3;
    private int status;
    private int layout;

    // Constructors
    public StaticPage() {

    }

    public StaticPage(int id, String title, int status, int layout) {
        this.title = title;
        this.id = id;
        this.status = status;
        this.layout = layout;
    }

    public StaticPage(String title, String content1, int status, int layout) {
        this.title = title;
        this.content1 = content1;
        this.status = status;
        this.layout = layout;
    }

    public StaticPage(int id, String title, String content1, int status, int layout) {
        this.id = id;
        this.title = title;
        this.content1 = content1;
        this.status = status;
        this.layout = layout;
    }

    public StaticPage(int id, String title, String content1, String content2, int status, int layout) {
        this.id = id;
        this.title = title;
        this.content1 = content1;
        this.content2 = content2;
        this.status = status;
        this.layout = layout;
    }

    public StaticPage(int id, String title, String content1, String content2, String content3, int status, int layout) {
        this.id = id;
        this.title = title;
        this.content1 = content1;
        this.content1 = content2;
        this.content1 = content3;
        this.status = status;
        this.layout = layout;
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

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public String getContent3() {
        return content3;
    }

    public void setContent3(String content3) {
        this.content3 = content3;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.title);
        hash = 53 * hash + Objects.hashCode(this.content1);
        hash = 53 * hash + Objects.hashCode(this.content2);
        hash = 53 * hash + Objects.hashCode(this.content3);
        hash = 53 * hash + this.status;
        hash = 53 * hash + this.layout;
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
        if (this.layout != other.layout) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.content1, other.content1)) {
            return false;
        }
        if (!Objects.equals(this.content2, other.content2)) {
            return false;
        }
        if (!Objects.equals(this.content3, other.content3)) {
            return false;
        }
        return true;
    }

   

    
}
