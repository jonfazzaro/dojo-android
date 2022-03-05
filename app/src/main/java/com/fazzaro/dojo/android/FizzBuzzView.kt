package com.fazzaro.dojo.android

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fazzaro.dojo.android.ui.theme.DojoTheme

class FizzBuzzView {

    @Composable
    fun Render() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("Let's play Fizz Buzz!")
            Spacer(modifier = Modifier.size(20.dp))
            OutlinedTextField(
                value = "",
                label = { Text("Enter a number") },
                onValueChange = {},
                modifier = Modifier.fillMaxWidth()
            )
            Text("(The result)" )
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