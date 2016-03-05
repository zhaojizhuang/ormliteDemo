package com.zjz.model;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "tb_user")
public class User 
{
	/**
	 *
	 * ���������ı�ʾ��������Ψһ�ģ������ı�ʶ�ֶ��б���Ψһ��ֵ�����������DAO����id��ѯ��ɾ����ˢ�»��߸���ָ���е�ʱ�����Ǳ�����ڡ�
	*Ϊ������һ����Ա������Ϊ��ʶ��Ա����Ӧ��ʹ��������������֮һ�����ұ���ʹ��һ������@DatabaseField: id, generatedId, 
	*generatedIdSequence ��
	 */
	@DatabaseField(generatedId = true)
	private int id=-1;
	@DatabaseField  
    private String userName;  
    //����  
    @DatabaseField  
    private int age;  
    //��ְʱ��  
    @DatabaseField(format="DATE_STRING")  
    private Date date;  
    //�û���������  
    /** 
     * foreign = true:˵������һ���ⲿ���ù�ϵ 
     * foreignAutoRefresh = true�������󱻲�ѯʱ���ⲿ�����Զ�ˢ�� 
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
