package com.example.yagami.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.help:
                Toast.makeText(this, "You clicked Help.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit:
                Toast.makeText(this, "You clicked Exit.", Toast.LENGTH_SHORT).show();
                finish();       //destroy Activity
                break;
            default:
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button btn_1 = (Button)findViewById(R.id.button_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    //添加了一个Toast用于提醒
                Toast.makeText(FirstActivity.this, "You clicked Button 1.", Toast.LENGTH_SHORT).show();
                /**
                 * 这里我们修改点击事件，构建一个Intent（显式）
                 * FirstActivity.this作为上下文
                 * SecondActivity作为目标活动
                 */
                String data = "Hello from FirstActivity.";
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("extra_data", data);    //利用putExtra()，将想要传递的数据暂存在Intent中，启动后再取出
                startActivity(intent);
            }
        });
    }
}
