public class Food {
    private String name;
    private double price;
    public enum EvaluateType {DISGUSTING,BAD,NORMAL,GOOD,EXCELLENT};
    private EvaluateType evaluateType;

    public Food(String name, double price) {
        this.name = name;
        this.price = price;
        this.evaluateType = EvaluateType.NORMAL;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    /**
     * 用户针对这一食物进行评级
     * @param evaluateType:代表用户的评价
     */
    public void setEvaluateType(EvaluateType evaluateType) {
        this.evaluateType = evaluateType;
    }
    public EvaluateType getEvaluateType() {
        return evaluateType;
    }

    public String toString() {
        return "["+name + "," + price + "," + evaluateType+"]";
    }

}
