package com.wonders.bigdata.word;


import freemarker.template.Configuration;
import freemarker.template.Template;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.*;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2020/4/28 11:22
 */
public class CreateWord {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        try {
            /*map.put("name", "张三");
            map.put("age", "28");
            map.put("phone", "13813426573");
            //map.put("imageStr", getImageStr("C:\\file\\timg (1).jpg"));

            //测试map
            map.put("number", "REST-IIT-2020-0605");
            map.put("name", "测试伦理审查表");
            map.put("projectType", "伦理类型");
            map.put("deciName", "格列宁");
            map.put("shiyan", "诊断试剂");
            map.put("applyUnit", "癌症研究中心");
            map.put("fundSource", "企业拨款");
            map.put("properties", "单中心");
            map.put("teamLeader", "仁济医院");
            map.put("flag", 1);*/

            //学术审查申请表map
            SponsorTypeO sponsorTypeO = new SponsorTypeO();
            String sponsorStatement = "上海交通大学医学院附属仁济医院是临床研究数据所有人，" +
                    "对研究数据具有保存、安全保密、批准共享的责任，支持主要研究者合理使用数据和再开发，" +
                    "形成有价值的研究成果。医院可按规定对国家上级管理部门，杂志社或项目主要研究者合理要求开放研究数据。" +
                    "临床研究数据出院须获得医院审批同意，包括但不限于数据的院外存放、管理、分析挖掘、发表、延展开发等；" +
                    "临床研究数据对外开放共享须得到医院协议许可或批准。" +
                    "院外资助方可按事先与医院签署的协议规定共享或使用经医院质控的数据。";
            map.put("sponsorTypeList", Arrays.asList(sponsorTypeO));
            map.put("number", "REST-IIT-2020-0605");
            map.put("sponsorPurpose", "资助目的");
            map.put("sponsorStatement", sponsorStatement);
            map.put("declareDescription", "遗传说明");
            Map<String, Object> masters = new HashMap<>();
            masters.put("inchargeName", "医生1");
            masters.put("department", "骨科");
            masters.put("inchargeLevel", "技师");
            map.put("masters", Arrays.asList(masters,masters));
            map.put("background", "背景是什么");
            map.put("programme", "方案和策划");
            map.put("riskAssessment", "风险预防及规避");
            map.put("innovation", "创新研究");
            MemberO memberO = new MemberO("用户", "骨科", "主任医师",
                    "2020-01-02", "辅助研究", "仁济医院", "13312344321", "仁济医院西苑",
                    "310231198709058456", "在职");
            map.put("inMemberList", Arrays.asList(memberO));
            map.put("outMemberList", Arrays.asList(memberO));
            map.put("studentMemberList", Arrays.asList(memberO));
            map.put("otherMemberList", Arrays.asList(memberO));

            FundsO fundsO = new FundsO("收费项目", 234.5, "收费理由");
            FundsO fundsO1 = new FundsO("(1)购置设备费", 2324.5, "收费理由1");
            FundsO fundsO2 = new FundsO("(2)试制设备费", 2434.5, "收费理由2");
            FundsO fundsO3 = new FundsO("(3)设备改造与租赁", 2364.5, "收费理由3");
            FundsO fundsO4 = new FundsO("2.材料费", 2364.5, "收费理由3");
            FundsO fundsO5 = new FundsO("3.测试化验加工费", 2364.5, "收费理由3");
            map.put("fundsList", Arrays.asList(fundsO));
            map.put("fundsBudgetTotal", 123.5);
            map.put("fundsTotal", 54.8);
            map.put("fundsSourceFlag", 1);
            map.put("fundsSource", "社会募捐");
            map.put("contactName", "联系人");
            map.put("contactPhone", "133584659236");
            map.put("name", "急诊应急处置可行性研究");
            map.put("consult", "是<w:p></w:p>院内：潘舒婷");
            map.put("cellTypeId", 1);
            map.put("cellOther", "卷纸");
            map.put("preparationSideName", "某某制药公司");
            map.put("cellSourceId", 1);
            map.put("declareId", 1);
            map.put("joinUnitId", 1);
            map.put("masterUnitName", "应急处、急诊科、科研处、调度中心、值班室");
            map.put("joinUnitName", "");
            map.put("trialStage", "分四期");
            map.put("drugName", "应急处置药品");
            map.put("instrumentName", "止血钳");
            map.put("instrumentSpecification", "7235-TIH-09");
            map.put("instrumentType", "TTI");
            map.put("experimentKinds", 1);
            map.put("applicationRange", "应急急症");
            map.put("manufacturer", "生物制药器械研究公司");
            map.put("contraindication", "遗传病史");
            map.put("isInterpose", 1);
            map.put("stemCell", 1);
            map.put("somaticCell", 0);
            map.put("gene", 1);
            map.put("transplant", 1);
            map.put("supers", 1);
            map.put("other", 0);
            map.put("nosafety", 1);
            map.put("interposeOther", "结婚的");
            map.put("resourceMoney", Arrays.asList(fundsO));
            map.put("performanceMoney", Arrays.asList(fundsO));
            map.put("directCost", Arrays.asList(fundsO,fundsO1,fundsO2,fundsO3,fundsO4,fundsO5));
            map.put("sample", "182374");
            map.put("number", "IIT-202000708-SIR");
            map.put("incharges", "医生1、小李、县长");
            map.put("departments", "骨科、风湿科");
            map.put("statistician", "院外统计师：小黄(上海科研所)");
            map.put("researchMethod1", 1);
            map.put("researchMethod2", 0);
            map.put("checkOpinion", "临床研究中心意见");
            map.put("undertakeDepartmentName", "急诊科");
            map.put("inchargeName", "医生1");
            List<Map<String, Object>> opinions = new ArrayList<>();
            List<Map<String, Object>> amendmentDetails = new ArrayList<>();
            Map<String, Object> opinion = new HashMap<>();
            Map<String, Object> amendmentDetail = new HashMap<>();
            amendmentDetail.put("result", "23456543212345676543");
            amendmentDetail.put("detail", "33333333333333333333333333333333333333 33333333333333333333333333333333333 33333333333333333333333333333333333333333");
            amendmentDetails.add(amendmentDetail);
            amendmentDetails.add(amendmentDetail);
            opinion.put("amendmentDetails", amendmentDetails);
            opinion.put("revisionInstruction", "其他修正需要有专家论证及指导以及大型研究公司资助。随风我胡丢额我年度率和女巫额不行年底女电脑腐恶随风我胡丢额我年度率和女巫额不行年底女电脑腐恶随风我胡丢额我年度率和女巫额不行年底女电脑腐恶");
            opinion.put("year", "2020");
            opinion.put("month", "08");
            opinion.put("day", "18");
            opinions.add(opinion);
            opinions.add(opinion);
            map.put("opinions", opinions);
            map.put("sponsorUnitName", "仁济医院");
            map.put("researcherName", "张医生");
            map.put("a", 34.6);
            map.put("b", 78.5);
            map.put("c", 87.5);
            map.put("d", 96);
            map.put("e", 68.5);
            map.put("totalScore", 78.56);
            map.put("isOpen", 0);
            map.put("status", 2);
            map.put("comment", "可以开始执行先一步任务");
            map.put("userNameAndDate", "李专家-2020-08-18");
            //configuration用于读取ftl文件
            Configuration configuration = new Configuration();
            configuration.setDefaultEncoding("utf-8");
            configuration.setDirectoryForTemplateLoading(new File("c:/file/ethic/"));
            //输出文档路径及名称
            String name = "伦理审查申请及受理表申请表";
            File outFile = new File("c:/file/ethic/" + name +".doc");
            //以utf-8的编码读取ftl文件
            Template template = configuration.getTemplate(name + ".ftl", "utf-8");
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"), 10240);
            map.putAll(new EthicApplyTableO().initMap());
            template.process(map, out);
            out.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getImageStr(String imgFile) {
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }
}
