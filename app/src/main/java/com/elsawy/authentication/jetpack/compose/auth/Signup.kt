package com.elsawy.authentication.jetpack.compose.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elsawy.authentication.jetpack.compose.ui.theme.AuthenticationJetPackComposeTheme
import com.elsawy.authentication.jetpack.compose.ui.theme.Blue


@Composable
fun Signup(navController: NavController) {
   Column(modifier = Modifier
      .fillMaxSize()
      .background(Blue)) {

   }
}


@Preview(showBackground = true)
@Composable
fun SignupPreview() {
   AuthenticationJetPackComposeTheme {
      Signup(rememberNavController())
   }

}