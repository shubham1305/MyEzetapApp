package com.example.myezetapapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myezetapapp.navigation.Screens
import com.example.myezetapapp.ui.CustomUIViewModel
import com.example.myezetapapp.ui.theme.MyEzetapAppTheme
import com.example.myezetapapp.ui.views.CustomUIDetailPage
import com.example.myezetapapp.ui.views.CustomUIHome
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyEzetapAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val viewModel = viewModel<CustomUIViewModel>()
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screens.CUSTOM_UI_HOME.route
                    ) {
                        composable(Screens.CUSTOM_UI_HOME.route) {
                            CustomUIHome(
                                modifier = Modifier.fillMaxSize(),
                                responseData = viewModel.response,
                                onDataEntered = { key, value ->
                                    viewModel.response[key] = value
                                },
                                uiState = viewModel.uiState
                            ) {
                                if (viewModel.response.values.isNotEmpty() && viewModel.response.values.all { it.isNotEmpty() }) {
                                    navController.navigate(Screens.CUSTOM_UI_DETAIL.route)
                                } else {
                                    Toast.makeText(this@MainActivity, getString(R.string.error_empty_fields), Toast.LENGTH_LONG).show()
                                }
                            }
                        }

                        composable(Screens.CUSTOM_UI_DETAIL.route) {
                            CustomUIDetailPage(modifier = Modifier.fillMaxSize(), data = viewModel.response.values.toList())
                        }
                    }
                }
            }
        }
    }
}