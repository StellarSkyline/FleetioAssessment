package com.example.fleetioassessment.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.fleetioassessment.R
import com.example.fleetioassessment.domain.Record
import com.example.fleetioassessment.ui.theme.ProjectColors

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun VehicleItem(
    modifier: Modifier = Modifier,
    record: Record = Record(),
    onClick: (Record) -> Unit = {}
) {

    Card(
        modifier = modifier
            .width(800.dp)
            .padding(top = 16.dp, bottom = 16.dp),
        elevation = CardDefaults.cardElevation(4.dp)

    ) {

        Column(
            modifier = Modifier
                .background(ProjectColors.light_gray)
                .padding(10.dp)
                .clickable { onClick(record) },
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            GlideImage(
                modifier = Modifier
                    .width(800.dp)
                    .height(200.dp),
                contentScale = if (record.default_image_url_small == null) ContentScale.Fit else ContentScale.Crop,
                model = record.default_image_url_small,
                failure = placeholder(R.drawable.icn_car),
                contentDescription = "Vehicle Photo",
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                verticalArrangement = Arrangement.spacedBy(1.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                TextLabel(
                    modifier = Modifier,
                    label = "Name",
                    content = record.name ?: "N/A"
                )
                TextLabel(
                    modifier = Modifier,
                    label = "Make",
                    content = record.make ?: "N/A"
                )
                TextLabel(
                    modifier = Modifier,
                    label = "Model",
                    content = record.model ?: "N/A"
                )
            }
        }
    }
}


@Preview
@Composable
fun VehicleItemPreview() {
    VehicleItem()
}