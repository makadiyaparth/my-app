package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PriceComparisonApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PriceComparisonApp() {
    var price1 by remember { mutableStateOf(0f) }
    var measurement1 by remember { mutableStateOf(0f) }
    var price2 by remember { mutableStateOf(0f) }
    var measurement2 by remember { mutableStateOf(0f) }
    var result by remember { mutableStateOf("") }

    Column(
            modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
    ) {
        Text(
                text = "Price Comparator",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(32.dp))
        TextField(
                value = price1.toString(),
                onValueChange = { price1 = it.toFloatOrNull() ?: 0f },
                label = { Text("Price 1") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
                value = measurement1.toString(),
                onValueChange = { measurement1 = it.toFloatOrNull() ?: 0f },
                label = { Text("Measurement 1") }
        )
        Spacer(modifier = Modifier.height(32.dp))
        TextField(
                value = price2.toString(),
                onValueChange = { price2 = it.toFloatOrNull() ?: 0f },
                label = { Text("Price 2") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
                value = measurement2.toString(),
                onValueChange = { measurement2 = it.toFloatOrNull() ?: 0f },
                label = { Text("Measurement 2") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
                onClick = {
                    result = if (price1 / measurement1 < price2 / measurement2) {
                        "The 1st measurement is cheaper."
                    } else {
                        "The 2nd measurement is cheaper."
                    }
                },
                modifier = Modifier.widthIn(min = 200.dp)
        ) {
            Text("Compare")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(result, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}
