package com.wonders.bigdata.word;

import org.apache.commons.lang.StringUtils;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2019/11/21 16:39
 */
public class FundsO {
    private String subject;      //预算科目
    private Double amount;      //金额/次
    private String count;       //计算根据及理由

    public FundsO(String subject, Double amount, String count){
        if(StringUtils.isNotEmpty(subject)) {
            this.subject = subject;
        }else {
            this.subject = "";
        }
        if(amount != null) {
            this.amount = amount;
        }else {
            this.amount = 0.0;
        }
        if(count != null) {
            this.count = count;
        }else {
            this.count = "";
        }
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
