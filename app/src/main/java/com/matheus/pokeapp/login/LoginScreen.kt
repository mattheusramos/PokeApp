package com.matheus.pokeapp.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.matheus.pokeapp.R
import com.matheus.pokeapp.utils.*

@Composable
fun LoginScreen(
    onLoginClick: (String, String) -> Unit,
    onVisitClick: () -> Unit,
){
    var usuario by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.pokedex_logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(240.dp)
                .padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = usuario,
            onValueChange = { usuario = it },
            label = { Text("Usuário") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(16.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            shape = RoundedCornerShape(16.dp),
            visualTransformation = PasswordVisualTransformation()
        )

        Button(
            onClick = {
                if (usuario == "teste" && password == "123456") {
                    onLoginClick(usuario, password)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 36.dp)
                .height(50.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = VermelhoPrincipal)
        ) {
            Text(
                text = "Login",
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
            )
        }

        Text(
            text = "Continuar como visitante",
            fontSize = 16.sp,
            color = VermelhoPrincipal,
            modifier = Modifier.clickable { onVisitClick() }
        )
    }
}

@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreen(
        onLoginClick = { _, _ -> },
        onVisitClick = { }
    )
}