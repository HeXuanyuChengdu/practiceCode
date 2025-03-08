public class Menu {
    private Food[] foods;
    private  String menuHead ;
    private int foodNumber;

    public enum menuHeadType {SEQUENCE,FOOD_NAME,FOOD_PRICE,};



    public Menu(Food[] foodList) {
        this.foods = foodList;
        this.foodNumber = foods.length;
        menuHeadType[] menuHeadTypeArray = menuHeadType.values();
        this.menuHead = creatMenuHeadByType(menuHeadTypeArray);

    }

    /**
     * 创建菜单表头的字符串
     * @param menuHeadTypeArray:存放菜单表头的枚举常量数组
     * @return 代表菜单表头的字符串
     */
    private String creatMenuHeadByType(menuHeadType[] menuHeadTypeArray) {
        StringBuilder headBuilder = new StringBuilder();
        for(menuHeadType headType : menuHeadTypeArray) {
            switch (headType) {
                case SEQUENCE:
                    headBuilder.append("序号\t\t");
                    break;
                case FOOD_NAME:
                    headBuilder.append("菜品名\t\t");
                    break;
                case FOOD_PRICE:
                    headBuilder.append("单价\t\t");
                    break;
            }
        }
        return headBuilder.toString();

    }

    /**
     * 在控制台输出菜单内容
     */
    public void displayMenu() {
        int count = 1;
        System.out.println(menuHead);
        for(Food food : foods) {
            String evaluate = switch (food.getEvaluateType()){
                case DISGUSTING -> "恶心";
                case BAD -> "不好吃";
                case NORMAL -> "一般";
                case GOOD -> "好吃";
                case EXCELLENT -> "人间美味";
            };
            System.out.printf("%d\t%s(%s)\t\t%.2f\n",count,food.getName(),evaluate,food.getPrice());
            count++;
        }
        //foodNumber = count;
    }

    /**
     * 计算这份菜单的总价
     * @return 菜单上所有菜品的总价
     */
    public double accountMenu(){
        double sum = 0;
        for(Food food : foods) {
            sum += food.getPrice();
        }
        return sum;
    }

    public int getFoodNumber() {
        return foodNumber;
    }

    public Food[] getFoods() {
        return foods;
    }

    /**
     * 根据食物序号获得对应的食物对象
     * @param orderCode 在菜单上的食物序号
     * @return 对应的食物对象
     */
    public Food getFood(int orderCode) {
        return foods[orderCode-1];
    }




    public static void main(String[] args) {
        Food[] foodList = new Food[3];
        foodList[0] = new Food("红烧鱼",2.5);
        foodList[1] = new Food("回锅肉",10.8);
        foodList[2] = new Food("炒腰花",35.0);
        Menu menu = new Menu(foodList);
        menu.displayMenu();
    }

}
