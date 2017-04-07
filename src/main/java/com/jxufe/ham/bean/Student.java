package com.jxufe.ham.bean;

public class Student {
    /**
     * 遵循javabean要求
     * 1.公有的类
     * 2. 提供公有的布袋参数的默认的构造方法
       3. 属性要私有化private
       4. 属性要用setter/getter封装
     */

    private int sid;
    private String name;
    private String number;

    public Student(){

    }

    public Student(int sid, String name, String number) {
        super();
        this.sid = sid;
        this.name = name;
        this.number = number;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    
    @Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name +
				",number=" + number +"]";
	}
}
