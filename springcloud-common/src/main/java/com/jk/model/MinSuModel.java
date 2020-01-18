package com.jk.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Document(indexName ="ms_minsu",type = "md_minsu")
public class MinSuModel {
    @Id
    private Integer msid;
    //房间名称
    @Field(analyzer = "ik_smart")
    private String msname;
    //房间介绍
    private String msinfo;
    //房间价格
    private Integer msprice;
    //房间地址
    private String msaddressid;
    //房间配置
    private String mspz;
    //宜住几人
    private Integer msyizhu;
    //房间主人
    private String mszhuren;
    //房间莱尼方式
    private String msphone;
    //房间第一张照片
    private String msimg;
    //房间主人头像
    private String mszhurenimg;

    public String getMspz() {
        return mspz;
    }

    public void setMspz(String mspz) {
        this.mspz = mspz;
    }
    public Integer getMsyizhu() {
        return msyizhu;
    }

    public void setMsyizhu(Integer msyizhu) {
        this.msyizhu = msyizhu;
    }

    public String getMsimg() {
        return msimg;
    }

    public void setMsimg(String msimg) {
        this.msimg = msimg;
    }

    public String getMszhurenimg() {
        return mszhurenimg;
    }

    public void setMszhurenimg(String mszhurenimg) {
        this.mszhurenimg = mszhurenimg;
    }

    public Integer getMsid() {
        return msid;
    }

    public void setMsid(Integer msid) {
        this.msid = msid;
    }

    public String getMsname() {
        return msname;
    }

    public void setMsname(String msname) {
        this.msname = msname == null ? null : msname.trim();
    }

    public String getMsinfo() {
        return msinfo;
    }

    public void setMsinfo(String msinfo) {
        this.msinfo = msinfo == null ? null : msinfo.trim();
    }

    public Integer  getMsprice() {
        return msprice;
    }

    public void setMsprice(Integer msprice) {
        this.msprice = msprice;
    }

    public String getMsaddressid() {
        return msaddressid;
    }

    public void setMsaddressid(String msaddressid) {
        this.msaddressid = msaddressid;
    }

    public String getMszhuren() {
        return mszhuren;
    }

    public void setMszhuren(String mszhuren) {
        this.mszhuren = mszhuren == null ? null : mszhuren.trim();
    }

    public String getMsphone() {
        return msphone;
    }

    public void setMsphone(String msphone) {
        this.msphone = msphone == null ? null : msphone.trim();
    }
}