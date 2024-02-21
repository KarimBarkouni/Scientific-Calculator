package com.example.calculator;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {

    TextView previousCalculation;
    EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        previousCalculation = findViewById(R.id.prevCalcRevew);
        display = findViewById(R.id.displayEditText);

        display.setShowSoftInputOnFocus(false);
    }

    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();

        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos + strToAdd.length());
    }
    public void zeroBTnPush(View view){
        updateText(getResources().getString(R.string.zeroText));
    }
    public void oneBTnPush(View view){
        updateText(getResources().getString(R.string.oneText));
    }
    public void twoBTnPush(View view){
        updateText(getResources().getString(R.string.twoText));
    }
    public void threeBTnPush(View view){
        updateText(getResources().getString(R.string.threeText));
    }
    public void fourBTnPush(View view){
        updateText(getResources().getString(R.string.fourText));
    }
    public void fiveBTnPush(View view){
        updateText(getResources().getString(R.string.fiveText));
    }
    public void sixBTnPush(View view){
        updateText(getResources().getString(R.string.sixText));
    }
    public void sevenBTnPush(View view){
        updateText(getResources().getString(R.string.sevenText));
    }
    public void eightBTnPush(View view){
        updateText(getResources().getString(R.string.eightText));
    }
    public void nineBTnPush(View view){
        updateText(getResources().getString(R.string.nineText));
    }
    public void plusBTnPush(View view){
        updateText(getResources().getString(R.string.addText));
    }
    public void minusBTnPush(View view){
        updateText(getResources().getString(R.string.subtractText));
    }
    public void multiplicationBTnPush(View view){
        updateText(getResources().getString(R.string.multiplyText));
    }
    public void divisionBTnPush(View view){
        updateText(getResources().getString(R.string.divideText));
    }
    public void equalBTnPush(View view){
        String userExp = display.getText().toString();

        previousCalculation.setText(userExp);

        userExp = userExp.replaceAll(getResources().getString(R.string.divideText), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiplyText), "*");

        Expression exp = new Expression(userExp);
        String result =String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }
    public void clearBTnPush(View view){
        display.setText("");
        previousCalculation.setText("");
    }
    public void decimalBTnPush(View view){
        updateText(getResources().getString(R.string.decimalText));
    }
    public void backSpaceBTnPush(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }
    public void parenthesesOpenTextBTnPush(View view){
        updateText(getResources().getString(R.string.parenthesesOpenText));
    }
    public void parenthesesCloseTextBTnPush(View view){
        updateText(getResources().getString(R.string.parenthesesCloseText));
    }
    public void trigSinBtnPush(View view){
        updateText("sin(");
    }

    public void trigCosBtnPush(View view){
        updateText("cos(");
    }

    public void trigTanBtnPush(View view){
        updateText("tan(");
    }

    public void trigArcSinBtnPush(View view){
        updateText("ArcSin(");
    }

    public void trigArcCosBtnPush(View view){
        updateText("ArcCos(");
    }

    public void trigArcTanBtnPush(View view){
        updateText("ArcTan(");
    }

    public void naturalLogBtnPush(View view){
        updateText("ln(");
    }

    public void LogBtnPush(View view){
        updateText("Log(");
    }

    public void squareRootBtnPush(View view){
        updateText("√");
    }

    public void absoluteBtnPush(View view){
        updateText("abs(");
    }

    public void PiBtnPush(View view){
        updateText("π");
    }

    public void eBtnPush(View view){
        updateText("e");
    }

    public void xSquaredBtnPush(View view){
        updateText("^(2)");
    }

    public void xPowerBtnPush(View view){
        updateText("^(");
    }

    public void isPrimeBtnPush(View view){
        updateText("is-pr(");
    }

}