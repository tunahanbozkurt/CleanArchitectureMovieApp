package com.example.findsavemovies.feature.presentation.find_screen.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.findsavemovies.feature.domain.model.Movie

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieItem(
    item: Movie? = null,
    isLoading: Boolean = false,
    onClick: (String) -> Unit,
    onLongClick: (String) -> Unit

) {
    if (item != null){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.combinedClickable(
                onLongClick = {
                    item.title?.let { onLongClick(it) }
                },
                onClick = {
                    item.title?.let { onClick(it) }
                }
            )
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize()
                    .padding(top = 24.dp),
                backgroundColor = Color.LightGray

            ) {
                Row{

                    Image(
                        painter = rememberImagePainter(item.poster),
                        contentDescription = "Image",
                        modifier = Modifier
                            .size(180.dp)
                            .padding(top = 10.dp, bottom = 10.dp)
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = item.title?: "N/A",
                            modifier = Modifier
                                .padding()
                                .fillMaxWidth(),
                            maxLines = 1
                        )
                        Text(
                            text = "Genre: ${item.genre?: "N/A"}",
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .fillMaxWidth(),
                            maxLines = 1
                        )
                        Text(
                            text = "Year: ${item.year?: "N/A"}",
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .fillMaxWidth(),
                            maxLines = 1
                        )
                        Text(
                            text = "IMDB: ${item.imdbRating?: "N/A"}",
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .fillMaxWidth(),
                            maxLines = 1
                        )
                        Text(
                            text = "Languages: ${item.language?: "N/A"}",
                            modifier = Modifier
                                .padding(top = 10.dp, bottom = 10.dp)
                                .fillMaxWidth(),
                            maxLines = 1
                        )

                    }
                }
            }
            if(isLoading){
                CircularProgressIndicator()
            }

        }
    }



}




