package com.example.darshan.foodude;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.darshan.foodude.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class signUp extends AppCompatActivity {

    MaterialEditText editPhone, editName, editPassword;
    Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        editName = (MaterialEditText)findViewById(R.id.editName);
        editPassword = (MaterialEditText)findViewById(R.id.editPassword);
        editPhone = (MaterialEditText)findViewById(R.id.editPhone);
        btnSignUp = (Button)findViewById(R.id.btnSignUp);


        //firebase init
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference tableuser = database.getReference("User");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog = new ProgressDialog(signUp.this);
                mDialog.setMessage("Waiting");
                mDialog.show();

                tableuser.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //check if user phone number already exists
                        if(dataSnapshot.child(editPhone.getText().toString()).exists()){
                            mDialog.dismiss();
                            Toast.makeText(signUp.this, "Phone Number Already Exits", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            mDialog.dismiss();
                            User user = new User(editName.getText().toString(),editPassword.getText().toString());
                            tableuser.child(editPhone.getText().toString()).setValue(user);
                            Toast.makeText(signUp.this, "Sign Up Successful!", Toast.LENGTH_SHORT).show();
                            finish();
                        }


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
