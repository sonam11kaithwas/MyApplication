package android.com.myapplication.apicall_pkg

import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.http.GET


/**
 * Created by Sona-11 on 29/12/21.
 */
interface MyApiEndUrl {
    @GET("api/users?page=2")
    fun getUserList(): Observable<JsonObject>

}