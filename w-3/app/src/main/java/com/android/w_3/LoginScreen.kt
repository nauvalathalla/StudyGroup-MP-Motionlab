package com.android.w_3

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.ag_apps.w_3.desing_system.AuthOption
import com.ag_apps.w_3.desing_system.MyTextField




@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LoginScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Column {
            Image(
                painter = painterResource(R.drawable.telkom),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .size(width = 140.dp, height = 120.dp)
            )

            Spacer(modifier = Modifier.height(100.dp))

            Text(
                text = "Halo,Telkomers",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Silahkan Masuk akun anda",
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )
        }

        MyTextField(
            textFieldState = TextFieldState(),
            hint = "Email",
            leadingIcon = Icons.Outlined.Face,
            trailingIcon = Icons.Outlined.Check,
            keyboardType = KeyboardType.Email,
            modifier = Modifier.fillMaxWidth()
        )

        MyTextField(
            textFieldState = TextFieldState(),
            hint = "Password",
            leadingIcon = Icons.Outlined.Lock,
            trailingText = "Forgot?",
            isPassword = true,
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Login",
                fontSize = 17.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        Text(
            text = "Atau, Login dengan...",
            fontSize = 15.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .alpha(0.5f)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            AuthOption(image = R.drawable.google)
            AuthOption(image = R.drawable.facebook)
            AuthOption(
                image = R.drawable.apple,
                tint = MaterialTheme.colorScheme.onBackground
            )
        }

        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Belum Punya Akun? ",
                fontSize = 16.sp,
            )
            Text(
                text = "Register",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable {
                    navController.navigate("register")
                }
            )
        }

        Spacer(modifier = Modifier.height(1.dp))
    }
}