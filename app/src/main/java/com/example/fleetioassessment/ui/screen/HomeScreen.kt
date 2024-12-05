package com.example.fleetioassessment.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.fleetioassessment.R
import com.example.fleetioassessment.ui.components.ButtonArrow
import com.example.fleetioassessment.ui.components.IncludeSpinner
import com.example.fleetioassessment.ui.components.InputText
import com.example.fleetioassessment.ui.components.VehicleItem
import com.example.fleetioassessment.ui.navigation.Screen
import com.example.fleetioassessment.viewmodel.VehicleViewModel

@Composable
fun HomeScreen(vm: VehicleViewModel, onNavigate: (String) -> Unit) {

    val records by vm.records.collectAsStateWithLifecycle()
    val cursor by vm.cursor.collectAsStateWithLifecycle()
    val searchText by vm.searchText.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        vm.getVehicle()
    }

    val constraints = ConstraintSet {
        val img_logo = createRefFor("img_logo")
        val tv_logo = createRefFor("tv_logo")
        val rv_vehicle = createRefFor("rv_vehicle")
        val include_spinner = createRefFor("include_spinner")
        val page_navigation = createRefFor("page_navigation")

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

        constrain(rv_vehicle) {
            top.linkTo(img_logo.bottom)
            start.linkTo(parent.start, 16.dp)
            end.linkTo(parent.end, 16.dp)
            width = Dimension.fillToConstraints
            height = Dimension.value(500.dp)
        }

        constrain(page_navigation) {
            top.linkTo(rv_vehicle.bottom, 16.dp)
            start.linkTo(parent.start, 16.dp)
            end.linkTo(parent.end, 16.dp)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }

        constrain(include_spinner) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        }
    }

    ConstraintLayout(
        constraintSet = constraints,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            modifier = Modifier.layoutId("tv_logo"),
            text = "Powered By",
            fontSize = 16.sp,
            color = Color.Black
        )

        Image(
            modifier = Modifier
                .layoutId("img_logo"),
            painter = painterResource(R.drawable.img_logo_title),
            contentDescription = "fleetio_logo"
        )

        LazyColumn(
            modifier = Modifier.layoutId("rv_vehicle")
        ) {
            items(records.size) {
                VehicleItem(record = records[it]) {
                    vm.setRecord(it)
                    onNavigate(Screen.DetailsScreen.route)
                }
            }
        }

        Row(
            modifier = Modifier
                .layoutId("page_navigation")
                .fillMaxWidth()
        ) {

            ButtonArrow(
                modifier = Modifier.weight(.5f),
                arrowDirection = "left",
                isEnabled = true,
            ) {
                vm.getVehicle()
            }

            InputText(
                modifier = Modifier.weight(3f),
                text = searchText,
                onChange = { vm.onChangeState(it) },
            ) {
                vm.filterVehicle(searchText)
            }

            ButtonArrow(
                modifier = Modifier.weight(.5f),
                arrowDirection = "right",
            ) {
                vm.getVehicle(cursor)
            }
        }

        //Spinner while network call loading - records is empty
        if(records.isEmpty()) IncludeSpinner(modifier = Modifier.layoutId("include_spinner"))
    }
}