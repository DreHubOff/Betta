package com.studying.bettamovies.db.dao

import androidx.room.*
import com.studying.bettamovies.db.models.MovieDetailEntity
import com.studying.bettamovies.db.models.MovieItemEntity
import io.reactivex.Single

@Dao
interface MovieDetailsEntityDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingle(movieDetails: MovieItemEntity)

    @Query("SELECT * FROM MovieDetailEntity")
    fun selectAll(): Single<List<MovieDetailEntity>>

    @Query("SELECT * FROM MovieDetailEntity WHERE net_id = :netId")
    fun getMovieById(netId: Int): Single<MovieDetailEntity>

    @Delete
    fun deleteSingle(movie: MovieDetailEntity)

    @Delete
    fun deleteAll(movieDetailsList: List<MovieDetailEntity>)
}