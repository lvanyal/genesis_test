package genesis.iph.domain.repository

import genesis.iph.domain.model.Movie
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by ivanphytsyk on 3/24/18.
 */
interface MoviesRepository {
    fun getRecentMovies(recentMoviesCount: Int): Single<List<Movie>>;
    fun getFavorites(): Flowable<List<Movie>>;
    fun addToFavorites(movie: Movie)
    fun removeFromFavorites(movie: Movie)
}