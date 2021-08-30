package com.libra.spring.demo.dao;

import com.libra.spring.demo.model.entity.Student;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

/**
 * @description: 结果处理器
 * @author: sx
 * @date: 2021-10:35 上午-2021/8/27
 */
public class DemoResultHandler implements ResultHandler<Student> {

    @Override
    public void handleResult(ResultContext<? extends Student> resultContext) {
        Student resultObject = resultContext.getResultObject();
        System.out.println(resultObject.toString());
    }
}
