package com.wonders.bigdata.listcomparator;

import com.wonders.bigdata.utils.DateUtils;

import java.util.*;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2020/5/20 9:14
 */
public class UserComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (((User) o2).getTime().getTime() > ((User) o1).getTime().getTime()) {
            return -1;
        }else if (((User) o2).getTime().getTime() < ((User) o1).getTime().getTime()) {
            return 1;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        try {
            List<User> list = new ArrayList<>();
            list.add(new User(1L, 23, new Date()));
            list.add(new User(2L, 25, DateUtils.strToDate("2020-01-01 11:12:12")));
            list.add(new User(3L, 22, DateUtils.strToDate("2020-06-01 11:12:12")));
            list.add(new User(4L, 27, DateUtils.strToDate("2020-05-01 11:12:12")));
            list.add(new User(5L, 25, DateUtils.strToDate("2020-05-02 11:12:12")));

            //Arrays.sort(list.toArray(), new UserComparator());
            Collections.sort(list);
            for (User user : list) {
                System.out.println(user.getId() + "-" + DateUtils.dateToStr(user.getTime()));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
