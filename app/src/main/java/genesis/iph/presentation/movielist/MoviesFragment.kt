package genesis.iph.presentation.movielist

import android.os.Bundle
import genesis.iph.domain.model.Movie
import genesis.iph.presentation.movielist.mvp.MoviesPresenter
import genesis.iph.presentation.movielist.mvp.MoviesView
import javax.inject.Inject

/**
 * Created by ivanphytsyk on 3/24/18.
 */
class MoviesFragment : BaseMoviesFragment() {

    @Inject lateinit var presenter: MoviesPresenter

    override fun getMovieItemLeftButtonFunction(): (Movie?) -> Unit {
        return {presenter.addToFavorites(it)}
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

    override fun getLeftButtonText() = "ADD TO FAVORITES"
}