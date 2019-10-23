package com.example.demo.service;

import com.example.demo.pojo.VPingLun;
import com.example.demo.pojo.Video;
import com.example.demo.pojo.author;
import com.example.demo.pojo.huiFu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoService {
   /* *//**
     * 查询全部
     * @return
     *//*
    List<Video> getAll();*/
    /**
     * 根据下拉框查询框查询
     */
    List<Video> getIndexById(int vTypeId,String vName,@Param("pageIndex") int pageIndex,@Param("pageCount") int pageCount);
    /**
     * 查询新闻总数
     */
    int getCount();
    /**
     * 查询当前页面的新闻集合
     */
    List<Video> getAllByPage(@Param("pageIndex") int pageIndex, @Param("pageCount") int pageCount);
    /**
     * 查询作者详情
     * @param authorId
     * @return
     */
    author selectAuthor(Integer authorId);
    /**
     * 根据vtypeId查询条数
     */
    int getCountT(Integer vTypeId);
    /**
     * 根据用户Id查询用户评论的消息
     */
    List<VPingLun> getPL(@Param("vid") int vid);
    /**
     * 根据视频用户id评论视频
     */
    int addPL(VPingLun vPingLun);
    /**
     * 添加回复
     */
    int addHF(huiFu huifu);
    /**
     * 查询回复
     */
    List<huiFu> getHF(@Param("pinglunId") int pinglunId);
    /*List<huiFu> getHF();*/
    /**
     * 删除回复
     * @param id
     * @return
     */
    Integer del(@Param("hfId") Integer hfId);

}
