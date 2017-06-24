
package com.sherchen.gankclient.databinding

import com.bumptech.glide.Glide

/**
 * Created by sherchen on 2017/6/23
 */

@android.databinding.BindingAdapter("load_image")
fun loadImage(imageView: android.widget.ImageView, url: String?) =
    Glide.with(imageView.context).load(url)
        .crossFade()
        .into(imageView)


@android.databinding.BindingAdapter("load_asset")
fun loadAsset(imageView: android.widget.ImageView, id:Int) =
        Glide.with(imageView.context).load(id).into(imageView)
