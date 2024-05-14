package in.adityashukla.lopark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {

    ImageButton backLogin;
    Button signup;
    EditText userName,emailId,password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        backLogin = findViewById(R.id.backLogin);
        userName =findViewById(R.id.userName);
        emailId = findViewById(R.id.emailId);
        password = findViewById(R.id.passWord);
        signup = findViewById(R.id.signup);


        backLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
            }
        });

        mAuth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validUserCheck();

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }
    }

    private void validUserCheck() {

        String name,email,pass;

        name = userName.getText().toString();
        email = emailId.getText().toString();
        pass = password.getText().toString();

        if(name.isEmpty() || email.isEmpty() || pass.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please fill all fields correct", Toast.LENGTH_SHORT).show();
            finish();
        }else {

            mAuth.createUserWithEmailAndPassword(email,pass)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(SignUpActivity.this, "Account successfully added", Toast.LENGTH_SHORT).show();

                                if(task.isSuccessful()) {
                                    Toast.makeText(SignUpActivity.this, "Account successfully added", Toast.LENGTH_SHORT).show();

                                    UserProfileChangeRequest request = new UserProfileChangeRequest.Builder()
                                            .setDisplayName(String.valueOf(userName))
                                            .build();
                                    Objects.requireNonNull(mAuth.getCurrentUser()).updateProfile(request);
                                openLogin();

                                }else {
                                    Toast.makeText(SignUpActivity.this, "Something error : "+task.getException(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
        }
    }
    private void openLogin() {
        startActivity(new Intent(SignUpActivity.this,MainActivity.class));
        finish();
    }
}
