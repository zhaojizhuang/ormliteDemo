package com.wellgood.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.wellgood.model.TaskEntity;
import com.wellgood.model.TaskNodeEntity;

/**
 * 定义数据访问对象，对指定的表进行增删改查操作
 * @author 
 *
 */
public class TaskNodeEntityDAO {
	public static String TAG="SQLite";
    private Dao<TaskNodeEntity, Integer> taskNodeEntityDao;
    private DatabaseHelper dbHelper;

    /**
     * 构造方法
     * 获得数据库帮助类实例，通过传入Class对象得到相应的Dao
     * @param context
     */
    public TaskNodeEntityDAO(Context context) {
        try {
            dbHelper = DatabaseHelper.getHelper(context);
            taskNodeEntityDao = dbHelper.getDao(TaskNodeEntity.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加一条记录
     * @param theme
     */
    public void add(TaskNodeEntity taskNodeEntity) {
    	
        try {
        	taskNodeEntityDao.create(taskNodeEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除一条记录
     * @param theme
     */
    public void delete(TaskNodeEntity taskNodeEntity) {
        try {
            taskNodeEntityDao.delete(taskNodeEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 更新一条记录
     * @param theme
     */
    public void update(TaskNodeEntity taskEntity) {
        try {
            taskNodeEntityDao.update(taskEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询一条记录
     * @param id
     * @return
     */
    public TaskNodeEntity queryForId(int id) {
    	Log.i(TAG, "查询一条记录，根据id:"+id);
        TaskNodeEntity taskNodeEntity = null;
        try {
            taskNodeEntity = taskNodeEntityDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taskNodeEntity;
    }


    /**
     * 查询所有记录
     * @return
     */
    public List<TaskNodeEntity> queryForAll() {
    	Log.i(TAG, "查询TaskNodeEntity所有记录");
        List<TaskNodeEntity> taskNodeEntitys = new ArrayList<TaskNodeEntity>();
        try {
        	taskNodeEntitys = taskNodeEntityDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taskNodeEntitys;
    }

}