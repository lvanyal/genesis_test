package genesis.iph.di

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import genesis.iph.GenesisTestApp
import genesis.iph.concurrency.JobExecutor
import genesis.iph.concurrency.UiThread
import genesis.iph.data.RepositoryImpl
import genesis.iph.data.local.Database
import genesis.iph.domain.executor.PostExecutionThread
import genesis.iph.domain.executor.ThreadExecutor
import genesis.iph.domain.repository.MoviesRepository
import genesis.iph.presentation.movielist.FavoritesPresenterImpl
import genesis.iph.presentation.movielist.MoviesPresenterImpl
import genesis.iph.presentation.movielist.mvp.FavoritesPresenter
import genesis.iph.presentation.movielist.mvp.MoviesPresenter
import javax.inject.Singleton

/**
 * Created by ivanphytsyk on 3/24/18.
 */
@Module
class AppModule {
    @Provides
    @AppScope
    fun provideApplication(app: GenesisTestApp): Context = app

    @Provides
    @AppScope
    fun provideMoviesPresenter(moviesPresenter: MoviesPresenterImpl): MoviesPresenter {
        return moviesPresenter
    }

    @Provides
    @AppScope
    fun provideFavoritesPresenter(favoritesPresenter: FavoritesPresenterImpl): FavoritesPresenter {
        return favoritesPresenter
    }

    @Provides
    @AppScope
    fun provideMoviesRepository(repositoryImpl: RepositoryImpl): MoviesRepository {
        return repositoryImpl
    }

    @Provides
    @AppScope
    fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @AppScope
    fun provideUIThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @AppScope
    fun provideDatabase(context: Context): Database {
        return Room.databaseBuilder(context, Database::class.java, "database.db")
                .fallbackToDestructiveMigration().build()
    }
}