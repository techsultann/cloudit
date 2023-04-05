package com.techsultan.cloudit.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.techsultan.cloudit.R
import com.techsultan.cloudit.databinding.FragmentSignupBinding


class SignupFragment : Fragment() {

    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        auth = Firebase.auth

        binding.signupBtn.setOnClickListener {
            signUpUser()
        }

        binding.loginTv.setOnClickListener {
            findNavController().navigate(R.id.action_signupFragment_to_loginFragment, null)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }




    private fun signUpUser() {

        val name = binding.etName.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() ) {

            Snackbar.make(requireView(), "All fields are required", Snackbar.LENGTH_SHORT).show()
            return
        }


        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) {task ->

                if (task.isSuccessful) {
                    findNavController().navigate(R.id.action_signupFragment_to_loginFragment, null)


                } else {
                    Snackbar.make(requireView(), "Signup failed", Snackbar.LENGTH_SHORT).show()
                    return@addOnCompleteListener

                }
            }


    }


}