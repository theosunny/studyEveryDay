package com.test.Util.Comparable;

import java.util.Arrays;

/**
 * 比较器测试
 */
public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    /**
     * 覆写compareTo方法
     * 1表示大于
     **/
    @Override
    public int compareTo(Student s) {
        if (this.score > s.score) {
            return -1;
        } else if (this.score < s.score) {
            return 1;
        } else {
            if (this.age > s.age) {
                return -1;
            } else if (this.age < s.age) {
                return 1;
            }
            return 0;
        }

    }

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public static void main(String[] args){
        Student[] ss = {
          new Student("张三",12,66),
          new Student("李四",14,68),
          new Student("王小玮",13,66)
        };
        /**
         * 实现从大到小排序了，如果没有实现Comparable接口则会报错
         */
        Arrays.sort(ss);
        for (int i = 0; i < ss.length; i++) {
            System.err.println(ss[i].toString());
        }
    }
}
