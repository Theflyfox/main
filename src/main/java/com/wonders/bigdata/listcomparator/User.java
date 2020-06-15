package com.wonders.bigdata.listcomparator;

import java.util.Date;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2020/5/20 9:13
 */
public class User implements Comparable<User> {
    private Long id;
    private int age;
    private Date time;

    public User(Long id, int age, Date time) {
        this.id = id;
        this.age = age;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public int compareTo(User o) {
        if (this.getAge() > o.getAge()) {
            return 1;
        }else if (this.getAge() < o.getAge()) {
            return -1;
        }else {
            return 0;
        }
    }
}
