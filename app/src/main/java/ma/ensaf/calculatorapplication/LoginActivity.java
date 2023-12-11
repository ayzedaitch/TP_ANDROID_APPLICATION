package ma.ensaf.calculatorapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    Button Login;

    FloatingActionButton adduser;

DBHelper DB;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        Login= findViewById(R.id.Login);

        adduser=findViewById(R.id.Adduser);
        DB= new DBHelper(this);



        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String user= username.getText().toString();
                    String pass=password.getText().toString();
                    if(user.equals("") || pass.equals(""))
                    {
                        Toast.makeText(LoginActivity.this, "Some fields are missing", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        boolean checkuser= DB.checkusernamePassword(user,pass);
                        if(checkuser==true){
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);

                        }
                        else{
                            Toast.makeText(LoginActivity.this, "user does not exist", Toast.LENGTH_SHORT).show();
                        }
                    }

            }
        });

        adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,AddUser.class);
                startActivity(intent);
            }
        });


    }
}
