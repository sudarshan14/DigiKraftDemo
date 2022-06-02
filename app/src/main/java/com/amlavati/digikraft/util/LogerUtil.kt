package com.amlavati.digikraft.util

import android.util.Log
import com.amlavati.digikraft.BuildConfig

private const val isDebug = true
const val UNI_TAG = "sudarshandebug"

fun exceptionLogger(TAG: String?, message: String?, exception: Exception?) {
    Log.e(TAG, message, exception)
}

fun debugLogger(TAG: String?, message: String?) {
    if (BuildConfig.DEBUG) {

        Log.d(TAG, message!!)
    }

}
