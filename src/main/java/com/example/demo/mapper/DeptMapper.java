package com.example.demo.mapper;

import com.example.demo.pojo.Dept;

public interface DeptMapper {
    /**
     * 根据id查询
     */
    Dept seldept(int deptid);
}
