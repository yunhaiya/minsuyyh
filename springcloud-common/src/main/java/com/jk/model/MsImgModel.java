package com.jk.model;

public class MsImgModel {
    //房间图片
    private String msfimg;
    //房间对应id
    private Integer mspid;

    public String getMsfimg() {
        return msfimg;
    }

    public void setMsfimg(String msfimg) {
        this.msfimg = msfimg == null ? null : msfimg.trim();
    }

    public Integer getMspid() {
        return mspid;
    }

    public void setMspid(Integer mspid) {
        this.mspid = mspid;
    }
}