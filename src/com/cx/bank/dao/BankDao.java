package com.cx.bank.dao;

import com.cx.bank.model.MoneyBean;
import com.cx.bank.model.UserBean;
import com.cx.bank.util.MD5;
import org.junit.Test;

import java.io.*;
import java.util.Properties;

public class BankDao implements BankDaoInterface{

    public BankDao() {}
    /**
     * 更新余额
     * @param userBean
     * @param moneyBean
     * @throws IOException
     */
    @Override
    public void updateMoney(UserBean userBean, MoneyBean moneyBean) throws IOException {

        Properties props = new Properties();
        props.setProperty("uname",userBean.getName());
        props.setProperty("upwd",userBean.getPassword());
        props.setProperty("money",String.valueOf(moneyBean.getMoney()));
        FileOutputStream output =new FileOutputStream(".\\"+userBean.getName()+".properties");
        props.store(output,"");
        output.close();
    }

    /**
     * 插入用户
     * @param userBean
     * @param moneyBean
     * @throws IOException
     */
    @Override
    public void insertUser(UserBean userBean, MoneyBean moneyBean) throws IOException {
        Properties props = new Properties();
        MD5 md5=new MD5();

        props.setProperty("uname",userBean.getName());

        props.setProperty("upwd",md5.getMD5(userBean.getPassword()));

        String money=String.valueOf(moneyBean.getMoney());

        props.setProperty("money",money);
        FileOutputStream output = new FileOutputStream(".\\"+userBean.getName() + ".properties");
        props.store(output,"");
        output.close();
    }

    /**
     * 查找用户
     * @param userBean
     * @param moneyBean
     */
    @Override
    public void findUser(UserBean userBean, MoneyBean moneyBean) throws IOException {
        Properties props = new Properties();
        FileInputStream input = new FileInputStream(".\\"+userBean.getName() + ".properties");
        props.load(input);

        userBean.setName(props.getProperty("uname"));
        userBean.setPassword(props.getProperty("upwd"));
        moneyBean.setMoney(Double.parseDouble(props.getProperty("money")));
        input.close();
    }
@Test
public void test() throws IOException {
        UserBean userBean = new UserBean();
        MoneyBean moneyBean = new MoneyBean();
        userBean.setName("zqw");
        findUser(userBean,moneyBean);
}
    /**
     *
     * @param moneyBean
     * @param _uname
     * @param money
     * @throws IOException
     */
    @Override
    public void transfer(MoneyBean moneyBean, String _uname, String money) throws IOException {
        Properties props = new Properties();
        File file = new File(".\\"+_uname + ".properties");

        FileInputStream input = new FileInputStream(file);
        props.load(input);
        input.close();

        moneyBean.setMoney(moneyBean.getMoney()-Double.parseDouble(money));
        double money0=Double.parseDouble(props.getProperty("money"))+Double.parseDouble(money);

        props.setProperty("money",String.valueOf(money0));

        FileOutputStream output = new FileOutputStream(file);
        props.store(output,"");

    }
}