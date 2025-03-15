package com.guoxinan.bank.ui;

import com.guoxinan.bank.dao.AccountDAO;
import com.guoxinan.bank.dao.FileAccountDAO;
import com.guoxinan.bank.service.AuthService;
import com.guoxinan.bank.service.BankService;
import com.guoxinan.bank.service.RegisterService;

import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args) {
        //初始化数据访问层,选择文件系统实现
        AccountDAO accountDAO = new FileAccountDAO();

        //初始化业务逻辑层
        AuthService authService = new AuthService(accountDAO);
        BankService bankService = new BankService(accountDAO);
        RegisterService registerService = new RegisterService(accountDAO);

        //线程安全的打开登录界面
        SwingUtilities.invokeLater(() ->{
            LoginFrame loginFrame = new LoginFrame(authService, bankService, registerService);
            loginFrame.setVisible(true);
        });

    }
}
