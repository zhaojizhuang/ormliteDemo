package com.zjz.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 任务节点实体
 * @author Administrator
 *
 */
@DatabaseTable(tableName = "tb_tasknode")
public class TaskNodeEntity {
	/**
	 *
	 * 是这个对象的标示，表明是唯一的，自增的标识字段有表中唯一的值并且如果你用DAO根据id查询、删除、刷新或者更新指定行的时候他们必须存在。
	*为了配置一个成员变量作为标识成员，你应该使用下面三个设置之一（而且必须使用一个）：@DatabaseField: id, generatedId, 
	*generatedIdSequence 。
	 */
	 @DatabaseField(generatedId=true)//自增长的主键 
	private int _id=-1;
	 @DatabaseField
	private int id=-1;
	@DatabaseField
	private String name="default";

	// 外部对象字段
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    public TaskEntity taskinfo;
	   public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TaskEntity getTaskinfo() {
		return taskinfo;
	}
	public void setTaskinfo(TaskEntity taskinfo) {
		this.taskinfo = taskinfo;
	}
	@Override
	public String toString() {
		return "TaskNodeEntity [id=" + id + ", name=" + name + ", taskinfo="
				+ taskinfo + "]";
	}
}
