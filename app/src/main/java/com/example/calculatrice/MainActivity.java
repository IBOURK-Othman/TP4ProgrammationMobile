package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    double firstNum;
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button num0 = findViewById(R.id.num0);Button num1 = findViewById(R.id.num1);
        Button num2 = findViewById(R.id.num2);Button num3 = findViewById(R.id.num3);
        Button num4 = findViewById(R.id.num4);Button num5 = findViewById(R.id.num5);
        Button num6 = findViewById(R.id.num6);Button num7 = findViewById(R.id.num7);
        Button num8 = findViewById(R.id.num8);Button num9 = findViewById(R.id.num9);

        Button on = findViewById(R.id.on);Button ac = findViewById(R.id.ac);
        Button off = findViewById(R.id.off);Button del = findViewById(R.id.del);
        Button division = findViewById(R.id.division);Button egaL = findViewById(R.id.egal);
        Button addition = findViewById(R.id.additon);Button sous = findViewById(R.id.soustraction);
        Button prod = findViewById(R.id.produit);Button pt = findViewById(R.id.pt);

        TextView screen = findViewById(R.id.screen);

        ac.setOnClickListener(view -> {
            firstNum = 0;
            screen.setText("0");

        });

        off.setOnClickListener(view -> screen.setVisibility(view.GONE));
        on.setOnClickListener(view -> {
            screen.setVisibility(view.VISIBLE);
            screen.setText("0");
        });


        ArrayList<Button> nums = new ArrayList<>();
        nums.add(num0);nums.add(num1);nums.add(num2);nums.add(num3);nums.add(num4);
        nums.add(num5);nums.add(num6);nums.add(num7);nums.add(num8);nums.add(num9);

        for (Button b : nums) {
            b.setOnClickListener(view -> {
                if (!screen.getText().toString().equals("0")) {
                    screen.setText(screen.getText().toString() + b.getText().toString());
                } else {
                    screen.setText(b.getText().toString());
                }
            });
        }

        ArrayList<Button> oppers = new ArrayList<>();
        oppers.add(division);oppers.add(sous);oppers.add(addition);oppers.add(prod);
        for (Button b : oppers) {
            b.setOnClickListener(view -> {
                firstNum = Double.parseDouble(screen.getText().toString());
                operation = b.getText().toString();
                screen.setText("");
            });
            egaL.setOnClickListener(view -> {
                double secondNum = Double.parseDouble(screen.getText().toString());
                double result;
                switch (operation) {
                    case "/":
                        result = firstNum / secondNum;
                        break;
                    case "X":
                        result = firstNum * secondNum;
                        break;
                    case "+":
                        result = firstNum + secondNum;
                        break;
                    case "-":
                        result = firstNum - secondNum;
                        break;
                    default:
                        result = firstNum + secondNum;
                }
                screen.setText(String.valueOf(result));
                firstNum = result;
            });
        }
    }
}