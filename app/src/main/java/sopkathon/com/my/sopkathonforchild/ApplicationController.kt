package sopkathon.com.my.sopkathonforchild

import android.app.Application
import android.content.Context
import android.widget.Toast
import okhttp3.JavaNetCookieJar
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sopkathon.com.my.sopkathonforchild.Network.NetworkService
import java.net.CookieManager
import java.net.CookiePolicy.ACCEPT_ALL
import java.util.concurrent.TimeUnit



class ApplicationController : Application() {

    var networkService: NetworkService? = null
        private set
    val baseUrl = "http://52.79.132.56:3000/"
    var appContext: Context? = null
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext

        instance = this

        buildNetwork()
    }


    fun buildNetwork() {
        val cookieStore = PersistentCookieStore(instance)
        val cookieManager = CookieManager(cookieStore, ACCEPT_ALL)

        val builder = Retrofit.Builder()
        val retrofit = builder
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient().newBuilder() .connectTimeout(10, TimeUnit.SECONDS) .writeTimeout(10, TimeUnit.SECONDS) .readTimeout(10, TimeUnit.SECONDS) .cookieJar(JavaNetCookieJar(cookieManager)) .build())
                .build()

        networkService = retrofit.create(NetworkService::class.java)
    }

    fun makeToast(message: String) {
        Toast.makeText(appContext, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        var instance: ApplicationController? = null
    }
}
