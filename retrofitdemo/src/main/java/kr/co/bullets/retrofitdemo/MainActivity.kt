package kr.co.bullets.retrofitdemo

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var retService: AlbumService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text_view = findViewById<TextView>(R.id.text_view)
        retService = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)
        getRequestWithQueryParameters(text_view)
//        getRequestWithPathParameters()
    }

    private fun getRequestWithQueryParameters(text_view: TextView) {
        val responseLiveData: LiveData<Response<Albums>> = liveData {
//            val response = retService.getAlbums()
            val response = retService.getSortedAlbums(3)
            emit(response)
        }
        responseLiveData.observe(this, Observer {
            val albumsList = it.body()?.listIterator()
            if (albumsList != null) {
                while (albumsList.hasNext()) {
                    val albumsItem = albumsList.next()
                    Log.i("MYTAG", albumsItem.title)
                    val result = " Album Title : ${albumsItem.title}\n" +
                            " Album Id : ${albumsItem.id}\n" +
                            " User Id : ${albumsItem.userId}\n\n\n"
                    text_view.append(result)
                }
            }
        })
    }

    private fun getRequestWithPathParameters() {
        // path parameter example
        val pathResponse: LiveData<Response<AlbumsItem>> = liveData {
            val response = retService.getAlbum(3)
            emit(response)
        }

        pathResponse.observe(this, Observer {
            val title = it.body()?.title
            Toast.makeText(applicationContext, title, Toast.LENGTH_LONG).show()
        })
    }
}