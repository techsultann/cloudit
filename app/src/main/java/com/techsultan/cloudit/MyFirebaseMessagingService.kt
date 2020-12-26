package com.techsultan.cloudit

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(p0: RemoteMessage) {

            if(p0?.data!= null) {
                Log.d(TAG, "DATA :" + p0.data.toString())

            }

        if(p0?.notification!= null) {

            Log.d(TAG, "NOTIFICATION :" + p0.notification.toString())
        }
        }


    }
