package com.example.mediaplayer.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mediaplayer.R
import com.example.mediaplayer.models.AudioData

@Preview
@Composable
fun PreviewItem(){
    AudioItem(
        AudioData(
            "2",
            "Die with a smile",
            "https://savebytes.github.io/test_utils/musics/Jennifer%20Warnes%20-%20Bird%20on%20a" +
                    "%20Wire%20lossless.wav",
            "The Weeknd",
            "03:30",
            null
            )
    )
}


@Composable
fun AudioItem(audioItem: AudioData){
    Card(
        modifier = Modifier.padding(5.dp).fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(4.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.audioicon),
                contentDescription = "",
                modifier = Modifier.size(50.dp).padding(8.dp)
            )
            Column(){
                Text(
                    text = audioItem.audio_title,
                    style = MaterialTheme.typography.titleLarge
                )
                Row() {
                    Text(
                        text = audioItem.artist,
                        fontWeight = FontWeight.Normal,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(0.dp, 0.dp, 8.dp, 0.dp)
                    )
                    Text(
                        text = "|",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(8.dp, 0.dp)
                    )
                    Text(
                        text = audioItem.duration,
                        fontWeight = FontWeight.Normal,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(8.dp, 0.dp)
                    )
                }
            }
        }
    }
}