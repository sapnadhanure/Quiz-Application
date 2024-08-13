package com.example.quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.quiz.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class signUpActivity extends AppCompatActivity {
    ActivitySignUpBinding binding;
    FirebaseAuth auth;
    FirebaseFirestore database;
    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        binding=ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth=FirebaseAuth.getInstance();
        database= FirebaseFirestore.getInstance();

        dialog= new ProgressDialog(this);
        dialog.setMessage("Just wait a moment....");

        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail, pass, name, refercode;
                mail= binding.email.getText().toString();
                pass=binding.password.getText().toString();
                name= binding.name.getText().toString();
                refercode= binding.code.getText().toString();

                final User user= new  User(name, pass, mail,refercode);
                dialog.show();


                auth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            dialog.dismiss();
                            String uid=task.getResult().getUser().getUid();
                            database
                                    .collection("users")
                                            .document(uid)
                                                    .set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()){
                                                startActivity(new Intent(signUpActivity.this,MainActivity.class));
                                                finish();
                                            }else {
                                                Toast.makeText(signUpActivity.this,task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();


                                            }
                                        }
                                    });
                            Toast.makeText(signUpActivity.this, "Successfull", Toast.LENGTH_SHORT).show();

                        }else {
                            dialog.dismiss();
                            Toast.makeText(signUpActivity.this,task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}