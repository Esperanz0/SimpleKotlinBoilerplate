package com.sherchen.gankclient.features

import android.app.Activity
import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.sherchen.common.util.Utils
import com.sherchen.gankclient.di.AppInjector
import com.sherchen.gankclient.di.component.ApiComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by sherchen on 2017/6/23
 */
class App : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchAndroidInjector: DispatchingAndroidInjector<Activity>
    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return dispatchAndroidInjector
    }

    init {
        instance = this
    }

    @Inject lateinit var apiComponent: ApiComponent
    override fun onCreate() {
        super.onCreate()
        Utils.init(this)
        AppInjector.init(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }

    companion object {
        lateinit var instance: App
    }
}