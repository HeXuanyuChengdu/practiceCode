import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UI {
   // private String title;
    private Restaurant restaurant;
    private final String boundary = "########";
    private Customer customer;


    public enum Operation {VIEW_MENU,ORDER,WATCH,SIGN,DELETE,LIKE,EXIT,ERROR};
    private Operation operation;

    public UI(Restaurant restaurant, Customer customer) {
        this.restaurant = restaurant;
        this.customer = customer;
    }

    /**
     * 打印程序开始界面
     */
    public void displayStartFrame() {
        System.out.println(customer.getCustomerName()
                + "同志,欢迎光临"
                + restaurant.getRestaurantAddress()
                + restaurant.getRestaurantName());
        System.out.println(boundary);

    }

    /**
     * 显示用户能够进行的所有操作
     */
    public void displayMainFrame() {
        System.out.println(boundary);
        for (Operation operation : Operation.values()) {
            displayOperation(operation);
        }
    }

    /**
     * 根据用户的操作选项，显示对应文字
     * @param operation 可能的操作选项
     */
    private void displayOperation(Operation operation) {
        switch (operation) {
            case VIEW_MENU:
                System.out.println("1.浏览菜单");
                break;
            case ORDER:
                System.out.println("2.我要订餐");
                break;
            case WATCH:
                System.out.println("3.查看餐袋");
                break;
            case SIGN:
                System.out.println("4.签收订单");
                break;
            case DELETE:
                System.out.println("5.删除订单");
                break;
            case LIKE:
                System.out.println("6.我要点赞");
                break;
            case EXIT:
                System.out.println("7.退出系统");
                break;
        }
    }

    /**
     * 获取用户输入的指令
     * @return 返回对应的枚举常量
     */
    public Operation getCode(){
        int code = handleUserInput();
        return codeToOperation(code);
    }

    /**
     * 将用户键入的数字转换成对应的枚举常量
     * @param code 用户键入的数字
     * @return 对应的表示操作的枚举超量
     */
    private Operation codeToOperation(int code) {
        return switch (code) {
            case 1 -> Operation.VIEW_MENU;
            case 2 -> Operation.ORDER;
            case 3 -> Operation.WATCH;
            case 4 -> Operation.SIGN;
            case 5 -> Operation.DELETE;
            case 6 -> Operation.LIKE;
            case 7 -> Operation.EXIT;
            default -> Operation.ERROR;
        };
    }

    /**
     * 处理用户输入
     * @param operation :用户键入的用来控制流程的输入
     */
    public void handleUserInput(Operation operation) {
        switch (operation) {
            case ORDER:
                handleOrder();
                break;
            case WATCH:
                //实现查看餐袋
                handleWatch();
                break;
            case SIGN:
                //实现签收订单
                handleSign();
                break;
            case DELETE:
                //实现删除订单
                handleDelete();
                break;
            case LIKE:
                //实现点赞
                handleLike();
                break;
            case EXIT:
                System.out.println("谢谢惠顾,再见！");
                System.exit(0);
                break;
            case VIEW_MENU:
                viewMenu();
                break;
            case ERROR:
                System.out.println("输入有误！请重新输入");
                break;
        }


    }

    /**
     * 处理用户输入，避免当需要输入整数时用户输入其他类型数据
     * @return 合法的输入
     */
    private int handleUserInput(){
        Scanner scanner = new Scanner(System.in);
        int code = 0;
        boolean validInput = false;
        while (!validInput) {
            if (scanner.hasNextInt()) {
                code = scanner.nextInt();
                validInput = true;   //输入的是整数，结束循环
            } else {
                System.out.println("无效输入，请输入整数!");
                scanner.next();
            }
        }
        return code;
    }

    /**
     * 处理浏览菜单逻辑
     */
    private void viewMenu() {
        restaurant.getMenu().displayMenu();
    }


    /**
     * 处理用户要点餐的逻辑
     */
    private void handleOrder() {
        do {
            System.out.println();
            System.out.println(boundary);
            System.out.println("\t\t本店菜品");
            restaurant.getMenu().displayMenu();

            System.out.println("请输入您要点的菜品序号:");
            int number = handleUserInput();

            if (number < 1 || number > restaurant.getMenu().getFoodNumber()) {
                System.out.println("输入有误！");
                return;
            } else {
                Order newOrder = customer.createOrder(restaurant, number);
                restaurant.setOrderList(newOrder);
                System.out.println(newOrder.toString());
                System.out.println("点菜成功!\n输入0返回上一级,输入任意数继续点餐");
                int backCode = handleUserInput();
                if (backCode == 0) {
                    break;
                }

            }
        } while (true);


    }

    /**
     * 处理用户要查看餐袋的逻辑
     */
    private void handleWatch() {
        int count = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss ");
        do {

            displayOlder();
            System.out.println("输入0返回上一级");
            int backCode = handleUserInput();
            if (backCode == 0) {
                break;
            }
        } while (true);

    }

    private void displayOlder(){
        if (restaurant.getIndexOrderList() > 0) {
            int count = 0;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss ");

            System.out.println();
            System.out.println(boundary);
            System.out.println("订单编号\t\t订单内容\t\t订单时间\t\t订单状态");
            for (Order order : restaurant.getOrderList()) {
                String formatTime = order.getOrderTime().format(formatter);
                System.out.printf("%d\t%s\t%s\t%s\t\n",
                        order.getId(),
                        order.getOrderFood().getName(),
                        formatTime,
                        order.getOrderStatus());
                count++;
                if (count == restaurant.getIndexOrderList()) {
                    break;
                }

            }
        } else {
            System.out.println("还没有订单哦~");
        }
    }

    /**
     * 处理用户要签收的逻辑
     */
    private void handleSign() {
        if (restaurant.getIndexOrderList() > 0) {
            System.out.println();
            System.out.println(boundary);
            System.out.println("当前订单:");
            displayOlder();

            System.out.println("请输入要签收的订单编号:");
            int orderId = handleUserInput();
            Restaurant.OperationStatus status = restaurant.signOrder(orderId, customer);

            if (status == Restaurant.OperationStatus.OK) {
                System.out.println("签收成功！祝您用餐愉快");
            }
        } else {
            System.out.println("还没有订单哦~");
        }
    }

    /**
     * 处理用户删除订单的逻辑
     */
    private void handleDelete() {
        if (restaurant.getIndexOrderList() > 0) {
            System.out.println();
            System.out.println(boundary);
            System.out.println("当前订单:");
            displayOlder();

            System.out.println("请输入要删除的订单编号:");
            int orderId = handleUserInput();

            Restaurant.OperationStatus status = restaurant.deleteOrder(orderId);
            if (status == Restaurant.OperationStatus.OK) {
                System.out.println("删除成功");
            }
        } else {
            System.out.println("还没有订单哦~");

        }

    }

    /**
     * 处理用户点赞菜品的逻辑
     */
    private void handleLike() {
        int count = 1;
        int index = 0;
        Scanner scanner = new Scanner(System.in);
        String userInputFood;
        int userInputEvaluate;
        System.out.println();
        System.out.println(boundary);

        if (customer.getRealeatlength() == 0) {
            System.out.println("您还没有品尝过本店的食物哦~");
            return;
        } else {
            System.out.println("您已经品尝过的食物有:");
            for (Food food : customer.getEatList()) {
                System.out.println(food.getName());
                index++;
                if (index == customer.getRealeatlength()) {
                    break;
                }
            }

        }

        System.out.println();
        System.out.println("请输入您要评价的食物名称:");
        userInputFood = scanner.next();
        Food choiceFood = null;
        index = 0;
        for (Food food : customer.getEatList()) {
            if (food.getName().equals(userInputFood)) {
                choiceFood = food;
                break;
            }
            index++;
            if (index == customer.getRealeatlength())
                break;
       }
       if(choiceFood == null){
           System.out.println("抱歉，您暂时没吃过这种食物哦~");
           return;
       }
        System.out.println("评价标准为:");
        String standard = """
                1.恶心
                2.不好吃
                3.一般
                4.好吃
                5.人间美味
                """;
        System.out.println(standard);
        System.out.println("请选择您的评价:");
        userInputEvaluate = handleUserInput();
        customer.evaluateFood(choiceFood,userInputEvaluate);

    }

    public void process() {
        displayStartFrame();
        while (true) {
            displayMainFrame();
            System.out.println(boundary);
            System.out.println("请输入您的选择");
            Operation userOperation = getCode();
            handleUserInput(userOperation);
        }

    }
}
