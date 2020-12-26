package com.techsultan.cloudit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.google.firebase.database.core.view.View

data class contant (

    val image: String,
    val name: String

)


fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): android.view.View? {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}
