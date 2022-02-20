package com.example.findsavemovies

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.getSystemService
import com.example.findsavemovies.feature.data.local.AppDatabase
import com.example.findsavemovies.feature.navigation.NavigationProvider
import com.example.findsavemovies.feature.presentation.find_screen.FindScreen
import com.example.findsavemovies.ui.theme.FindSaveMoviesTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            FindSaveMoviesTheme {

                NavigationProvider()


            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FindSaveMoviesTheme {
        Greeting("Android")
    }
}



