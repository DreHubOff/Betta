package com.studying.bettamovies.models;

import com.studying.bettamovies.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Loader {
    private final int animationId = R.raw.loading_anim;
    private Disposable disposable = null;
    private OnLoadingStartListener onLoadingStartListener;

    public Loader(OnLoadingStartListener onLoadingStartListener) {
        this.onLoadingStartListener = onLoadingStartListener;
    }

    public int getAnimationId() {
        return animationId;
    }

    public void startLoadingDelay(int delay) {
        disposable = Single.just(true)
                .delay(delay, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((s) -> {
                    if (onLoadingStartListener != null) {
                        onLoadingStartListener.onLoadingStart();
                    }
                }, error -> {/*Do nothing*/});
    }

    public void unActiveDelay() {
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public interface OnLoadingStartListener {
        void onLoadingStart();
    }
}
