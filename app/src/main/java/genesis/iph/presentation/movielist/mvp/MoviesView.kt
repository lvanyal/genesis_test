package genesis.iph.presentation.movielist.mvp

import genesis.iph.domain.model.Movie
import genesis.iph.presentation.base.View

/**
 * Created by ivanphytsyk on 3/24/18.
 */
interface MoviesView : View {
    fun showMovies(movies: List<Movie>)
}