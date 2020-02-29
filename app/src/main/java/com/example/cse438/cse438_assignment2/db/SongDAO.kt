package com.example.cse438.cse438_assignment2.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SongDAO {

    @Query("SELECT * FROM songs")
    fun getSongs(): LiveData<List<Song>>

    @Insert
    fun insertSong(song: Song)

    @Query("DELETE FROM songs")
    fun deleteAll()

    //    @Query("SELECT * FROM songs WHERE playlistID = :id")
//    fun getPlaylistSongs(id: Int): LiveData<List<Song>>
    @Query("SELECT * FROM songs WHERE playlistID = :id")
    fun getPlaylistSongs(id: Int): LiveData<List<Song>>
}