package genesis.iph.concurrency

import genesis.iph.domain.executor.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Singleton
import javax.inject.Inject


/**
 * Created by ivanphytsyk on 1/13/18.
 */

class UiThread @Inject constructor() : PostExecutionThread {
    override fun getScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

}