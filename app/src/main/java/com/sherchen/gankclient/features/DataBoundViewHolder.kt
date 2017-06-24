package com.sherchen.gankclient.features

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by sherchen on 2017/6/23
 */
 class DataBoundViewHolder<out T : ViewDataBinding>(val binding:T) : BaseViewHolder(binding.root)
