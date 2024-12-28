package com.example.mediaplayer.models

import com.google.gson.annotations.SerializedName

data class AudioList(
    @SerializedName("audio_list")
    val audio_list: List<AudioData>

)

data class AudioData(
    @SerializedName("id")
    val id: String,

    @SerializedName("audio_title")
    val audio_title: String,

    @SerializedName("audio_url")
    val audio_url: String,

    @SerializedName("artist")
    val artist: String,

    @SerializedName("duration")
    val duration: String,

    @SerializedName("song_poster")
    val song_poster: String?
)