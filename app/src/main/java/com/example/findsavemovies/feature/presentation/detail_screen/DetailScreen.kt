package com.example.findsavemovies.feature.presentation.detail_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.findsavemovies.feature.navigation.BottomBarScreen

@Composable
fun DetailScreen(
    viewModel: DetailScreenViewModel = hiltViewModel(),
    navController: NavController,
    arg: String?
) {
    val cacheMovie = viewModel.detailState.value.movie
    viewModel.handleEvent(DetailScreenEvent.LoadData(arg))

    if (cacheMovie != null) {

        Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    viewModel.handleEvent(DetailScreenEvent.SaveMovie(cacheMovie))
                    navController.navigate(BottomBarScreen.HomeScreen.route)

                }) {
                    Icon(Icons.Filled.Add, "")
                }
            }

        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .background(Color.LightGray)
            ) {
                Image(
                    painter = rememberImagePainter(cacheMovie.poster),
                    contentDescription = "Image",
                    modifier = Modifier
                        .size(240.dp)
                        .padding(top = 10.dp, bottom = 10.dp, start = 10.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Text(
                    text = cacheMovie.title ?: "N/A",
                    fontSize = 24.sp,
                    color = Color.Red,
                    modifier = Modifier.padding(top = 15.dp, start = 10.dp)

                )
                Text(
                    text = "Genre: ${cacheMovie.genre ?: "N/A"}",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 15.dp, start = 10.dp)
                )
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp, start = 10.dp)
                ) {
                    Text(
                        text = "Plot: ",
                        fontSize = 18.sp
                    )
                    Text(
                        text = cacheMovie.plot ?: "N/A",
                        fontSize = 18.sp
                    )
                }
                Text(
                    text = "IMDB: ${cacheMovie.imdbRating ?: "N/A"}",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 15.dp, start = 10.dp)
                )
                Text(
                    text = "Year: ${cacheMovie.year ?: "N/A"}",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 15.dp, start = 10.dp)
                )
                Text(
                    text = "Actors: ${cacheMovie.actors ?: "N/A"}",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 15.dp, start = 10.dp)
                )
                Text(
                    text = "Runtime: ${cacheMovie.runtime ?: "N/A"}",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 15.dp, start = 10.dp)
                )
                Text(
                    text = "Director: ${cacheMovie.director ?: "N/A"}",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 15.dp, start = 10.dp)
                )
                Text(
                    text = "Language: ${cacheMovie.language ?: "N/A"}",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 15.dp, start = 10.dp)
                )
                Text(
                    text = "Country: ${cacheMovie.country ?: "N/A"}",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 15.dp, start = 10.dp)
                )
                Text(
                    text = "BoxOffice: ${cacheMovie.boxOffice ?: "N/A"}",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 15.dp, start = 10.dp)
                )
                Text(
                    text = "Writer: ${cacheMovie.writer ?: "N/A"}",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 15.dp, start = 10.dp, bottom = 15.dp)
                )


            }
        }
    }

}
