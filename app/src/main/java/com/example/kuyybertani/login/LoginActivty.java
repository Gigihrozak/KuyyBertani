package com.example.kuyybertani.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kuyybertani.MainActivity;
import com.example.kuyybertani.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivty extends AppCompatActivity {
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activty);
        editTextEmail = (EditText) findViewById(R.id.emailin);
        editTextPassword = (EditText) findViewById(R.id.inputPassword);
        buttonLogin = (Button) findViewById(R.id.btn_login);

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override

            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if (firebaseAuth.getCurrentUser() != null) {

                    startActivity(new Intent(LoginActivty.this, MainActivity.class) );

                }

            }

        };
        buttonLogin.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                startSignIn();

            }

        });

    }
    @Override

    protected void onStart() {

        super.onStart();

        mAuth.addAuthStateListener(mAuthListener);

    }
    private void startSignIn() {

        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();



        if (TextUtils.isEmpty(email) | TextUtils.isEmpty(password)) {

            Toast.makeText(LoginActivty.this, "Fields are Empty", Toast.LENGTH_SHORT).show();

        } else {


            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener() {

                @Override

                public void onComplete(@NonNull Task task) {



                    if (!task.isSuccessful()) {

                        Toast.makeText(LoginActivty.this, "Login Problem", Toast.LENGTH_SHORT).show();

                    }



                }

            });

        }

    }

    public void home(View view){
        Intent intent = new Intent(LoginActivty.this,LoginActivty.class);
        startActivity(intent);
    }

}
