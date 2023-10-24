package com.example.quiz_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    Button BT1, BT2, BT3,BTThoat;
    ImageButton IB1,IB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //xác định trang
        setContentView(R.layout.activity_main);

        //các button của câu hỏi
        BT1 = findViewById(R.id.BtnDe);
        BT2 =findViewById(R.id.BtnTrungBinh);
        BT3=findViewById(R.id.BtnKho);

        IB1 = findViewById(R.id.imgBtnRanking);
        IB2 =findViewById(R.id.imgBtnSetting);

        //nút thoát ra màn hình đăng nhập
        BTThoat=findViewById(R.id.BtnThoat);

        //Khai báo nút chuyển trang Câu hỏi dễs
        BT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dùng intent để chuyển qua trang
                Intent intent= new Intent(MainActivity.this, quiz_easy.class);
                startActivity(intent);
            }
        });

        //Khai báo nút chuyển trang Câu hỏi trung bình
        BT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, quiz_medium.class);
                startActivity(intent);
            }
        });

        //Khai báo nút chuyển trang Câu hỏi khó
        BT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, quiz_hard.class);
                startActivity(intent);
            }
        });

        //ghi nhận sự kiện khi được nhấn.
        BTThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, activity_login.class);
                startActivity(intent);
            }
        });

        IB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, activity_ranking.class);
                startActivity(intent);
            }
        });


    }
}