 package com.techsultan.cloudit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.techsultan.cloudit.databinding.ActivityMainBinding
import com.techsultan.cloudit.databinding.ActivityUploadScreenBinding

class MainActivity : AppCompatActivity() {

    private val db : FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference : CollectionReference = db.collection("user")

    var cloudAdapter : cloudAdapter? = null

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerview()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatBtn.setOnClickListener {
            startActivity(Intent(this, ActivityUploadScreenBinding::class.java))
            finish()

        }


    }

    private fun setupRecyclerview() {

        val query : CollectionReference = collectionReference;
        val firestoreRecyclerOptions : FirestoreRecyclerOptions<contant> = FirestoreRecyclerOptions.Builder<contant>()
                .setQuery(query, contant::class.java)
                .build()

        cloudAdapter = cloudAdapter(firestoreRecyclerOptions)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = cloudAdapter
    }

    override fun onStart() {
        super.onStart()
        cloudAdapter!!.startListening()
    }

    override fun onDestroy() {
        super.onDestroy()
        cloudAdapter!!.stopListening()
    }

}

