package com.libra.spring.demo.model.entity;

import java.io.Serializable;

/**
 * @description: ${desc}
 * @author: sx
 * @date: 2021-5:52 下午-2021/11/15
 */
public class GenderInfo  implements Serializable {
    private String id;

    private String name;

    private Boolean used;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    @Override
    public String toString() {
        return "GenderInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", used=" + used +
                '}';
    }
}