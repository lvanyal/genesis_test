package genesis.iph.presentation.movielist

import android.content.Context
import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import genesis.iph.R
import genesis.iph.domain.model.Movie
import javax.inject.Inject

/**
 * Created by ivanphytsyk on 3/24/18.
 */
class MoviesAdapter @Inject constructor(private val context: Context) : RecyclerView.Adapter<MovieViewHolder>() {

    var movies: List<Movie>? = null
    var leftButtonClickListener: ((movie: Movie?) -> Unit)? = null
    var righButtonClickListener: ((movie: Movie?) -> Unit)? = null
    lateinit var leftButtonText: String

    override fun onBindViewHolder(holder: MovieViewHolder?, position: Int) {
        val movie = movies?.get(position)

        Picasso.get().load(movie?.imageUrl).into(holder?.movieImage)
        holder?.movieTitleView?.text = movie?.title
        holder?.movieDescriptionView?.text = movie?.description

        holder?.leftButton?.text = leftButtonText
        holder?.leftButton?.setOnClickListener { leftButtonClickListener?.invoke(movie) }
        holder?.rightButton?.setOnClickListener { righButtonClickListener?.invoke(movie) }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies?.size ?: 0;
    }

}