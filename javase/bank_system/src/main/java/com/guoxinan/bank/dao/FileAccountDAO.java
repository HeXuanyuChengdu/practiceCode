package com.guoxinan.bank.dao;

import com.guoxinan.bank.domain.Account;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Objects;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * 文件实现类，实现对文件中的数据的访问
 */
public class FileAccountDAO implements AccountDAO {
    //Maven将src/main/resources的文件复制到target/classes中
    private static final String RESOURCE_FILE = "/accounts.txt";//资源文件路径
    private static final String PROJECT_ROOT = "D:/workspace/code/javase/bank_system"; // 项目根目录
    private static final String APPDATA_DIR = PROJECT_ROOT + "/appdata"; // 存储数据的目录
    private static final String STORAGE_FILE = APPDATA_DIR + "/accounts.txt"; // 存储数据的文件路径


    /***
     * 键值对，key = accountNumber,value = account对象
     * 用来将文件中的数据存储到内存中
     */
    private HashMap<String, Account> accounts = new HashMap<>();
    //记录更新的记录
    private HashMap<String,Account> updatedAccounts = new HashMap<>();

    public FileAccountDAO() {
        loadFromFile();//从文件中加载数据
    }

    private void loadFromFile() {
       //确保appdata目录存在
       File directory = new File(APPDATA_DIR);
       if (!directory.exists()) {
           directory.mkdirs(); //如果不存在，创建个目录
       }

       //确保数据文件存在，如果不存在，从资源文件复制
        File file = new File(STORAGE_FILE);
       if (!file.exists()) {
           //打开资源文件流
           try(InputStream resourceStream = getClass().getResourceAsStream(RESOURCE_FILE) )
           {
                if (resourceStream == null) {
                    throw new FileNotFoundException("没有找到资源文件："+RESOURCE_FILE);
                }
                Files.copy(resourceStream, Path.of(STORAGE_FILE), StandardCopyOption.REPLACE_EXISTING);
           }
           catch (IOException e){
               e.printStackTrace();
           }
       }

        try (BufferedReader reader = new BufferedReader(
                //从可读写位置的资源文件读取数据
                new FileReader(STORAGE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim(); // 去除前后空格
                if (line.isEmpty()) continue; // 跳过空行

                //从文件中读取数据，构造新的账户
                String[] parts = line.split(",");
                if (parts.length != 3) {
                    System.err.println("数据格式错误，跳过该行: " + line);
                    continue;
                }

                try {
                    /*
用来暂存文件中的一条账户信息
                    Account acc = new Account(
                            parts[0],//账户号
                            parts[1],//账户密码
                            BigDecimal.valueOf(Double.parseDouble(parts[2]))//账户余额
                    );
*/
                    Account acc = Account.createAccount(parts[0],parts[1],Double.parseDouble(parts[2]));
                    //System.out.println(acc);

                    //将账户号与账户组合
                    accounts.put(acc.getAccountNumber(), acc);
                } catch (NumberFormatException e) {
                    System.out.println("无效的数字格式，跳过改行: " + line);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account findAccountById(String accountNumber) {
        //通过对应的账户号获取对应的Account对象
        return accounts.get(accountNumber);
    }

    @Override
    public void updateAccount(Account account) {
        //更新内存中的键值对
        accounts.put(account.getAccountNumber(), account);
        //加入文件
        persistToFile();
    }


    /**
     * 向文件中写入数据
     */
    private void persistToFile() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(STORAGE_FILE, false)))
        {
            for(Account acc : accounts.values()) {
                writer.write(acc.getAccountNumber() + "," + acc.getPassword() + "," + acc.getBalance());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        FileAccountDAO dao = new FileAccountDAO();
        //Account account = new Account("20250001","haoyueran1109",BigDecimal.valueOf(100.00));

       // dao.updateAccount(account);
        System.out.println(dao.findAccountById("20250001"));
    }
}
