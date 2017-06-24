package com.sherchen.gankclient.features.girl

import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import com.sherchen.gankclient.R
import com.sherchen.gankclient.bean.FuckGoods
import com.sherchen.gankclient.databinding.ItemGirlBinding
import com.sherchen.gankclient.features.BaseBindingAdapter
import com.sherchen.gankclient.features.DataBoundViewHolder

/**
 * Created by sherchen on 2017/6/23
 */
class GirlAdapter(private val mList: List<FuckGoods>) : BaseBindingAdapter<ItemGirlBinding>() {
    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: DataBoundViewHolder<ItemGirlBinding>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.binding.girl = mList[holder.adapterPosition]

        //赋值到layout布局中
        holder.binding.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: android.view.ViewGroup,
                                    viewType: Int): DataBoundViewHolder<ItemGirlBinding> {
        return DataBoundViewHolder(
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_girl,
                        parent,
                        false
                )
        )
//        return DataBoundViewHolder(
//                ItemGirlBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }


}