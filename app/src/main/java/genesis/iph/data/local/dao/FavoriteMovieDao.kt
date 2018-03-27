package genesis.iph.data.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import genesis.iph.data.local.entity.FavoriteMovie
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Created by ivanphytsyk on 3/26/18.
 */
@Dao
interface FavoriteMovieDao {

    @Insert
    fun addFavorite(favoriteMovie: FavoriteMovie)

    @Delete
    fun removeFavorite(favoriteMovie: FavoriteMovie)

    @Query("SELECT * from favorite_movies")
    fun getFavorites(): Flowable<List<FavoriteMovie>>
}