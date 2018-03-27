package genesis.iph.domain.usecase

import genesis.iph.domain.executor.PostExecutionThread
import genesis.iph.domain.executor.ThreadExecutor
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers


/**
 * Created by ivanphytsyk on 3/24/18.
 */
abstract class UseCase<RESULT, PARAMS>(val threadExecutor: ThreadExecutor,
                                       val postExecutionThread: PostExecutionThread) {

    private val disposables = CompositeDisposable()

    protected abstract fun buildUseCaseObservable(params: PARAMS): Observable<RESULT>;

    fun execute(observer: DisposableObserver<RESULT>, params: PARAMS) {
        val observable = buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
        observable.subscribe(observer)
        disposables.add(observer)
    }

    public fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

}