package genesis.iph.presentation.movielist

import android.os.Bundle
import genesis.iph.domain.model.Movie
import genesis.iph.presentation.movielist.mvp.FavoritesPresenter
import genesis.iph.presentation.movielist.mvp.FavoritesView
import genesis.iph.presentation.movielist.mvp.MoviesPresenter
import javax.inject.Inject

/**
 * Created by ivanphytsyk on 3/24/18.
 */
class FavoritesFragment : BaseMoviesFragment(), FavoritesView {

    @Inject lateinit var presenter: FavoritesPresenter

    override fun getMovieItemLeftButtonFunction(): (Movie?) -> Unit {
        return {presenter.removeFromFavorites(it)}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.setView(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.subscribe()
    }

    override fun onPause() {
        super.onPause()
        presenter.unsubscribe()
    }

    override fun getLeftButtonText() = "REMOVE FROM FAVORITES"
}