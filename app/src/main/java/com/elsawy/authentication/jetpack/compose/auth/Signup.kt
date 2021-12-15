package com.elsawy.authentication.jetpack.compose.auth

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elsawy.authentication.jetpack.compose.R
import com.elsawy.authentication.jetpack.compose.ui.theme.AuthenticationJetPackComposeTheme
import com.elsawy.authentication.jetpack.compose.ui.theme.Blue


@Composable
fun Signup(navController: NavController) {
   val context = LocalContext.current
   val name = remember { mutableStateOf("") }
   val email = remember { mutableStateOf("") }
   val password = remember { mutableStateOf("") }
   val confirmPassword = remember { mutableStateOf("") }
   val passwordVisibility = remember { mutableStateOf(false) }

   Column(modifier = Modifier
      .fillMaxSize()
      .background(Blue)) {

      HeaderBox(header = stringResource(R.string.sign_up))

      Column(
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Center,
         modifier = Modifier
            .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
            .fillMaxSize()
            .background(Color.White)
      ) {

         TextField(textValue = name.value,
            OnValueChange = { name.value = it },
            label = "Full Name")

         Spacer(modifier = Modifier.padding(5.dp))

         TextField(textValue = email.value,
            OnValueChange = { email.value = it },
            label = "Email Address")

         Spacer(modifier = Modifier.padding(5.dp))

         TextField(textValue = password.value,
            OnValueChange = { password.value = it },
            label = "Password",
            passwordVisibility = passwordVisibility.value,
            isPassword = true
         ) {
            passwordVisibility.value = !passwordVisibility.value
         }

         Spacer(modifier = Modifier.padding(5.dp))

         TextField(textValue = confirmPassword.value,
            OnValueChange = { confirmPassword.value = it },
            label = "Confirm password",
            passwordVisibility = passwordVisibility.value,
            isPassword = true
         ) {
            passwordVisibility.value = !passwordVisibility.value
         }

         Spacer(modifier = Modifier.padding(20.dp))

         MyButton(context = context, text = stringResource(R.string.sign_up)) {
            if (isValidData(name.value, email.value, password.value, confirmPassword.value)) {
               Toast.makeText(context,
                  "Account created Successfully!",
                  Toast.LENGTH_LONG
               ).show()
            }
         }

         Spacer(modifier = Modifier.padding(10.dp))

         Text(text = "Already have an Account", fontSize = 20.sp,
            modifier = Modifier.clickable { navController.popBackStack() }
         )

      }
   }
}

private fun isValidData(
   name: String,
   email: String,
   password: String,
   confirmPassword: String,
) = (name != "" && email != "" && password != "" && password == confirmPassword)


@Preview(showBackground = true)
@Composable
fun SignupPreview() {
   AuthenticationJetPackComposeTheme {
      Signup(rememberNavController())
   }

}