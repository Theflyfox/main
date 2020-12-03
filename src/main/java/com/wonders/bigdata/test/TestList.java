package com.wonders.bigdata.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2020/11/30 9:20
 */
public class TestList {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Student student1 = new TestList().new Student("张三", 23);
        Student student2 = new TestList().new Student("李四", 25);
        list.add(student1);
        list.add(student2);
        System.out.println(list.get(0).getName() + "：" + list.get(0).getAge());
        for (Student student : list) {
            student.setAge(student.getAge() + 5);
            student.setName(student.getName() + "01");
        }
        System.out.println(list.get(0).getName() + "：" + list.get(0).getAge());
    }

    public class Student {
        private String name;
        private Integer age;

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
