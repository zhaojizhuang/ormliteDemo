package com.zjz.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/** 
 * 部门（这里假设一个用户只对应一个部门，而一个部门对应着多个用户，即一对多的关系） 
 * @author leox 
 * 
 */  
@DatabaseTable(tableName="tb_dept")  
public class Dept {  
    //部门编号  唯一标示
    @DatabaseField(generatedId=true)  
    private int deptId;  
    //部门名称  
    @DatabaseField  
    private String deptName;  
    //用户信息集合  
    @ForeignCollectionField  
    /** 
     * 这里需要注意的是：属性类型只能是ForeignCollection<T>或者Collection<T> 
     * 如果需要懒加载（延迟加载）可以在@ForeignCollectionField加上参数eager=false 
     * 这个属性也就说明一个部门对应着多个用户 
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