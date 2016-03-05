package com.zjz.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.zjz.model.Dept;

/**
 * �������ݷ��ʶ��󣬶�ָ���ı������ɾ�Ĳ����
 * @author 
 *
 */
public class DeptDao {
	public static String TAG="SQLite";
    private Dao<Dept, Integer> deptDao;
    private DatabaseHelper dbHelper;

    /**
     * ���췽��
     * ������ݿ������ʵ����ͨ������Class����õ���Ӧ��Dao
     * @param context
     */
    public DeptDao(Context context) {
        try {
        	Log.i(TAG, "deptDAOʵ����");
            dbHelper = DatabaseHelper.getHelper(context);
            deptDao = dbHelper.getDao(Dept.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * ���һ����¼
     * @param theme
     */
    public void add(Dept dept) {
    	
        try {
        	Log.i(TAG, "���һ����¼:"+dept);
            deptDao.create(dept);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * ɾ��һ����¼
     * @param theme
     */
    public void delete(Dept dept) {
        try {
        	Log.i(TAG, "ɾ��һ����¼:"+dept);
            deptDao.delete(dept);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * ����һ����¼
     * @param theme
     */
    public void update(Dept dept) {
    	Log.i(TAG, "����һ����¼:"+dept);
        try {
            deptDao.update(dept);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ѯһ����¼
     * @param id
     * @return
     */
    public Dept queryForId(int id) {
    	Log.i(TAG, "��ѯһ����¼������id:"+id);
    	Dept dept = null;
        try {
            dept = deptDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dept;
    }


    /**
     * ��ѯ���м�¼
     * @return
     */
    public List<Dept> queryForAll() {
    	Log.i(TAG, "��ѯdept���м�¼");
        List<Dept> depts = new ArrayList<Dept>();
        try {
            depts = deptDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return depts;
    }

}