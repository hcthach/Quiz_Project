package com.example.quiz_project;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

class QuestionNare {
    public String ID;
    public String Q;
    public String AnswerA, AnswerB, AnswerC, AnswerD, Answer;
}
public class quiz_easy extends Activity {
//     ImageView Cauhoi;
    TextView Cauhoi;
    Button A, B, C, D;
    int pos = 0;
    int kq = 0;
    ArrayList<QuestionNare> L = new ArrayList();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_easy);
        Cauhoi = (TextView) findViewById(R.id.TxtCauhoi);
//        Cauhoi = (ImageView) findViewById(R.id.iVCauHoi);
//        Ketqua = (TextView) findViewById(R.id.TxtKetqua);
//        BT = (Button) findViewById(R.id.BtnTraloi);
        A =  findViewById(R.id.BtnDapAnA);
        B = findViewById(R.id.BtnDapAnB);
        C =  findViewById(R.id.BtnDapAnC);
        D =  findViewById(R.id.BtnDapAnD);

        int isCheck = 0 ;

        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCheck==R.id.BtnDapAnA){
                    if (L.get(pos).Answer.compareTo("A") == 0) {
                        kq = kq + 1;
                    }

                }
                pos++;
                if (pos >= L.size()) {
                    Display(pos); // Hiển thị lại nội dung
                } else Display(pos);

            }
        });
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCheck==R.id.BtnDapAnA){
                    if (L.get(pos).Answer.compareTo("A") == 0) {
                        kq = kq + 1;
                    }

                }
                pos++;
                if (pos >= L.size()) {
                    Display(pos); // Hiển thị lại nội dung
                } else Display(pos);

            }
        });
        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCheck==R.id.BtnDapAnA){
                    if (L.get(pos).Answer.compareTo("A") == 0) {
                        kq = kq + 1;
                    }

                }
                pos++;
                if (pos >= L.size()) {
                    Display(pos); // Hiển thị lại nội dung
                } else Display(pos);


            }
        });
        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCheck==R.id.BtnDapAnA){
                    if (L.get(pos).Answer.compareTo("A") == 0) {
                        kq = kq + 1;
                    }

                }
                pos++;
                if (pos >= L.size()) {
                    Display(pos); // Hiển thị lại nội dung
                } else Display(pos);

            }
        });








    }
    void Display(int i) {
        Cauhoi.setText(L.get(i).Q);
        A.setText(L.get(i).AnswerA);
        B.setText(L.get(i).AnswerB);
        C.setText(L.get(i).AnswerC);
        D.setText(L.get(i).AnswerD);
    }
    void ReadData() {
        try {
//Tạo đối tượng DocumentBuilder (builder )
            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = DBF.newDocumentBuilder();
//Tạo FileInputStream từ tập tin XML nguồn
            InputStream in = getAssets().open("data.xml");
//Dùng phương thức parse của đối tượng builder để tạo Document
            Document doc = builder.parse(in);
            Element root = doc.getDocumentElement();//lấy tag Root
            NodeList list = root.getChildNodes();// lấy toàn bộ node con của Root
            for (int i = 0; i < list.getLength(); i++) {
// duyệt từ node đầu tiên cho tới node cuối cùng
                Node node = list.item(i);// mỗi lần duyệt thì lấy ra 1 node
// kiểm tra xem node đó có phải là Element hay không
                if (node instanceof Element) {
                    Element Item = (Element) node;// lấy được tag Item
// lấy tag ID bên trong của tag Item
                    NodeList listChild = Item.getElementsByTagName("ID");
//lấy nội dung của tag ID
                    String ID = listChild.item(0).getTextContent();
// lấy tag Question
                    listChild = Item.getElementsByTagName("Question");
// lấy nội dung Question
                    String Question = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("AnswerA");
                    String AnswerA = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("AnswerB");
                    String AnswerB = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("AnswerC");
                    String AnswerC = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("AnswerD");
                    String AnswerD = listChild.item(0).getTextContent();
                    listChild = Item.getElementsByTagName("Answer");
                    String Answer = listChild.item(0).getTextContent();
//lưu vào list
                    QuestionNare Q1 = new QuestionNare();
                    Q1.ID = ID;
                    Q1.Q = Question;
                    Q1.AnswerA = AnswerA;
                    Q1.AnswerB = AnswerB;
                    Q1.AnswerC = AnswerC;
                    Q1.AnswerD = AnswerD;
                    Q1.Answer = Answer;
                    L.add(Q1);
                }
                ;
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
