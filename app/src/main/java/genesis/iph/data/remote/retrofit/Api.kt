package genesis.iph.data.remote.retrofit

import genesis.iph.data.remote.retrofit.response.MovieResponse
import genesis.iph.data.remote.retrofit.response.MoviesResponse
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Created by ivanphytsyk on 3/25/18.
 */
interface Api {
    @GET()
    fun getMovies(@Url url: String) : Single<MoviesResponse>

    companion object Factory {
        fun create(): Api {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            val retrofit = Retrofit.Builder()
                    .client(client)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.themoviedb.org/3/")
                    .build()

            return retrofit.create(Api::class.java);
        }
    }
}