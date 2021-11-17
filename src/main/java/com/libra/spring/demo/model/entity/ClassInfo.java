package com.libra.spring.demo.model.entity;

import java.io.Serializable;

/**
 * @description: ${desc}
 * 
 * @author: sx
 * @date: 2021-3:54 下午-2021/11/16
 */
public class ClassInfo implements Serializable {
    private Long id;

    private String name;

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

    @Override
    public String toString() {
        return "ClassInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}