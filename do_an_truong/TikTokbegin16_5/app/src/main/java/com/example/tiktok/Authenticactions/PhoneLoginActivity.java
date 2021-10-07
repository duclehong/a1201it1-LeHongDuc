package com.example.tiktok.Authenticactions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tiktok.HomeActivity;
import com.example.tiktok.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class PhoneLoginActivity extends AppCompatActivity {
    private ImageView loader;
    private EditText phoneText,otpText;
    private ImageView phoneBtn,otpBtn;
    private ConstraintLayout phoneLayout,otpLayout;
    /////////////////firabase//////////////
    private String mVerificationId;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks callback;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_login);

        loader = (ImageView) findViewById(R.id.imageView20);
        phoneText = (EditText) findViewById(R.id.editTextTextPersonName);
        otpText = (EditText)findViewById(R.id.otpNo);

        phoneBtn = (ImageView) findViewById(R.id.imageView22);
        otpBtn = (ImageView) findViewById(R.id.imageView222);

        phoneLayout = (ConstraintLayout) findViewById(R.id.phone);
        otpLayout = (ConstraintLayout) findViewById(R.id.otp);

        mAuth = FirebaseAuth.getInstance();

        ///////////////callback//////////////

        callback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){

            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                String code =phoneAuthCredential.getSmsCode();
                if(code!=null){
                    otpText.setText(code);
                    singInWithPhoneAuthCredentials(phoneAuthCredential);
                }
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                Toast.makeText(PhoneLoginActivity.this, "Invalid phone number", Toast.LENGTH_SHORT).show();
                phoneLayout.setVisibility(View.VISIBLE);
                otpLayout.setVisibility(View.GONE);
                loader.setVisibility(View.GONE);
            }

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                Toast.makeText(PhoneLoginActivity.this, "Otp sent", Toast.LENGTH_SHORT).show();
                phoneLayout.setVisibility(View.GONE);
                otpLayout.setVisibility(View.VISIBLE);
                loader.setVisibility(View.GONE);
            }
        };
        //////////////////////////////////////////
        otpBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(otpText.getText().toString()) || otpText.getText().toString().length()!=6){
                    Toast.makeText(PhoneLoginActivity.this, "Hay nhap 6 so", Toast.LENGTH_SHORT).show();
                }else{
                    loader.setVisibility(View.VISIBLE);
                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId,otpText.getText().toString());
                    singInWithPhoneAuthCredentials(credential);
                    otpBtn.setVisibility(View.GONE);
                }
            }
        });
        phoneBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(phoneText.getText().toString()) || phoneText.getText().toString().length()!=10){
                    Toast.makeText(PhoneLoginActivity.this, "Hay nhap 10 so", Toast.LENGTH_SHORT).show();
                }else{
//                    loader.setVisibility(View.VISIBLE);
//                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId,otpText.getText().toString());
//                    singInWithPhoneAuthCredentials(credential);
//                    otpBtn.setVisibility(View.GONE);
                    login();
                    phoneBtn.setVisibility(View.GONE);
                    loader.setVisibility(View.VISIBLE);
                }
            }
        });


    }
    private void login() {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91"+phoneText.getText().toString(),60, TimeUnit.SECONDS,PhoneLoginActivity.this, callback
        );
    }
    private void singInWithPhoneAuthCredentials(PhoneAuthCredential phoneAuthCredential){
        mAuth.signInWithCredential(phoneAuthCredential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            loader.setVisibility(View.GONE);
                            Intent intent = new Intent(PhoneLoginActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish();
                            Animatoo.animateSlideUp(PhoneLoginActivity.this);

                        }else{
                            phoneLayout.setVisibility(View.VISIBLE);
                            otpLayout.setVisibility(View.GONE);
                            loader.setVisibility(View.GONE);
                        }
                    }
                });


    }
}