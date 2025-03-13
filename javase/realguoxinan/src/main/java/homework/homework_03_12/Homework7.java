package main.java.homework.homework_03_12;

import java.util.Objects;

public class Homework7 {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        Vehicle car = new Vehicle(0.0,new Volume(100,100,100),"🚗");

        System.out.println(car);

        System.out.println("为您的交通工具设置一个起步速度吧！");
        int userInput = Homework6.handleUserInput();
        car.setSpeed(userInput);
        System.out.printf("设置成功!当前%s的速度为%.2f\n",car.getName(),car.getSpeed());

        System.out.println("开始加速吧！请输入您要加速的速率:");
        userInput = Homework6.handleUserInput();
        car.speedUp(userInput);
        System.out.printf("加速成功!当前%s的速度为%.2f\n",car.getName(),car.getSpeed());

        System.out.println("开始减速吧！请输入您要加速的速率:");
        userInput = Homework6.handleUserInput();
        car.speedDown(userInput);
        System.out.printf("减速成功!当前%s的速度为%.2f\n",car.getName(),car.getSpeed());

    }


}

/**
 * 一个{@code Vehicle}对象代表了一种交通工具，主要有速率和体积两种属性
 * 交通工具可以移动、加速、减速
 */
class Vehicle{
    private double speed;
    private  Volume volume;
    private String name;

    public Vehicle(double speed, Volume volume, String name) {
        if (speed >= 0) {
            this.speed = speed;
        } else {
            System.out.println("初始速率不能为负值!");
            throw new ArithmeticException();
        }
        this.volume = Objects.requireNonNull(volume);
        this.name = Objects.requireNonNull(name);
    }

    public double getSpeed() {
        return speed;
    }
    public Volume getVolume() {
        return volume;
    }

    public void setSpeed(double speed) {
        if(speed > 0){
            this.speed = speed;
        }else {
            System.out.println("速率不能为负值！");
        }
    }

    /**
     * 对交通工具进行加速
     * @param speed 要加速的具体值
     */
    public void speedUp(double speed){
        if(speed >= 0){
            this.speed = this.speed + speed;
        }else {
            System.out.println("不能用负值速率进行加速，您是否希望减速？");
        }
    }

    /**
     * 对交通工具进行减速
     * @param speed 要减少的速率
     */
    public void speedDown(double speed){
        if(speed >= 0){
            if (this.speed - speed >= 0) {
                this.speed = this.speed - speed;
            }else{
                System.out.println("超过目前速度值，直接减速为0");
                this.speed = 0;
            }
        }else {
            System.out.println("不能用负值进行减速，请输入您希望减慢的速率的绝对值");
        }
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return "名称:"+this.name
                +"\t速度:"+this.speed
                +"\t体积(长，宽，高):"+this.volume.length()+","+this.volume.width()+","+this.volume.height()
                +"\t体积值："+Volume.calculateVolume(this.volume);
    }

}

/**
 * 表示体积的记录 近似为长方体看待
 * @param length 表示物体的长
 * @param width  表示物体的宽
 * @param height 表示物体的高
 */
record Volume(double length, double width, double height){
    public Volume{
        if (length == 0 || width == 0 || height == 0){
            throw new ArithmeticException();
        }
    }

    /**
     * 获得一个体积的具体数值
     * @param volume 要计算的体积的具体值
     * @return 对应的具体体积值
     */
    public static double calculateVolume(Volume volume){
        return volume.length * volume.width * volume.height;
    }
}
