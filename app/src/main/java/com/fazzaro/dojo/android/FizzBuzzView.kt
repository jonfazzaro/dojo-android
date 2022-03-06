package com.fazzaro.dojo.android

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fazzaro.dojo.android.ui.models.FizzBuzzViewModel
import com.fazzaro.dojo.android.ui.theme.DojoTheme


class FizzBuzzView {

    @Composable
    fun Render(model: FizzBuzzViewModel = viewModel()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("Let's play Fizz Buzz!")
            Spacer(modifier = Modifier.size(20.dp))
            OutlinedTextField(
                value = model.input?.toString() ?: "",
                label = { Text("Enter a number") },
                onValueChange = { model.setInput(it) },
                modifier = Modifier.fillMaxWidth()
            )
            Text(model.result ?: "(no result)")
            Spacer(modifier = Modifier.size(20.dp))
            Button(enabled = model.buttonIsEnabled, onClick = { model.play() }) {
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