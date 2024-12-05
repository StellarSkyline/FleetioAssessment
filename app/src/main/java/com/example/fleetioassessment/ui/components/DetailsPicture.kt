package com.example.fleetioassessment.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.fleetioassessment.R

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailsPicture(
    modifier: Modifier = Modifier,
    url: String? = null,
) {
    Card(
        modifier = modifier
            .size(150.dp),
        elevation = CardDefaults.cardElevation(5.dp),
        shape = CircleShape
    ) {
        GlideImage(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentScale = if (url == null) ContentScale.Fit else ContentScale.Crop,
            model = url,
            failure = placeholder(R.drawable.icn_car),
            contentDescription = "Vehicle Photo",
        )
    }
}