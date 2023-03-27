package kr.co.bullets.retrofitdemoreview

import retrofit2.Response
import retrofit2.http.GET

interface AlbumService {

    @GET("/albums")
    suspend fun getAlbums(): Response<Albums>
}