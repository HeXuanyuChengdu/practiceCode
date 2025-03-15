package com.guoxinan.bank.ui;

import com.guoxinan.bank.domain.Account;
import com.guoxinan.bank.domain.State;
import com.guoxinan.bank.service.BankService;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class MainFrame extends javax.swing.JFrame {
    private BankService bankService;
    private Account curentAccount;

    private JLabel balanceLabel;
    private JTextField amountField;
    private JRadioButton depositButton, withdrawButton;
    private JButton confirmButton;


    public MainFrame(BankService bankService, Account account) {
        this.bankService = bankService;
        this.curentAccount = account;

        layoutMainFrame();



    }
    public MainFrame() {
        this.curentAccount = Account.createAccount("test", "test");
        layoutMainFrame();
    }

    private void layoutMainFrame() {
        // 设置窗口属性
        setTitle("银行账户管理");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        // 初始化组件
        balanceLabel = new JLabel("当前余额: ￥" + curentAccount.getBalance() );
        amountField = new JTextField(15);
        depositButton = new JRadioButton("存款");
        withdrawButton = new JRadioButton("取款");
        confirmButton = new JButton("确认");

        // 组单选按钮，确保只有一个选项可选
        ButtonGroup group = new ButtonGroup();
        group.add(depositButton);
        group.add(withdrawButton);
        depositButton.setSelected(true); // 默认选中存款

        // 添加组件到界面
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // 组件间距

        // 余额显示（第一行）
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // 占据两列
        gbc.anchor = GridBagConstraints.CENTER;
        add(balanceLabel, gbc);

        // 金额输入框（第二行）
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(amountField, gbc);

        // 单选按钮组（第三行）
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(depositButton, gbc);

        gbc.gridx = 1;
        add(withdrawButton, gbc);

        // 确认按钮（第四行）
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        confirmButton.addActionListener(e -> onConfirmButtonClick());
        add(confirmButton, gbc);
    }

    /**
     * 确认按钮的响应方法
     */
    public void onConfirmButtonClick(){
        double amount = Double.parseDouble(amountField.getText());
        //用户选择存钱
        if(depositButton.isSelected()){
            try {
                bankService.deposit(curentAccount,amount);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "金额必须为正");
            }
        }
        //用户选择取钱
        else if(withdrawButton.isSelected()){
            boolean success = bankService.withdraw(curentAccount,amount);
            if(!success){
                JOptionPane.showMessageDialog(this,"余额不足");
            }
        }
        updateBalanceDisplay();
    }

    /**
     * 更新余额显示
     */
    private void updateBalanceDisplay() {
        balanceLabel.setText("￥" + String.format("%.2f", curentAccount.getBalance()));
    }

    public static void main(String[] args) {
        MainFrame ui = new MainFrame();
        ui.setVisible(true);
    }

}
