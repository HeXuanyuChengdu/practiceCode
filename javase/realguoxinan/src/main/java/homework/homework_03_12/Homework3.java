package main.java.homework.homework_03_12;

public class Homework3 {
    public static void main(String[] args) {
        Laptop[] laptops = new Laptop[3];
        laptops[0] = new Laptop("猜想","OX1234",new Size(16.0,18.0),Laptop.Status.OFF);
        laptops[1] = new Laptop("美硕","FX_504",new Size(15.4,19.0),Laptop.Status.OFF);
        laptops[2] = new Laptop("地球人","ZB8954",new Size(20.0,18.0),Laptop.Status.OFF);

        for (Laptop laptop : laptops) {
            System.out.println(laptop);
            System.out.println("对电脑:"+laptop.getBrand()+"#"+laptop.getModel()+"进行开机");
            laptop.turnOn();
            laptop.showInfo();
            System.out.println("对电脑:"+laptop.getBrand()+"#"+laptop.getModel()+"进行关机");
            laptop.turnOff();
            laptop.showInfo();
            System.out.println("-----------");


        }
    }

}

/**
 * 一个{@code Laptop}对象表示一台笔记本电脑
 * 拥有品牌、型号、尺寸等属性
 */
class Laptop{
    public enum Status {ON,OFF}

    private String brand;
    private String model;
    private Size size;
    private Status status;

    public Laptop(String brand, String model, Size size, Status status) {
        this.brand = brand;
        this.model = model;
        this.size = size;
        this.status = status;
    }

    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public Size getSize() {
        return size;
    }
    public Status getStatus() {
        return status;
    }

    public void turnOn(){
        if (status == Status.OFF) {
            status = Status.ON;
        }else {
            System.out.println("电脑已经开机！");
        }
    }
    public void turnOff(){
        if (status == Status.ON) {
            status = Status.OFF;
        }else{
            System.out.println("电脑已经关机！");
        }
    }

    /**
     * 代表电脑开机或关机的逻辑
     */
    public void showInfo(){
        if (status == Status.ON) {
            System.out.println("电脑开机");
        }else {
            System.out.println("电脑关机！");
        }
    }

    public String toString(){
        return brand + "\t" + model + "\t" + size + "\t" + status;
    }


}

/**
 * 表示笔记本电脑的尺寸
 * @param width 笔记本电脑的宽
 * @param length 笔记本电脑的长
 */
record Size(double width, double length) {
    public Size{
        if(width == 0 || length == 0){
            throw new ArithmeticException();
        }
    }

    /**
     * 计算一对尺寸的面积
     * @param size 要计算的尺寸
     * @return 这对尺寸的面积
     */
    public static double getArea(Size size) {
        return size.width()*size.length();
    }
}
