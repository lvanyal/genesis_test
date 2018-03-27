package genesis.iph.di

import android.app.Application
import android.app.Fragment
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import genesis.iph.GenesisTestApp
import genesis.iph.presentation.movielist.MoviesFragment

/**
 * Created by ivanphytsyk on 3/24/18.
 */
@Component(modules = arrayOf(AppModule::class, AndroidInjectionModule::class, FragmentModule::class))
@AppScope
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun app(app: GenesisTestApp): Builder

        fun build(): AppComponent
    }

    fun inject(app: GenesisTestApp)
}