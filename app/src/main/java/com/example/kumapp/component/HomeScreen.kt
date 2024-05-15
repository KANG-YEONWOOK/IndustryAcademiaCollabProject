package com.example.kumapp.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsTransitFilled
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults.elevation
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kumapp.R

@Composable
fun HomeScreen(navController: NavHostController){
    var search by remember{ mutableStateOf("") }

    Box(modifier = Modifier
        .fillMaxWidth()
    ){
        //지도구현
        BasicTextField(
            modifier = Modifier
                .padding(16.dp)
                .height(48.dp)
                .border(
                    3.dp,
                    color = colorResource(id = R.color.kudarkgreen),
                    shape = RoundedCornerShape(12)
                ),
            maxLines = 1,
            value = search,
            onValueChange = {search = it},
            textStyle = LocalTextStyle.current.copy(fontSize = 25.sp),
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Spacer(modifier = Modifier.padding(0.dp))
                    innerTextField()
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        modifier = Modifier
                            .size(40.dp)
                            .padding(end = 6.dp),
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = colorResource(id = R.color.kudarkgreen),
                    )
                }
            }
            //건물들 이름 쭉 저장해두고 search(검색한 내용)이 들어가 있는
            //건물을 검색해서 선택모달 띄우고 길찾기 기능 수행
        )
    }

    Column(modifier= Modifier
        .fillMaxSize()
        .padding(12.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End) {
        FloatingActionButton(
            modifier = Modifier.padding(10.dp).size(60.dp),
            shape = RoundedCornerShape(100),
            containerColor = colorResource(id = R.color.kulightgreen),
            elevation = elevation(0.dp),
            onClick = { /*지도 내 현위치이동*/ }) {
            Icon(imageVector = Icons.Default.Place,
                contentDescription = null,
                tint = colorResource(id = R.color.kudarkgreen))
        }
        FloatingActionButton(
            modifier = Modifier.padding(10.dp).size(60.dp),
            shape = RoundedCornerShape(100),
            containerColor = colorResource(id = R.color.kulightgreen),
            elevation = elevation(0.dp),
            onClick = { /*근처 대중교통 시간표 검색*/ }) {
            Icon(imageVector = Icons.Default.DirectionsTransitFilled,
                contentDescription = null,
                tint = colorResource(id = R.color.kudarkgreen))
        }
        FloatingActionButton(
            modifier = Modifier.padding(10.dp).size(60.dp),
            shape = RoundedCornerShape(100),
            containerColor = colorResource(id = R.color.kulightgreen),
            elevation = elevation(0.dp),
            onClick = { /*인스타그램,카카오톡,위치공유,기타앱공유*/ }) {
            Icon(imageVector = Icons.Default.Share,
                contentDescription = null,
                tint = colorResource(id = R.color.kudarkgreen))
        }
    }
}