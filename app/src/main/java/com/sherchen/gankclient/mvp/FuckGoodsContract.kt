package com.sherchen.gankclient.mvp

import com.hannesdorfmann.mosby3.mvp.MvpView
import com.sherchen.gankclient.api.GankApi
import com.sherchen.gankclient.bean.FuckGoods
import com.sherchen.gankclient.bean.JsonResult
import com.sherchen.gankclient.features.MainActivity
import com.sherchen.gankclient.features.android.AndroidFragment
import com.sherchen.gankclient.features.girl.GirlFragment
import com.sherchen.gankclient.features.ios.IOSFragment
import io.reactivex.Observable

/**
 * Created by sherchen on 2017/6/23
 */
interface FuckGoodsView : MvpView {
    fun  setData(results: List<FuckGoods>)

}

class FuckGoodsModel
@javax.inject.Inject constructor(private val api: GankApi) {

    fun getData(page: Int, type: String): Observable<JsonResult<List<FuckGoods>>> {
        when (type) {
            AndroidFragment.Companion.ANDROID -> return api.getAndroidData(page)
            IOSFragment.Companion.IOS -> return api.getiOSData(page)
            GirlFragment.Companion.GIRL -> return api.getGirlData(page)
            else -> return api.getAndroidData(page)
        }
    }
}

class FuckGoodsPresenter
@javax.inject.Inject constructor(private val mModel: FuckGoodsModel,
                                 private val mActivity: MainActivity)
    : RxBasePresenter<FuckGoodsView>(mActivity) {

    fun getData(page: Int, type: String) {
        submit(mModel.getData(page, type)){
            t -> view.setData(t)
        }
    }
}