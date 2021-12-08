package com.libra.spring.demo.model.bo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @description: 分页结果
 * @author: sx
 * @date: 2021-11:14 上午-2021/12/1
 */
public class Page<T> extends ArrayList<T> {
    Long total;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
