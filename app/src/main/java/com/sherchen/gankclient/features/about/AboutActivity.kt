package com.sherchen.gankclient.features.about

import com.sherchen.gankclient.R
import com.sherchen.gankclient.router.GankClientUri

/**
 * Created by sherchen on 2017/6/23
 */
@com.airbnb.deeplinkdispatch.DeepLink(GankClientUri.ABOUT)
class AboutActivity : android.support.v7.app.AppCompatActivity() {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

    }
}
