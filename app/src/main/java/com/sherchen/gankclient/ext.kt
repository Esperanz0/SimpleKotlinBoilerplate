package com.sherchen.gankclient

import android.content.Context
import android.widget.Toast
import com.sherchen.common.util.ToastUtils
import com.sherchen.gankclient.features.App

/**
 * Created by sherchen on 2017/6/23
 */
fun Context.getMainComponent() = App.instance.apiComponent

fun Context.toast(msg:String, length:Int = Toast.LENGTH_SHORT){
    ToastUtils.showShortToast(msg)
//  Toast.makeText(this, msg, length).show()
}
fun Context.toast(resId:Int, length:Int = Toast.LENGTH_SHORT) {
    ToastUtils.showShortToast(resId)
}