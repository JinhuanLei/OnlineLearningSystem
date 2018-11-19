package com.example.administrator.testui7.Activity;

import android.content.DialogInterface;
import android.os.Looper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.administrator.testui7.R;

import java.util.Timer;
import java.util.TimerTask;

public class DownloadActivity extends AppCompatActivity {
long Pretime=System.currentTimeMillis();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                Looper.prepare();
                    Toast.makeText(DownloadActivity.this, "加载成功", Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        };
        timer.schedule(task,3000);

    }
    //判断时间是否已经完结

    public long timeup()
    {
        return(System.currentTimeMillis() - Pretime);
    }

    private void dialogList() {
        final String items[] = {"刘德华", "张柏芝", "蔡依林", "张学友"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("列表");
        // builder.setMessage("是否确认退出?"); //设置内容
        //builder.setIcon(R.mipmap.ic_launcher);
        // 设置列表显示，注意设置了列表显示就不要设置builder.setMessage()了，否则列表不起作用。
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(DownloadActivity.this, items[which],
                        Toast.LENGTH_SHORT).show();

            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(DownloadActivity.this, "确定", Toast.LENGTH_SHORT)
                        .show();
            }
        });
        builder.create().show();
    }
}
