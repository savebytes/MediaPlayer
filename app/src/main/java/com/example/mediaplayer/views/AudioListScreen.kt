package com.example.mediaplayer.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mediaplayer.models.AudioData


@Composable
fun AudioListScreen(audioData: List<AudioData>) {
    LazyColumn (
        content = {
            items(audioData){ item ->
                AudioItem(item)
            }
        }
    )
    Card(
        modifier = Modifier.padding(5.dp).fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
    ){

    }
}

