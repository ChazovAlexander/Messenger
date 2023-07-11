package com.example.messenger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private boolean isLoginFormVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);
        TextView registerUsername = findViewById(R.id.registerUsername);
        TextView registerPassword = findViewById(R.id.registerPassword);
        SwitchCompat switchForm = findViewById(R.id.switchForm);
        switchForm.getThumbDrawable().setTint(getResources().getColor(R.color.white));
        switchForm.getTrackDrawable().setTint(getResources().getColor(R.color.track));
        switchForm.getThumbDrawable().setBounds(10,10,10,10);
        MaterialButton loginbtn = findViewById(R.id.loginbtn);
        MaterialButton regbtn = findViewById(R.id.regbtn);
        TextView forgotpass = findViewById(R.id.forgotpass);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();
                }
            }
        });

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String registeredUsername = registerUsername.getText().toString();
                String registeredPassword = registerPassword.getText().toString();
                // Perform registration validation and save the user data
                Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
            }
        });

        switchForm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    // Hide login form, show register form
                    username.setVisibility(View.GONE);
                    password.setVisibility(View.GONE);
                    loginbtn.setVisibility(View.GONE);
                    forgotpass.setVisibility(View.GONE);
                    registerUsername.setVisibility(View.VISIBLE);
                    registerPassword.setVisibility(View.VISIBLE);
                    regbtn.setVisibility(View.VISIBLE);
                } else {
                    // Hide register form, show login form
                    username.setVisibility(View.VISIBLE);
                    password.setVisibility(View.VISIBLE);
                    loginbtn.setVisibility(View.VISIBLE);
                    forgotpass.setVisibility(View.VISIBLE);
                    registerUsername.setVisibility(View.GONE);
                    registerPassword.setVisibility(View.GONE);
                    regbtn.setVisibility(View.GONE);
                }
            }
        });
    }
}
