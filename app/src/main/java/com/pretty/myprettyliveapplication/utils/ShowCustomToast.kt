package com.pretty.myprettyliveapplication.utils

import android.content.Context
import android.widget.Toast

class ShowCustomToast {
    fun toast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}