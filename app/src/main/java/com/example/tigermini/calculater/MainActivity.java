package com.example.tigermini.calculater;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    int[] buttons;
    int result;
    int result0;
    int result1;
    Button button_add;
    Button button_minus;
    Button button_multiply;
    Button button_division;
    Button button_equality;
    Button button_clear;
    String str1;
    String str2;
    int flag=0;
    Button temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButton();               //初始化按钮
        button_clear.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        str1 = "";
                        str2 = "";
                        tv.setText(str1);
                        flag = 0;
                    }
                }
        );

        //监听
        for (int i=0;i<buttons.length;i++){
            temp=(Button)findViewById(buttons[i]);
            temp.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            str1=tv.getText().toString().trim();
                            str1=str1+String.valueOf(((Button)v).getText());           //获得新输入的值
                            System.out.println("str1"+":::"+str1);
                            tv.setText(str1);
                        }
                    }
            );
        }
        buttonListener(button_add,1);
        buttonListener(button_minus,2);
        buttonListener(button_multiply,3);
        buttonListener(button_division,4);

        //核心算法
        button_equality.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println(str1);
                        result1=Integer.parseInt(str1);
                        if(flag==1){
                            result=result0+result1;
                            System.out.println(result0+":"+result1);
                        }
                        else if(flag==2){
                            result=result0-result1;
                        }
                        else if(flag==3){
                            result=result0*result1;
                        }
                        else if(flag==4){
                            result=result0/result1;
                        }
                        String str=(result+"").trim();
                        System.out.println(str);
                        tv.setText(str);
                    }
                }
        );
    }


        //初始化按钮
        public void initButton(){
        tv=(TextView)this.findViewById(R.id.tv);
        str1=String.valueOf(tv.getText());
        str2="";
        button_add=(Button)this.findViewById(R.id.button_add);
        button_clear=(Button)this.findViewById(R.id.button_clear);
        button_division=(Button)this.findViewById(R.id.button_division);
        button_equality=(Button)this.findViewById(R.id.button_equality);
        button_minus=(Button)this.findViewById(R.id.button_minus);
        button_multiply=(Button)this.findViewById(R.id.button_multiply);
        buttons=new int[]{
                R.id.button00,R.id.button01,R.id.button02,R.id.button03,R.id.button04,R.id.button05,
                R.id.button05,R.id.button06,R.id.button07,R.id.button08,R.id.button09
        };
    }

    //按钮监听
    public void buttonListener(Button button,final int id){
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str=tv.getText().toString().trim();
                        result0=Integer.parseInt(str);
                        tv.setText("");
                        flag=id;
                    }
                }
        );
    }
}
