package com.example.quiz_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class activity_login extends Activity {
    Button BT1;
    TextView TV1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        BT1=findViewById(R.id.BtnDangNhap);
//        BT2=findViewById(R.id.BtnDangKy);

        TV1=findViewById(R.id.TxtDangKy);

        BT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_login.this, MainActivity.class);
                startActivity(intent);
            }
        });

//        BT2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(activity_login.this, activity_register.class);
//                startActivity(intent);
//            }
//        });

        TV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_login.this, activity_register.class);
                startActivity(intent);
            }
        });
        // Tạo một đối tượng SpannableString
        SpannableStringBuilder builder = new SpannableStringBuilder();
        // Thêm văn bản với định dạng khác nhau
//        String text1 = "Đăng ký";
//        SpannableString spannableString1 = new SpannableString(text1);
//        spannableString1.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, text1.length(), 0);
//        builder.append(spannableString1);

        String dangky = "Đăng ký";
        SpannableString spannableString2 = new SpannableString(dangky);
        spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.blue)), 0, dangky.length(), 0);
        builder.append(spannableString2);
//
//        String text3 = " trong Android Studio";
//        SpannableString spannableString3 = new SpannableString(text3);
//        spannableString3.setSpan(new UnderlineSpan(), 0, text3.length(), 0);
//        builder.append(spannableString3);

        // Hiển thị văn bản trong TextView
        TV1.setText(builder, TextView.BufferType.SPANNABLE);


    }
}
