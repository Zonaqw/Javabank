package com.cx.bank.model;

/**
 * @projectName Javabank
 * @package com.cx.bank.model
 * @className UserBean
 * @description ���ڷ�װ�û�����
 * @version v1.4
 */
public class UserBean {
    private String name;

    private String password;
    public UserBean(){}

    public void setName(String name) { this.name = name; }

    public void setPassword(String password) { this.password = password; }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
