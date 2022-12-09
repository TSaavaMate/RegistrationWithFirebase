package com.example.registrationwithfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonRegister.setOnClickListener {
            val email=EmailEditext.text.toString()
            val password=PasswordEditext.text.toString()

            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener { task->
                    if (task.isSuccessful){
                        Toast.makeText(this,"წარმატებით შეიქმნა",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this,"სცადეთ თავიდან",Toast.LENGTH_SHORT).show()
                    }
                }

        }

    }
}