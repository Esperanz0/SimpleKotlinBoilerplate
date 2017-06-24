package com.sherchen.gankclient.di.component

import com.sherchen.gankclient.features.App
import com.sherchen.gankclient.di.module.ApiModule
import com.sherchen.gankclient.di.module.MainActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

/**
 * Created by sherchen on 2017/6/23
 */
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        ApiModule::class,
        MainActivityModule::class
        ))
interface ApiComponent{
    fun inject(app: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: App) : Builder
        fun build() : ApiComponent
    }
}

