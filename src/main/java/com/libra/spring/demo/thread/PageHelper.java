package com.libra.spring.demo.thread;

import com.libra.spring.demo.model.bo.PageInfo;

import org.springframework.util.ObjectUtils;

/**
 * @description: 分页
 * @author: sx
 * @date: 2021-11:12 上午-2021/12/1
 */
public class PageHelper {
    private static final ThreadLocal<PageInfo> PAGE_INFO_THREAD_LOCAL = new ThreadLocal<>();

    public static void start(Integer pageSize, Integer pageNumber) {
        PageInfo pageInfo = new PageInfo();

        pageInfo.setPageSize(pageSize);
        pageInfo.setPageNumber(pageNumber);

        PAGE_INFO_THREAD_LOCAL.set(pageInfo);
    }

    public static PageInfo getPageInfo() {
        return PAGE_INFO_THREAD_LOCAL.get();
    }

    public static void clear(){
        PAGE_INFO_THREAD_LOCAL.remove();
    }
}
