package com.studying.bettamovies.network

import com.studying.bettamovies.network.models.FilmDetails
import com.studying.bettamovies.network.models.RequestModel
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


object ApiService {
    private const val END_POINT = "https://api.themoviedb.org/3/movie/"
    private const val API_KAY = "f4667f3a076d211f6606630182df9053"



    private val movieApi: MovieApi

    fun getPopularMovies(page: Int) = movieApi.popularMovies(API_KAY, "en-US", page)
    fun getDetailsById(id: Int) = movieApi.findById(id, API_KAY)

    fun getImageUrl(shortUrl: String) =
        "https://image.tmdb.org/t/p/w500/$shortUrl"

    interface MovieApi {
        @GET("popular")
        fun popularMovies(
            @Query("api_key") key: String,
            @Query("language") language: String,
            @Query("page") page: Int
        ): Single<RequestModel>

        @GET("{external_id}")
        fun findById(
            @Path("external_id")id: Int,
            @Query("api_key") key: String): Single<FilmDetails>
    }


    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client =
            OkHttpClient.Builder().addInterceptor(interceptor).build()
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(END_POINT)
            .client(client)
            .build()
        movieApi = retrofit.create(MovieApi::class.java)
    }
}