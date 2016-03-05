package com.zjz.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/** 
 * 学校（这里假设一个学校对应多个学生，即一对多的关系） 
 * @author zhaojizhuang
 * 
 */  
@DatabaseTable(tableName="tb_school")  
public class School {  
    //学校编号  唯一标示
    @DatabaseField(generatedId=true)  
    private int schoolId;  
    //学校名称  
    @DatabaseField  
    private String schoolName="德州市第一中学";  
    //用户信息集合  
    @ForeignCollectionField  
    /** 
     * 这里需要注意的是：属性类型只能是ForeignCollection<T>或者Collection<T> 
     * 如果需要懒加载（延迟加载）可以在@ForeignCollectionField加上参数eager=false 
     * 这个属性也就说明一个学校对应着多个用户 
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