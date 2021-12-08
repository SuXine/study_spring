package com.libra.spring.demo.model.bo;

/**
 * @description: 分页数据
 * @author: sx
 * @date: 2021-11:14 上午-2021/12/1
 */
public class PageInfo {
    private Integer pageSize;
    private Integer pageNumber;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
}
