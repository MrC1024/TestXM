package com.example.demo.pojo;

public class Video {
    private Integer vid;
    private String vName;
    private Integer vTypeId;
    private String path;
    private String lengthoftime;
    private Integer authorId;
    private VType vType;

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public VType getvType() {
        return vType;
    }

    public void setvType(VType vType) {
        this.vType = vType;
    }

    public Integer getVid() {

        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public Integer getvTypeId() {
        return vTypeId;
    }

    public void setvTypeId(Integer vTypeId) {
        this.vTypeId = vTypeId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLengthoftime() {
        return lengthoftime;
    }

    public void setLengthoftime(String lengthoftime) {
        this.lengthoftime = lengthoftime;
    }

}
