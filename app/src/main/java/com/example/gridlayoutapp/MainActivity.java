package com.example.gridlayoutapp;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Button;
import android.app.Activity;

public class MainActivity extends Activity implements OnClickListener {

    private TextView textView;
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
        textView = (TextView) findViewById(R.id.textView);
        addNum = true;
    }

    public void onClick(View v){
        str = (String) textView.getText();
        switch (v.getId()) {
            case R.id.buttonc:
                textView.setText("");
                break;
            case R.id.buttond:
                if(!str.equals("") && str != null){
                    textView.setText(str.substring(0, str.length()-1));
                }
                break;
            case R.id.buttonequ:
                if(str.contains("+")){
                    calculate(num1, num2, "+");
                }
                else if(str.contains("-")){
                    calculate(num1, num2, "-");
                }
                else if(str.contains("*")){
                    calculate(num1, num2, "*");
                }
                else if(str.contains("/")){
                    calculate(num1, num2, "/");
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
                    textView.setText(str+((Button)v).getText());
                if(!addNum)
                    addNum = true;
                break;
            default:
                if (addNum) {
                    textView.setText(str+((Button)v).getText());
                }else{
                    textView.setText(((Button)v).getText());
                    addNum = true;
                }
                break;
        }
    }
    private void calculate(String num1,String num2,String op) {
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
            result = n1/n2;
        }else {
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