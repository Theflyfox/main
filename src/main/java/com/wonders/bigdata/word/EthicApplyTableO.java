package com.wonders.bigdata.word;


import java.util.List;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2020/5/7 16:11
 */
public class EthicApplyTableO {
    //研究基本信息
    private String projectNumber;           //
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
    private String undertakeDepartment;     //参与科室id
    private String incharge;                //项目负责人id
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
    private Integer register;          //试验用药械是否拟申请注册/申报 1-是 0-否
    private Integer arange;            //试验用药械遵循批准适应症范围/使用方法 1-是 0-否

    //送审文件清单
    private Integer state;//文件清单审查状态 1:'初始审查', 2:'复审-修正后同意' 3:'复审-重审' 4,:'跟踪审查-修正案'
    private Integer self1;//主要研究者及研究团队利益冲突申明信
    private String self1_1;//主要研究者及研究团队利益冲突申明信名称
    private Integer self2;//经费来源情况的说明信
    private String self2_1;//经费来源情况的说明信名称
    private Integer self3;//临床研究方案
    private String self3_1;//临床研究方案名称
    private String self3_2;//临床研究方案版本号
    private String self3_3;//临床研究方案日期
    private Integer self4;//4选择一项
    private String self4_1;//4选择一项名称
    private String self4_2;//4选择一项版本号
    private String self4_3;//4选择一项日期
    private Integer self5;//文件清单列表
    private String self5_1;//5选择一项名称
    private String self5_2;//5选择一项版本号
    private String self5_3;//5选择一项日期
    private Integer self6;//文件清单列表
    private String self6_1;//6选择一项名称
    private String self6_2;//6选择一项版本号
    private String self6_3;//6选择一项日期
    private Integer self7;//研究者手册
    private String self7_1;//研究者手册名称
    private String self7_2;//研究者手册版本号
    private String self7_3;//研究者手册日期
    private Integer self8;//保险合同
    private String self8_1;//保险合同名称
    private String self8_2;//保险合同号
    private Integer self9;//文件清单列表
    private String self9_1;//研究团队名单、研究者履历及GCP证书名称
    private Integer self10;//文件清单列表
    private String self10_1;//参与单位列表名称
    private Integer self11;//文件清单列表
    private String self11_1;//11选择一项名称
    private String self11_2;//11选择一项文号
    private Integer self12;//文件清单列表
    private String self12_1;//12选择一项名称
    private String self12_2;//12选择一项文号
    private Integer self13;//文件清单列表
    private String self13_1;//13选择一项名称
    private String self13_2;//13选择一项编号
    private Integer self14;//文件清单列表
    private String self14_1;//医疗器械说明书
    private Integer self15;//文件清单列表
    private String self15_1;//临床试验机构的设施和条件能够满足试验的综述
    private Integer self16;//文件清单列表
    private String self16_1;//试验用医疗器械的研制符合适用的医疗器械质量管理体系相关要求的声明
    private Integer self17_1;//申办方资质证明
    private Integer self17_2;//SMO资质证明
    private Integer self17_3;//CRO资质证明
    private Integer self17_4;//中心实验室资质证明
    private Integer self18;//文件清单其他
    private String fileInput;//文件清单的其他内容

    private Integer amendmentCheck1;//跟踪审查id数组 1:本院严重不良事件
    private String reportType;         //报告类型id 1:"首次报告", 2:"随访报告", 3:"总结报告", 4:"首次+随访", 5:"首次+总结", 6:"随访+总结", 7:"首次+随访+总结", 8:"首报（更新）", 9:"随访（更新）", 10:"总结（更新）",
    private String number;              //受试者编号
    private String diagnose;            //诊断

    private Integer amendmentCheck2;//跟踪审查id数组 2:安全性报告
    private Integer safeReport1;   //全性报告id数组 1:'外院SAE'
    private Integer safeReport2;   //全性报告id数组 2:'SUSAR'
    private Integer safeReport3;   //全性报告id数组 3:'MSR'
    private Integer safeReport4;   //全性报告id数组 4:'药物的安全性报告'
    private Integer safeReport5;   //全性报告id数组 5:'其他’
    private String safeInputOther;      //安全性报告的其他字段
    private List<String> safeInput;     //报告时间范围，长度为4，没有为‘’

    private Integer amendmentCheck3;//跟踪审查id数组 3:方案违背报告
    private Integer breach1;       //方案违背报告id 1:"严重违背"
    private Integer breach2;       //方案违背报告id 2:"轻度违背"
    private List<String> breachInput;   //违背例数数组,长度为2.没有值为‘’

    private Integer amendmentCheck4;//跟踪审查id数组 4:定期跟踪报告
    private String frequency;          //批准跟踪审查频率id 1:"3个月", 2:"6个月", 3:"12个月", 4:"其他",
    private String time;                //上一次跟踪时间

    private Integer amendmentCheck5;//跟踪审查id数组 5:暂停研究报告
    private Integer amendmentCheck6;//跟踪审查id数组 6:提前终止研究报告
    private Integer amendmentCheck7;//跟踪审查id数组 7:结题报告
    private Integer closingreport1;//结题报告id数组 1:"关中心函"
    private Integer closingreport2;//结题报告id数组 2:"分中心小结"
    private Integer closingreport3;//结题报告id数组 3:"总结报告"
    private Integer closingreport4;//结题报告id数组 4:'其他’
    private String closingInput;        //结题报告的其他字段

    private Integer amendmentCheck8;//跟踪审查id数组 8:其他文件
    private String otherInput;          //其他文件

    //申请及送审流程
    private String approvalName;    //送审人姓名
    private String approvalLevel;   //送审人职位
    private String approvalPhone;   //送审人联系方式
    private String approvalUnit;    //送审人单位
    private String inchargePhone;   //主要研究者联系方式

}
