package com.example.bustime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.baidu.location.d.j.s
import com.baidu.mapapi.search.busline.BusLineResult
import com.baidu.mapapi.search.busline.BusLineSearch
import com.baidu.mapapi.search.busline.BusLineSearchOption
import com.baidu.mapapi.search.poi.*
import com.example.bustime.R.id.mapView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    private lateinit var mMap: GoogleMap



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val mapView : MapView = (MapView) findViewById(R.id.bmapView);





        val busLineSearch : BusLineSearch = BusLineSearch.newInstance()

        busLineSearch.setOnGetBusLineSearchResultListener { busLineResult ->

//            Gson().fromJson("a", BusLineResult::class.java)

            Log.d("aaa", Gson().toJson(busLineResult))
        }

        busLineSearch.searchBusLine(BusLineSearchOption().city("上海").uid("公交车"))



        val poiSearch : PoiSearch = PoiSearch.newInstance()
        poiSearch.setOnGetPoiSearchResultListener(object : OnGetPoiSearchResultListener {
            override fun onGetPoiIndoorResult(p0: PoiIndoorResult?) {

            }

            override fun onGetPoiResult(p0: PoiResult?) {
                Log.d("aaa", Gson().toJson(p0))

            }

            override fun onGetPoiDetailResult(p0: PoiDetailResult?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onGetPoiDetailResult(p0: PoiDetailSearchResult?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
        poiSearch.searchInCity(PoiCitySearchOption().city("上海").keyword("公交车"))




    }


    override fun onDestroy() {
        super.onDestroy()

        mapView.onDestroy()
    }

    override fun onResume() {
        super.onResume()

        mapView.onResume()

    }

    override fun onPause() {
        super.onPause()

        mapView.onPause()
    }




}




