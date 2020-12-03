package com.wonders.bigdata.word;

import java.util.*;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2020/5/7 16:11
 */
public class EthicApplyTableO {
    //研究基本信息
    private String projectNumber;           //受理号
    private String name;                    //项目名称
    private String projectType;            //项目类型的id 1:药物临床试验 2:医疗器械临床试验, 3:科研课题 4:研究者发起研究, 5:申办方观察性研究,
    private String medicalInstrumentName;   //药械名称
    private String testInstrumentType;     //试验分期/器械类型id 1:'Ⅰ期', 2,:'Ⅱ期', 3,:'Ⅲ期', 4,:'Ⅳ期', 5:'器械Ⅰ类' 6:'器械Ⅱ类' 7:'器械Ⅲ类' 8,:'诊断试剂Ⅰ类', 9:'诊断试剂Ⅱ类', 10:'诊断试剂Ⅲ类' 11:'不适用'
    private String sponsorUnit;             //申办单位
    private String fundsSource;             //经费来源
    private String researchNature;         //研究性质id 1:"国际多中心",2:"国内多中心",3:"单中心",
    private String role;                   //本中心角色id 1:'组长单位', 2:'协调单位', 3:'参与单位', 4:'不适应(单中心)',
    private String leaderUnit;              //组长单位
    private String joinUnit;                //参与单位
    private String undertakeDepartment;     //参与科室
    private String incharge;                //项目负责人
    private Integer researchMethod1;   //研究方法id数组 1:'实验性研究',
    private Integer researchMethod2;   //研究方法id数组 2:'前瞻性观察性研究'
    private Integer researchMethod3;   //研究方法id数组 3:'回顾性观察性研究'
    private Integer researchMethod4;   //研究方法id数组 4:'现况性观察性研究'
    private Integer researchMethod5;   //研究方法id数组 5:'描述性研究'
    private Integer sampleData;             //使用生物样本数据 1-是 0-否
    private Integer sampleSource1;     //样本来源id数组 1:"既往留存
    private Integer sampleSource2;     //样本来源id数组 2:"计划采集"
    private Integer sampleSource3;     //样本来源id数组 3:"生物样本库"
    private Integer sampleSource4;     //样本来源id数组 4:"其他",
    private String sampleInput1;       //样本类型数组，长度为4.没有填写赋值为‘’
    private String sampleInput2;       //样本类型数组，长度为4.没有填写赋值为‘’
    private String sampleInput3;       //样本类型数组，长度为4.没有填写赋值为‘’
    private String sampleInput4;       //样本类型数组，长度为4.没有填写赋值为‘’
    private Integer inheritance1;      //遗传办公室审批事项id 1:"采集",
    private Integer inheritance2;      //遗传办公室审批事项id 2:"利用",
    private Integer inheritance3;      //遗传办公室审批事项id 3:"出境",
    private Integer inheritance4;      //遗传办公室审批事项id 4:"保藏-建立样本库,
    private Integer inheritance5;      //遗传办公室审批事项id 5:"保藏-建立数据库",
    private Integer inheritance6;      //遗传办公室审批事项id 6:"保藏-国际合作 "
    private String register;          //试验用药械是否拟申请注册/申报 1-是 0-否
    private String arange;            //试验用药械遵循批准适应症范围/使用方法 1-是 0-否

    /**
     * 伦理审查类型：1-初始审查，2-复审-修正后同意，3-复审-重审，4-修正案，5-本院严重不良事件，6-安全性报告
     * 7-方案违背报告，8-定期跟踪报告，9-暂停研究报告，10-提前终止研究报告，11-结题报告，12-其他文件
     */
    private Integer checkType;
    private ApprovalFileO file31 = new ApprovalFileO();//主要研究者及研究团队利益冲突申明信
    private ApprovalFileO file68 = new ApprovalFileO();//经费来源情况的说明信
    private ApprovalFileO file5 = new ApprovalFileO();//临床研究方案
    private ApprovalFileO file7 = new ApprovalFileO();//知情同意书
    private ApprovalFileO file8 = new ApprovalFileO();//豁免知情同意书过程申请
    private ApprovalFileO file69 = new ApprovalFileO();//受试者招募材料
    private ApprovalFileO file70 = new ApprovalFileO();//招募方式说明
    private ApprovalFileO file71 = new ApprovalFileO();//样本来源及使用说明
    private ApprovalFileO file75 = new ApprovalFileO();//纸质病例报告表
    private ApprovalFileO file76 = new ApprovalFileO();//电子病例报告表
    private ApprovalFileO file12 = new ApprovalFileO();//研究者手册
    private ApprovalFileO file50 = new ApprovalFileO();//保险合同
    private ApprovalFileO file9 = new ApprovalFileO();// 研究团队名单、研究者履历及GCP证书
    private ApprovalFileO file10 = new ApprovalFileO();// 研究团队名单、研究者履历及GCP证书
    private ApprovalFileO file77 = new ApprovalFileO();//参与单位列表
    private ApprovalFileO file72 = new ApprovalFileO();//组长单位伦理委员会批件
    private ApprovalFileO file73 = new ApprovalFileO();//其他伦理委员会的审批决定
    private ApprovalFileO file79 = new ApprovalFileO();//国家食品药品监督管理总局临床试验批件
    private ApprovalFileO file80 = new ApprovalFileO();//国家药品监督管理局临床试验通知
    private ApprovalFileO file81 = new ApprovalFileO();// 医疗器械注册检验报告
    private ApprovalFileO file82 = new ApprovalFileO();//科研项目批文/任务书
    private ApprovalFileO file109 = new ApprovalFileO();// 药物的合格检验报告
    private ApprovalFileO file110 = new ApprovalFileO();//医疗器械自检报告
    private ApprovalFileO file62 = new ApprovalFileO();//医疗器械说明书
    private ApprovalFileO file97 = new ApprovalFileO();//赞助方资质证明
    private ApprovalFileO file85 = new ApprovalFileO();//SMO资质证明
    private ApprovalFileO file86 = new ApprovalFileO();//CRO资质证明
    private ApprovalFileO file87 = new ApprovalFileO();//中心实验室资质证明
    private ApprovalFileO file88 = new ApprovalFileO();//初始其他
    //本院严重不良事件
    private String reportType;//报告编号
    private String subjectNumber;//受试者编号
    private String diagnosis;//诊断
    private ApprovalFileO file101 = new ApprovalFileO();//非预期严重不良事件汇总记录表
    private ApprovalFileO file63 = new ApprovalFileO();//外院SAE
    private ApprovalFileO file89 = new ApprovalFileO();//SUSAR
    private ApprovalFileO file90 = new ApprovalFileO();//MSR
    private ApprovalFileO file91 = new ApprovalFileO();//药物的安全性报告
    private ApprovalFileO file102 = new ApprovalFileO();//安全性信息报告摘要
    private ApprovalFileO file98 = new ApprovalFileO();//安全性报告其他
    private ApprovalFileO file92 = new ApprovalFileO();//严重违背
    private ApprovalFileO file93 = new ApprovalFileO();//轻度违背
    private ApprovalFileO file103 = new ApprovalFileO();//受试者不依从或违背方案报告
    //定期跟踪报告
    private String trackFrequency;//批准跟踪频率
    private String lastTrackTime;//上一次跟踪时间
    private ApprovalFileO file104 = new ApprovalFileO();//年度或定期跟踪审查报告
    private ApprovalFileO file105 = new ApprovalFileO();//暂停研究报告模板
    private ApprovalFileO file107 = new ApprovalFileO();//提前终止研究报告模板
    private ApprovalFileO file94 = new ApprovalFileO();//关中心函
    private ApprovalFileO file95 = new ApprovalFileO();//分中心小结
    private ApprovalFileO file96 = new ApprovalFileO();//总结报告
    private ApprovalFileO file_fr98 = new ApprovalFileO();//结题报告其他
    private ApprovalFileO file_ot98 = new ApprovalFileO();//其他文件

    public Map<String, Object> initMap() {
        Map<String ,Object> map = new HashMap<>();
        map.put("projectNumber", "ETS-2020-0724-008");
        map.put("acceptanceNumber", "ETHIC-TANCE-09808");
        map.put("name", "新冠疫苗研发");
        map.put("projectType", "药物临床试验");
        map.put("medicalInstrumentName", "疫苗研发");
        map.put("testInstrumentType", "Ⅱ期");
        map.put("sponsorUnit", "疾控中心");
        map.put("researchNature", "国际多中心");
        map.put("role", "组长单位");
        map.put("leaderUnit", "国家疾控");
        map.put("joinUnit", "各个疾控");
        map.put("undertakeDepartment", "传染病科");
        map.put("incharge", "国家");
        map.put("researchMethod1", 0);
        map.put("researchMethod2", 1);
        map.put("researchMethod3", 0);
        map.put("researchMethod4", 1);
        map.put("researchMethod5", 0);
        map.put("sampleData", 1);
        map.put("sampleSource1", 1);
        map.put("sampleSource2", 0);
        map.put("sampleSource3", 0);
        map.put("sampleSource4", 0);
        map.put("sampleInput1", "既往病史");
        map.put("inheritance1", 1);
        map.put("inheritance2", 0);
        map.put("inheritance3", 1);
        map.put("inheritance4", 0);
        map.put("inheritance5", 1);
        map.put("inheritance6", 1);
        map.put("register", "是");
        map.put("arange", "是");
        map.put("checkType", 1);
        map.put("trackType", 4);
        List<FileInfoO> fileInfoOS = new ArrayList<>();
        FileInfoO fileInfoO = new FileInfoO();
        fileInfoO.init("流行病学或统计学相关专业老师签字文件","937492","20200723");
        fileInfoOS.add(fileInfoO);
        fileInfoOS.add(fileInfoO);
        file31.init(1, fileInfoOS);
        file68.init(1, fileInfoOS);
        map.put("file31", file31);
        map.put("file68", file68);
        map.put("file5", file68);
        map.put("file7", file68);
        map.put("file8", file68);
        map.put("file69", file68);
        map.put("file70", file68);
        map.put("file71", file68);
        map.put("file75", file68);
        map.put("file76", file68);
        map.put("file12", file68);
        map.put("file50", file68);
        map.put("file9", file68);
        map.put("file10", file68);
        map.put("file77", file68);
        map.put("file72", file68);
        map.put("file73", file68);
        map.put("file79", file68);
        map.put("file80", file68);
        map.put("file81", file68);
        map.put("file82", file68);
        map.put("file109", file68);
        map.put("file110", file68);
        map.put("file62", file68);
        map.put("file97", file68);
        map.put("file85", file68);
        map.put("file86", file68);
        map.put("file87", file68);
        map.put("file88", file68);
        map.put("file112", file68);
        map.put("file113", file68);
        map.put("reportType", "随访");
        map.put("subjectNumber", "ETD-02936456383");
        map.put("diagnosis", "重症痊愈患者");
        map.put("file100", file68);
        map.put("file101", file68);
        map.put("file63", file68);
        map.put("file89", file68);
        map.put("file90", file68);
        map.put("file91", file68);
        map.put("file102", file68);
        map.put("file98", file68);
        map.put("file92", file68);
        map.put("file93", file68);
        map.put("file103", file68);
        map.put("trackFrequency", "三个月");
        map.put("lastTrackTime", "2020-03-05");
        map.put("file104", file68);
        map.put("file105", file68);
        map.put("file106", file68);
        map.put("file107", file68);
        map.put("file94", file68);
        map.put("file95", file68);
        map.put("file96", file68);
        map.put("file_fr98", file68);
        map.put("file_ot98", file68);
        map.put("checkOS", new ArrayList<>());
        map.put("frequency", 3);
        map.put("effectiveYear", "2020");
        map.put("effectiveMonth", "07");
        map.put("effectiveDay", "28");
        map.put("invalidYear", "2020");
        map.put("invalidMonth", "10");
        map.put("invalidDay", "28");
        map.put("checkTime", "2020-07-28");
        //map.put("checkType", "简易审查");
        map.put("meetingShouldNum", "");
        map.put("meetingActualNum", "");
        map.put("meetingVoteNum", "");
        map.put("confilictExaminer", "");
        map.put("result", "通过");
        map.put("comment", "有待完善");
        map.put("trackCheckFrequency", "3个月");
        map.put("day", "2020-07-30");
        map.put("time", "17:05:05");
        map.put("address", "203");
        Map<String, Object> map1 = new HashMap<>();
        map1.put("checkbox", 1);
        map1.put("name", "赵委员");
        map.put("examinerOS", Arrays.asList(map1,map1,map1));
        map.put("host", "金主持");
        map.put("workers", "钱研究、孙博");
        map.put("shouldCome", 3);
        map.put("actualCome", 3);
        map.put("confilictExaminer", "疾控研究员");
        CheckProjectO checkProjectO = new CheckProjectO();
        checkProjectO.initEmpty();
        map.put("retrial", Arrays.asList(checkProjectO,checkProjectO));
        map.put("firstTrial", Arrays.asList(checkProjectO));
        map.put("amendmentsTrial", Arrays.asList(checkProjectO));
        map.put("annualTrial", Arrays.asList(checkProjectO));
        map.put("saeTrial", Arrays.asList(checkProjectO));
        map.put("otherTrial", Arrays.asList(checkProjectO));
        map.put("safetyReportTrial", Arrays.asList(checkProjectO));
        map.put("violationPlanTrial", Arrays.asList(checkProjectO));
        map.put("terminationTrial", Arrays.asList(checkProjectO));
        map.put("closingTrial", Arrays.asList(checkProjectO));
        map.put("subjectsComplainTrial", Arrays.asList(checkProjectO));
        map.put("siteVisit", Arrays.asList(checkProjectO));
        MeetingSingInWordO meetingSingInWordO = new MeetingSingInWordO();
        meetingSingInWordO.init();
        map.put("meetingSingInWordOs", Arrays.asList(meetingSingInWordO,meetingSingInWordO));
        map.put("filesNumber", "ETHIC-0283-463");
        map.put("version", "V3.0");
        map.put("versionDate", "2020-10-28");
        return map;
    }

    private List<CheckProjectO> retrial;//重审a
    private List<CheckProjectO> firstTrial;//初始审查b
    private List<CheckProjectO> amendmentsTrial;//修正案审查c
    private List<CheckProjectO> annualTrial;//年度/定期跟踪审查d
    private List<CheckProjectO> saeTrial;//严重不良事件审查e
    private List<CheckProjectO> safetyReportTrial;//安全性报告审查f
    private List<CheckProjectO> violationPlanTrial;//违背方案审查g
    private List<CheckProjectO> terminationTrial;//暂停/终止研究审查h
    private List<CheckProjectO> closingTrial;//结题项目审查i
    private List<CheckProjectO> subjectsComplainTrial;//受试者抱怨j
    private List<CheckProjectO> siteVisit;//现场访视k

    public static class ApprovalFileO {
        private Integer checked;//是否选中：0-否，1-是
        private List<FileInfoO> files;//文件信息

        public ApprovalFileO() {
            this.checked = 0;
            this.files = new ArrayList<>();
        }

        public ApprovalFileO init(Integer checked, List<FileInfoO> files) {
            this.checked = checked;
            this.files = files;
            return this;
        }

        public Integer getChecked() {
            return checked;
        }

        public void setChecked(Integer checked) {
            this.checked = checked;
        }

        public List<FileInfoO> getFiles() {
            return files;
        }

        public void setFiles(List<FileInfoO> files) {
            this.files = files;
        }
    }

    public static class FileInfoO {
        private String name;//文件名称
        private String number;//第二个空
        private String content;//第三个空

        public FileInfoO() {
            this.name = "";
            this.number = "";
            this.content = "";
        }

        public void init(String name, String number, String content) {
            this.name = name;
            this.number = number;
            this.content= content;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public class CheckProjectO {
        private Integer orderNumber;            //会议审查项目序号
        private String number;                  //受理号
        private String name;                    //项目名称
        private String undertakeDepartment;     //承担科室
        private String incharge;                //主要研究者
        private String sponsorUnit;             //申办单位
        private String researchType;            //研究类型
        private String masterExaminer;          //主审委员
        private String indepandentConsultant;   //独立顾问
        private String reporter;                //汇报人
        private String subjectNumber;           //受试者编号
        private String saeDiagnose;             //SAE诊断
        private String reportTime;              //报告时间范围
        private String reportType;              //报告类型/类别
        private String violationNum;            //违背例数
        private String violationDegree;         //违背程度
        private String violationDetail;         //违背详情
        private String questionsAndAnswers;     //提问与答疑
        private String confilictExaminer;       //申请人、声明有利益冲突的委员/独立顾问退出
        private String discuss;                 //讨论
        private List<String> pollResults;      //投票结果数组，按顺序获取每种结果的票数，没票则为0票
        private Integer result;                 //审查决定：1-同意，2-不同意，3-修改后同意，4-修改后重审，5-终止或暂停已批准的研究。。。
        private String comment;                 //审查意见
        private Integer frequencyType;          //跟踪审查频率：1-不变，2-改变，3-不适用
        private Integer frequency;              //跟踪审查频率：3-3个月，6-6个月，12-12个月，13-其他，14-不适用
        private String frequencyInput;          //跟踪审查频率：其他输入框
        private String checkType;          //
        private String fileNumber;         //
        private String originResult;         //
        private String reportContent;           //报告内容/访查内容及结果/处理过程及结果
        private String subjects;                //受试者
        private String diagnosis;               //诊断
        private String relevant;                //相关
        private String anticipation;            //预期性
        private String degree;                  //程度
        private String treatment;               //处理措施
        private String terminateReason;         //终止原因
        private String complaintContent;        //抱怨内容

        public void initEmpty() {
            this.orderNumber = 1;
            this.number = "ETR-303920-20200706";
            this.name = "疾病预防研究";
            this.undertakeDepartment = "传染病科";
            this.incharge = "张医生";
            this.sponsorUnit = "疾控中心";
            this.researchType = "药物研究";
            this.masterExaminer = "李医生、张医生";
            this.indepandentConsultant = "疾控主管";
            this.reporter = "张医生";
            this.subjectNumber = "SHOFZ-0004";
            this.saeDiagnose = "SAE-009";
            this.reportTime = "2020-07-29";
            this.reportType = "随访";
            this.violationNum = "343";
            this.violationDegree = "地点";
            this.violationDetail = "疼好的规定";
            this.questionsAndAnswers = "问：药物分析进度？答：稳步推进";
            this.confilictExaminer = "疾控研究员";
            this.discuss = "无讨论";
            this.pollResults = Arrays.asList("2", "1", "0", "3", "1", "1");
            this.result = 1;
            this.comment = "批准同意";
            this.frequencyType = 1;
            this.frequency = 3;
            this.frequencyInput = "";
            this.checkType = "会议审查";
            this.fileNumber = "F-0092-ED1";
            this.originResult = "原始结果";
            this.reportContent = "报告内容";           //报告内容/访查内容及结果/处理过程及结果
            this.subjects = "受试者";                //受试者
            this.diagnosis = "诊断结果阳性";               //诊断
            this.relevant = "追踪相关轨迹";                //相关
            this.anticipation = "预期防御";            //预期性
            this.degree = "红色预警";                  //程度
            this.treatment = "隔离14天观察";               //处理措施
            this.terminateReason = "隔离期到";         //终止原因
            this.complaintContent = "没有人性化防御措施";        //抱怨内容
        }

        public void setOrderNumber(Integer orderNumber) {
            this.orderNumber = orderNumber;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setUndertakeDepartment(String undertakeDepartment) {
            this.undertakeDepartment = undertakeDepartment;
        }

        public void setIncharge(String incharge) {
            this.incharge = incharge;
        }

        public void setSponsorUnit(String sponsorUnit) {
            this.sponsorUnit = sponsorUnit;
        }

        public void setResearchType(String researchType) {
            this.researchType = researchType;
        }

        public void setMasterExaminer(String masterExaminer) {
            this.masterExaminer = masterExaminer;
        }

        public void setIndepandentConsultant(String indepandentConsultant) {
            this.indepandentConsultant = indepandentConsultant;
        }

        public void setReporter(String reporter) {
            this.reporter = reporter;
        }

        public void setSubjectNumber(String subjectNumber) {
            this.subjectNumber = subjectNumber;
        }

        public void setSaeDiagnose(String saeDiagnose) {
            this.saeDiagnose = saeDiagnose;
        }

        public void setReportTime(String reportTime) {
            this.reportTime = reportTime;
        }

        public void setReportType(String reportType) {
            this.reportType = reportType;
        }

        public void setViolationNum(String violationNum) {
            this.violationNum = violationNum;
        }

        public void setViolationDegree(String violationDegree) {
            this.violationDegree = violationDegree;
        }

        public void setViolationDetail(String violationDetail) {
            this.violationDetail = violationDetail;
        }

        public void setQuestionsAndAnswers(String questionsAndAnswers) {
            this.questionsAndAnswers = questionsAndAnswers;
        }

        public void setConfilictExaminer(String confilictExaminer) {
            this.confilictExaminer = confilictExaminer;
        }

        public void setDiscuss(String discuss) {
            this.discuss = discuss;
        }

        public void setPollResults(List<String> pollResults) {
            this.pollResults = pollResults;
        }

        public void setResult(Integer result) {
            this.result = result;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public void setFrequencyType(Integer frequencyType) {
            this.frequencyType = frequencyType;
        }

        public void setFrequency(Integer frequency) {
            this.frequency = frequency;
        }

        public void setFrequencyInput(String frequencyInput) {
            this.frequencyInput = frequencyInput;
        }

        public Integer getOrderNumber() {
            return orderNumber;
        }

        public String getNumber() {
            return number;
        }

        public String getName() {
            return name;
        }

        public String getUndertakeDepartment() {
            return undertakeDepartment;
        }

        public String getIncharge() {
            return incharge;
        }

        public String getSponsorUnit() {
            return sponsorUnit;
        }

        public String getResearchType() {
            return researchType;
        }

        public String getMasterExaminer() {
            return masterExaminer;
        }

        public String getIndepandentConsultant() {
            return indepandentConsultant;
        }

        public String getReporter() {
            return reporter;
        }

        public String getSubjectNumber() {
            return subjectNumber;
        }

        public String getSaeDiagnose() {
            return saeDiagnose;
        }

        public String getReportTime() {
            return reportTime;
        }

        public String getReportType() {
            return reportType;
        }

        public String getViolationNum() {
            return violationNum;
        }

        public String getViolationDegree() {
            return violationDegree;
        }

        public String getViolationDetail() {
            return violationDetail;
        }

        public String getQuestionsAndAnswers() {
            return questionsAndAnswers;
        }

        public String getConfilictExaminer() {
            return confilictExaminer;
        }

        public String getDiscuss() {
            return discuss;
        }

        public List<String> getPollResults() {
            return pollResults;
        }

        public Integer getResult() {
            return result;
        }

        public String getComment() {
            return comment;
        }

        public Integer getFrequencyType() {
            return frequencyType;
        }

        public Integer getFrequency() {
            return frequency;
        }

        public String getFrequencyInput() {
            return frequencyInput;
        }

        public String getCheckType() {
            return checkType;
        }

        public void setCheckType(String checkType) {
            this.checkType = checkType;
        }

        public String getFileNumber() {
            return fileNumber;
        }

        public void setFileNumber(String fileNumber) {
            this.fileNumber = fileNumber;
        }

        public String getOriginResult() {
            return originResult;
        }

        public void setOriginResult(String originResult) {
            this.originResult = originResult;
        }

        public String getReportContent() {
            return reportContent;
        }

        public String getSubjects() {
            return subjects;
        }

        public String getDiagnosis() {
            return diagnosis;
        }

        public String getRelevant() {
            return relevant;
        }

        public String getAnticipation() {
            return anticipation;
        }

        public String getDegree() {
            return degree;
        }

        public String getTreatment() {
            return treatment;
        }

        public String getTerminateReason() {
            return terminateReason;
        }

        public String getComplaintContent() {
            return complaintContent;
        }
    }

    public class MeetingSingInWordO {
        private String name;   //专家名字
        private String sex;    //性别
        private String unit;   //工作单位
        private String backgrounds;  //专业背景
        private String role;     //职务
        private String tenure;      //任期
        private String post;   //职位

        public void init() {
            this.name = "张专家";
            this.sex = "男";
            this.unit = "仁济医院";
            this.backgrounds = "教授";
            this.role = "研究员";
            this.tenure = "四年";
            this.post = "主任医师";
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getBackgrounds() {
            return backgrounds;
        }

        public void setBackgrounds(String backgrounds) {
            this.backgrounds = backgrounds;
        }

        public String getPost() {
            return post;
        }

        public void setPost(String post) {
            this.post = post;
        }

        public String getTenure() {
            return tenure;
        }

        public void setTenure(String tenure) {
            this.tenure = tenure;
        }
    }
}
