package com.example.usernameid;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.usernameid.R;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername, etID;
    private Button btnValidate;
    private TextView tvValidationResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etID = findViewById(R.id.etID);
        btnValidate = findViewById(R.id.btnValidate);
        tvValidationResult = findViewById(R.id.tvValidationResult);

        btnValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInputs();
            }
        });
    }

    private void validateInputs() {
        String username = etUsername.getText().toString().trim();
        String id = etID.getText().toString().trim();

        // Reset validation result visibility
        tvValidationResult.setVisibility(View.GONE);

        // Check if any field is empty
        if (TextUtils.isEmpty(username)) {
            etUsername.setError("Username is required");
            return;
        }

        if (TextUtils.isEmpty(id)) {
            etID.setError("ID is required");
            return;
        }

        // Check if username contains only alphabets
        if (!username.matches("[a-zA-Z]+")) {
            etUsername.setError("Username should only contain alphabets");
            return;
        }

        // Check if ID is numeric and exactly 4 digits
        if (!id.matches("\\d{4}")) {
            etID.setError("ID should be a 4-digit number");
            return;
        }

        // If all validations pass, show validation result
        tvValidationResult.setText("Validation Successful");
        tvValidationResult.setVisibility(View.VISIBLE);
    }
}
