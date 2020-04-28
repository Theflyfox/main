package com.wonders.bigdata.test;

import com.wonders.bigdata.utils.RandomUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description: 生成随机数<br>
 *
 * @author: XB
 * @date: 2019/11/26 17:20
 */
public class CreateRandom {
    public static void main(String[] args) {
        try {
            for (int i=0;i<5;i++) {
                System.out.println(Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmssS").format(new Date()) + RandomUtil.getNumsToLength(2)));
            }
            StudentInfoVO vo = new StudentInfoVO();
            vo.setName("张三");
            List<StudentInfoVO.Result> results = new ArrayList<>();
            results.add(vo.new Result("语文", 90));
            results.add(vo.new Result("数学", 95));
            results.add(vo.new Result("英语", 100));
            vo.setResults(results);
            System.out.println(vo.getResults().get(2).getName() + ":" + vo.getResults().get(2).getScore());

            for (StudentInfoVO.Result result : vo.getResults()) {
                if (result.getName().equals("英语")) {
                    result.setScore(80);
                }
            }
            System.out.println(vo.getResults().get(2).getName() + ":" + vo.getResults().get(2).getScore());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
