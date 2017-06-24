package com.sherchen.gankclient.features.detail

import android.databinding.DataBindingUtil
import com.airbnb.deeplinkdispatch.DeepLink
import com.sherchen.gankclient.R
import com.sherchen.gankclient.databinding.ActivityDetailBinding
import com.sherchen.gankclient.features.BaseBindingActivity
import com.sherchen.gankclient.router.GankClientUri
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.view.*

@DeepLink(GankClientUri.DETAIL + "{${GankClientUri.DETAIL_PARAM_URL}}")
class DetailActivity : BaseBindingActivity<ActivityDetailBinding>() {
    var url = ""
    override fun initView() {
        if (intent.getBooleanExtra(com.airbnb.deeplinkdispatch.DeepLink.IS_DEEP_LINK, false)) {
            url = java.net.URLDecoder.decode(intent.extras.getString(GankClientUri.DETAIL_PARAM_URL))
        }
        setupToolbar(activity_detail.toolbar)
        activity_detail.tv_title.text = "Gank.io"
        activity_detail.webView.loadUrl(url)
        activity_detail.webView.setWebViewClient(object : android.webkit.WebViewClient() {
            override fun shouldOverrideUrlLoading(view: android.webkit.WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
         }
        )
    }

    override fun createDataBinding(savedInstanceState: android.os.Bundle?): ActivityDetailBinding {
        return DataBindingUtil.setContentView(this, R.layout.activity_detail)
    }

}
