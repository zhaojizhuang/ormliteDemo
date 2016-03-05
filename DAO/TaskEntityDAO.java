package com.wellgood.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.wellgood.model.TaskEntity;

/**
 * 定义数据访问对象，对指定的表进行增删改查操作
 * @author 
 *
 */
public class TaskEntityDAO {
	public static String TAG="SQLite";
    private Dao<TaskEntity, Integer> taskEntityDao;
    private DatabaseHelper dbHelper;

    /**
     * 构造方法
     * 获得数据库帮助类实例，通过传入Class对象得到相应的Dao
     * @param context
     */
    public TaskEntityDAO(Context context) {
        try {
            dbHelper = DatabaseHelper.getHelper(context);
            taskEntityDao = dbHelper.getDao(TaskEntity.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加一条记录
     * @param theme
     */
    public void add(TaskEntity TaskEntity) {
    	
        try {
            taskEntityDao.create(TaskEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除一条记录
     * @param theme
     */
    public void delete(TaskEntity TaskEntity) {
        try {
            taskEntityDao.delete(TaskEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 更新一条记录
     * @param theme
     */
    public void update(TaskEntity TaskEntity) {
        try {
            taskEntityDao.update(TaskEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询一条记录
     * @param id
     * @return
     */
    public TaskEntity queryForId(int id) {
    	Log.i(TAG, "查询一条记录，根据id:"+id);
        TaskEntity TaskEntity = null;
        try {
            TaskEntity = taskEntityDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return TaskEntity;
    }


    /**
     * 查询所有记录
     * @return
     */
    public List<TaskEntity> queryForAll() {
    	Log.i(TAG, "查询TaskEntity所有记录");
        List<TaskEntity> TaskEntitys = new ArrayList<TaskEntity>();
        try {
            TaskEntitys = taskEntityDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return TaskEntitys;
    }

}