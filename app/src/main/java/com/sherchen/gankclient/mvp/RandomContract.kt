package com.sherchen.gankclient.mvp

import com.sherchen.gankclient.api.GankApi
import com.sherchen.gankclient.bean.FuckGoods
import com.sherchen.gankclient.bean.JsonResult
import com.sherchen.gankclient.features.MainActivity
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by sherchen on 2017/6/23
 */
interface RandomView : com.hannesdorfmann.mosby3.mvp.MvpView {
    fun showRandomLuck(goods: com.sherchen.gankclient.bean.FuckGoods)

}
class RandomModel
@Inject constructor(private val api: GankApi){

    fun getRandom(type:String): Observable<JsonResult<List<FuckGoods>>> {
        return api.getRandom(type)
    }
}

class RandomPresenter
@Inject constructor(private val mModel: RandomModel,
                    private val mActivity : MainActivity
) : RxBasePresenter<RandomView>(mActivity) {
    fun getRandom(type: String) {
        submit(mModel.getRandom(type)){
            t ->
                if(t.size != 0) {
                    view.showRandomLuck(t[0])
                }
        }
    }
}
