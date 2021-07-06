
 package com.cx.bank.manager;

 import com.cx.bank.dao.BankDaoImpl;
 import com.cx.bank.model.MoneyBean;
 import com.cx.bank.model.UserBean;
 import com.cx.bank.util.AccountOverDrawnException;
 import com.cx.bank.util.InvalidDepositException;
 import org.junit.Test;

 import java.io.File;
 import java.io.IOException;

 public class ManagerImpl implements Manager {

     private static ManagerImpl managerImpl;

     public BankDaoImpl bankDaoImpl=BankDaoImpl.getInstance();

     public MoneyBean moneyBean=new MoneyBean();

     public UserBean userBean=new UserBean();

     private ManagerImpl(){}

     public static ManagerImpl getInstance(){
         if (managerImpl == null) {
             return new ManagerImpl();
         }
         return managerImpl;
     }

     /**
      * ·µ»ØÓà¶î
      * @return money
      */
  @Override
  public Double inquiry() {
   return moneyBean.getMoney();
  }

     /**
      *È¡Ç®
      * @param qumoney
      * @throws AccountOverDrawnException
      */
  @Override
  public void withdrawals(String qumoney) throws AccountOverDrawnException {
       double qumoney0=Double.parseDouble(qumoney);
      if(qumoney0>moneyBean.getMoney()){
       throw new AccountOverDrawnException();
      }
      if(qumoney0<0){
          throw new AccountOverDrawnException();
      }
      double money=moneyBean.getMoney()-qumoney0;
      moneyBean.setMoney(money);
  }

     /**
      * ´æÇ®
      * @param cunmoney
      * @throws InvalidDepositException
      */
  @Override
  public void deposit(String cunmoney) throws InvalidDepositException {
    double cunmoney0=Double.parseDouble(cunmoney);
    if(cunmoney0<0){
        throw new InvalidDepositException();
    }
    double money=moneyBean.getMoney()+cunmoney0;
    moneyBean.setMoney(money);
  }

   /**
    * ×¢²á
    * @param _uname
    * @param _upwd
    * @return
    * @throws IOException
    */
  @Override
  public boolean register(String _uname, String _upwd) throws IOException {
    File file = new File(".\\"+_uname+".properties");
    if (file.exists()) return false;
    userBean.setName(_uname);
    userBean.setPassword(_upwd);
    moneyBean.setMoney(10.0);
    bankDaoImpl.insertUser(userBean,moneyBean);
    return true;
  }

   /**
    * µÇÂ¼
    * @param _uname
    * @param _upwd
    * @return
    * @throws IOException
    */
  @Override
  public boolean login(String _uname, String _upwd) throws IOException {
    boolean flag=true;
    new File(".\\"+_uname + ".properties");

    userBean.setName(_uname);
    bankDaoImpl.findUser(userBean,moneyBean);


    if(!_upwd.equals(userBean.getPassword())) flag=false;
    return flag;
  }
/*@Test
public void test(){

	try {
		login("zqw","123");
	} catch (IOException e) {
		System.out.println(e.getMessage());
	}
}*/

     /**
      * ×ªÕË
      * @param _uname
      * @param money
      * @return
      * @throws IOException
      */
	 @Override
	 public boolean transfer(String _uname, String money) throws IOException {
  	    boolean flag = true;
		File file = new File(".\\"+_uname + ".properties");

		if (!file.exists()) flag=false;
		double money0=Double.parseDouble(money);

		if(money0<0) flag=false;

		if(money0>moneyBean.getMoney()) flag=false;

		bankDaoImpl.transfer(moneyBean,_uname,money);

		return flag;
	 }

	 /**
    * ÍË³öÏµÍ³
    * @throws IOException
    */
  @Override
  public void exitSystem() throws IOException {
    bankDaoImpl.updateMoney(userBean,moneyBean);
    System.exit(0);
  }
  /*@Test
   public void test(){
    String name="zqw";
    String pwd="123";
    try {
      System.out.println(register(name, pwd));
    }catch (IOException e){
      System.out.println(e);
    }
  }*/
 }