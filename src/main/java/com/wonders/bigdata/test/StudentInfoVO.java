package com.wonders.bigdata.test;

import java.util.List;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2020/4/27 14:07
 */
public class StudentInfoVO {
    private String name;
    private List<Result> results;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public class Result {
        private String name;
        private int score;

        public Result(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }
}
