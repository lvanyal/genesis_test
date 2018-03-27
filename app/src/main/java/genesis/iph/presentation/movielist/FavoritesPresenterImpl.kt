package genesis.iph.presentation.movielist

import genesis.iph.domain.model.Movie
import genesis.iph.domain.usecase.AddToFavorites
import genesis.iph.domain.usecase.GetFavorites
import genesis.iph.domain.usecase.GetUpcomingMovies
import genesis.iph.domain.usecase.RemoveFromFavorites
import genesis.iph.presentation.movielist.mvp.FavoritesPresenter
import genesis.iph.presentation.movielist.mvp.MoviesPresenter
import genesis.iph.presentation.movielist.mvp.MoviesView
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

/**
 * Created by ivanphytsyk on 3/24/18.
 */
class FavoritesPresenterImpl @Inject constructor() : FavoritesPresenter {

    private var view: MoviesView? = null

    @Inject
    lateinit var getFavorites: GetFavorites

    @Inject
    lateinit var removeFromFavorites: RemoveFromFavorites

    override fun subscribe() {
        getFavorites.execute(MoviesObserver(), GetFavorites.Params());
    }

    override fun unsubscribe() {
        getFavorites.dispose()
        view = null
    }

    override fun removeFromFavorites(movie: Movie?) {
        movie?.let {
            removeFromFavorites.execute(RemoveFavoriteObserver(), RemoveFromFavorites.Params(movie))
        }
    }

    override fun setView(view: MoviesView) {
        this.view = view
    }

    inner class MoviesObserver : DisposableObserver<List<Movie>>() {
        override fun onComplete() {
            view?.hideProgress()
        }

        override fun onNext(movies: List<Movie>) {
            view?.showMovies(movies)
        }

        override fun onError(e: Throwable) {
            view?.showError(e.message!!)
        }
    }

    inner class RemoveFavoriteObserver : DisposableObserver<Void>() {
        override fun onNext(t: Void) {

        }

        override fun onError(e: Throwable) {
        }

        override fun onComplete() {
        }

    }
}