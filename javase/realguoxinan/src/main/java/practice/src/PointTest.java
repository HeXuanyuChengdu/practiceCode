import java.util.Objects;

/**
 * 一个{@code Point}表示平面坐标上任意一个点，例如原点(0,0)
 * 一个点主要有x坐标和y坐标
 */
class Point {
    private double x;
    private double y;

    public static final Point Origin = new Point(0, 0);

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //作为拷贝函数
    public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * 计算两个点的距离
     *
     * @param start 起始点
     * @param end   结束点
     * @return 两点之间的距离
     */
    public static double calculateDistance(Point start, Point end) {
        return Math.hypot(start.x - end.x, start.y - end.y);
    }

    /**
     * 计算该点到原点的距离
     *
     * @return 返回这个点到原点的距离
     */
    public double calculateDistanceToOrigin() {
        return Point.calculateDistance(this, Origin);
    }


}

/**
 * 一个{@code Circle}表示一个平面坐标系中的任意圆，主要有半径和原型两个属性
 */
class Circle {
    private double radius;
    private Point center;

    public Circle(double radius, Point center) {
        if (radius < 0) {
            throw new IllegalArgumentException();
        }else {
            this.radius = radius;
        }
        //this.radius = radius;
        this.center = Objects.requireNonNull(center,"圆心不能为空");
    }

    public double getRadius() {
        return radius;
    }
    public Point getCenter() {
       return new Point(this.center);
    }

    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException();
        }else {
            this.radius = radius;
        }
    }
    public void setCenter(Point center) {
        if (center == null) {
            throw new IllegalArgumentException();
        }
        this.center = center;
    }

    /**
     * 计算这个圆的周长
     * @return 这个圆的周长
     */
    public double calculatePerimeter(){
        return 2 * Math.PI * radius;
    }

    /**
     * 计算这个圆的面积
     * @return 这个圆的面积
     */
    public double calculateArea(){
        return Math.PI * radius * radius;
    }
}


public class PointTest {
    public static void main(String[] args) {
        Point p1 = new Point(15, 15);
        System.out.println("p1的点坐标是: " + p1.getX()+","+p1.getY());
        System.out.println("原点坐标是:"+Point.Origin.getX()+","+Point.Origin.getY());
    }
}