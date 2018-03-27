package genesis.iph.domain.usecase

import genesis.iph.domain.executor.PostExecutionThread
import genesis.iph.domain.executor.ThreadExecutor
import genesis.iph.domain.model.Movie
import genesis.iph.domain.repository.MoviesRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by ivanphytsyk on 3/26/18.
 */
class GetFavorites @Inject constructor(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread)
    : UseCase<List<Movie>, GetFavorites.Params>(threadExecutor, postExecutionThread) {

    @Inject
    lateinit var repository: MoviesRepository

    override fun buildUseCaseObservable(params: Params): Observable<List<Movie>> {
        return repository.getFavorites().toObservable()
    }

    class Params {

    }
}