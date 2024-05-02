package ch.walica.temp20524_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ch.walica.temp20524_2.ui.theme.Temp20524_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Temp20524_2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {

    var counter by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp)
    ) {
        Text(text = "Domek w górach", color = Color.Gray, fontSize = 26.sp)
        Image(
            painter = painterResource(id = R.drawable.obraz),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
            )
        //start
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF008080))
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF008080),
                    contentColor = Color.White
                ),
                onClick = {
                    counter++
                }) {
                Text(text = "POLUB")
            }


            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF008080)
                ),
                onClick = {
                    if (counter > 0) {
                        counter--
                    }

                }) {
                Text(text = "Usuń".uppercase())
            }


            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF008080)
                ),
                onClick = { /*TODO*/ }) {
                Text(text = "ZAPISZ")
            }
        }
        //end
        Text(
            text = "$counter polubień",
            color = Color.Gray,
            textAlign = TextAlign.End,
            modifier = Modifier.fillMaxWidth()
            )
        Divider(color = Color(0xFF808080))
        Text(text = "Opis", color = Color.Gray, fontWeight = FontWeight.Bold)
        Text(
            text = "Odwiedź komfortowy domek w Sudetach, blisko do szlaków turystycznych",
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Temp20524_2Theme {
        MainScreen()
    }
}