package com.example.employeedirectory.presentation.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.employeedirectory.R
import com.example.employeedirectory.domain.model.Employee

@Composable
fun EmployeeItem(
    employee: Employee,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(employee.photoUrlSmall)
                .diskCachePolicy(CachePolicy.ENABLED)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.ic_launcher_background),
            contentDescription = stringResource(R.string.image_content_description),
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(CircleShape).width(64.dp).height(64.dp),
        )
        Column(
            modifier = modifier.padding(horizontal = 8.dp),
        ) {
            Row {
                Text(text = stringResource(id = R.string.name))
                employee.fullName?.let { fullName ->
                    Text(text = fullName)
                }
            }

            Spacer(modifier = modifier.padding(vertical = 4.dp))

            Row {
                Text(text = stringResource(id = R.string.team))
                employee.team?.let { team ->
                    Text(text = team)
                }
            }
        }
    }
}