package com.sherchen.gankclient.api

import com.sherchen.gankclient.bean.FuckGoods
import com.sherchen.gankclient.bean.JsonResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by sherchen on 2017/6/23
 */
interface GankApi{

  /**
   * Android所有数据
   */
  @GET("data/Android/10/{page}")
  fun getAndroidData(@Path("page") page:Int): Observable<JsonResult<List<FuckGoods>>>

  /**
    * iOS所有数据
   */
  @GET("data/iOS/10/{page}")
  fun getiOSData(@Path("page") page:Int): Observable<JsonResult<List<FuckGoods>>>

  /**
   * iOS所有数据
   */
  @GET("data/福利/10/{page}")
  fun getGirlData(@Path("page") page:Int): Observable<JsonResult<List<FuckGoods>>>


  /**
   * 手气不错
   */

  @GET("random/data/{type}/1")
  fun getRandom(@Path("type") type:String): Observable<JsonResult<List<FuckGoods>>>
}