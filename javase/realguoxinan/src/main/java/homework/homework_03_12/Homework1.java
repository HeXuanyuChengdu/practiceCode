package main.java.homework.homework_03_12;

import java.util.Objects;

public class Homework1 {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("🐱","公");
        students[1] = new Student("小明","男");
        students[2] = new Student("🚁","武装直升机");

        for (Student student : students) {
            student.showInfo();
        }
    }

}

/**
 * 一个{@code Student}对象表示一个学生，学生有姓名、学号、性别属性；
 * 有查看学生信息的showInfo()方法
 */
class Student{
    private static int nextId;

    private int id;
    private String name;
    private String gender;

    static
    {
        nextId = (int)(Math.random()*100);
    }
    {
        id = nextId;
        nextId++;
    }

    public Student(String name, String gender){
        this.name = Objects.requireNonNull(name,"姓名不能为空!");
        this.gender = Objects.requireNonNull(gender,"性别不能为空！");
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }

    /**
     * 显式这个学生的学生
     */
    public void showInfo(){
        System.out.println("学号:"+this.id+",姓名:"+this.name+",性别:"+this.gender);
    }
}
