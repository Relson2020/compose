package com.example.jetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            List(users)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Surface(Modifier.fillMaxSize()) {
        List(users)
    }
}

data class User(val name : String)
var users = listOf(
    User("Levi"),
    User("Eren"),
    User("Misaka"),
    User("Emir"),
    User("Armin"),
    User("Ervin"),
    User("Berthold"),
    User("Renier")
)

@Composable
fun List(users : List<User>){
    LazyColumn{
        items(users){ user ->
            SimpleInfo(user)
        }
    }
}

@Composable
fun SimpleInfo(users : User) {
    val context = LocalContext.current
    Card(elevation = 10.dp, backgroundColor = colorResource(id = R.color.lightGray),modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .wrapContentHeight()) {
        Row(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.kotlin),
                contentDescription = "simpleInfo"
            )
            Spacer(modifier = Modifier.height(20.dp))
            Column(Modifier.padding(10.dp)) {
                Text(
                    text = "Name : ${users.name}",
                    fontSize = 18.sp,
                    color = colorResource(id = R.color.Gray),
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 10.dp)
                )
                Button(onClick = {
                    Toast.makeText(context, users.name, Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "Button", fontSize = 15.sp)
                }
            }
        }
    }
}

