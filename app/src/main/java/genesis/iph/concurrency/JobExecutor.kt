package genesis.iph.concurrency

import genesis.iph.domain.executor.ThreadExecutor
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by ivanphytsyk on 1/13/18.
 */
class JobExecutor @Inject constructor() : ThreadExecutor {

    private val threadPoolExecutor: ThreadPoolExecutor

    override fun execute(runnable: Runnable?) {
        this.threadPoolExecutor.execute(runnable)
    }

    class JobThreadFactory : ThreadFactory {
        private var counter: Int = 0;
        override fun newThread(runnable: Runnable?): Thread {
            return Thread(runnable, "Genesis Test thread " + counter++)
        }

    }

    init {
        threadPoolExecutor = ThreadPoolExecutor(3, 8, 10,
                TimeUnit.SECONDS, LinkedBlockingQueue(), JobThreadFactory())
    }
}
