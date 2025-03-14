package inheritance;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class ManagerTest {
    public static void main(String[] args) {
//        Employee[] staff = new Employee[3];
//        staff[0] = new Employee("小明",75000,2024,12,31);
//        staff[1] = new Employee("王老五",80000,2024,7,15);
//        staff[2] = new Manager("王鑫",90000,2018,9,1);
//       // staff[2].setBound()
//        //Manager boss = staff[2];
//
//
////        Manager[] managers = new Manager[3];
////        Employee[] staff2 = managers;
////        staff2[0] = new Employee(1000,2020,11,11);
////        System.out.println(staff2[0]);
//
//        for (Employee e : staff) {
//            System.out.println(e);
//            e.raiseSalary(15);
//          // System.out.println("提升15%薪水后,"+e.getName()+"的薪水是"+e.getSalary());
//            System.out.printf("%s提升15%%薪水后，薪水为%,.2f\n",e.getName(),e.getSalary());
//        }

        Employee e = new Employee("haha",1000,2024,12,31);

        if(e instanceof Manager a){
            System.out.println(a.getName());
        }


        System.out.println(m);
    }




}

/**
 * 一个{@code Employee}对象表示了一名普通员工，
 * 拥有id，姓名，薪水。入职日期四个属性
 */
class Employee {
    private static long nextId = 20250001;

    private long id;
    private String name;
    private BigDecimal salary;
    private LocalDate hireDay;

    {
        this.id = nextId;
        nextId++;
    }

    public Employee( String name, double salary, int year,int month, int day) {
        this.name = Objects.requireNonNull(name,"员工姓名不能为null!");
        this.salary = BigDecimal.valueOf(salary);
        this.hireDay = LocalDate.of(year, month, day);
    }

    public Employee(double salary, int year, int month, int day) {
        this("Employee#"+nextId, salary,year,month,day);
        this.id = nextId;
        nextId++;
    }



    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getSalary() {
        return this.salary.doubleValue();
    }
    public LocalDate getHireDay() {
        return hireDay;
    }

    /**
     * 根据百分比提升员工的薪资，e.g.10代表提高10%
     * @param byPercent 提升薪资的百分比
     */
    public void raiseSalary(int byPercent) {
        double raise = salary.doubleValue() * byPercent / 100;
        salary = salary.add(BigDecimal.valueOf(raise));
    }

    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary+ ", hireDay=" + hireDay + "]";
    }

}

/**
 * 一个{@code Manager}对象继承自Employee，代表经理员工
 * 除了Employee的四种属性(姓名，ID，薪水，入职日期)外，还有一个额外的属性是经理独有的奖金
 */
class Manager extends Employee {
    private BigDecimal bound;
    public final double BASE_FOUND = 5000.0;

    public Manager(String name, double salary,int year,int month, int day) {
        super(name, salary, year, month, day);
        this.bound = BigDecimal.valueOf(BASE_FOUND);
    }

    public double getBound() {
        return bound.doubleValue();
    }

    public void setBound(double bound) {
        this.bound = BigDecimal.valueOf(bound);
    }

    /**
     * 由于经理的工资构成与普通的Employee不同，因此需要重写该方法
     * 经理的工资为基本工资+奖金
     * @return 经理工资的double值
     */
    @Override
    public double getSalary() {
        return super.getSalary()+this.bound.doubleValue();
    }

    /**
     * 经历的工资计算方法不同，因为经理的工资要加上奖金部分
     * @param byPercent 提升薪资的百分比
     */
    public void raiseSalary(int byPercent) {
        double raise = (bound.doubleValue()+super.getSalary()) * byPercent / 100;
        bound = bound.add(BigDecimal.valueOf(raise));
    }

    public String toString() {
        return "Manager [id="+super.getId()+",name = "+super.getName()+",salary="+this.getSalary()
                +",hireDay="+super.getHireDay()+ ",bound=" + bound + ", base=" + BASE_FOUND + "]";
    }


}