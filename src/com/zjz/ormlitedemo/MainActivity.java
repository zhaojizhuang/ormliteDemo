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
import com.zjz.DAO.DeptDao;
import com.zjz.model.Dept;
import com.zjz.model.User;

public class MainActivity extends Activity {  
  
    Button button1;//Ա����Ϣ¼�밴ť  
    Button button2;//Ա����Ϣ��ʾ��ť  
    TextView textView;//������ʾ��ѯ�����û���Ϣ  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.main);  
        button1 = (Button)this.findViewById(R.id.main_btn_inputinfo);  
        button2 = (Button)this.findViewById(R.id.main_btn_show);  
        textView = (TextView)this.findViewById(R.id.main_show_user);  
        //���ע�ᰴť��ת��ע��ҳ��  
        button1.setOnClickListener(new OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                Intent intent = new Intent();  
                intent.setClass(MainActivity.this, RegistActivity.class);  
                startActivity(intent);  
            }  
        });  
        //�������ʾ����ť��ת���û���Ϣ��ʾҳ�沢��ע���û���Ϣ��ʾ����  
        button2.setOnClickListener(new OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                List<Dept> list = new DeptDao(MainActivity.this).queryForAll();
                Log.i("test", "��û�в��ţ�----------------"+list.size());  
                Dept dept = null;  
                if(list.size()>0){  
                	 String str="";
                	for (int i = 0; i < list.size(); i++) {
                		  dept = new DeptDao(MainActivity.this).queryForId(list.get(i).getDeptId());  
                		  Log.d("tag", "dept"+dept+"-------i:"+i);
                		   str += dept.getDeptName()+" ������������ְԱ��";  
                          ForeignCollection<User> orders = dept.getUsers();  
                          CloseableIterator<User> iterator = orders.closeableIterator();  
                          String users="";
                          try {  
                              while(iterator.hasNext()){  
                                  User user = iterator.next();  
                                  users+=user.getId()+"��:"+user.getUserName()+" ���䣺"+user.getAge()+"  �ܹ����ڣ� "+user.getDate()+";"; 
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
                    textView.setText("�ף���û�в��Űɣ�");  
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