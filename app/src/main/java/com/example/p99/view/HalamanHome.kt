package com.example.p99.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p99.R
import com.example.p99.room.Siswa
import com.example.p99.uicontroller.DestinasiEntry
import com.example.p99.uicontroller.DestinasiHome
import com.example.p99.uicontroller.SiswaTopAppBar
import com.example.p99.viewmodel.HomeViewModel
import com.example.p99.viewmodel.PenyediaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToItemEntry: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            SiswaTopAppBar(
                title = stringResource(DestinasiHome.titleRes),
                canNavigateBack = false,
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToItemEntry,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.entry_siswa)
                )
            }
        },
    ) { innerPadding ->
        val homeUiState by viewModel.homeUiState.collectAsState()
        HomeBody(
            listSiswa = homeUiState.listSiswa,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
        )
    }
}

@Composable
fun HomeBody(
    listSiswa: List<Siswa>,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        if (listSiswa.isEmpty()) {
            Text(
                text = stringResource(R.string.deskripsi_no_item),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))
            )
        } else {
            ListSiswa(
                listSiswa = listSiswa,
                modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
            )
        }
    }
}

@Composable
fun ListSiswa(
    listSiswa: List<Siswa>,
    modifier: Modifier = Modifier
)