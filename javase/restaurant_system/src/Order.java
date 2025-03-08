import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private Food orderFood;
    private Customer customer;
    private Restaurant targetRestaurant;
    private static long nextid = 20250001 ;
    private long id;
    private LocalTime orderTime;
    public enum OrderStatus {FINISHED, STANDING_BY};
    private OrderStatus orderStatus;

    public Order(Food orderFood, Customer customer, Restaurant targetRestaurant) {
        this.orderFood = orderFood;
        this.customer = customer;
        this.targetRestaurant = targetRestaurant;
        this.orderStatus = OrderStatus.STANDING_BY;
        id = nextid;
        nextid++;
        this.orderTime = LocalTime.now();
    }


    public Food getOrderFood() {
        return orderFood;
    }
    public Customer getCustomer() {
        return customer;
    }
    public Restaurant getTargetRestaurant() {
        return targetRestaurant;
    }
    public LocalTime getOrderTime() {
        return orderTime;
    }
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    public long getId() {
        return id;
    }

    /**
     * 通过ID获得订单对应的食物
     * @param id 提供的订单ID
     * @return 对应的食物
     */
    public Food getOrderFoodByID(long id) {
        return orderFood;
    }


    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String formattedTime =orderTime.format(formatter);
        return "[订单编号:"+id+",订单食物:"+orderFood.toString()+",订单餐馆:"+targetRestaurant.getRestaurantName()+",订单时间"+formattedTime+"]";
    }


}
