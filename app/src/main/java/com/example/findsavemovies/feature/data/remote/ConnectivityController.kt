package com.example.findsavemovies.feature.data.remote

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities


class ConnectivityController(
   private val context: Context
) {
     fun isOnline(): Boolean {
        val connectivityManager = context.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        var res = false
        connectivityManager.let {
            it.getNetworkCapabilities(connectivityManager.activeNetwork)?.apply {
                res = when {
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    else -> false
                }
            }
        }
        return res
    }
}