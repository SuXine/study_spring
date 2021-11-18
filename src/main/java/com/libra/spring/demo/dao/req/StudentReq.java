package com.libra.spring.demo.dao.req;

import com.libra.spring.demo.model.entity.ClassInfo;
import com.libra.spring.demo.model.entity.GenderInfo;

import java.io.Serializable;

/**
 * @description: ${desc}
 * @author: sx
 * @date: 2021-3:53 下午-2021/11/16
 */
public class StudentReq implements Serializable {
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
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}