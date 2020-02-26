package com.example.cse438.cse438_assignment2.data

import retrofit2.http.Url
import java.sql.Date

data class Track(
    val id: Int,
    val title: String,
    val title_short: String,
    val title_version: String,
    val link: String,
    val duration: Int,
    val rank: Int,
    val explicit_lyrics: Boolean,
    val explicit_content_lyrics: Int,
    val explicit_content_cover: Int,
    val preview: String,
    val position: Int,
    val artist: String,
    val album: String,
    val type: String

//    val readable: Boolean,
//    val unseen: Boolean,
//    val isrc: String,
//
//    val share: Url,
//
//    val track_position: Int,
//    val disk_number: Int,
//
//    val release_date: Date,
//
//
//
//    val bpm: Float,
//    val gain: Float,
//    val available_countries: List<String>,
//    val alternative: Track,
//    val contributors: List<String>,
//
//    val album: Album
)

data class TrackPayload (
    val data: List<Track>,
    val total: Int
)