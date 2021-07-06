package com.cx.bank.factory;

import com.cx.bank.dao.BankDaoInterface;

import java.io.FileInputStream;

import java.util.Properties;

public class UserDaoFactory {
	private static UserDaoFactory userDaoFactory;

	public BankDaoInterface userDao;

	private UserDaoFactory() {

		try {

			//��ȡ�ļ�classInfo.properties
			FileInputStream input = new FileInputStream("E:\\Desktop\\zuoye\\Javabank\\src\\com\\cx\\bank\\factory\\classInfo.properties");
			Properties props = new Properties();
			props.load(input);
			input.close();

			//�����������ͨ�����䴴������
			String className = props.getProperty("className");
			Class cls = Class.forName(className);
			Object o = cls.newInstance();
			userDao = (BankDaoInterface) o;

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	//��ȡ����
	public static UserDaoFactory getInstance() {
		if (userDaoFactory == null) {
		    return new UserDaoFactory();
		}
		return userDaoFactory;
	}

	/**
	 * ���ؽӿڶ���userDao
	 * @return
	 */
	public BankDaoInterface createUserDao(){
		return userDao;
	}


}
