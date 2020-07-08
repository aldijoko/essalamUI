package com.example.essalamui.service

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object OkHttpSingleton {

    private var mInstance: OkHttpClient? = null

    val instance: OkHttpClient
        get() {
            if (mInstance == null) {
                mInstance = OkHttpClient()
                mInstance = mInstance!!.newBuilder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .build()
            }
            return mInstance!!
        }
}