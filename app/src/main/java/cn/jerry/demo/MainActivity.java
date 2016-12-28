package cn.jerry.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import cn.jerry.easyclick.NTimeClicked;
import cn.jerry.easyclick.OnceClick;
import cn.jerry.easyclick.TwiceClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new OnceClick(){

            @Override
            protected void onOnceClick(View view) {
                Toast.makeText(MainActivity.this, "第一次点了一下", Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void otherCase(View view) {
                Toast.makeText(MainActivity.this, "对不起你已经参加过了", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new TwiceClick() {

            @Override
            protected void firstClick(View view) {
                Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void secondClick(View view) {
                Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.button3).setOnClickListener(new NTimeClicked() {

            @Override
            protected void nClick(int index, View view) {
                Toast.makeText(MainActivity.this, "index : " + index, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
