package genesis.iph.domain.executor

import io.reactivex.Scheduler

/**
 * Created by ivanphytsyk on 3/24/18.
 */
interface PostExecutionThread {
    fun getScheduler(): Scheduler;
}