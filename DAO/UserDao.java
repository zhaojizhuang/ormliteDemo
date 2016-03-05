package com.wellgood.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.wellgood.model.User;

/**
 * 定义数据访问对象，对指定的表进行增删改查操作
 * @author 
 *
 */
public class UserDao {
	public static String TAG="SQLite";
    private Dao<User, Integer> userDao;
    private DatabaseHelper dbHelper;

    /**
     * 构造方法
     * 获得数据库帮助类实例，通过传入Class对象得到相应的Dao
     * @param context
     */
    public UserDao(Context context) {
        try {
        	Log.i(TAG, "UserDAO实例化");
            dbHelper = DatabaseHelper.getHelper(context);
            userDao = dbHelper.getDao(User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加一条记录
     * @param theme
     */
    public void add(User user) {
    	
        try {
        	Log.i(TAG, "添加一条记录:"+user);
            userDao.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除一条记录
     * @param theme
     */
    public void delete(User user) {
        try {
        	Log.i(TAG, "删除一条记录:"+user);
            userDao.delete(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 更新一条记录
     * @param theme
     */
    public void update(User user) {
    	Log.i(TAG, "更新一条记录:"+user);
        try {
            userDao.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询一条记录
     * @param id
     * @return
     */
    public User queryForId(int id) {
    	Log.i(TAG, "查询一条记录，根据id:"+id);
        User user = null;
        try {
            user = userDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    /**
     * 查询所有记录
     * @return
     */
    public List<User> queryForAll() {
    	Log.i(TAG, "查询user所有记录");
        List<User> users = new ArrayList<User>();
        try {
            users = userDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

}