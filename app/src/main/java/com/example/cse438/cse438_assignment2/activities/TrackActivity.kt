package com.example.cse438.cse438_assignment2.activities

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cse438.cse438_assignment2.R
import com.example.cse438.cse438_assignment2.viewmodels.TrackViewModel
import com.example.cse438.cse438_assignment2.data.Track
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_track.*

class TrackActivity: AppCompatActivity(){

    lateinit var trackViewModel: TrackViewModel
    var trackList: ArrayList<Track> = ArrayList()
    lateinit var thisTrack: Track

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track)


        var id: String = intent.getStringExtra("id")

        trackViewModel = ViewModelProviders.of(this).get(TrackViewModel::class.java)
        trackViewModel!!.track.observe(this, Observer {
            trackList.clear()
            trackList.add(it)
            Log.d("TAG", it.toString())
            for(track in trackList){
                updateView(track)
                thisTrack = track
            }

        })
        trackViewModel.getTrack(id)

    }

    fun updateView(track: Track){
        trackTitle.text = track.title
        trackArtist.text = track.artist.name
        trackAlbum.text = track.album.title
        trackDuration.text = track.duration.toString()
        trackReleased.text = track.release_date
        trackRank.text = track.rank.toString()
        trackPosition.text = track.track_position.toString()

        var image = track.album.cover_xl
        Picasso.with(trackImage.context).load(image).into(trackImage)
    }


    fun addToPlaylist(v: View){
        Toast.makeText(this, thisTrack.title, Toast.LENGTH_LONG).show()



    }

}