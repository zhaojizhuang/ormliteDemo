package com.zjz.DAO;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.zjz.model.School;
import com.zjz.model.TaskEntity;
import com.zjz.model.TaskNodeEntity;
import com.zjz.model.User;

public  class DatabaseHelper extends OrmLiteSqliteOpenHelper
{
	private static final String TABLE_NAME = "sqlite.db";

	private Map<String, Dao> daos = new HashMap<String, Dao>();
	private static final int TABLE_VERSION=6; 

	private DatabaseHelper(Context context)
	{
		super(context, TABLE_NAME, null, TABLE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database,
			ConnectionSource connectionSource)
	{
		try
		{
			TableUtils.createTable(connectionSource, User.class);
			TableUtils.createTable(connectionSource, TaskEntity.class);
			TableUtils.createTable(connectionSource, TaskNodeEntity.class);
			TableUtils.createTable(connectionSource, School.class);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase database,
			ConnectionSource connectionSource, int oldVersion, int newVersion)
	{
		try
		{
			TableUtils.dropTable(connectionSource, User.class, true);
			TableUtils.dropTable(connectionSource, TaskEntity.class, true);
			TableUtils.dropTable(connectionSource, TaskNodeEntity.class, true);
			TableUtils.dropTable(connectionSource, School.class, true);
			onCreate(database, connectionSource);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	private static DatabaseHelper instance;

	/**
	 * 单例获取该Helper
	 * 
	 * @param context
	 * @return
	 */
	public static synchronized DatabaseHelper getHelper(Context context)
	{
		context = context.getApplicationContext();
		if (instance == null)
		{
			synchronized (DatabaseHelper.class)
			{
				if (instance == null)
					instance = new DatabaseHelper(context);
			}
		}

		return instance;
	}

	public synchronized Dao getDao(Class clazz) throws SQLException
	{
		Dao dao = null;
		String className = clazz.getSimpleName();

		if (daos.containsKey(className))
		{
			dao = daos.get(className);
		}
		if (dao == null)
		{
			dao = super.getDao(clazz);
			daos.put(className, dao);
		}
		return dao;
	}

	/**
	 * 释放资源
	 */
	@Override
	public void close()
	{
		super.close();

		for (String key : daos.keySet())
		{
			Dao dao = daos.get(key);
			dao = null;
		}
	}

}
