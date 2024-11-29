package com.example.inclassassignment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.inclassassignment.ui.theme.InclassAssignmentTheme
import kotlinx.coroutines.selects.select
import kotlin.random.Random

data class Member(val id: String, val name: String)

val members = listOf{
    Member("411855488","Hardy Amuntai");
    Member("002","Javier Wibowo");
    Member("003", "Christiela");
    Member("004","Jonathan Brian");
    Member("005","Bryan kenneth budiyantoro")
}
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BirthdayCard()
        }
    }
}

@SuppressLint("InvalidColorHexValue")
@Composable
fun BirthdayCard(){
    var selectedMember by remember { mutableStateOf<member?>(null) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xff2471a3), Color(0xffeaf2f8))
                )
            )
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = "LUCKY DRAW",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    selectedMember = members[Random.NextInt(members.size)]
                },
                colors = ButtonDefaults.buttonColors(Color(0xFF288D1))
            ) {
                Text(text = "Pick a member", Color = Color.White)
            }
            Spacer(modifier = Modifier.height(20.dp))

            SelectedMember?.let { member ->
                Column(horizontalAlignment = Alignment.CenterHorizontally){
                    Image(
                        painter = painterResource(id = member.avatar),
                        contentDescription = "Avatar of ${member.name}",
                        modifier = Modifier
                            .size(120.dp)
                            .background(Color.LightGray, CircleShape)
                            .padding(8.dp),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "ID: ${member.id}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        text = "Name: ${member.name}",
                        fontSize = 20.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}


