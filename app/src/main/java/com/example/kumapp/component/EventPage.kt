package com.example.kumapp.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kumapp.R

@Composable
fun EventPage(navController: NavHostController) {

    var quizAnswer by remember{ mutableStateOf("") }

    Scaffold (topBar = {
        TopBar(navController = navController)
    }){contentPadding ->
        Column(modifier = Modifier.fillMaxSize().padding(contentPadding),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "오늘의 이벤트",
                color = colorResource(id = R.color.kudarkgreen),
                fontFamily = FontFamily.Monospace,
                fontSize = 40.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(32.dp),
                textAlign = TextAlign.Center)

            Text(text = "다양한 기능과 귀여운 쿠펫으로\n건국대학교 모험의 동반자가 될 지도앱의\n이름은 무엇일까요?\n(힌트 : KU로 시작해요!)",
                color = colorResource(id = R.color.kudarkgreen),
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(32.dp),
                textAlign = TextAlign.Center)

            QuizTextField(text = quizAnswer) {
                quizAnswer = it
            }

            Button(onClick = {},
                modifier = Modifier.padding(top= 200.dp, bottom= 40.dp),
                shape = RoundedCornerShape(12),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.kumiddlegreen),)
            ){
                Text(text = "다른 이벤트 하기",
                    color = colorResource(id = R.color.kuhighlightgreen),
                    fontFamily = FontFamily.Monospace
                )
            }
        }
    }

}

@Composable
fun QuizTextField(
    text: String,
    onTextChanged: (String) -> Unit,
) {
    BasicTextField(
        value = text,
        onValueChange = onTextChanged,
        decorationBox = {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                text.forEachIndexed { index, char ->
                    QuizTextFieldCharContainer(
                        text = char,
                        isFocused = index == text.lastIndex,
                    )
                }
                repeat(3 - text.length) {
                    QuizTextFieldCharContainer(
                        text = ' ',
                        isFocused = false,
                    )
                }
            }
        },
    )
}

@Composable
fun QuizTextFieldCharContainer(
    modifier: Modifier = Modifier,
    text: Char,
    isFocused: Boolean,
) {
    val shape = remember { RoundedCornerShape(4.dp) }

    Box(
        modifier = modifier
            .size(
                width = 40.dp,
                height = 40.dp,
            )
            .background(
                color = colorResource(id = R.color.kuhighlightgreen),
                shape = shape,
            )
            .run {
                if (isFocused) {
                    border(
                        width = 1.dp,
                        color = colorResource(id = R.color.kumiddlegreen),
                        shape = shape,
                    )
                } else {
                    this
                }
            },
        contentAlignment = Alignment.Center,
    ) {
        Text(text = text.toString())
    }
}