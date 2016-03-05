package com.zjz.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.zjz.model.School;

/**
 * 定义数据访问对象，对指定的表进行增删改查操作
 * @author 
 *
 */
public class SchoolDao {
	public static String TAG="SQLite";
    private Dao<School, Integer> schoolDao;
    private DatabaseHelper dbHelper;

    /**
     * 构造方法
     * 获得数据库帮助类实例，通过传入Class对象得到相应的Dao
     * @param context
     */
    public SchoolDao(Context context) {
        try {
        	Log.i(TAG, "SchoolDao实例化");
            dbHelper = DatabaseHelper.getHelper(context);
            schoolDao = dbHelper.getDao(School.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加一条记录
     * @param theme
     */
    public void add(School school) {
    	
        try {
        	Log.i(TAG, "添加一条记录:"+school);
            schoolDao.create(school);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除一条记录
     * @param theme
     */
    public void delete(School school) {
        try {
        	Log.i(TAG, "删除一条记录:"+school);
            schoolDao.delete(school);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 更新一条记录
     * @param theme
     */
    public void update(School school) {
    	Log.i(TAG, "更新一条记录:"+school);
        try {
            schoolDao.update(school);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询一条记录
     * @param id
     * @return
     */
    public School queryForId(int id) {
    	Log.i(TAG, "查询一条记录，根据id:"+id);
    	School school = null;
        try {
            school = schoolDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return school;
    }


    /**
     * 查询所有记录
     * @return
     */
    public List<School> queryForAll() {
    	Log.i(TAG, "查询School所有记录");
        List<School> schools = new ArrayList<School>();
        try {
            schools = schoolDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schools;
    }

}