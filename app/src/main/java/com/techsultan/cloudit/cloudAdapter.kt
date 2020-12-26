package com.techsultan.cloudit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions



class cloudAdapter(options: FirestoreRecyclerOptions<contant>) :
    FirestoreRecyclerAdapter<contant, cloudAdapter.cloudAdapterVH>(options) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cloudAdapterVH {
        return cloudAdapterVH(LayoutInflater.from(parent.context).inflate(R.layout.activity_file_screen,parent, false))
    }

    override fun onBindViewHolder(holder: cloudAdapterVH, position: Int, model: contant) {
        Glide.with()
    }

    class cloudAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image: ImageView = itemView.findViewById(R.id.image)

        val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_droidhub_logo_1)
                .error(R.drawable.ic_launcher_background)


    }

}