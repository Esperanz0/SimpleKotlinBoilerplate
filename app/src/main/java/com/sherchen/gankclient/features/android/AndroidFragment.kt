package com.sherchen.gankclient.features.android

import android.os.Bundle
import android.support.v4.app.Fragment
import com.sherchen.gankclient.bean.FuckGoods
import com.sherchen.gankclient.features.BaseBindingAdapter
import com.sherchen.gankclient.features.FuckGoodsAdapter
import com.sherchen.gankclient.features.MainFragment

/**
 * Created by sherchen on 2017/6/23
 */
class AndroidFragment : MainFragment() {
    override fun getAdapter(list: ArrayList<FuckGoods>): BaseBindingAdapter<*> {
        return FuckGoodsAdapter(list)
    }

    override fun getType(): String {
        return ANDROID
    }


    //companion object的好处是，外部类可以直接访问对象，不需要通过对象指针
    companion object {
        val ANDROID = "ANDROID"
        fun newInstance(): Fragment {
            val fragment = AndroidFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

}