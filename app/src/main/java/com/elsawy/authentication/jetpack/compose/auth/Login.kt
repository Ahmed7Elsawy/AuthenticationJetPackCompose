package com.elsawy.authentication.jetpack.compose.auth

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elsawy.authentication.jetpack.compose.R
import com.elsawy.authentication.jetpack.compose.ui.theme.AuthenticationJetPackComposeTheme
import com.elsawy.authentication.jetpack.compose.ui.theme.Black
import com.elsawy.authentication.jetpack.compose.ui.theme.Blue
import com.elsawy.authentication.jetpack.compose.ui.theme.TextWhite

@Composable
fun Login(navController: NavController) {

   val context = LocalContext.current
   val emailValue = remember { mutableStateOf("") }
   val passwordValue = remember { mutableStateOf("") }
   val passwordVisibility = remember { mutableStateOf(false) }

   Column(modifier = Modifier
      .fillMaxSize()
      .background(Blue)) {


      HeaderBox(header = "Sign In")

//      Box(modifier = Modifier
//         .fillMaxWidth()
//         .fillMaxHeight(.25f)
//         .background(Blue)
//      )
//      {
//         Text(
//            text = "Sign In", fontSize = 40.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color.White,
//            modifier = Modifier.padding(top = 30.dp, start = 10.dp)
//         )
//      }

      Column(
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Center,
         modifier = Modifier
            .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
            .fillMaxSize()
            .background(Color.White)
      ) {

         // pass label
         MyTextField(emailValue.value, "Email Address") { emailValue.value = it }


//         OutlinedTextField(
//            value = emailValue.value,
//            onValueChange = { emailValue.value = it },
//            label = { Text(text = "Email Address", fontSize = 18.sp, color = Color.Black) },
//            singleLine = true,
//            modifier = Modifier.fillMaxWidth(0.8f),
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//               unfocusedBorderColor = Color.Black, textColor = Color.Black
//            )
//         )

         Spacer(modifier = Modifier.padding(5.dp))

         PasswordTextField(textValue = passwordValue.value,
            OnValueChange = { passwordValue.value = it },
            label = "Password",
            passwordVisibility = passwordVisibility.value) {
            passwordVisibility.value = !passwordVisibility.value
         }

//         OutlinedTextField(
//            value = passwordValue.value,
//            onValueChange = { passwordValue.value = it },
//            label = { Text(text = "Password", fontSize = 18.sp, color = Color.Black) },
//            singleLine = true,
//            modifier = Modifier.fillMaxWidth(0.8f),
//            visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//               unfocusedBorderColor = Color.Black, textColor = Color.Black
//            ),
//            trailingIcon = {
//               IconButton(onClick = {
//                  passwordVisibility.value = !passwordVisibility.value
//               }) {
//                  Icon(
//                     painter = painterResource(R.drawable.ic_baseline_remove_red_eye_24),
//                     contentDescription = "Password",
//                     tint = if (passwordVisibility.value) Blue else Color.Gray
//                  )
//               }
//            }
//         )

         Spacer(modifier = Modifier.padding(20.dp))

         MyButton(context = context, text = "sign in") {
            if (emailValue.value != "" && passwordValue.value != "") {
               Toast.makeText(context,
                  "Logged Successfully!",
                  Toast.LENGTH_LONG
               ).show()
            }
         }

//         Button(
//            colors = ButtonDefaults.buttonColors(backgroundColor = Blue),
//            onClick = {
//               if (emailValue.value != "" && passwordValue.value != "") {
//                  Toast.makeText(context,
//                     "Logged Successfully!",
//                     Toast.LENGTH_LONG
//                  ).show()
//               }
//            },
//            modifier = Modifier
//               .fillMaxWidth(0.8f)
//               .height(50.dp)
//               .clip(RoundedCornerShape(10.dp))
//         ) {
//            Text(text = "sign in", fontSize = 20.sp, color = TextWhite)
//         }

         Spacer(modifier = Modifier.padding(20.dp))

         Text(text = "Create an account", fontSize = 20.sp,
            modifier = Modifier.clickable { navController.navigate("signup") }
         )

      }

   }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
   AuthenticationJetPackComposeTheme {
      Login(rememberNavController())
   }

}