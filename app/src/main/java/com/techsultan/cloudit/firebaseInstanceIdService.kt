package com.techsultan.cloudit

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceIdService


const val TAG = "MyFirebase"
class firebaseInstanceIdService() : FirebaseInstanceIdService() {

    override fun onTokenRefresh() {
        super.onTokenRefresh()

        /**
         * Called if the FCM registration token is updated. This may occur if the security of
         * the previous token had been compromised. Note that this is called when the
         * FCM registration token is initially generated so this is where you would retrieve the token.
         */
        fun onNewToken(token: String) {
            Log.d(TAG, "Refreshed token: $token")

        }

    }

}

