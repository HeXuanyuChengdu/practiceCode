package frame;

import javax.swing.*;

public class LoginFrame {

    /**
     * 运行客户端界面
     */
    public static void launchLoginFrame() {
        JFrame frame = new JFrame("门诊管理系统");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);  //居中

        addWidgetsToFrame(frame);

        frame.setVisible(true);  //确保运行
    }

    /**
     * 向界面添加组件
     * @param frame:要添加组件的界面对象
     */
    public static void addWidgetsToFrame(JFrame frame) {
        frame.setLayout(null);

        JLabel usernameLabel = new JLabel("用户名");
        usernameLabel.setBounds(320,250,40,20);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(370,250,100,20);

        JButton confirmButton = new JButton("确定");
        confirmButton.setBounds(480,250,60,20);


        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(confirmButton);

    }
}
