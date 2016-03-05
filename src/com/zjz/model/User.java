package com.zjz.model;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "tb_user")
public class User 
{
	/**
	 *
	 * 是这个对象的标示，表明是唯一的，自增的标识字段有表中唯一的值并且如果你用DAO根据id查询、删除、刷新或者更新指定行的时候他们必须存在。
	*为了配置一个成员变量作为标识成员，你应该使用下面三个设置之一（而且必须使用一个）：@DatabaseField: id, generatedId, 
	*generatedIdSequence 。
	 */
	@DatabaseField(generatedId = true)
	private int id=-1;
	@DatabaseField  
    private String userName;  
    //密码  
    @DatabaseField  
    private int age;  
    //入职时间  
    @DatabaseField(format="DATE_STRING")  
    private Date date;  
    //用户所属部门  
    /** 
     * foreign = true:说明这是一个外部引用关系 
     * foreignAutoRefresh = true：当对象被查询时，外部属性自动刷新 
     *  
     */  
    @DatabaseField(foreign = true,foreignAutoRefresh = true)  
    private Dept dept;  

	public User()
	{
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", age=" + age
				+ ", date=" + date + ", dept=" + dept + "]";
	}

	


	
}
