package com.example.bustime

import android.app.Application
import com.baidu.mapapi.CoordType
import com.baidu.mapapi.SDKInitializer


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        SDKInitializer.initialize(this)

        //also can gcj
        SDKInitializer.setCoordType(CoordType.BD09LL)
    }


}
