package com.studying.bettamovies.data;

import android.net.Uri;

import com.studying.bettamovies.db.models.MovieDetailEntity;
import com.studying.bettamovies.db.models.MovieItemEntity;
import com.studying.bettamovies.models.DetailsMovie;
import com.studying.bettamovies.models.ItemMovie;
import com.studying.bettamovies.network.ApiService;
import com.studying.bettamovies.network.models.FilmDetailsRequest;
import com.studying.bettamovies.network.models.ItemMovieRequest;
import com.studying.bettamovies.network.models.RequestModel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import javax.xml.validation.Validator;

public final class ModelConverter {
    private ModelConverter() {
    }

    private static ArrayList<ItemMovie> resultList = new ArrayList<>();

    @NotNull
    public static List<ItemMovie> convertRequestModelToItemModel_List(@Nullable RequestModel requestModel) {
        resultList.clear();
        if (requestModel != null && !requestModel.getItemMovieRequests().isEmpty()) {

            for (ItemMovieRequest itemMovieRequest : requestModel.getItemMovieRequests()) {

                resultList.add(
                        new ItemMovie(
                                itemMovieRequest.getTitle(),
                                Uri.parse(ApiService
                                        .INSTANCE
                                        .getImageUrl(
                                                ValidatorKt
                                                        .validUri(itemMovieRequest.getPosterURL())
                                        )
                                ),
                                Integer.parseInt(itemMovieRequest.getNetId())
                        )
                );
            }
        }
        return resultList;
    }

    @NotNull
    public static List<ItemMovie> convertMovieItemEntityToItemModel_List(@NotNull List<MovieItemEntity> movieItemEntityList) {
        resultList.clear();
        if (!movieItemEntityList.isEmpty()) {
            for (MovieItemEntity movieItemEntity : movieItemEntityList) {
                resultList.add(
                        new ItemMovie(
                                movieItemEntity.getTitle(),
                                Uri.parse(ApiService
                                        .INSTANCE
                                        .getImageUrl(
                                                ValidatorKt
                                                        .validUri(movieItemEntity.getPosterURL())
                                        )
                                ),
                                movieItemEntity.getNetId()
                        )
                );
            }
        }
        return resultList;
    }

    public static DetailsMovie convertMovieDetailsEntityToDetailsMovie(@NotNull MovieDetailEntity movieDetailsEntity) {
        Uri backdropURL = Uri.parse(ApiService.INSTANCE.getImageUrl(ValidatorKt.validUri(movieDetailsEntity.getPoster_path())));
        return new DetailsMovie(
                ValidatorKt.validateInputData(movieDetailsEntity.getPopularity()),
                ValidatorKt.validateInputData(movieDetailsEntity.getReleaseDate()),
                ValidatorKt.validateInputData(movieDetailsEntity.getRuntime()),
                ValidatorKt.validateInputData(movieDetailsEntity.getGenres()),
                ValidatorKt.validateInputData(movieDetailsEntity.getBudget()),
                ValidatorKt.validateInputData(movieDetailsEntity.getOverview()),
                ValidatorKt.validateInputData(movieDetailsEntity.getHomepage()),
                backdropURL,
                ValidatorKt.validateInputData(movieDetailsEntity.getOriginalLanguage()),
                ValidatorKt.validateInputData(movieDetailsEntity.getOriginalTitle()),
                ValidatorKt.validateInputData(movieDetailsEntity.getAdult()),
                ValidatorKt.validateInputData(movieDetailsEntity.getProductionCompanies()),
                ValidatorKt.validateInputData(movieDetailsEntity.getSpokenLanguages()),
                movieDetailsEntity.getNetId()
        );

    }

    @NotNull
    public static DetailsMovie convertFilmDetailsRequestToDetailsMovie(@NotNull FilmDetailsRequest filmDetailsRequest) {
        return null;
    }
}
