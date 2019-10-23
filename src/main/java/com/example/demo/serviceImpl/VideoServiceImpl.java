package com.example.demo.serviceImpl;

import com.example.demo.mapper.VideoMapper;
import com.example.demo.pojo.VPingLun;
import com.example.demo.pojo.Video;
import com.example.demo.pojo.author;
import com.example.demo.pojo.huiFu;
import com.example.demo.service.VideoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("videoService")
public class VideoServiceImpl implements VideoService{
    @Autowired
    private VideoMapper videoMapper;
   /* public List<Video> getAll() {
        return videoMapper.getAll();
    }*/
    /**
     * 根据下拉框搜索框搜索
     *
     * @return
     */
    @Override
    public List<Video> getIndexById(int vTypeId, String vName,int pageIndex,int pageCount) {
        return  videoMapper.getIndexById(vTypeId,vName,pageIndex,pageCount);
    }

    @Override
    public int getCount() {
        return videoMapper.getCount();
    }

    @Override
    public List<Video> getAllByPage(int pageIndex, int pageCount) {
        return videoMapper.getAllByPage(pageIndex,pageCount);
    }

    @Override
    public author selectAuthor(Integer authorId) {
        return videoMapper.selectAuthor(authorId);
    }

    @Override
    public int getCountT(Integer vTypeId) {
        return videoMapper.getCountT(vTypeId);
    }

    @Override
    public List<VPingLun> getPL(int vid) {
        return videoMapper.getPL(vid);
    }

    @Override
    public int addPL(VPingLun vPingLun) {
        return videoMapper.addPL(vPingLun);
    }

    @Override
    public int addHF(huiFu huifu) {
        return  videoMapper.addHF(huifu);
    }

/*    @Override
    public List<huiFu> getHF() {
        return videoMapper.getHF();
    }*/

    public VideoMapper getVideoMapper() {
        return videoMapper;
    }

    public void setVideoMapper(VideoMapper videoMapper) {
        this.videoMapper = videoMapper;
    }

   @Override
    public List<huiFu> getHF(int pinglunId) {
        return videoMapper.getHF(pinglunId);
    }

    @Override
    public Integer del(Integer hfId) {
        return videoMapper.del(hfId);
    }
}
