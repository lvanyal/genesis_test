package genesis.iph.data.local.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by ivanphytsyk on 3/26/18.
 */
@Entity(tableName = "favorite_movies")
data class FavoriteMovie(@PrimaryKey var id: Long, var title: String, var description: String, var imageUrl: String) {
    constructor() : this(0, "", "", "")
}