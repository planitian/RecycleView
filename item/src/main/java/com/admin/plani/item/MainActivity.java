package com.admin.plani.item;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mainRecy;
    private TestAdapter testAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainRecy = findViewById(R.id.main_recy);
        List<TestBean> beans = new ArrayList<>();
        beans.add(new TestBean("我是第一个","12M",12));
        beans.add(new TestBean("我是第二个","5M",5));
        beans.add(new TestBean("我是第三个","44M",44));

        testAdapter = new TestAdapter((view, position) -> {
              beans.get(position).setAge(18);
             testAdapter.notifyItemChanged(position,"one");
             testAdapter.notifyItemChanged(position,"two");
             testAdapter.notifyItemChanged(position,"three");
        }, beans);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mainRecy.setLayoutManager(linearLayoutManager);
        mainRecy.setAdapter(testAdapter);
    }
}
