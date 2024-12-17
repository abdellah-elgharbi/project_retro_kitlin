package abdellah.project.retrofite_rest.retroClinet

import abdellah.project.retrofite_rest.api.Api
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitClient {

    private const val BASE_URL = "http://192.168.1.8:8085/api/"

    private val client: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Méthode pour obtenir l'instance de Retrofit
    val retrofitInstance: Retrofit
        get() = retrofit


    val api: Api
        get() = retrofit.create(Api::class.java)
}
