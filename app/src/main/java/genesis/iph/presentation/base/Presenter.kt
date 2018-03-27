package genesis.iph.presentation.base

/**
 * Created by ivanphytsyk on 3/24/18.
 */
interface Presenter<T : View> {
    fun subscribe()
    fun unsubscribe()
    fun setView(view: T)
}