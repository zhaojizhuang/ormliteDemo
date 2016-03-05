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
import com.zjz.DAO.DeptDao;
import com.zjz.DAO.UserDao;
import com.zjz.model.Dept;
import com.zjz.model.User;

/* 员工信息录入 
 * @author  
 * 
 */  
public class RegistActivity  extends Activity {  
    EditText userNameEdit;//用户名编辑框  
    EditText ageEdit;//年龄编辑框  
    EditText hiredateEdit;//入职时间编辑框  
    EditText deptEdit;//部门编辑框  
    Button reButton;//提交按钮  
      
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
        userNameEdit = (EditText)this.findViewById(R.id.et_username);  
        ageEdit = (EditText)this.findViewById(R.id.et_age);  
        hiredateEdit = (EditText)this.findViewById(R.id.et_date);  
        deptEdit = (EditText)this.findViewById(R.id.et_dept);  
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
            String da = hiredateEdit.getText().toString();  
            if (da.length()<=0) {
				hiredateEdit.setError("null");
			}
            //入职时间  
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
            Date hiredate=null;  
            try {  
                hiredate = df.parse(da);  
            } catch (ParseException e) {  
                e.printStackTrace();  
            }  
            Log.i("test", "date = "+hiredate);  
            //部门信息  
            String deptName = deptEdit.getText().toString(); 
            if(deptName.length()<=0){
            	deptEdit.setError("null");
            }
            List<Dept> depts = new DeptDao(RegistActivity.this).queryForAll();  
            Dept dept = null;  
            //查询出所有的部门信息，如果输入的部门名数据库中不存在那就创建一条新的记录，如果存在则采用原有  
            if(depts.size()>0){  
                for(Dept d:depts){  
                    if(d.getDeptName().equals(deptName)){  
                        dept = d;  
                    }else{  
                        dept = new Dept();  
                        dept.setDeptName(deptName);  
                        //插入部门信息  
                        new DeptDao(RegistActivity.this).add(dept);  
                    }  
                }  
            }else{  
                dept = new Dept();  
                dept.setDeptName(deptName);  
                //插入部门信息  
                new DeptDao(RegistActivity.this).add(dept);  
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
           
         
            user.setDate(hiredate);  
            user.setDept(dept);  
            //插入用户信息  
            new UserDao(RegistActivity.this).add(user);
            if ((userName.length()>0)&&(age.length()>0)&&(da.length()>0)&&(deptName.length()>0)) {
            	Log.d("tag", "doubuweikong");
            	Log.d("tag", "userName"+(userName!=null));
            	Log.d("tag", "age"+(userName!=null));
            	Log.d("tag", "da"+(userName!=null));
            	Log.d("tag", "deptName"+(userName!=null));
                Intent intent = new Intent();  
                intent.setClass(RegistActivity.this, MainActivity.class);  
                startActivity(intent);  
			}

        }  
          
    }  
}  