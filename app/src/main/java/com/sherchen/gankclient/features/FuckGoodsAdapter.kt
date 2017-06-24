package com.sherchen.gankclient.features

import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import com.sherchen.gankclient.R
import com.sherchen.gankclient.bean.FuckGoods
import com.sherchen.gankclient.databinding.ItemFuckgoodsBinding
import com.sherchen.gankclient.features.BaseBindingAdapter
import com.sherchen.gankclient.features.DataBoundViewHolder

/**
 * Created by sherchen on 2017/6/23
 */
class FuckGoodsAdapter(private val mList: List<FuckGoods>) : BaseBindingAdapter<ItemFuckgoodsBinding>() {
  override fun getItemCount(): Int {
    return mList.size
  }

  override fun onBindViewHolder(holder: DataBoundViewHolder<ItemFuckgoodsBinding>, position: Int) {
    super.onBindViewHolder(holder, position)
    holder.binding.fuckgoods = mList[position]
    holder.binding.executePendingBindings()
  }

  override fun onCreateViewHolder(parent: android.view.ViewGroup,
                                  viewType: Int): DataBoundViewHolder<ItemFuckgoodsBinding> {
    return DataBoundViewHolder(
            DataBindingUtil.inflate<ItemFuckgoodsBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_fuckgoods,
                    parent,
                    false
            )
    )
//    return DataBoundViewHolder(
//        ItemFuckgoodsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
  }
}