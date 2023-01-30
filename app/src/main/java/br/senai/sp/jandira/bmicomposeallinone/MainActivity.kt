package br.senai.sp.jandira.bmicomposeallinone

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmicomposeallinone.ui.theme.BMIComposeAllInOneTheme
import br.senai.sp.jandira.bmicomposeallinone.ui.theme.poppins

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMIComposeAllInOneTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BmiCalculator()
                }
            }
        }
    }
}

@Composable
fun BmiCalculator() {

    var isCardVisible = remember {
        mutableStateOf(false)
    }

    Box(){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, bottom = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bmi256),
                    contentDescription = "",
                    alignment = Alignment.Center
                )
                Text(
                    text = "BMI CALCULATOR",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 28.sp,
                    fontFamily = poppins, fontWeight = FontWeight.Bold,
                    letterSpacing = 4.sp,
                    textAlign = TextAlign.Center
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Your weight in kgs",
                    modifier = Modifier.fillMaxWidth(),
                    fontFamily = poppins, fontWeight = FontWeight.Normal,
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Your height in cm",
                    modifier = Modifier.fillMaxWidth(),
                    fontFamily = poppins, fontWeight = FontWeight.Normal,
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    onClick = {
                        isCardVisible.value = !isCardVisible.value
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                        //.height(48.dp),
                    shape = RoundedCornerShape(16.dp),
                    contentPadding = PaddingValues(12.dp)
                ) {
                    Text(
                        text = "CALCULATE",
                        fontSize = 16.sp,
                        fontFamily = poppins, fontWeight = FontWeight.Normal,
                    )
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            if (isCardVisible.value){
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    shape = RoundedCornerShape(
                        topStart = 32.dp,
                        topEnd = 32.dp
                    ),
                    backgroundColor = MaterialTheme.colors.primary
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Your Score",
                            fontSize = 24.sp,
                            fontFamily = poppins, fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "0.0",
                            fontSize = 48.sp,
                            fontFamily = poppins, fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = "Congratulations! Your weight is ideal.",
                            fontSize = 20.sp,
                            fontFamily = poppins, fontWeight = FontWeight.Normal,
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(0.5f),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Button(
                                onClick = { /*TODO*/ },
                                modifier = Modifier.height(48.dp),
                                colors = ButtonDefaults.buttonColors(MaterialTheme.colors.secondary)
                            ) {
                                Text(text = "Reset")
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Button(
                                onClick = { /*TODO*/ },
                                modifier = Modifier.height(48.dp),
                                colors = ButtonDefaults.buttonColors(MaterialTheme.colors.secondary)
                            ) {
                                Text(text = "Share")
                            }
                        }
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BmiCalculatorPreview() {
    BMIComposeAllInOneTheme {
        BmiCalculator()
    }
}
