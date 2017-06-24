package com.sherchen.gankclient.features.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.webkit.WebView
import android.widget.ProgressBar
import com.sherchen.gankclient.R

/**
 * Created by sherchen on 2017/6/23
 */
class ProgressWebView(context: Context, attrs: AttributeSet) : WebView(context, attrs) {

    private val progressbar: ProgressBar

    init {
        progressbar = ProgressBar(context, null,
                android.R.attr.progressBarStyleHorizontal)
        progressbar.layoutParams = LayoutParams(LayoutParams.FILL_PARENT,
                10, 0, 0)

        val drawable = context.resources.getDrawable(R.drawable.progress_bar)
        progressbar.progressDrawable = drawable
        addView(progressbar)
        setWebChromeClient(WebChromeClient())
        settings.builtInZoomControls = true
    }

    inner class WebChromeClient : android.webkit.WebChromeClient() {
        override fun onProgressChanged(view: WebView, newProgress: Int) {
            if (newProgress == 100) {
                progressbar.visibility = View.GONE
            } else {
                if (progressbar.visibility == View.GONE)
                    progressbar.visibility = View.VISIBLE
                progressbar.progress = newProgress
            }
            super.onProgressChanged(view, newProgress)
        }

    }

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        val lp = progressbar.layoutParams as LayoutParams
        lp.x = l
        lp.y = t
        progressbar.layoutParams = lp
        super.onScrollChanged(l, t, oldl, oldt)
    }
}
