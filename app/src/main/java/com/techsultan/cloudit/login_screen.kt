package com.techsultan.cloudit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging
import com.techsultan.cloudit.databinding.ActivityLoginScreenBinding
import com.techsultan.cloudit.databinding.ActivitySignUpBinding




class login_screen : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLoginScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.orSignupBtn.setOnClickListener {
            startActivity(Intent(this, ActivitySignUpBinding::class.java))
            finish()
        }
        binding.buttonSp.setOnClickListener {

        }


        Firebase.messaging.isAutoInitEnabled = true

        auth = FirebaseAuth.getInstance()

    }

    private fun login() {

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

        auth.signInWithEmailAndPassword(binding.emailTxt.toString(), binding.passwordTxt.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                }
                    updateUI(null)

                }


            }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(currentUser: FirebaseUser?) {

        if(currentUser != null){
            startActivity(Intent(this, file_screen::class.java))
        }
        else {

            Toast.makeText(baseContext, "Login failed.",
                Toast.LENGTH_SHORT).show()

    }

}



    }
