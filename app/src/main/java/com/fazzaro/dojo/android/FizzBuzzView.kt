package com.fazzaro.dojo.android

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import com.fazzaro.dojo.android.ui.models.FizzBuzzViewModel
import com.fazzaro.dojo.android.ui.theme.DojoTheme

class FizzBuzzView() {

    @Composable
    fun Render() {
        var input by remember { mutableStateOf("") }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("Let's play Fizz Buzz!")
            Spacer(modifier = Modifier.size(20.dp))
            OutlinedTextField(
                value = input,
                label = { Text("Enter a number") },
                onValueChange = { input = it },
                modifier = Modifier.fillMaxWidth()
            )
            Text( "(No result)" )
            Spacer(modifier = Modifier.size(20.dp))
            Button(enabled = false, onClick = {}) {
                Text(text = "Play")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FizzBuzzPreview() {
    DojoTheme {
        FizzBuzzView().Render()
    }
}