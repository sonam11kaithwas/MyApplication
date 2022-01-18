package android.com.myapplication.apicall_pkg

import com.google.gson.JsonObject

/**
 * Created by Sona-11 on 30/12/21.
 */
interface ResponseListener {
    val USER_LIST_RES_CODE: Int
        public get() = 1
    val user_test: Int
        get() = 5


    fun onSuccess(jsonObject: JsonObject, requestCode: Int)
    fun onError(error: Throwable, requestCode: Int)

}