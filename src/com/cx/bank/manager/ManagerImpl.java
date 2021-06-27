
 package com.cx.bank.manager;

 import com.cx.bank.dao.BankDaoImpl;
 import com.cx.bank.model.MoneyBean;
 import com.cx.bank.model.UserBean;
 import com.cx.bank.util.AccountOverDrawnException;
 import com.cx.bank.util.InvalidDepositException;

 import java.io.File;
 import java.io.FileInputStream;
 import java.io.IOException;
 import java.io.InputStream;
 import java.util.Properties;
 import java.util.Scanner;

/*@projectName Javabank
 * @package com.cx.bank.manager
 * @className ManagerImpl
 * @description 用于实现各种功能模块
 * @version v1.4
 * */
 public class ManagerImpl implements Manager{
    private static ManagerImpl managerimpl;

    Scanner in = new Scanner(System.in);
    private ManagerImpl(){}
    public static ManagerImpl getManagerImpl() {
        if (managerimpl == null) {
            managerimpl = new ManagerImpl();
        }
        return managerimpl;
    }

     /**创建对象
      * MoneyBean对象，暂时存储money
      * BankDaoImpl对象，存储并读取数据
      * props对象，将读取的数据暂时存储
      */
    MoneyBean m1 = MoneyBean.getMoneyBean();
    BankDaoImpl b1 = BankDaoImpl.getBankDaoImpl();
    Properties props = BankDaoImpl.getProps();

    /*
    * 退出系统
    * */
    public void exitSystem(){
      b1.AddBank();
      System.out.println("退出成功");
      System.exit(1); }

    /*查询余额，对账户中的money进行查询操作
    * @return 返回余额
    * */
    public double inquiry(){ return m1.getMoney(); }

    /*从银行里取钱
     *@param qumoney
     */
    public void withdrawals(Double qumoney) throws AccountOverDrawnException {
            if(qumoney>inquiry()){
                throw new AccountOverDrawnException("余额不足");
            }
            else if(qumoney<0){
                throw new AccountOverDrawnException("取钱不能取负的");
            }
            m1.setMoney(m1.getMoney() - qumoney);
        }
    /*
    * 从银行里存钱
    * @param cunmoney
    * */
    public void deposit(Double cunmoney) throws InvalidDepositException {
        if(cunmoney < 0) {
        throw new InvalidDepositException("存钱不能存负的");
        }
    m1.setMoney(m1.getMoney() + cunmoney);
    }

  /**
   * 用户注册
   * @param _uname
   * @param _upwd
   * @return flag
   */
     @Override
     public boolean register(String _uname,String _upwd)  {

            boolean flag = true;

            //用户名和密码不能为空
            if(_uname==null||_upwd==null) return false;

            //用户和密码不能已经存在
            File dir = new File(".\\"+_uname+".properties");
            if (dir.exists()) flag=false;

            //将用户名和密码写入文件中
            try {
              if(flag) b1.register(_uname, _upwd);
            }catch (IOException e){
              System.out.println(e);
            }


            return flag;
     }

  /**
   * 用户登录
   * @param  _uname
   * @param  _upwd
   * @return flag
   */
     @Override
     public boolean login(String _uname,String _upwd) {

        boolean flag = true;

        //用户名和密码不能为空
        if (_uname == null || _upwd == null)  return false;

        //用户名和密码不能不存在
         File dir = new File(".\\"+_uname+".properties");
         if (!dir.exists()) flag=false;

        //读取并存储数据
       try {
         b1.login(_uname, _upwd);
       }catch (IOException e) {
         System.out.println("没有这个用户名，请检查用户名是否输入正确");
         flag = false;
       }
        //判断输入的用户名和密码是否正确，如果错误，显示登录失败
        if(_uname.equals(props.getProperty("uname"))&&_upwd.equals(props.getProperty("upwd"))){
            flag = true;
        }else {
          flag = false;
        }
        return flag;
     }
 }