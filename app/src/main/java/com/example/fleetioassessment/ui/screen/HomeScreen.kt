package com.example.fleetioassessment.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import com.example.fleetioassessment.R
import com.example.fleetioassessment.viewmodel.VehicleViewModel

@Composable
fun HomeScreen(vm:VehicleViewModel, onNavigate: (String) -> Unit) {

    val constraints = ConstraintSet {
        val img_logo = createRefFor("img_logo")
        val tv_logo = createRefFor("tv_logo")

        constrain(img_logo) {
            top.linkTo(parent.top, 30.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.value(300.dp)
            height = Dimension.wrapContent
        }

        constrain(tv_logo) {
            top.linkTo(parent.top, 40.dp)
            end.linkTo(img_logo.end)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
    }

    ConstraintLayout(
        constraintSet = constraints,
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            modifier = Modifier.layoutId("tv_logo"),
            text = "Powered By:",
            fontSize = 16.sp,
            color = Color.Black
        )

        Image(
            modifier = Modifier.layoutId("img_logo"),
            painter = painterResource(R.drawable.img_logo_title),
            contentDescription = "fleetio_logo"
        )
    }




}