package com.elsawy.authentication.jetpack.compose.auth

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elsawy.authentication.jetpack.compose.R
import com.elsawy.authentication.jetpack.compose.ui.theme.Blue
import com.elsawy.authentication.jetpack.compose.ui.theme.TextWhite

@Composable
fun MyTextField(textValue: String, label: String, OnValueChange: (String) -> Unit) {
   OutlinedTextField(
      value = textValue,
      onValueChange = OnValueChange,
      label = { Text(text = "Email Address", fontSize = 18.sp, color = Color.Black) },
      singleLine = true,
      modifier = Modifier.fillMaxWidth(0.8f),
      colors = TextFieldDefaults.outlinedTextFieldColors(
         unfocusedBorderColor = Color.Black, textColor = Color.Black
      )
   )
}

@Composable
fun PasswordTextField(
   textValue: String, OnValueChange: (String) -> Unit,
   label: String, passwordVisibility: Boolean,
   onIconClick: () -> Unit,
) {
   OutlinedTextField(
      value = textValue,
      onValueChange = OnValueChange,
      label = { Text(text = label, fontSize = 18.sp, color = Color.Black) },
      singleLine = true,
      modifier = Modifier.fillMaxWidth(0.8f),
      visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
      colors = TextFieldDefaults.outlinedTextFieldColors(
         unfocusedBorderColor = Color.Black, textColor = Color.Black
      ),
      trailingIcon = {
         IconButton(onClick = onIconClick) {
            Icon(
               painter = painterResource(R.drawable.ic_baseline_remove_red_eye_24),
               contentDescription = "Password",
               tint = if (passwordVisibility) Blue else Color.Gray
            )
         }
      }
   )
}


@Composable
fun MyButton(context: Context, text: String, onButtonClick: () -> Unit) {
   Button(
      colors = ButtonDefaults.buttonColors(backgroundColor = Blue),
      onClick = onButtonClick,
      modifier = Modifier
         .fillMaxWidth(0.8f)
         .height(50.dp)
         .clip(RoundedCornerShape(10.dp))

   ) {
      Text(text = text, fontSize = 20.sp, color = TextWhite)
   }

}

@Composable
fun HeaderBox(header: String) {
   Box(modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight(.25f)
      .background(Blue)
   )
   {
      Text(
         text = header, fontSize = 40.sp,
         fontWeight = FontWeight.Bold,
         color = Color.White,
         modifier = Modifier.padding(top = 30.dp, start = 10.dp)
      )
   }
}