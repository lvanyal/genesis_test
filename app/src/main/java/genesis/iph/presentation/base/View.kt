package genesis.iph.presentation.base

/**
 * Created by ivanphytsyk on 3/24/18.
 */
interface View {
    fun showError(message: String)
    fun showProgress()
    fun hideProgress()
}