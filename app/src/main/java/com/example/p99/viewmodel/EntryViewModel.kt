package com.example.p99.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.p99.repositori.RepositoriSiswa
import com.example.p99.room.Siswa

class EntryViewModel(private val repositoriSiswa: RepositoriSiswa): ViewModel(){
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set
