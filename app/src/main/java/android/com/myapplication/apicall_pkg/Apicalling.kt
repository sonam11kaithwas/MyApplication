package android.com.myapplication.apicall_pkg

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Sona-11 on 29/12/21.
 */
class Apicalling {
    companion object {

        private val client = OkHttpClient.Builder().build()
        var retrofit: Retrofit? = null
        fun getApiiInstace(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .baseUrl("https://reqres.in/")

                    .build()
            }

            return retrofit
        }

        fun getServiceInstace(): MyApiEndUrl? {
            return getApiiInstace()?.create(MyApiEndUrl::class.java)
        }
    }

}