package com.zjz.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.zjz.model.School;

/**
 * �������ݷ��ʶ��󣬶�ָ���ı������ɾ�Ĳ����
 * @author 
 *
 */
public class SchoolDao {
	public static String TAG="SQLite";
    private Dao<School, Integer> schoolDao;
    private DatabaseHelper dbHelper;

    /**
     * ���췽��
     * ������ݿ������ʵ����ͨ������Class����õ���Ӧ��Dao
     * @param context
     */
    public SchoolDao(Context context) {
        try {
        	Log.i(TAG, "SchoolDaoʵ����");
            dbHelper = DatabaseHelper.getHelper(context);
            schoolDao = dbHelper.getDao(School.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * ���һ����¼
     * @param theme
     */
    public void add(School school) {
    	
        try {
        	Log.i(TAG, "���һ����¼:"+school);
            schoolDao.create(school);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * ɾ��һ����¼
     * @param theme
     */
    public void delete(School school) {
        try {
        	Log.i(TAG, "ɾ��һ����¼:"+school);
            schoolDao.delete(school);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * ����һ����¼
     * @param theme
     */
    public void update(School school) {
    	Log.i(TAG, "����һ����¼:"+school);
        try {
            schoolDao.update(school);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ѯһ����¼
     * @param id
     * @return
     */
    public School queryForId(int id) {
    	Log.i(TAG, "��ѯһ����¼������id:"+id);
    	School school = null;
        try {
            school = schoolDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return school;
    }


    /**
     * ��ѯ���м�¼
     * @return
     */
    public List<School> queryForAll() {
    	Log.i(TAG, "��ѯSchool���м�¼");
        List<School> schools = new ArrayList<School>();
        try {
            schools = schoolDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schools;
    }

}