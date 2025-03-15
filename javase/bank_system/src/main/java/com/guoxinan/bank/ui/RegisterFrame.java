package com.guoxinan.bank.ui;

import com.guoxinan.bank.service.RegisterService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame {
    private RegisterService registerService;
    private LoginFrame loginFrame; //持有登录界面引用，方便注册成功后跳转回去

    private JLabel accountNumberHintLabel;
    private JTextField accountNumberField;
    private JLabel passwordHintLabel;
    private JPasswordField passwordField;
    private JButton registerButton;


    public RegisterFrame(RegisterService registerService, LoginFrame loginFrame) {
        this.registerService = registerService;
        this.loginFrame = loginFrame;

        layoutRegisterFrame();
    }

    /**
     * 实现对注册页面的布局
     */
    private void layoutRegisterFrame() {
        setTitle("注册页面");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10); // 组件边距（上、左、下、右）
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // 用户名标签
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(new JLabel("用户名："), gbc);

        // 用户名输入框
        accountNumberField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1; // 允许横向拉伸
        panel.add(accountNumberField, gbc);

        // 用户名格式提示
        accountNumberHintLabel = new JLabel("格式要求：8位数字");
        accountNumberHintLabel.setForeground(Color.GRAY);
        accountNumberHintLabel.setFont(new Font("宋体", Font.PLAIN, 10));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2; // 跨两列
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(accountNumberHintLabel, gbc);

        // 密码标签
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1; // 重置跨列
        panel.add(new JLabel("密码："), gbc);

        // 密码输入框
        passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(passwordField, gbc);

        // 密码格式提示
        passwordHintLabel = new JLabel("格式要求：8位以上，含大小写和数字");
        passwordHintLabel.setForeground(Color.GRAY);
        passwordHintLabel.setFont(new Font("宋体", Font.PLAIN, 10));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(passwordHintLabel, gbc);

        // 注册按钮
        registerButton = new JButton("注册");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE; // 不拉伸按钮
        gbc.insets = new Insets(20, 0, 10, 0); // 增加上下边距
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRegisterButtonClicked();
            }
        });
        panel.add(registerButton, gbc);

        add(panel);

    }

    public void onRegisterButtonClicked() {
        String accountNumber = accountNumberField.getText();
        String password = new String(passwordField.getPassword());
        try{
            //调用注册逻辑
            boolean success = registerService.register(accountNumber, password);
            if (success) {
                //处理成功情况
                JOptionPane.showMessageDialog(this,"注册成功!");
                this.dispose(); //关闭注册页面回到登录界面
                loginFrame.setVisible(true);
            }else {
                //JOptionPane.showMessageDialog(this,"注册失败:"+e.getMessage());
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(this,"注册失败:"+e.getMessage());
        }

    }
}
