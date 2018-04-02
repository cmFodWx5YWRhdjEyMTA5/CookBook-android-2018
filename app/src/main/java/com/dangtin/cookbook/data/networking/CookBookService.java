/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.data.networking;

import com.dangtin.cookbook.BuildConfig;
import com.dangtin.cookbook.constant.Constant;
import com.dangtin.cookbook.constant.KeyAPI;
import com.dangtin.cookbook.data.models.Food;
import com.dangtin.cookbook.data.models.response.ApiSuccess;
import com.dangtin.cookbook.data.models.response.CategoryResponse;
import com.dangtin.cookbook.data.models.response.FoodResponse;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import io.realm.annotations.Ignore;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface CookBookService {

    class Creator {
        public static Retrofit newRetrofitInstance() {
            OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();
            okBuilder.readTimeout(30, TimeUnit.SECONDS);
            okBuilder.connectTimeout(30, TimeUnit.SECONDS);
            okBuilder.retryOnConnectionFailure(true);
            okBuilder.addInterceptor(chain -> {
                Request original = chain.request();
                Request.Builder builder = original.newBuilder();
                builder.header(KeyAPI.KEY_DEVICE_TYPE, KeyAPI.VALUE_DEVICE_TYPE)
                        .header(KeyAPI.KEY_HTTP_X_APP_ID, KeyAPI.VALUE_HTTP_X_APP_ID)
                        .header(KeyAPI.KEY_HTTP_X_SECRET_KEY, KeyAPI.VALUE_HTTP_X_SECRET_KEY)
                        .method(original.method(), original.body());
                return chain.proceed(builder.build());
            });
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                okBuilder.addInterceptor(interceptor);
            }
            Gson gson = new GsonBuilder()
                    .addDeserializationExclusionStrategy(new ExclusionStrategy() {
                        @Override
                        public boolean shouldSkipField(FieldAttributes f) {
                            return f.getAnnotation(Ignore.class) != null;
                        }

                        @Override
                        public boolean shouldSkipClass(Class<?> clazz) {
                            return false;
                        }
                    }).setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .create();

            return new Retrofit.Builder()
                    .baseUrl(Constant.HOST)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okBuilder.build())
                    .build();
        }
    }

    @GET("food.json")
    Observable<FoodResponse> getFood(@Header(KeyAPI.KEY_HTTP_X_API_TOKEN) String token,
                                     @Query("page") int page);

    @GET("keisuke/shops_list.json")
    Observable<CategoryResponse> getListCategory();

    @FormUrlEncoded
    @POST("auth/fbconnect.json")
    Observable<ApiSuccess> postLikeFood(@Header(KeyAPI.KEY_HTTP_X_API_TOKEN) String token,
                                        @Field("id") int id);
}
