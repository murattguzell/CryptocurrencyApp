package com.muratguzel.kriptopara.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muratguzel.kriptopara.model.CyriptoModel
import com.muratguzel.kriptopara.R
import com.muratguzel.kriptopara.adapter.CyriptoAdapter
import com.muratguzel.kriptopara.service.CyriptoAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity(), CyriptoAdapter.Listener {

    val Base_URL = "https://raw.githubusercontent.com/"
    private var cyriptoModels: ArrayList<CyriptoModel>? = null
    private var cyriptoAdapter: CyriptoAdapter? = null
    private lateinit var recyclerView: RecyclerView

    //Disposable
    private var compositeDisposable: CompositeDisposable? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        compositeDisposable = CompositeDisposable()
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager

        loadData()

    }


    private fun loadData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(CyriptoAPI::class.java)
        compositeDisposable?.add(
            retrofit.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse)
        )


        /*
              val service = retrofit.create(CyriptoAPI::class.java)
          val call = service.getData()
          call.enqueue(object : Callback<List<CyriptoModel>> {

              override fun onResponse(
                  call: Call<List<CyriptoModel>>,
                  response: Response<List<CyriptoModel>>
              ) {
                  if (response.isSuccessful) {
                      response.body()?.let {
                          cyriptoModels = ArrayList(it)
                          cyriptoModels?.let {
                              cyriptoAdapter = CyriptoAdapter(it, this@MainActivity)
                              recyclerView.adapter = cyriptoAdapter

                          }


                                            for (cyriptoModel: CyriptoModel in cyriptoModels!!){
                                                  println(cyriptoModel.currency)
                                                  println(cyriptoModel.price)
                                              }


                      }
                  }
              }

              override fun onFailure(call: Call<List<CyriptoModel>>, t: Throwable) {
                  t.printStackTrace()
              }

          })
  */
    }

    private fun handleResponse(cyriptoList: List<CyriptoModel>) {
        cyriptoModels = ArrayList(cyriptoList)
        cyriptoModels?.let {
            cyriptoAdapter = CyriptoAdapter(it, this@MainActivity)
            recyclerView.adapter = cyriptoAdapter
        }
    }

    override fun onItemClick(cyriptoModel: CyriptoModel) {
        Toast.makeText(this, "Clicked: ${cyriptoModel.currency}", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable?.clear()
    }
}