package com.litesky.imaudio;

import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.rtp.AudioStream;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.security.Permission;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.jar.Manifest;

public class FileActivity extends AppCompatActivity {

    private Button play;
    private Button start;
    private TextView info;
    private ExecutorService mExecutorService;
    private MediaRecorder mediaRecorder;
    private File audioFile;
    private Long startTime,stopTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        mExecutorService= Executors.newSingleThreadExecutor();


        initViews();
        initEvents();
    }

    private void initViews() {
        play = ((Button) findViewById(R.id.button_play_FileActivity));
        start = ((Button) findViewById(R.id.button_start_FileActivity));
        info = ((TextView) findViewById(R.id.textView_info_FileActivity));
    }

    private void initEvents() {
        start.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        startRecord();
                        break;
                    case MotionEvent.ACTION_UP:
                        stopRecord();
                        break;
                }
                return true;
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer=new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(audioFile.getAbsolutePath());
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void startRecord() {

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.RECORD_AUDIO)!=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{
                    android.Manifest.permission.RECORD_AUDIO, android.Manifest.permission.WRITE_EXTERNAL_STORAGE
            },1);
        }
        {
            start.setText("正在录音...");

            try {
                mediaRecorder=new MediaRecorder();
                audioFile=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/demo/"+System.currentTimeMillis()+".m4a");
                audioFile.getParentFile().mkdirs();
                audioFile.createNewFile();

                //设置声音采集来源： 麦克风
                mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);

                //设置输出格式
                mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);

                //设置采样率
                mediaRecorder.setAudioSamplingRate(44100);

                //设置编码
                mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);

                //设置编码率
                mediaRecorder.setAudioEncodingBitRate(96000);

                //设置输出文件位置
                mediaRecorder.setOutputFile(audioFile.getAbsolutePath());

                mExecutorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            mediaRecorder.prepare();
                            mediaRecorder.start();
                            startTime=System.currentTimeMillis();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }


    private void stopRecord() {
        start.setText("开始录音");
        mediaRecorder.stop();
        stopTime=System.currentTimeMillis();
        info.setText((int)(stopTime-startTime)/1000+"秒");
        Toast.makeText(this,audioFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mExecutorService.shutdownNow();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        {
            case 1:
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED
                        &&grantResults[1]==PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(this,"你同意了此权限",Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(this,"你拒绝了此权限",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
