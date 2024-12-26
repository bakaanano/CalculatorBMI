package my.edu.utem.ftmk.calculatorbmi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UserInfo extends AppCompatActivity {

    private EditText editTextName, editTextAge;
    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        buttonNext = findViewById(R.id.buttonNext);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String ageStr = editTextAge.getText().toString();

                // Check for empty fields
                if (name.isEmpty() || ageStr.isEmpty()) {
                    Toast.makeText(UserInfo.this, "Please fill in all fields!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Parse age
                int age = Integer.parseInt(ageStr);

                // Start MainActivity and pass the data
                Intent intent = new Intent(UserInfo.this, MainActivity.class);
                intent.putExtra("NAME", name);
                intent.putExtra("AGE", age);
                startActivity(intent);
            }
        });
    }
}