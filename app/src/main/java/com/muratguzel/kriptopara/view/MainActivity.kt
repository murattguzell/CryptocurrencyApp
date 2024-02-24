package com.muratguzel.kriptopara.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.muratguzel.kriptopara.model.CyriptoModel
import com.muratguzel.kriptopara.R
import com.muratguzel.kriptopara.adapter.CyriptoAdapter
import com.muratguzel.kriptopara.service.CyriptoAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity(), CyriptoAdapter.Listener {

    private val Base_URL = "https://raw.githubusercontent.com/"
    private var cyriptoModels: ArrayList<CyriptoModel>? = null
    private var cyriptoAdapter: CyriptoAdapter? = null
    private lateinit var recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager

        loadData()

    }


    private fun loadData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

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


                        /*                    for (cyriptoModel: CyriptoModel in cyriptoModels!!){
                                                println(cyriptoModel.currency)
                                                println(cyriptoModel.price)
                                            }
                                            */

                    }
                }
            }

            override fun onFailure(call: Call<List<CyriptoModel>>, t: Throwable) {
                t.printStackTrace()
            }

        })

    }

    override fun onItemClick(cyriptoModel: CyriptoModel) {
        Toast.makeText(this,"Clicked: ${cyriptoModel.currency}",Toast.LENGTH_LONG ).show()
    }
}