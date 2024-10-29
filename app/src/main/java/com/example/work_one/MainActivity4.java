package com.example.work_one;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Field;

public class MainActivity4 extends Activity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
    private int selectedPosition=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.context_main);

        // 获取 ListView 实例
        listView = findViewById(R.id.listView);

        // 使用 ArrayAdapter 绑定数据
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        // 为 ListView 设置长按监听器来启用 ActionMode
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            // 长按时，改变选中项的背景颜色为红色
            selectedPosition = position;
            view.setBackgroundColor(Color.BLUE);

            // 启动 ActionMode
            startActionMode(new ActionModeCallback());
            return true;
        });
    }

    // ActionMode 的回调实现
    private class ActionModeCallback implements ActionMode.Callback {

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // 创建上下文菜单
            mode.setTitle("Select");
            mode.getMenuInflater().inflate(R.menu.context_menu, menu); // 可以创建自定义的菜单资源
//            // 获取 ActionMode 标题栏的视图
//            View actionModeView = mode.getCustomView();
//            // 通过反射获取 ActionMode 标题栏并设置背景
//            try {
//                Field field = mode.getClass().getDeclaredField("mContextView");
//                field.setAccessible(true);
//                View contextView = (View) field.get(mode);
//
//                // 设置背景颜色
//                contextView.setBackgroundColor(Color.RED); // 设置为你需要的颜色
//            } catch (NoSuchFieldException | IllegalAccessException e) {
//                e.printStackTrace();
//            }
            return true;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            // 根据点击的菜单项执行不同操作
            if (item.getItemId() == R.id.action_delete) {
                Toast.makeText(MainActivity4.this, "Delete Item", Toast.LENGTH_SHORT).show();
                mode.finish(); // 关闭 ActionMode
                return true;
            }  else {
                return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            // 在 ActionMode 结束时恢复原来背景
            if (selectedPosition != -1) {
                View selectedView = listView.getChildAt(selectedPosition - listView.getFirstVisiblePosition());
                if (selectedView != null) {
                    selectedView.setBackgroundColor(Color.TRANSPARENT); // 恢复背景
                }
            }
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false; // 默认不做任何准备操作
        }
    }
}
