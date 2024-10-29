package com.example.work_one;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

public class MainActivity3 extends AppCompatActivity {
    private TextView textView;  // 你要修改字体的 TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);// 获取 TextView 控件



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 加载菜单 XML 文件
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.font_small) {
            textView.setTextSize(10);  // 设置字体大小为 10
            return true;
        } else if (item.getItemId() == R.id.font_medium) {
            textView.setTextSize(16);  // 设置字体大小为 16
            return true;
        } else if (item.getItemId() == R.id.font_large) {
            textView.setTextSize(20);  // 设置字体大小为 20
            return true;
        } else if (item.getItemId() == R.id.color_red) {
            textView.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_light));  // 使用 ContextCompat 获取颜色
            return true;
        } else if (item.getItemId() == R.id.color_black) {
            textView.setTextColor(ContextCompat.getColor(this, android.R.color.black));  // 使用 ContextCompat 获取颜色
            return true;
        } else if (item.getItemId() == R.id.menu_toast) {
            Toast.makeText(this, "这是一个 Toast 提示", Toast.LENGTH_SHORT).show();  // 弹出 Toast 提示
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }

    }
}
