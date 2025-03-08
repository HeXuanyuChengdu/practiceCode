import java.util.Scanner;

public class Customer {
    private  static long customerId = 20250001;
    private String customerName;
    private Food[] eatList;
    public  final int MAX_EAT = 20;
    private int realeatlength;


    public Customer(String customerName) {
        this.customerName = customerName;
        customerId = customerId++;
        eatList = new Food[MAX_EAT];
        realeatlength = 0;
    }

    public String getCustomerName() {
        return customerName;
    }
    public int getRealeatlength() {
        return realeatlength;
    }

    /**
     * 对签收完的订单上的食物把它吃掉
     * @param food 吃掉的食物
     */
    public void eatFood(Food food) {
        eatList[realeatlength] = food;
        realeatlength++;
    }

    public Food[] getEatList() {
        return eatList;
    }

    /**
     * 顾客进行点餐
     * @return 生成一个待完成订单
     * @param restaurant 点餐的餐馆
     * @param orderCode 点餐序号
     */
    public Order createOrder(Restaurant restaurant,int orderCode) {
        Food targetFood = restaurant.getMenu().getFood(orderCode);
        //Food[] targetFoods = new Food[]{targetFood};
        return new Order(targetFood, this,restaurant);
    }

    /**
     * 对食物进行评价
     * @param food :要评价的食物
     */
    public void evaluateFood(Food food,int evaluateCode) {
        Food.EvaluateType evaluateUser = switch (evaluateCode){
            case 1 -> Food.EvaluateType.DISGUSTING;
            case 2 -> Food.EvaluateType.BAD;
            case 3 -> Food.EvaluateType.NORMAL;
            case 4 -> Food.EvaluateType.GOOD;
            case 5 -> Food.EvaluateType.EXCELLENT;
            default -> throw new IllegalStateException("Unexpected value: " + evaluateCode);
        };
        food.setEvaluateType(evaluateUser);
    }


}
