@file:Suppress("DEPRECATION")

package com.techsultan.cloudit

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import com.google.firebase.storage.FirebaseStorage
import com.techsultan.cloudit.databinding.ActivityLoginScreenBinding
import com.techsultan.cloudit.databinding.ActivitySplashScreenBinding
import com.techsultan.cloudit.databinding.ActivityUploadScreenBinding

@Suppress("DEPRECATION")
class upload_screen : AppCompatActivity() {

    private lateinit var binding: ActivityUploadScreenBinding
    lateinit var filepath : Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_screen)

        binding = ActivityUploadScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnChoose.setOnClickListener {
            chooseFile()
        }

        binding.btnUpload.setOnClickListener {
            uploadFile()
        }

    }

    private fun uploadFile() {

        val progress = ProgressDialog(this)
        progress.setTitle("uploading")
        progress.show()
        val imageRef = FirebaseStorage.getInstance().reference.child("files")
        imageRef.putFile(filepath)

            .addOnSuccessListener {
                progress.dismiss()
                Toast.makeText(applicationContext, "Your file has been uploaded successfully", Toast.LENGTH_LONG).show()
            }
            .addOnProgressListener { task ->
                val uploading = (100.0 * task.bytesTransferred) / task.totalByteCount

                progress.setMessage("uploading ${uploading.toInt()}%")



            }
            .addOnFailureListener { task ->
                progress.dismiss()
                Toast.makeText(applicationContext, task.message,Toast.LENGTH_LONG).show()

            }
    }

    private fun chooseFile() {
        val choose = Intent ()
        choose.setType("image/*")
        choose.setAction(Intent.ACTION_GET_CONTENT)
        startActivityForResult(Intent.createChooser(choose, "choose picture"), 234)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 234 && resultCode == Activity.RESULT_OK && data != null)  {

            filepath = data.data!!
            @Suppress("DEPRECATION") val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filepath)
            binding.image.setImageBitmap(bitmap)
        }
    }

}