
 package com.cx.bank.manager;

 import com.cx.bank.dao.BankDaoImpl;
 import com.cx.bank.model.MoneyBean;
 import com.cx.bank.model.UserBean;
 import com.cx.bank.util.*;

 import java.io.File;
 import java.io.FileInputStream;
 import java.io.IOException;
 import java.io.InputStream;
 import java.util.Properties;
 import java.util.Scanner;

 import static com.cx.bank.dao.BankDaoImpl.properties;

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
    UserBean userBean=UserBean.getUserBean();
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
     public void register(String _uname,String _upwd) throws RegisterException, IOException {

            //用户名和密码不能为空
            if(_uname==null||_upwd==null){
              throw new RegisterException("用户名和密码不能为空");
            }

            //用户和密码不能已经存在
            File dir = new File(".\\"+_uname+".properties");
            if (dir.exists()){

              throw new RegisterException("用户已经存在");
            }

            //将用户名和密码写入文件中

              b1.register(_uname, _upwd);

     }

  /**
   * 用户登录
   * @param  _uname
   * @param  _upwd
   * @return flag
   */
     @Override
     public void login(String _uname,String _upwd) throws LoginException, IOException {
        //用户名和密码不能为空
        if (_uname == null || _upwd == null) {
           throw new LoginException("用户名和密码不能为空");
        }
        //用户名和密码不能不存在
         File dir = new File(".\\"+_uname+".properties");
         if (!dir.exists()){
           throw new LoginException("用户不存在");
         }

        //读取并存储数据
         b1.login(_uname, _upwd);
        //判断输入的用户名和密码是否正确，如果错误，显示登录失败
        if(_uname.equals(props.getProperty("uname"))&&_upwd.equals(props.getProperty("upwd"))){
          userBean.setName(props.getProperty("uname"));
          userBean.setPassword(props.getProperty("upwd"));
          m1.setMoney(Double.parseDouble(props.getProperty("money")));
        }else {
          throw new LoginException("用户名或密码错误");
        }

     }

   /**
    *
    * @param others
    * @param money
    * @return
    */
  @Override
  public  void transfer(String others, String money) throws IOException, TransferException {

    File file = new File(".//"+others+".properties");
    if (!file.exists()){
      throw new TransferException("没有这个用户");
    }
    if(Double.parseDouble(money)>m1.getMoney()) {
      throw new TransferException("余额不足");
    }
    if(Double.parseDouble(money)<0){
      throw new TransferException("金额不能为负数");
    }
    b1.transfer(others, money);
    if(properties.getProperty("uname").equals(userBean.getName())){
      throw new TransferException("不能给自己转账");
    }


  }
}