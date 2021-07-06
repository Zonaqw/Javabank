package com.cx.bank.factory;

import com.cx.bank.dao.BankDaoInterface;

import java.io.FileInputStream;

import java.util.Properties;

public class UserDaoFactory {
	private static UserDaoFactory userDaoFactory;

	public BankDaoInterface userDao;

	private UserDaoFactory() {

		try {

			//读取文件classInfo.properties
			FileInputStream input = new FileInputStream("E:\\Desktop\\zuoye\\Javabank\\src\\com\\cx\\bank\\factory\\classInfo.properties");
			Properties props = new Properties();
			props.load(input);
			input.close();

			//创建反射对象并通过反射创建对象
			String className = props.getProperty("className");
			Class cls = Class.forName(className);
			Object o = cls.newInstance();
			userDao = (BankDaoInterface) o;

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	//获取对象
	public static UserDaoFactory getInstance() {
		if (userDaoFactory == null) {
		    return new UserDaoFactory();
		}
		return userDaoFactory;
	}

	/**
	 * 返回接口对象userDao
	 * @return
	 */
	public BankDaoInterface createUserDao(){
		return userDao;
	}


}
