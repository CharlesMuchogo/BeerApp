package com.example.beerapp

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import coil.compose.AsyncImage
import com.example.beerapp.model.Beer
import com.example.beerapp.network.Status
import com.example.beerapp.ui.theme.BeerAppTheme
import com.example.beerapp.viewModel.BeerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            val viewModel =  hiltViewModel<BeerViewModel>()
            val context = LocalContext.current
            BeerListScreen(viewModel = viewModel, context)
        }
    }
}

@Composable
fun BeerListScreen(viewModel: BeerViewModel, context: Context) {
    val beerState by viewModel.beerState.collectAsState()

    when (beerState.status) {
        Status.LOADING -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator()
            }
        }

        Status.SUCCESS -> {
            beerState.data?.let { beers ->
                LazyColumn {
                    items(beers) { beer ->
                        BeerCard(beer = beer)
                    }
                }

            }
        }

        Status.ERROR -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "Failed to load Beers \uD83D\uDE14")
            }        }
    }
}

@Composable
fun BeerCard(beer: Beer) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp),

        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)

    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model =  beer.image_url,
                    contentDescription = "Beer Image",
                    modifier = Modifier
                        .height(150.dp)
                        .width(50.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(20.dp))

                Column() {
                    Text(
                        text = beer.name,
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = beer.tagline,
                        style = MaterialTheme.typography.subtitle1,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = beer.description,
                        style = MaterialTheme.typography.body1
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "First Brewed: ${beer.first_brewed}",
                        style = MaterialTheme.typography.caption,
                        color = Color.Gray
                    )
                }
            }

        }
    }
}


@Composable
fun BeerList(beers: List<Beer>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(beers) { beer ->
            BeerCard(beer = beer)
        }
    }
}