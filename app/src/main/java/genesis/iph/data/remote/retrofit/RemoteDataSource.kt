package genesis.iph.data.remote.retrofit

import genesis.iph.domain.model.Movie
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by ivanphytsyk on 3/25/18.
 */
class RemoteDataSource(val api: Api) {

    private val IMAGE_HOST = "http://image.tmdb.org/t/p/w400"

    fun getMovies(): Single<List<Movie>> {
        return api.getMovies("https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=c902432dbc366c09eb2db1ea25476978")
                .map { it.results.map { Movie(it.id, it.title, it.overview, IMAGE_HOST + it.imagePath) } }
    }
}

object RemoteDataSourceProvider {
    fun provide(): RemoteDataSource {
        return RemoteDataSource(Api.create())
    }
}
