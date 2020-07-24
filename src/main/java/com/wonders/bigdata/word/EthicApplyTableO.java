package com.wonders.bigdata.word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private ApprovalFileO file_sae = new ApprovalFileO();//本院严重不良事件
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
    private ApprovalFileO file_cr = new ApprovalFileO();//定期跟踪报告
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
        List<FileInfoO> fileInfoOS = new ArrayList<>();
        FileInfoO fileInfoO = new FileInfoO();
        fileInfoO.init("文件1","937492","20200723");
        fileInfoOS.add(fileInfoO);
        fileInfoOS.add(fileInfoO);
        file31.init(1, fileInfoOS);
        file68.init(1, fileInfoOS);
        map.put("file31", file31);
        map.put("file68", file68);
        return map;
    }

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
}
