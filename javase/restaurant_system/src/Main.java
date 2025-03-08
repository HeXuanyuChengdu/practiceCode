import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的姓名:");
        String customerName = scanner.nextLine();
        Restaurant restaurant = new Restaurant();
        Customer customer = new Customer(customerName);

        //System.out.println(restaurant.toString());

        UI ui = new UI(restaurant, customer);
        ui.process();
    }
}