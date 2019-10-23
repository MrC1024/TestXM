package com.example.demo.serviceImpl;

import com.example.demo.mapper.DeptMapper;
import com.example.demo.pojo.Dept;
import com.example.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service("deptService")
public class Deptserviceimpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public Dept seldept(int deptid) {
        return deptMapper.seldept(deptid);
    }
}
