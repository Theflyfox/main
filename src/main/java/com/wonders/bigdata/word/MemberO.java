package com.wonders.bigdata.word;

import org.apache.commons.lang.StringUtils;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2019/11/21 16:36
 */
public class MemberO {
    private String name;          //成员姓名
    private String department;    //所在科室
    private String level;         //职称
    private String GCPTime;       //GCP证书时间
    private String division;      //分工
    private String unit;          //院外成员单位/学生学校
    private String phone;         //联系方式
    private String hospital;      //学生意愿
    private String otherIdCard;      //其他人员身份证
    private String otherStatus;      //其他人群目前状态

    public MemberO(String name, String department, String level, String GCPTime, String division, String unit,
                   String phone, String hospital, String otherIdCard, String otherStatus) {
        if(StringUtils.isNotEmpty(name)) {
            this.name = name;
        }else {
            this.name = "";
        }
        if(StringUtils.isNotEmpty(department)) {
            this.department = department;
        }else {
            this.department = "";
        }
        if(StringUtils.isNotEmpty(level)) {
            this.level = level;
        }else {
            this.level = "";
        }
        if(StringUtils.isNotEmpty(GCPTime)) {
            this.GCPTime = GCPTime;
        }else {
            this.GCPTime = "";
        }
        if(StringUtils.isNotEmpty(division)) {
            this.division = division;
        }else {
            this.division = "";
        }
        if(StringUtils.isNotEmpty(unit)) {
            this.unit = unit;
        }else {
            this.unit = "";
        }
        if(StringUtils.isNotEmpty(phone)) {
            this.phone = phone;
        }else {
            this.phone = "";
        }
        if(StringUtils.isNotEmpty(hospital)) {
            this.hospital = hospital;
        }else {
            this.hospital = "";
        }
        if(StringUtils.isNotEmpty(otherIdCard)) {
            this.otherIdCard = otherIdCard;
        }else {
            this.otherIdCard = "";
        }
        if(StringUtils.isNotEmpty(otherStatus)) {
            this.otherStatus = otherStatus;
        }else {
            this.otherStatus = "";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getGCPTime() {
        return GCPTime;
    }

    public void setGCPTime(String GCPTime) {
        this.GCPTime = GCPTime;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getOtherIdCard() {
        return otherIdCard;
    }

    public void setOtherIdCard(String otherIdCard) {
        this.otherIdCard = otherIdCard;
    }

    public String getOtherStatus() {
        return otherStatus;
    }

    public void setOtherStatus(String otherStatus) {
        this.otherStatus = otherStatus;
    }
}
