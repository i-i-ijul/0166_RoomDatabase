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

    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa ): Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank()
        }
    }
    fun updateUiState(detailSiswa: DetailSiswa){
        uiStateSiswa =
            UIStateSiswa(detailSiswa, isEntryValid = validasiInput(detailSiswa))
    }
    suspend fun saveSiswa(){
        if (validasiInput()) {
            repositoriSiswa.insertSiswa((uiStateSiswa.detailSiswa.toSiswa()))
        }
    }
}
