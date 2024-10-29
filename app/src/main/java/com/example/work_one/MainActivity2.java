package com.example.work_one;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main); // 主界面的布局
        // 创建 AlertDialog.Builder 对象
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);

        // 加载自定义布局文件
        LayoutInflater inflater = getLayoutInflater();
        View loginView = inflater.inflate(R.layout.linear3, null);

        // 获取布局中的控件
        final EditText etUsername = loginView.findViewById(R.id.et_username);
        final EditText etPassword = loginView.findViewById(R.id.et_password);
        Button btnCancel = loginView.findViewById(R.id.btn_cancel);
        Button btnLogin = loginView.findViewById(R.id.btn_login);

        TextView titleTextView = new TextView(this);
        titleTextView.setText("ANOPOIO APP");
        titleTextView.setTextSize(20); // 设置字体大小
        titleTextView.setTextColor(Color.WHITE); // 设置字体颜色
        titleTextView.setBackgroundColor(Color.parseColor("#FFA500")); // 设置背景颜色
        titleTextView.setGravity(Gravity.CENTER); // 设置文本居中显示
        titleTextView.setPadding(20, 20, 20, 20);

        // 设置布局到 AlertDialog
        builder.setTitle("ANOPOIO APP")//原先的已不再使用
                .setCustomTitle(titleTextView)
                .setView(loginView)
                .setCancelable(false); // 不允许点击外部区域关闭对话框

        // 创建对话框
        final AlertDialog dialog = builder.create();

        // 取消按钮事件
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();  // 关闭对话框
            }
        });

        // 登录按钮事件
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    // 如果用户名或密码为空，提示用户
                    Toast.makeText(MainActivity2.this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
                } else {
                    // 模拟登录操作
                    Toast.makeText(MainActivity2.this, "Logging in with\nUsername: " + username + "\nPassword: " + password, Toast.LENGTH_SHORT).show();
                    dialog.dismiss(); // 登录后关闭对话框
                }
            }
        });

        // 显示对话框
        dialog.show();
    }
}
