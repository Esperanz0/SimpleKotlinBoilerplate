package com.sherchen.gankclient.features

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

/**
 * Created by sherchen on 2017/6/23
 */
abstract class BaseBindingAdapter<B : ViewDataBinding> : RecyclerView.Adapter<DataBoundViewHolder<B>>() {


    var mListener: ((pos: Int) -> Unit)? = null


    override fun onBindViewHolder(holder: DataBoundViewHolder<B>, position: Int) {
        holder.binding.root.setOnClickListener {
            //kotlin的invoke方法相当于java的reflection
            mListener?.invoke(holder.adapterPosition)
        }
    }

    fun setOnItemClickListener(listener: ((pos: Int) -> Unit)) {
        mListener = listener
    }

}