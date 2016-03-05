package com.zjz.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.zjz.model.Dept;

/**
 * 定义数据访问对象，对指定的表进行增删改查操作
 * @author 
 *
 */
public class DeptDao {
	public static String TAG="SQLite";
    private Dao<Dept, Integer> deptDao;
    private DatabaseHelper dbHelper;

    /**
     * 构造方法
     * 获得数据库帮助类实例，通过传入Class对象得到相应的Dao
     * @param context
     */
    public DeptDao(Context context) {
        try {
        	Log.i(TAG, "deptDAO实例化");
            dbHelper = DatabaseHelper.getHelper(context);
            deptDao = dbHelper.getDao(Dept.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加一条记录
     * @param theme
     */
    public void add(Dept dept) {
    	
        try {
        	Log.i(TAG, "添加一条记录:"+dept);
            deptDao.create(dept);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除一条记录
     * @param theme
     */
    public void delete(Dept dept) {
        try {
        	Log.i(TAG, "删除一条记录:"+dept);
            deptDao.delete(dept);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 更新一条记录
     * @param theme
     */
    public void update(Dept dept) {
    	Log.i(TAG, "更新一条记录:"+dept);
        try {
            deptDao.update(dept);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询一条记录
     * @param id
     * @return
     */
    public Dept queryForId(int id) {
    	Log.i(TAG, "查询一条记录，根据id:"+id);
    	Dept dept = null;
        try {
            dept = deptDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dept;
    }


    /**
     * 查询所有记录
     * @return
     */
    public List<Dept> queryForAll() {
    	Log.i(TAG, "查询dept所有记录");
        List<Dept> depts = new ArrayList<Dept>();
        try {
            depts = deptDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return depts;
    }

}