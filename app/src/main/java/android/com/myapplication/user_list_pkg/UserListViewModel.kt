package android.com.myapplication.user_list_pkg

import android.app.Application
import android.com.myapplication.apicall_pkg.ApiCallController
import android.com.myapplication.apicall_pkg.ResponseListener
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken

/**
 * Created by Sona-11 on 30/12/21.
 */
class UserListViewModel(application: Application) : AndroidViewModel(application),

    ResponseListener {
    var usreMutableList: MutableLiveData<List<UserListRes>> = MutableLiveData()

    fun getUserListFromSrvr() {
        var apicall = ApiCallController(this, USER_LIST_RES_CODE)
        apicall.getDataFromServer()
    }

    override val USER_LIST_RES_CODE: Int
        get() = super.USER_LIST_RES_CODE

    override fun onSuccess(jsonObject: JsonObject, requestCode: Int) {
        var type = object : TypeToken<List<UserListRes>>() {}.type
        usreMutableList.postValue(
            Gson().fromJson(
                (jsonObject.get("data").asJsonArray).asJsonArray, type
            )
        )
    }

    override fun onError(jsonObject: Throwable, requestCode: Int) {
        println()

    }


}