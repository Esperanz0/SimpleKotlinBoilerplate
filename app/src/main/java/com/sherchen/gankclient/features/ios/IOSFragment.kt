package com.sherchen.gankclient.features.ios

import android.os.Bundle
import android.support.v4.app.Fragment
import com.sherchen.gankclient.bean.FuckGoods
import com.sherchen.gankclient.features.BaseBindingAdapter
import com.sherchen.gankclient.features.FuckGoodsAdapter
import com.sherchen.gankclient.features.MainFragment

/**
 * Created by sherchen on 2017/6/23
 */
class IOSFragment : MainFragment() {
  override fun getAdapter(list: ArrayList<FuckGoods>): BaseBindingAdapter<*> {
    return FuckGoodsAdapter(list)
  }

  override fun getType(): String {
    return IOS
  }

  companion object {
    const val IOS = "iOS"
    fun newInstance(): Fragment {
      val fragment = IOSFragment()
      val bundle = Bundle()
      fragment.arguments = bundle
      return fragment
    }
  }
}