package com.cloud.study.ztree;

import java.io.Serializable;

/**
 * Created by 37300 on 2017/7/13.
 */
public class ZTreeNode implements Serializable {

    private Long id;
    private String name;
    private Boolean isParent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean parent) {
        isParent = parent;
    }
}
