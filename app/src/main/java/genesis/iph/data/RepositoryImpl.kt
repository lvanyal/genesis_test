package genesis.iph.data

import genesis.iph.data.local.LocalDataSource
import genesis.iph.data.remote.retrofit.RemoteDataSourceProvider
import genesis.iph.domain.model.Movie
import genesis.iph.domain.repository.MoviesRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by ivanphytsyk on 3/25/18.
 */
class RepositoryImpl @Inject constructor() : MoviesRepository {

    private val remoteSource = RemoteDataSourceProvider.provide()

    @Inject
    lateinit var localSource: LocalDataSource

    override fun getRecentMovies(recentMoviesCount: Int): Single<List<Movie>> {
        return remoteSource.getMovies()
    }

    override fun getFavorites(): Flowable<List<Movie>> {
        return localSource.getFavorites()
    }

    override fun addToFavorites(movie: Movie) {
        localSource.addToFavorites(movie)
    }

    override fun removeFromFavorites(movie: Movie) {
        localSource.removeFromFavorites(movie)
    }
}