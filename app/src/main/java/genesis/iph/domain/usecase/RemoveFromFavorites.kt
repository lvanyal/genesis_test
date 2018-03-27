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
class RemoveFromFavorites @Inject constructor(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread)
    : UseCase<Void, RemoveFromFavorites.Params>(threadExecutor, postExecutionThread) {

    @Inject
    lateinit var moviesRepository: MoviesRepository

    override fun buildUseCaseObservable(params: Params): Observable<Void> {
        return Observable.create({
            moviesRepository.removeFromFavorites(params.movie)
        })

    }

    data class Params(val movie: Movie) {}
}