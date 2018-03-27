package genesis.iph.domain.usecase

import genesis.iph.domain.executor.PostExecutionThread
import genesis.iph.domain.executor.ThreadExecutor
import genesis.iph.domain.model.Movie
import genesis.iph.domain.repository.MoviesRepository
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import javax.inject.Inject

/**
 * Created by ivanphytsyk on 3/24/18.
 */
class AddToFavorites @Inject constructor(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread)
    : UseCase<Void, AddToFavorites.Params>(threadExecutor, postExecutionThread) {

    @Inject
    lateinit var moviesRepository: MoviesRepository

    override fun buildUseCaseObservable(params: Params): Observable<Void> {
        return Observable.create({
            moviesRepository.addToFavorites(params.movie)
        })

    }

    data class Params(val movie: Movie) {}
}