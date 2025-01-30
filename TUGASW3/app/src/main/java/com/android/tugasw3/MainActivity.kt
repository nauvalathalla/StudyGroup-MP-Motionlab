package com.android.tugasw3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.tugasw3.ui.theme.TUGASW3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column (
                modifier = Modifier
                    .background(Color.Green)
                    .padding(top = 80.dp)
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth()
                    .border(10.dp, Color.Blue)
                    .padding(5.dp)
                    .border(20.dp, Color.Cyan )
                    .padding(5.dp)
                    .border(20.dp, Color.Magenta)
                    .padding(10.dp),



                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top

            ) {
                Spacer(modifier = Modifier.height(50.dp))
                Text("hello", modifier = Modifier.clickable{

                })
                Spacer(modifier = Modifier.height(50.dp))
                Text("world")
            }

        }
    }
}

