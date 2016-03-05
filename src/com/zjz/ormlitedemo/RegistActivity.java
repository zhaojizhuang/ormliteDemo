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

/* Ա����Ϣ¼�� 
 * @author  
 * 
 */  
public class RegistActivity  extends Activity {  
    EditText userNameEdit;//�û����༭��  
    EditText ageEdit;//����༭��  
    EditText schoolEdit;//ѧУ�༭��  
    Button reButton;//�ύ��ť  
      
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
            //�û���  
            String userName = userNameEdit.getText().toString();  
            if (userName.length()<=0) {
            	userNameEdit.setError("null");
			}
            //����  
            String age = ageEdit.getText().toString();  
            if (age.length()<=0) {
				ageEdit.setError("null");
			}
            //ѧУ��Ϣ  
            String schoolName = schoolEdit.getText().toString(); 
            if(schoolName.length()<=0){
            	schoolEdit.setError("null");
            }
            List<School> schools = new SchoolDao(RegistActivity.this).queryForAll();  
            School school = null;  
            //��ѯ�����е�ѧУ��Ϣ����������ѧУ�����ݿ��в������Ǿʹ���һ���µļ�¼��������������ԭ��  
            if(schools.size()>0){  
                for(School d:schools){  
                    if(d.getschoolName().equals(schoolName)){  
                        school = d;  
                    }else{  
                        school = new School();  
                        school.setschoolName(schoolName);  
                        //����ѧУ��Ϣ  
                        new SchoolDao(RegistActivity.this).add(school);  
                    }  
                }  
            }else{  
                school = new School();  
                school.setschoolName(schoolName);  
                //���벿����Ϣ  
                new SchoolDao(RegistActivity.this).add(school);  
            }  
              
            //�û���Ϣ  
            User user = new User();  
            user.setUserName(userName);  
            try {
            	 int ageint=Integer.parseInt(age);
            	   user.setAge(ageint);  
			} catch (Exception e) {
				// TODO: handle exception
			}
           
         
            user.setSchool(school);  
            //�����û���Ϣ  
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