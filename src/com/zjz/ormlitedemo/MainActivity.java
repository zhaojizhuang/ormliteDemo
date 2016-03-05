package com.zjz.ormlitedemo;

import java.sql.SQLException;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.ForeignCollection;
import com.wellgood.ormlitedemo.R;
import com.zjz.DAO.DatabaseHelper;
import com.zjz.DAO.SchoolDao;
import com.zjz.model.School;
import com.zjz.model.User;

public class MainActivity extends Activity {  
  
    Button button1;//信息录入按钮  
    Button button2;//信息显示按钮  
    TextView textView;//用来显示查询到的用户信息  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.main);  
        button1 = (Button)this.findViewById(R.id.main_btn_inputinfo);  
        button2 = (Button)this.findViewById(R.id.main_btn_show);  
        textView = (TextView)this.findViewById(R.id.main_show_user);  
        //点击注册按钮跳转到注册页面  
        button1.setOnClickListener(new OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                Intent intent = new Intent();  
                intent.setClass(MainActivity.this, RegistActivity.class);  
                startActivity(intent);  
            }  
        });  
        //点击“显示”按钮跳转到用户信息显示页面并将注册用户信息显示出来  
        button2.setOnClickListener(new OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                List<School> list = new SchoolDao(MainActivity.this).queryForAll();
                Log.i("test", "有没有学校？----------------"+list.size());  
                School school = null;  
                if(list.size()>0){  
                	 String str="";
                	for (int i = 0; i < list.size(); i++) {
                		  school = new SchoolDao(MainActivity.this).queryForId(list.get(i).getschoolId());  
                		  Log.d("tag", "school"+school+"-------i:"+i);
                		   str += school.getschoolName()+" 学校有这些学生：";  
                          ForeignCollection<User> orders = school.getUsers();  
                          CloseableIterator<User> iterator = orders.closeableIterator();  
                          String users="";
                          try {  
                              while(iterator.hasNext()){  
                                  User user = iterator.next();  
                                  users+=user.getId()+"号:"+user.getUserName()+" 年龄："+user.getAge()+";"; 
                                  Log.d("tag", "users"+users+"-------i:"+i);
                              }  
                          } finally {  
                              try {  
                                  iterator.close();  
                              } catch (SQLException e) {  
                                  e.printStackTrace();  
                              }  
                          }  
                          str+=users;
					}
                  
                    textView.setText(str);  
                }else{  
                    textView.setText("还没有录入学校！");  
                }  
            }  
        });  
          
    }  
  
    @Override  
    public boolean onCreateOptionsMenu(Menu menu) {  
        // Inflate the menu; this adds items to the action bar if it is present.  
        getMenuInflater().inflate(R.menu.main, menu);  
        return true;  
    }  
  
}  