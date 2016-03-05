package com.zjz.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/** 
 * ���ţ��������һ���û�ֻ��Ӧһ�����ţ���һ�����Ŷ�Ӧ�Ŷ���û�����һ�Զ�Ĺ�ϵ�� 
 * @author leox 
 * 
 */  
@DatabaseTable(tableName="tb_dept")  
public class Dept {  
    //���ű��  Ψһ��ʾ
    @DatabaseField(generatedId=true)  
    private int deptId;  
    //��������  
    @DatabaseField  
    private String deptName;  
    //�û���Ϣ����  
    @ForeignCollectionField  
    /** 
     * ������Ҫע����ǣ���������ֻ����ForeignCollection<T>����Collection<T> 
     * �����Ҫ�����أ��ӳټ��أ�������@ForeignCollectionField���ϲ���eager=false 
     * �������Ҳ��˵��һ�����Ŷ�Ӧ�Ŷ���û� 
     */  
    private ForeignCollection<User> users;  
      
    public Dept(){  
          
    }  
      
    public Dept(int deptId,String deptName){  
        this.deptId = deptId;  
        this.deptName = deptName;  
    }

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public ForeignCollection<User> getUsers() {
		return users;
	}

	public void setUsers(ForeignCollection<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", deptName=" + deptName + ", users="
				+ users + "]";
	}  
  
}  