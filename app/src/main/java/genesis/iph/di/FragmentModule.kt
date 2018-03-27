package genesis.iph.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import genesis.iph.presentation.movielist.FavoritesFragment
import genesis.iph.presentation.movielist.MoviesFragment

/**
 * Created by ivanphytsyk on 3/24/18.
 */
@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeMoviesFragment(): MoviesFragment;

    @ContributesAndroidInjector
    abstract fun contributeFavoritesFragment(): FavoritesFragment;
}