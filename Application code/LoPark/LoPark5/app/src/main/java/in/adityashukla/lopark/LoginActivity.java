package in.adityashukla.lopark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    Button signup;
    EditText emailCheck;
    EditText passCheck;
    Button loginBtn;

    String emailValid = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
       emailCheck = findViewById(R.id.emailCheck);
        passCheck = findViewById(R.id.passCheck);

        loginBtn = findViewById(R.id.login);

        signup = findViewById(R.id.signup);




        mAuth=FirebaseAuth.getInstance();



        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= emailCheck.getText().toString().trim();
                String password=passCheck.getText().toString().trim();

                if(email.isEmpty())
                {
                    emailCheck.setError("Email is empty");
                    emailCheck.requestFocus();
                    return;
                }
                if(!email.matches(emailValid) ){
                    emailCheck.setError("Enter the valid email");
                    emailCheck.requestFocus();
                    return;
                }
                if(password.isEmpty())
                {
                    passCheck.setError("Password is empty");
                    passCheck.requestFocus();
                    return;
                }
                if(password.length()<6)
                {
                    passCheck.setError("Length of password is more than 6");
                    passCheck.requestFocus();
                }

                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                        }
                        else
                        {
                            Toast.makeText(LoginActivity.this,
                                    "Please Check Your login Credentials",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
            }
        });

    }
}