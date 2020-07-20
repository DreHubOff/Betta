package com.studying.bettamovies.db

import androidx.room.*
import com.studying.bettamovies.db.models.MovieEntity
import io.reactivex.Flowable

@Dao
interface ActivityEntityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingle(movie: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movieList: List<MovieEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateSingle(movie: MovieEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateAll(movieList: List<MovieEntity>)

    @Query("SELECT * FROM MovieEntity")
    fun selectAll(): Flowable<List<MovieEntity>>

    @Query("SELECT * FROM MovieEntity WHERE movie_id = :movieId")
    fun getMovieById(movieId: Long): Flowable<MovieEntity>

    @Delete
    fun deleteSingle(movie: MovieEntity)

    @Delete
    fun deleteAll(movieList: List<MovieEntity>)
}