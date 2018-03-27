package genesis.iph.presentation.movielist

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import genesis.iph.R
import kotlinx.android.synthetic.main.movie_content_layout.view.*

/**
 * Created by ivanphytsyk on 3/24/18.
 */
class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val movieImage: ImageView = itemView.findViewById(R.id.movie_image)
    val movieTitleView: TextView = itemView.findViewById(R.id.movie_title)
    val movieDescriptionView: TextView = itemView.findViewById(R.id.movie_description)
    val leftButton: Button = itemView.findViewById(R.id.left_button)
    val rightButton: Button = itemView.findViewById(R.id.right_button)
}