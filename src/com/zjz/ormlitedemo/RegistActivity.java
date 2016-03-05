package com.zjz.ormlitedemo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.wellgood.ormlitedemo.R;
import com.zjz.DAO.SchoolDao;
import com.zjz.DAO.UserDao;
import com.zjz.model.School;
import com.zjz.model.User;

/* 员工信息录入 
 * @author  
 * 
 */  
public class RegistActivity  extends Activity {  
    EditText userNameEdit;//用户名编辑框  
    EditText ageEdit;//年龄编辑框  
    EditText schoolEdit;//学校编辑框  
    Button reButton;//提交按钮  
      
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
        userNameEdit = (EditText)this.findViewById(R.id.et_username);  
        ageEdit = (EditText)this.findViewById(R.id.et_age);  
        schoolEdit = (EditText)this.findViewById(R.id.et_school);  
        reButton = (Button)this.findViewById(R.id.btn_regist);  
        reButton.setOnClickListener(new myClickListener());  
    }  
  
    @Override  
    public boolean onCreateOptionsMenu(Menu menu) {  
        getMenuInflater().inflate(R.menu.main, menu);  
        return true;  
    }  
      
    class myClickListener implements OnClickListener{  
        @Override  
        public void onClick(View v) {  
            //用户名  
            String userName = userNameEdit.getText().toString();  
            if (userName.length()<=0) {
            	userNameEdit.setError("null");
			}
            //年龄  
            String age = ageEdit.getText().toString();  
            if (age.length()<=0) {
				ageEdit.setError("null");
			}
            //学校信息  
            String schoolName = schoolEdit.getText().toString(); 
            if(schoolName.length()<=0){
            	schoolEdit.setError("null");
            }
            List<School> schools = new SchoolDao(RegistActivity.this).queryForAll();  
            School school = null;  
            //查询出所有的学校信息，如果输入的学校名数据库中不存在那就创建一条新的记录，如果存在则采用原有  
            if(schools.size()>0){  
                for(School d:schools){  
                    if(d.getschoolName().equals(schoolName)){  
                        school = d;  
                    }else{  
                        school = new School();  
                        school.setschoolName(schoolName);  
                        //插入学校信息  
                        new SchoolDao(RegistActivity.this).add(school);  
                    }  
                }  
            }else{  
                school = new School();  
                school.setschoolName(schoolName);  
                //插入部门信息  
                new SchoolDao(RegistActivity.this).add(school);  
            }  
              
            //用户信息  
            User user = new User();  
            user.setUserName(userName);  
            try {
            	 int ageint=Integer.parseInt(age);
            	   user.setAge(ageint);  
			} catch (Exception e) {
				// TODO: handle exception
			}
           
         
            user.setSchool(school);  
            //插入用户信息  
            new UserDao(RegistActivity.this).add(user);
            if ((userName.length()>0)&&(age.length()>0)&&(schoolName.length()>0)) {
            	Log.d("tag", "doubuweikong");
            	Log.d("tag", "userName"+(userName!=null));
            	Log.d("tag", "age"+(userName!=null));
            	Log.d("tag", "da"+(userName!=null));
            	Log.d("tag", "schoolName"+(userName!=null));
                Intent intent = new Intent();  
                intent.setClass(RegistActivity.this, MainActivity.class);  
                startActivity(intent);  
			}

        }  
          
    }  
}  