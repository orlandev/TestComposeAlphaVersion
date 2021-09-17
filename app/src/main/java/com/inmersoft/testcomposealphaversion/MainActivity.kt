package com.inmersoft.testcomposealphaversion

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.OffsetEffect
import androidx.compose.ui.graphics.RenderEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.inmersoft.testcomposealphaversion.ui.theme.TestComposeAlphaVersionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            TestComposeAlphaVersionTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Home()
                }
            }
        }
    }
}

@Composable
fun Home() {

    val context = LocalContext.current

    val radiusValue = remember { mutableStateOf(0.dp) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 57.dp)

    ) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .blur(radiusValue.value)) {
            items(1000) {
                Text(text = "Testing Blur")
            }
        }
        Box(
            modifier = Modifier
                .width(300.dp)
                .height(60.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(color = Color.Gray)
                .align(Alignment.BottomCenter)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                Button(onClick = {
                    radiusValue.value = 4.dp
                }, modifier = Modifier.clip(shape = CircleShape)) {
                    Text(text = "A")
                }
                Button(onClick = {
                    radiusValue.value = 0.dp
                }, modifier = Modifier.clip(shape = CircleShape)) {
                    Text(text = "B")
                }
                Button(onClick = {

                    Toast.makeText(context, "C", Toast.LENGTH_LONG).show()

                }, modifier = Modifier.clip(shape = CircleShape)) {
                    Text(text = "C")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestComposeAlphaVersionTheme {
        Home()
    }
}