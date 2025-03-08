import java.time.LocalTime;

public class Restaurant {

    private String restaurantName;
    private String restaurantAddress;
    private LocalTime openTime;
    private LocalTime closeTime;
    private Food[] foodList;
    private Menu menu;
    private Order[] orderList;//实际元素商都是this.indexOrder，length是最大长度
    //private int userCode;
    private int indexOrderList = 0;

    public final int MAX_ORDER = 100;
    public enum foodType {BOILED_FISH,FRIED_PIG_KIDNEY,TWICE_COOKED_PORK,MAPO_TOFU}
    public enum OperationStatus {OK,ERROR};

    public Restaurant() {
        this.restaurantName = "大大小饭店";
        this.restaurantAddress = "火星路333号";
        this.openTime = LocalTime.of(10, 0);
        this.closeTime = LocalTime.of(20, 0);

        foodType[] types = foodType.values();//获取枚举常量
        this.foodList = new Food[types.length];//初始化foodlist数组
        for (int i = 0; i < types.length; i++) {
            this.foodList[i] = creatFoodFromType(types[i]);
        }

        this.menu = new Menu(foodList);
        this.orderList = new Order[MAX_ORDER];
    }

    private Food creatFoodFromType(foodType type) {
        return  switch (type){
            case BOILED_FISH -> new Food("水煮鱼",48.00);
            case FRIED_PIG_KIDNEY -> new Food("炒腰花",40.00);
            case TWICE_COOKED_PORK -> new Food("回锅肉",35.00);
            case MAPO_TOFU -> new Food("麻婆豆腐",18.00);
        };

    }
    
    public String getRestaurantName() {
        return restaurantName;
    }
    public String getRestaurantAddress() {
        return restaurantAddress;
    }
    //LocalTime是不可变类
    public LocalTime getOpenTime() {
        return openTime;
    }
    public LocalTime getCloseTime() {
        return closeTime;
    }
    public Food[] getFoodList() {
        return (Food[]) foodList.clone();
    }
    public Menu getMenu() {
        return menu;
    }
//
   

    public void setOrderList(Order order) {
        orderList[indexOrderList] =order ;
        indexOrderList++;
    }
    public int getIndexOrderList() {
        return indexOrderList;
    }

    public Order[] getOrderList() {
        return (Order[]) orderList.clone();
    }

    /**
     * 从餐厅订单列表中删除订单
     * @param orderId 要删除的订单编号
     * @return 成功返回OK，否则返回ERROR
     */
    public OperationStatus deleteOrder(int orderId) {
        int indexDeleteOrder = getOrderIndexById(orderId);
        if (indexDeleteOrder != -1) {
            for (int i = indexDeleteOrder; i < indexOrderList; i++) {
                orderList[i] = orderList[i+1];
            }
            indexOrderList--;
            return OperationStatus.OK;
        }else {
            System.out.println("试图删除的订单不存在!");
            return OperationStatus.ERROR;
        }

    }

    /**
     * 通过目标订单ID获取在餐馆订单列表中的索引
     * @param orderId 想要寻找的Order的ID
     * @return 若找到返回对应索引，否则返回-1
     */
    private int getOrderIndexById(int orderId) {
        int indexDeleteOrder = -1;
        //找到对应id的order索引
        for (int i = 0; i < this.indexOrderList; i++) {
            if (orderList[i].getId() == orderId) {
                indexDeleteOrder = i;
                break;
            }
        }
        return indexDeleteOrder;
    }

    /**
     * 对订单进行签收
     * @param orderId 将要签收的订单索引
     * @return 若成功签收，返回表示操作成功的枚举常量OK，否则返回ERROR
     */
    public OperationStatus signOrder(int orderId,Customer customer) {
        int indexSignOrder = getOrderIndexById(orderId);
        if (indexSignOrder != -1) {
            if (orderList[indexSignOrder].getOrderStatus() == Order.OrderStatus.STANDING_BY) {
                orderList[indexSignOrder].setOrderStatus(Order.OrderStatus.FINISHED);
                customer.eatFood(orderList[indexSignOrder].getOrderFood());
            }else {
                System.out.println("不能签收已完成的订单！");
                return OperationStatus.ERROR;
            }
        }else {
            System.out.println("试图签收的订单不存在!");
            return OperationStatus.ERROR;
        }
        return OperationStatus.OK;
    }
    //public String get

    
//    public void runningRestaurant() {
//        UI frame = new UI(this);
//        frame.displayStartFrame();
//
//    }

    /**
     * 关闭餐厅
     */
    public void closeRestaurant() {

    }

    public String toString() {
        return "Restaurant [restaurantName=" + restaurantName + ", restaurantAddress="+restaurantAddress+"]";
    }

}
