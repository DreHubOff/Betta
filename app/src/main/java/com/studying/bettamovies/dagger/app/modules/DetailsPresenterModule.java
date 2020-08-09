package com.studying.bettamovies.dagger.app.modules;

import com.studying.bettamovies.ui.details.DetailsPresenterImpl;
import com.studying.bettamovies.ui.details.interfaces.DetailsInteractor;
import com.studying.bettamovies.ui.details.interfaces.DetailsPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module(includes = DetailsInteractorModule.class)
public class DetailsPresenterModule {
    @Provides
    @Singleton
    DetailsPresenter provideDetailsPresenter(DetailsInteractor detailsInteractor) {
        return new DetailsPresenterImpl(detailsInteractor, new CompositeDisposable());
    }
}
