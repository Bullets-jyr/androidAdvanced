package kr.co.bullets.retrofitdemoreview

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInstance {


    companion object {
        val BASE_URL = "https://jsonplaceholder.typicode.com/"

        val interceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
                // 이 속성은 클라이언트가 서버와 연결을 시도하는 시간을 정의합니다.
                // 클라이언트가 서버에 연결하려면 일정 시간이 필요하므로, 이 시간을 초과하면 SocketTimeoutException 예외가 발생합니다.
                // 이 속성은 클라이언트가 서버와 빠르게 연결되어야 하는 경우, 예를 들어 모바일 네트워크에서 사용할 때 유용합니다. 기본값은 10초입니다.
                .connectTimeout(30, TimeUnit.SECONDS)
                // 이 속성은 서버가 클라이언트의 요청에 대한 응답을 보내는 데 필요한 시간을 정의합니다.
                // 서버가 응답을 보내지 않으면 SocketTimeoutException 예외가 발생합니다.
                // 이 속성은 서버가 처리하는 데 시간이 오래 걸리는 작업이 있거나 서버의 응답이 큰 경우 유용합니다. 기본값은 10초입니다.
                .readTimeout(20, TimeUnit.SECONDS)
                // 이 속성은 클라이언트가 서버에 데이터를 보내는 데 필요한 시간을 정의합니다.
                // 데이터를 전송하지 못하면 SocketTimeoutException 예외가 발생합니다.
                // 이 속성은 서버에 데이터를 빠르게 보내야 하는 경우, 예를 들어 파일 업로드 또는 데이터베이스 쿼리 실행과 같은 경우 유용합니다. 기본값은 10초입니다.
                .writeTimeout(25, TimeUnit.SECONDS)
        }.build()

        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }
    }
}