package genesis.iph.presentation.movielist

import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.Snackbar.LENGTH_LONG
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import dagger.android.AndroidInjection
import genesis.iph.R
import genesis.iph.domain.model.Movie
import genesis.iph.presentation.base.View
import genesis.iph.presentation.movielist.mvp.MoviesView
import javax.inject.Inject

/**
 * Created by ivanphytsyk on 3/24/18.
 */
abstract class BaseMoviesFragment : Fragment(), MoviesView {

    @Inject
    lateinit var adapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): android.view.View? {
        return inflater?.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: android.view.View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val moviesListView = view?.findViewById<RecyclerView>(R.id.movies_list)
        moviesListView?.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        moviesListView?.adapter = adapter
        adapter.leftButtonClickListener = getMovieItemLeftButtonFunction()
        adapter.righButtonClickListener = { shareMovie(it) }
        adapter.leftButtonText = getLeftButtonText()
    }

    override fun showMovies(movies: List<Movie>) {
        adapter.movies = movies
        adapter.notifyDataSetChanged()
    }

    protected abstract fun getMovieItemLeftButtonFunction(): (Movie?) -> Unit;

    protected abstract fun getLeftButtonText(): String

    private fun shareMovie(movie: Movie?) {

    }

    override fun showError(message: String) {
        Snackbar.make(view, message, LENGTH_LONG).show()
    }

    override fun showProgress() {
    }

    override fun hideProgress() {
    }
}