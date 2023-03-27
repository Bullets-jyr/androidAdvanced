package kr.co.bullets.retrofitdemoreview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var retService: AlbumService
    private lateinit var text_view: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text_view = findViewById<TextView>(R.id.text_view)
        retService = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)

        getRequestWithQueryParameters()
//        getRequestWithPathParameters()
    }

    private fun getRequestWithQueryParameters() {
        val responseLiveData: LiveData<Response<Albums>> = liveData {
//            val response = retService.getAlbums()
            val response = retService.getSortedAlbums(3)
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            // 이 메서드는 ListIterator 인터페이스를 반환하는데, 이 인터페이스는 List를 양방향으로 순회하며 수정할 수 있는 기능을 제공합니다.
            val albumsList = it.body()?.listIterator()
            Log.e("MYTAG", "$albumsList")
            if (albumsList != null) {
                while (albumsList.hasNext()) {
                    val albumsItem = albumsList.next()
                    Log.i("MYTAG", albumsItem.title)
                    val result = " " + "Album title : ${albumsItem.title}" + "\n" +
                            " " + "Album id : ${albumsItem.id}" + "\n" +
                            " " + "Album userId : ${albumsItem.userId}" + "\n\n\n"
                    text_view.append(result)
                }
            }
        })
    }

    private fun getRequestWithPathParameters() {
        // path parameter example
        val pathResponse: LiveData<Response<AlbumsItem>> = liveData {
            val response = retService.getAlbum(3)
            Log.e("MYTAG", "$response")
            emit(response)
        }

        pathResponse.observe(this, Observer {
            val title = it.body()?.title
            Toast.makeText(applicationContext, title, Toast.LENGTH_LONG).show()
        })
    }
}