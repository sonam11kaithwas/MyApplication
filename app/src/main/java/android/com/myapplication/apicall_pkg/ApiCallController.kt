package android.com.myapplication.apicall_pkg

import com.google.gson.JsonObject
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Sona-11 on 30/12/21.
 */
class ApiCallController {
    var apiCallingcntrl: ResponseListener
    var req_res_code: Int

    constructor(apiCallingcntrl: ResponseListener, req_res_code: Int) {
        this.apiCallingcntrl = apiCallingcntrl
        this.req_res_code = req_res_code
    }

    fun getDataFromServer() {
        Apicalling.getServiceInstace()?.getUserList()?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : Observer<JsonObject> {
                override fun onNext(countriesStats: JsonObject) {
                    println("system " + countriesStats)
                    apiCallingcntrl.onSuccess(countriesStats, req_res_code)
                }


                override fun onError(e: Throwable) {
                    apiCallingcntrl.onError(e, req_res_code)
                }

                override fun onComplete() {
                    println("")

                }

                override fun onSubscribe(d: Disposable) {
                    println("")

                }

            })

    }

}