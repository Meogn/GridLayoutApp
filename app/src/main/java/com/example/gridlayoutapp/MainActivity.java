package com.example.gridlayoutapp;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Button;
import android.app.Activity;

public class MainActivity extends Activity implements OnClickListener {

    private TextView textView;
    private TextView textViews;
    private String str,num1,num2;
    private double result;
    private boolean addNum;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonadd= (Button) findViewById(R.id.buttonadd);
        buttonadd.setOnClickListener(this);
        Button buttonsub= (Button)findViewById(R.id.buttonsub);
        buttonsub.setOnClickListener(this);
        Button buttonmul= (Button)findViewById(R.id.buttonmul);
        buttonmul.setOnClickListener(this);
        Button buttondiv= (Button)findViewById(R.id.buttondiv);
        buttondiv.setOnClickListener(this);
        Button buttonsqu= (Button) findViewById(R.id.buttonsqu);
        buttonsqu.setOnClickListener(this);
        Button buttonfac= (Button) findViewById(R.id.buttonfac);
        buttonfac.setOnClickListener(this);
        Button button0= (Button)findViewById(R.id.button0);
        button0.setOnClickListener(this);
        Button button1= (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);
        Button button2= (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3= (Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);
        Button button4= (Button)findViewById(R.id.button4);
        button4.setOnClickListener(this);
        Button button5= (Button)findViewById(R.id.button5);
        button5.setOnClickListener(this);
        Button button6= (Button)findViewById(R.id.button6);
        button6.setOnClickListener(this);
        Button button7= (Button)findViewById(R.id.button7);
        button7.setOnClickListener(this);
        Button button8= (Button)findViewById(R.id.button8);
        button8.setOnClickListener(this);
        Button button9= (Button)findViewById(R.id.button9);
        button9.setOnClickListener(this);
        Button buttondot= (Button)findViewById(R.id.buttondot);
        buttondot.setOnClickListener(this);
        Button buttonequ= (Button)findViewById(R.id.buttonequ);
        buttonequ.setOnClickListener(this);
        Button buttond=(Button)findViewById(R.id.buttond);
        buttond.setOnClickListener(this);
        Button buttonc=(Button)findViewById(R.id.buttonc);
        buttonc.setOnClickListener(this);
        textViews = (TextView) findViewById(R.id.textViews);
        textView = (TextView) findViewById(R.id.textView);
        addNum = true;
        //
    }

    public void onClick(View v){
        str = (String) textViews.getText();
        switch (v.getId()) {
            case R.id.buttonc:
                textViews.setText("");
                textView.setText("");
                break;
            case R.id.buttond:
                if(!str.equals("") && str != null){
                    textViews.setText(str.substring(0, str.length()-1));
                }
                break;
            case R.id.buttonequ:
                if(str.contains("+")){
                    calculate1(num1, num2, "+");
                }
                else if(str.contains("-")){
                    calculate1(num1, num2, "-");
                }
                else if(str.contains("*")){
                    calculate1(num1, num2, "*");
                }
                else if(str.contains("/")){
                    calculate1(num1, num2, "/");
                }
                else if(str.contains("X2")) {
                    calculate2(num1,"X2");
                }
                else if(str.contains("X!")) {
                    calculate2(num1,"X!");
                }
                else {
                    return;
                }
                break;
            case R.id.buttonadd:
            case R.id.buttonsub:
            case R.id.buttonmul:
            case R.id.buttondiv:
                if (str.contains("+")||str.contains("-")||str.contains("*")||str.contains("/"))
                    return;
                else
                    textViews.setText(str+((Button)v).getText());
                if(!addNum)
                    addNum = true;
                break;
            default:
                if (addNum) {
                    textViews.setText(str+((Button)v).getText());
                }else{
                    textViews.setText(((Button)v).getText());
                    addNum = true;
                }
                break;
        }
    }
    private void calculate1(String num1,String num2,String op) {
        num1 = str.substring(0,str.indexOf(op));
        num2 = str.substring(str.indexOf(op)+1);
        double n1 = Double.parseDouble(num1);
        double n2 = Double.parseDouble(num2);
        if (op.equals("+")) {
            result = n1+n2;
        }else if(op.equals("-")){
            result = n1-n2;
        }else if(op.equals("*")){
            result = n1*n2;
        }else if(op.equals("/")){
            result = n1 / n2;
        }else {
            return;
        }
        String r = result+"";
        if(r.contains(".")&&r.substring(r.length()-1).equals("0")){
            r = r.substring(0,r.indexOf("."));
        }
        if(op.equals("/")) {
            if(n2==0)
                textView.setText("除数不能为0！");
            else
                textView.setText(r);
        }
        else {
            textView.setText(r);
        }
        addNum = false;
    }
    private void calculate2(String num1,String op) {
        double i;
        num1 = str.substring(0,str.indexOf(op));
        double n1 = Double.parseDouble(num1);
        if(op.equals("X2")) {
            result = n1 * n1;
        }else if(op.equals("X!")) {
            result = 1;
            for(i = n1;i>0;i--) {
                result = result * i;
            }
        }
        else {
            return;
        }
        String r = result+"";
        if(r.contains(".")&&r.substring(r.length()-1).equals("0")){
            r = r.substring(0,r.indexOf("."));
        }
        textView.setText(r);
        addNum = false;
    }
}