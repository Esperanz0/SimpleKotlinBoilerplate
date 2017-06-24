package com.sherchen.gankclient.router

import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * Created by sherchen on 2017/6/23
 */
object GankRouter{
    fun router(context: Context,uri : String){
        val intent = Intent()
        intent.data = Uri.parse(uri)
        intent.action = Intent.ACTION_VIEW
        context.startActivity(intent)
    }

}