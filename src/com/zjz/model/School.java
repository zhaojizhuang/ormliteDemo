package com.zjz.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/** 
 * ѧУ���������һ��ѧУ��Ӧ���ѧ������һ�Զ�Ĺ�ϵ�� 
 * @author zhaojizhuang
 * 
 */  
@DatabaseTable(tableName="tb_school")  
public class School {  
    //ѧУ���  Ψһ��ʾ
    @DatabaseField(generatedId=true)  
    private int schoolId;  
    //ѧУ����  
    @DatabaseField  
    private String schoolName="�����е�һ��ѧ";  
    //�û���Ϣ����  
    @ForeignCollectionField  
    /** 
     * ������Ҫע����ǣ���������ֻ����ForeignCollection<T>����Collection<T> 
     * �����Ҫ�����أ��ӳټ��أ�������@ForeignCollectionField���ϲ���eager=false 
     * �������Ҳ��˵��һ��ѧУ��Ӧ�Ŷ���û� 
     */  
    private ForeignCollection<User> users;  
      
    public School(){  
          
    }  
      
    public School(int schoolId,String schoolName){  
        this.schoolId = schoolId;  
        this.schoolName = schoolName;  
    }

	public int getschoolId() {
		return schoolId;
	}

	public void setschoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public String getschoolName() {
		return schoolName;
	}

	public void setschoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public ForeignCollection<User> getUsers() {
		return users;
	}

	public void setUsers(ForeignCollection<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "school [schoolId=" + schoolId + ", schoolName=" + schoolName + ", users="
				+ users + "]";
	}  
  
}  