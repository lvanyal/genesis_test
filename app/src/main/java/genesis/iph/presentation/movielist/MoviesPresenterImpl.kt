package genesis.iph.presentation.movielist

import genesis.iph.domain.model.Movie
import genesis.iph.domain.usecase.AddToFavorites
import genesis.iph.domain.usecase.GetUpcomingMovies
import genesis.iph.presentation.base.View
import genesis.iph.presentation.movielist.mvp.MoviesPresenter
import genesis.iph.presentation.movielist.mvp.MoviesView
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

/**
 * Created by ivanphytsyk on 3/24/18.
 */
class MoviesPresenterImpl @Inject constructor() : MoviesPresenter {
    private var view: MoviesView? = null

    @Inject
    lateinit var getUpcomingMovies: GetUpcomingMovies

    @Inject
    lateinit var addToFavorites: AddToFavorites

    override fun subscribe() {
        getUpcomingMovies.execute(MoviesObserver(), GetUpcomingMovies.Params(20));
    }

    override fun unsubscribe() {
        getUpcomingMovies.dispose()
        addToFavorites.dispose()
        view = null
    }

    override fun setView(view: MoviesView) {
        this.view = view
    }

    override fun addToFavorites(movie: Movie?) {
        movie?.let {
            addToFavorites.execute(AddFavoriteObserver(), AddToFavorites.Params(movie))
        }
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

    inner class AddFavoriteObserver : DisposableObserver<Void>() {
        override fun onNext(t: Void) {
        }

        override fun onError(e: Throwable) {
        }

        override fun onComplete() {
        }


    }

}