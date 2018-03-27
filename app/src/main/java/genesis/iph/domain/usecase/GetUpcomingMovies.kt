package genesis.iph.domain.usecase

import genesis.iph.domain.executor.PostExecutionThread
import genesis.iph.domain.executor.ThreadExecutor
import genesis.iph.domain.model.Movie
import genesis.iph.domain.repository.MoviesRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by ivanphytsyk on 3/24/18.
 */
public class GetUpcomingMovies @Inject constructor(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread)
    : UseCase<List<Movie>, GetUpcomingMovies.Params>(threadExecutor, postExecutionThread) {

    @Inject
    lateinit var moviesRepository: MoviesRepository

    override fun buildUseCaseObservable(params: Params): Observable<List<Movie>> {
        return moviesRepository.getRecentMovies(params.recentMoviesCount)
                .toObservable()
    }

    data class Params(val recentMoviesCount: Int) {

    }
}