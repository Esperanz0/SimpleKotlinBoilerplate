package com.sherchen.gankclient.di.module

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sherchen.gankclient.api.GankApi
import com.sherchen.gankclient.features.App
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.Cache
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

/**
 * Created by sherchen on 2017/6/23
 */
@Module()
class ApiModule {
    @Provides fun provideRetrofit(baseUrl: String, client: OkHttpClient, gson: Gson) =
            Retrofit.Builder()
                    .client(client)
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .build()

    @Provides fun provideBaseUrl() = "http://gank.io/api/"
    @Provides fun provideOkhttp(context: App,interceptor: HttpLoggingInterceptor): OkHttpClient {
        val cacheSize = 1024 * 1024 * 10L
        val cacheDir = File(context.cacheDir, "http")
        val cache = Cache(cacheDir, cacheSize)
        return OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(interceptor).build()
    }
    @Provides fun provideInterceptor() :HttpLoggingInterceptor{
        val interceptor = HttpLoggingInterceptor{
            msg -> Log.d("okhttp",msg)
        }
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides fun provideGson() = GsonBuilder().create()

    @Provides fun provideApi(retrofit:Retrofit) = retrofit.create(GankApi::class.java)
}

