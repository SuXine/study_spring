package com.libra.spring.demo.model.entity;

import java.io.Serializable;

/**
 * @description: ${desc}
 * @author: sx
 * @date: 2021-3:53 下午-2021/11/16
 */
public class Student implements Serializable {
    private Long id;

    private String name;

    private ClassInfo classNumber;

    private Integer height;

    private Integer weight;

    private Double base;

    private GenderInfo gender;

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

    public GenderInfo getGender() {
        return gender;
    }

    public void setGender(GenderInfo gender) {
        this.gender = gender;
    }

    public ClassInfo getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(ClassInfo classNumber) {
        this.classNumber = classNumber;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public Student() {
    }

    public Student(ClassInfo classNumber) {
        this.classNumber = classNumber;
    }

    public Student(Long id, ClassInfo classNumber) {
        this.id = id;
        this.classNumber = classNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classNumber=" + classNumber +
                ", height=" + height +
                ", weight=" + weight +
                ", base=" + base +
                ", gender=" + gender +
                '}';
    }
}