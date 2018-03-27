package genesis.iph.domain.repository

/**
 * Created by ivanphytsyk on 3/24/18.
 */
interface Session {
    fun login();
    fun logout()
    fun isLoggedIn()
}