package genesis.iph.data.remote.retrofit.response

import com.google.gson.annotations.SerializedName

/**
 * Created by ivanphytsyk on 3/25/18.
 */
data class MoviesResponse (
    val results: List<MovieResponse>
)

data class MovieResponse (
    val id: Long,
    @SerializedName("poster_path")
    val imagePath: String,
    val title: String,
    val overview: String
)