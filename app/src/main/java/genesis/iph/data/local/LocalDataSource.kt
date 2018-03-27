package genesis.iph.data.local

import genesis.iph.data.local.entity.FavoriteMovie
import genesis.iph.domain.model.Movie
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by ivanphytsyk on 3/26/18.
 */
class LocalDataSource @Inject constructor() {
    @Inject
    lateinit var database: Database

    fun getFavorites(): Flowable<List<Movie>> {
        return database.favoriteDao().getFavorites()
                .map { it.map { Movie(it.id, it.title, it.description, it.imageUrl) } }
    }

    fun addToFavorites(movie: Movie) {
        database.favoriteDao().addFavorite(FavoriteMovie(movie.id, movie.title, movie.description, movie.imageUrl))
    }

    fun removeFromFavorites(movie: Movie) {
        database.favoriteDao().removeFavorite(FavoriteMovie(movie.id, movie.title, movie.description, movie.imageUrl))
    }
}