import android.graphics.drawable.Icon
import android.text.Layout
import android.widget.EditText
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun loginPage(){

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Login",
            fontWeight = Bold,
            modifier = Modifier.padding(top = 40.dp, start = 30.dp),
            fontSize = 20.sp
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 30.dp)
        ) {
            val text = buildAnnotatedString {
                append("Doesn't have an account yet? ")
                pushStringAnnotation(tag = "signup", annotation = "click")
                withStyle(
                    style = SpanStyle(
                        color = Color.Blue,
                        textDecoration = TextDecoration.Underline
                    )
                ) {
                    append("Sign up")
                }
                pop()
            }

            ClickableText(
                text = text,
                modifier = Modifier.fillMaxWidth(),
                onClick = { offset ->
                    text.getStringAnnotations(tag = "signup", start = offset, end = offset)
                        .firstOrNull()?.let {

                    }
                }
            )
        }


        OutlinedTextField(modifier = Modifier.padding(top = 20.dp,start = 30.dp),
            value = "text",
            onValueChange = {
            },
            label = {
                Text("Email Address")
            }, 
        leadingIcon = {

            androidx.compose.material3.Icon(imageVector = (Icons.Default.Email), contentDescription ="email"
            , tint = Color.Blue)
        })


        OutlinedTextField(modifier = Modifier.padding(top = 20.dp,start = 30.dp),
            value = "Password",
            onValueChange = {
            },
            label = {
                Text("Password")
            },
            leadingIcon = {

                androidx.compose.material3.Icon(imageVector = (Icons.Default.Lock), contentDescription ="email"
                    , tint = Color.Blue)
            })
        
        Row(modifier = Modifier.fillMaxWidth()){

            val isChecked = remember {
                mutableStateOf(false)
            }
            Checkbox(checked = isChecked.value, onCheckedChange = {isChecked.value  = it}, modifier = Modifier.padding(start = 20.dp),enabled = true
            ,colors =CheckboxDefaults.colors(Color.Blue))


            Text(text = "Remember me ", modifier = Modifier.padding(top= 15.dp))

        }

        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center){
            Button(onClick = { }, modifier = Modifier.padding(top = 10.dp),shape = RoundedCornerShape(5.dp) , colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)) {
                Text(text = "Login",color = Color.White, modifier = Modifier.width(50.dp) )
            }
        }


    }
        }












