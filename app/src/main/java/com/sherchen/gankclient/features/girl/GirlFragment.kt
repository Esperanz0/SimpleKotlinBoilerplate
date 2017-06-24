package com.sherchen.gankclient.features.girl

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.widget.ImageView
import com.sherchen.gankclient.R
import com.sherchen.gankclient.bean.FuckGoods
import com.sherchen.gankclient.features.BaseBindingAdapter
import com.sherchen.gankclient.features.MainFragment
import com.sherchen.gankclient.features.ios.ImageActivity
import com.sherchen.gankclient.router.GankClientUri
import com.sherchen.gankclient.router.GankRouter
import kotlinx.android.synthetic.main.item_girl.*
import kotlinx.android.synthetic.main.view_recycler.*
import java.net.URLEncoder

/**
 * Created by sherchen on 2017/6/23
 */
class GirlFragment : MainFragment(){
    override fun getType(): String {
        return GIRL
    }

    override fun getAdapter(list: ArrayList<FuckGoods>): BaseBindingAdapter<*> {
        return GirlAdapter(list)
    }

    override fun getLayoutManager(): LinearLayoutManager {
        return GridLayoutManager(context, 2)
    }

    override fun getItemClickListener(): (Int) -> Unit {
        return { pos ->
            val holder = recyclerView.findViewHolderForAdapterPosition(pos)
            val imageView = holder?.itemView?.findViewById(R.id.iv_girl) as ImageView
            ImageActivity.startActivity(context, imageView, mList[pos]?.url)
        }
    }

    companion object {
        val GIRL = "GIRL"
        fun newInstance(): GirlFragment {
            val fragment = GirlFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }
}