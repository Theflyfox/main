package com.wonders.bigdata.word;

/**
 * Description: 资助形式信息<br>
 *
 * @author: XB
 * @date: 2020/6/1 17:20
 */
public class SponsorTypeO {
    private Integer sponsorUnitId;              //资助方id(已有)（原赞助单位）
    private String sponsorUnitName;             //资助方名字(其它)（原赞助单位）
    private Integer sponsorTypeId;              //资助类型id 是否有资金形式
    private Integer sponsorTypeOtherId;         //资助类型其他id  是否有其他形式
    private Integer sponsorTypeDrugId;         //资助类型药物id
    private String sponsorTypeMoney;           //资助形式数目
    private String sponsorTypeName;             //资助形式其他名字

    private String sponsorTypeMedicineNum;      //药物数量
    private String sponsorTypeMedicineStore;    //药物存储条件

    public SponsorTypeO() {
        this.sponsorUnitId = 99;
        this.sponsorUnitName = "院内";
        this.sponsorTypeId = 1;
        this.sponsorTypeOtherId = 99;
        this.sponsorTypeDrugId = 99;
        this.sponsorTypeMoney = "232";
        this.sponsorTypeName = "赞助";
        this.sponsorTypeMedicineNum = "";
        this.sponsorTypeMedicineStore = "";
    }

    public Integer getSponsorUnitId() {
        return sponsorUnitId;
    }

    public void setSponsorUnitId(Integer sponsorUnitId) {
        this.sponsorUnitId = sponsorUnitId;
    }

    public String getSponsorUnitName() {
        return sponsorUnitName;
    }

    public void setSponsorUnitName(String sponsorUnitName) {
        this.sponsorUnitName = sponsorUnitName;
    }

    public Integer getSponsorTypeId() {
        return sponsorTypeId;
    }

    public void setSponsorTypeId(Integer sponsorTypeId) {
        this.sponsorTypeId = sponsorTypeId;
    }

    public Integer getSponsorTypeOtherId() {
        return sponsorTypeOtherId;
    }

    public void setSponsorTypeOtherId(Integer sponsorTypeOtherId) {
        this.sponsorTypeOtherId = sponsorTypeOtherId;
    }

    public Integer getSponsorTypeDrugId() {
        return sponsorTypeDrugId;
    }

    public void setSponsorTypeDrugId(Integer sponsorTypeDrugId) {
        this.sponsorTypeDrugId = sponsorTypeDrugId;
    }

    public String getSponsorTypeMoney() {
        return sponsorTypeMoney;
    }

    public void setSponsorTypeMoney(String sponsorTypeMoney) {
        this.sponsorTypeMoney = sponsorTypeMoney;
    }

    public String getSponsorTypeName() {
        return sponsorTypeName;
    }

    public void setSponsorTypeName(String sponsorTypeName) {
        this.sponsorTypeName = sponsorTypeName;
    }

    public String getSponsorTypeMedicineNum() {
        return sponsorTypeMedicineNum;
    }

    public void setSponsorTypeMedicineNum(String sponsorTypeMedicineNum) {
        this.sponsorTypeMedicineNum = sponsorTypeMedicineNum;
    }

    public String getSponsorTypeMedicineStore() {
        return sponsorTypeMedicineStore;
    }

    public void setSponsorTypeMedicineStore(String sponsorTypeMedicineStore) {
        this.sponsorTypeMedicineStore = sponsorTypeMedicineStore;
    }
}
