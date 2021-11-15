package com.libra.spring.demo.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author : bz
 */
public class Student implements Serializable {
    private Long id;
    private String name;
    private GenderInfo genderInfo;

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

    public GenderInfo getGenderInfo() {
        return genderInfo;
    }

    public void setGenderInfo(GenderInfo genderInfo) {
        this.genderInfo = genderInfo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genderInfo=" + genderInfo +
                '}';
    }
}