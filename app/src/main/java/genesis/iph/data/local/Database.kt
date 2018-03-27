package genesis.iph.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import genesis.iph.data.local.dao.FavoriteMovieDao
import genesis.iph.data.local.entity.FavoriteMovie

/**
 * Created by ivanphytsyk on 3/26/18.
 */
@Database(entities = arrayOf(FavoriteMovie::class), version = 2, exportSchema = false)
abstract class Database: RoomDatabase() {
    abstract fun favoriteDao(): FavoriteMovieDao
}