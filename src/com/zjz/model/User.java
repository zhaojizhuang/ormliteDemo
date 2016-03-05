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
    //�û�����ѧУ
    /** 
     * foreign = true:˵������һ���ⲿ���ù�ϵ 
     * foreignAutoRefresh = true�������󱻲�ѯʱ���ⲿ�����Զ�ˢ�� 
     *  
     */  
    @DatabaseField(foreign = true,foreignAutoRefresh = true)  
    private School school;  

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

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", age=" + age
				+ ", school=" + school + "]";
	}




	


	
}
