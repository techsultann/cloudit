package com.techsultan.cloudit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.techsultan.cloudit.databinding.ActivitySignUpBinding

class sign_up : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.orSignupBtn.setOnClickListener{
            signUpUser()
        }
    }

    private fun signUpUser() {

        if (binding.emailTxt.toString().isEmpty()){
            binding.emailTxt.error = "Please enter your email"
            binding.emailTxt.requestFocus()
            return
        }

        if (Patterns.EMAIL_ADDRESS.matcher(binding.emailTxt.toString()).matches()) {
            binding.emailTxt.error = "Please enter your email"
            binding.emailTxt.requestFocus()
            return
        }
        if (binding.passwordTxt.editText.toString().isEmpty()) {
            binding.emailTxt.error = "Please enter password"
            binding.passwordTxt.requestFocus()
            return
        }

        auth.createUserWithEmailAndPassword(binding.emailTxt.editText.toString(), binding.passwordTxt.editText.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    startActivity(Intent(this, file_screen::class.java))
                    finish()

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }


            }
    }
}