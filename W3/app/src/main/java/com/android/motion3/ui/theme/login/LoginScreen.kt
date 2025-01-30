package com.android.motion3.ui.theme.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Columnimport
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.motion3.ui.theme.components.HeaderText
import com.android.motion3.ui.theme.components.LoginTextField

androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

val defaultPadding = 16.dp
val itemSpacing = 8.dp

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(defaultPadding),
    ){
        HeaderText(
            text = "Login",
            modifier = Modifier.padding(vertical = defaultPadding)
        )
        LoginTextField(
            value = "",
            onValueChange = {},
            labelText = "Username",
            leadingIcon = Icons.Default.Person,
            modifier = Modifier
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    MaterialTheme{
        LoginScreen()
    }
}