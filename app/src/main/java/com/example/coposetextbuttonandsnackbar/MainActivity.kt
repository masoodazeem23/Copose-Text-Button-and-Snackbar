package com.example.coposetextbuttonandsnackbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coposetextbuttonandsnackbar.ui.theme.CoposeTextButtonAndSnackbarTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            CoposeTextButtonAndSnackbarTheme {
                val scafoldState = rememberScaffoldState()
                var textFieldState by remember {
                    mutableStateOf("")
                }
                val scope = rememberCoroutineScope()
                // A surface container using the 'background' cxolor from the theme
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scafoldState
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(30.dp)

                    ) {
                        TextField(
                            value = textFieldState,
                            label = {
                                    Text("Enter your name")
                            },
                            onValueChange = {
                                textFieldState = it
                            },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        Button(onClick = {
                            scope.launch{
                                scafoldState.snackbarHostState.showSnackbar("Hello $textFieldState")
                            }
                        }) {
                            Text(text = "Submit")
                        }
                    }
                }
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
    CoposeTextButtonAndSnackbarTheme {
        Greeting("Android")
    }
}