package com.studying.bettamovies.db.dao

import androidx.room.*
import com.studying.bettamovies.db.models.MovieItemEntity
import io.reactivex.Single

@Dao
interface MovieItemEntityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingle(movieItem: MovieItemEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movieItemList: List<MovieItemEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateSingle(movieItem: MovieItemEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateAll(movieItemList: List<MovieItemEntity>)

    @Query("SELECT * FROM MovieItemEntity")
    fun selectAll(): Single<List<MovieItemEntity>>

    @Query("SELECT * FROM MovieItemEntity WHERE movie_id = :movieId")
    fun getMovieById(movieId: Int): Single<MovieItemEntity>

    @Delete
    fun deleteSingle(movieItem: MovieItemEntity)

    @Delete
    fun deleteAll(movieItemList: List<MovieItemEntity>)
}