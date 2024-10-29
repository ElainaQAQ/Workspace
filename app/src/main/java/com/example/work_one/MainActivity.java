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


//public class MainActivity extends AppCompatActivity {
//
////    private AppBarConfiguration appBarConfiguration;
////    private ActivityMainBinding binding;
//
//    @SuppressLint("MissingInflatedId")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.constraint1);// 加载布局文件
//          setContentView(R.layout.table);
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        setSupportActionBar(binding.toolbar);
//
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//
//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAnchorView(R.id.fab)
//                        .setAction("Action", null).show();
//            }
//        });
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
//}




public class MainActivity extends Activity {
    private String[] names=new String[]{"Lion","Tiger","Monkey","Dog","Cat","Elephone"};
    private int[] imageIds=new int[]{R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear1);
        List<Map<String, Object>> listItems=new ArrayList<>();
        for (int  i=0;i< names.length;i++){
            Map<String ,Object> listItem=new HashMap<>();
            listItem.put("header",imageIds[i]);
            listItem.put("name",names[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,R.layout.linear2,new String[]{"header","name"},new int[]{R.id.header,R.id.name});
        ListView list=findViewById(R.id.mylist);
        list.setAdapter(simpleAdapter);

        // 添加点击事件
        list.setOnItemClickListener((parent, view, position, id) -> {
            // 获取被点击项的文本内容
            String selectedName = names[position];
//            Toast toast=new Toast(MainActivity.this);
            // 显示 Toast 提示框
            Toast toast=Toast.makeText(MainActivity.this, selectedName, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();

            // 将点击项背景设为红色
            view.setBackgroundColor(Color.RED); // 标记背景为红色

            // 需要的话，可以恢复其他项的背景颜色
            for (int i = 0; i < parent.getChildCount(); i++) {
                View item = parent.getChildAt(i);
                if (i != position) {
                    item.setBackgroundColor(Color.TRANSPARENT); // 恢复其他项背景颜色
                }
            }
        });
    }
}












//public class MainActivity extends AppCompatActivity {
//    private TextView textView;  // 你要修改字体的 TextView
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        textView = findViewById(R.id.textView);// 获取 TextView 控件
//
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // 加载菜单 XML 文件
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == R.id.font_small) {
//            textView.setTextSize(10);  // 设置字体大小为 10
//            return true;
//        } else if (item.getItemId() == R.id.font_medium) {
//            textView.setTextSize(16);  // 设置字体大小为 16
//            return true;
//        } else if (item.getItemId() == R.id.font_large) {
//            textView.setTextSize(20);  // 设置字体大小为 20
//            return true;
//        } else if (item.getItemId() == R.id.color_red) {
//            textView.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_light));  // 使用 ContextCompat 获取颜色
//            return true;
//        } else if (item.getItemId() == R.id.color_black) {
//            textView.setTextColor(ContextCompat.getColor(this, android.R.color.black));  // 使用 ContextCompat 获取颜色
//            return true;
//        } else if (item.getItemId() == R.id.menu_toast) {
//            Toast.makeText(this, "这是一个 Toast 提示", Toast.LENGTH_SHORT).show();  // 弹出 Toast 提示
//            return true;
//        } else {
//            return super.onOptionsItemSelected(item);
//        }
//
//    }
//}

//public class MainActivity extends Activity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        // 加载约束布局文件
//        setContentView(R.layout.constraint); // 这里 R.layout.activity_main 是你的布局文件
//    }
//}




