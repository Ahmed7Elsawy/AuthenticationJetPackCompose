package com.elsawy.authentication.jetpack.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.elsawy.authentication.jetpack.compose.auth.Login
import com.elsawy.authentication.jetpack.compose.auth.Signup
import com.elsawy.authentication.jetpack.compose.ui.theme.AuthenticationJetPackComposeTheme

class MainActivity : ComponentActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContent {
         AuthenticationJetPackComposeTheme {
            SetupNavigation()
         }
      }
   }

   @Composable
   private fun SetupNavigation() {
      val navController = rememberNavController()
      NavHost(navController = navController, startDestination = "login") {
         composable("login") { Login(navController) }
         composable("signup") { Signup(navController) }
      }
   }
}
