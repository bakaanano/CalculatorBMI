package my.edu.utem.ftmk.calculatorbmi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView textViewResult, textViewCategory;
    private Button buttonBack, buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewResult = findViewById(R.id.textViewResult);
        textViewCategory = findViewById(R.id.textViewCategory);
        buttonBack = findViewById(R.id.buttonBack);
        buttonLogout = findViewById(R.id.buttonLogout1);

        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        double bmi = intent.getDoubleExtra("BMI", 0);

        if (name == null || name.isEmpty()) {
            Toast.makeText(this, "Name field is empty!", Toast.LENGTH_SHORT).show();
            textViewResult.setText("BMI calculation could not be completed.");
            textViewCategory.setText("");
        } else {
            textViewResult.setText("Name: " + name + "\nBMI: " + String.format("%.2f", bmi));
            textViewCategory.setText("Category: " + getBMICategory(bmi));
        }

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); 
            }
        });

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logoutIntent = new Intent(ResultActivity.this, UserInfo.class);
                logoutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(logoutIntent);
                finish();
            }
        });
    }

    private String getBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 24.9) {
            return "Normal weight";
        } else if (bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obesity";
        }
    }
}