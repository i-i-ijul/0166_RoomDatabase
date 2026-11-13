package com.example.p99

import android.app.Application
import com.example.p99.repositori.ContainerApp
import com.example.p99.repositori.ContainerDataApp

class AplikasiSiswa : Application() {
    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}