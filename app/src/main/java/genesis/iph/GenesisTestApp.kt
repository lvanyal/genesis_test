package genesis.iph

import android.app.Activity
import android.app.Application
import android.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasFragmentInjector
import genesis.iph.di.DaggerAppComponent
import javax.inject.Inject

/**
 * Created by ivanphytsyk on 3/24/18.
 */
class GenesisTestApp : Application(), HasActivityInjector, HasFragmentInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().app(this).build().inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }

    override fun fragmentInjector(): AndroidInjector<Fragment> {
        return fragmentInjector
    }
}
