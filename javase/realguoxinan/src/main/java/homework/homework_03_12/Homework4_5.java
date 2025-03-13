package main.java.homework.homework_03_12;

import java.util.Objects;

public class Homework4_5 {
    public static void main(String[] args) {
        Point aPoint = new Point(3,4);
        Circle untiCircle = new Circle(1,new Point(0,0));

        if(untiCircle.isInCircle(aPoint)){
            System.out.println(aPoint+"在单位圆上");
        }else {
            System.out.println(aPoint+"不在单位圆上");
        }

    }


}

/**
 * 记录平面坐标系中的定点
 * @param x 定点的x坐标
 * @param y 定点的y坐标
 */
record Point(double x, double y) {
    /**
     * 计算两个点之间的距离
     * @param start 开始点
     * @param end 结束点
     * @return 两点之间的距离
     */
    public static double calculateDistance(Point start, Point end) {
        return Math.hypot(start.x - end.x, start.y - end.y);
    }
}

/**
 * 一个{@code Circle}对象表示平面坐标系中的一个圆
 * 主要有半径和一个作为圆心的定点两个属性
 */
class Circle{
    double radius;
    Point center;

    public Circle(double radius, Point center) {
        this.radius = radius;
        this.center = Objects.requireNonNull(center,"点不能为空!");
    }

    public Point getCenter() {
        return center;
    }
    public double getRadius() {
        return radius;
    }

    /**
     * 判断一个定点是否在圆内部（包括圆上）
     * @param point 要判断的点
     * @return 如果在返回true，否则返回false
     */
    public boolean isInCircle(Point point){
        return Point.calculateDistance(center, point) <= radius;
    }
}