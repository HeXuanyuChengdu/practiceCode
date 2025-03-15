package com.guoxinan.bank.ui;

import com.guoxinan.bank.domain.Account;
import com.guoxinan.bank.service.AuthService;
import com.guoxinan.bank.service.BankService;
import com.guoxinan.bank.service.RegisterService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends javax.swing.JFrame {
    private AuthService authService;
   // private AccountDAO accountDAO;
    private BankService bankService;
    private RegisterService registerService;

    private JTextField accountField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private JButton registerButton;

    public LoginFrame(AuthService authService, BankService bankService, RegisterService registerService) {
        this.authService = authService;
        this.bankService = bankService;
        this.registerService = registerService;

        layoutLoginFrame();

    }

    private void layoutLoginFrame() {
        setTitle("登录界面");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //设置用户在启动关闭时结束程序
        setSize(300, 150);//设置组件的宽和高
        setLocationRelativeTo(null);  //位于屏幕中央

        // 创建面板并使用 GridBagLayout
        JPanel panel = new JPanel();//一个轻量级容器
        panel.setLayout(new GridBagLayout());//水平垂直对齐不要求大小的布局管理器
        GridBagConstraints gbc = new GridBagConstraints();//与GridBagLayout关联的约束对象
        gbc.insets = new Insets(5, 5, 5, 5);//组件和边缘的距离
        gbc.fill = GridBagConstraints.HORIZONTAL;//调整组件，水平填充，不改变高度

        // 添加账号字段
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("账户:"), gbc);

        gbc.gridx = 1;
        accountField = new JTextField(15);
        panel.add(accountField, gbc);

        // 添加密码字段
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("密码:"), gbc);

        gbc.gridx = 1;
        passwordField = new JPasswordField(15);
        panel.add(passwordField, gbc);

        // 添加登录按钮
        gbc.gridx = 1;
        gbc.gridy = 2;
        loginButton = new JButton("登录");
        panel.add(loginButton, gbc);

        gbc.gridx = 2;
        registerButton = new JButton("注册");
        panel.add(registerButton, gbc);

        //添加监听器
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                onLoginButtonClick();
            }
        });
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                onRegisterButton();
            }
        });


        // 将面板添加到窗口
        add(panel);
    }

    private void onRegisterButton() {
        System.out.println("注册");
        RegisterFrame registerFrame = new RegisterFrame(registerService,this);
        registerFrame.setVisible(true);
        //隐藏当前界面
        this.setVisible(false);
    }

    /**
     * 登录按钮回调函数
     */
    public void onLoginButtonClick(){
        String accountNumber = accountField.getText();
        String password = new String(passwordField.getPassword());
        if(authService.login(accountNumber, password)){
            //登录成功，打开主界面,ui层不应该直接接触数据访问层，而是通过业务逻辑层调用
            Account account = authService.getAccountDAO().findAccountById(accountNumber);
            new MainFrame(bankService,account).setVisible(true);//显示mainFrame
            this.dispose();//释放loginFrame的所有组件
        }else{
            JOptionPane.showMessageDialog(this, "账户与密码不匹配!");
        }

    }
}
