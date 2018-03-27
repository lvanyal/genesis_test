package genesis.iph.presentation.movielist.mvp

import genesis.iph.domain.model.Movie
import genesis.iph.presentation.base.Presenter

/**
 * Created by ivanphytsyk on 3/24/18.
 */
interface FavoritesPresenter : Presenter<MoviesView> {
    fun removeFromFavorites(movie: Movie?)
}