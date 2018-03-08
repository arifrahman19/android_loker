package com.example.welcomebos.loker2.API;

import com.example.welcomebos.loker2.Model.Value;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Welcome Bos on 7/9/2017.
 */

public interface RegisterAPI {

    @FormUrlEncoded
    @POST("insert.php")
    Call<Value> daftar(@Field("npm") String npm,
                       @Field("nama") String nama,
                       @Field("deskripsi") String deskripsi,
                       @Field("jeniskelamin") String jeniskelamin);

    @GET("view.php")
    Call<Value> view();

    @FormUrlEncoded
    @POST("update.php")
    Call<Value> ubah(@Field("npm") String npm,
                     @Field("nama") String nama,
                     @Field("deskripsi") String deskripsi,
                     @Field("jeniskelamin") String jeniskelamin);

    @FormUrlEncoded
    @POST("delete.php")
    Call<Value> hapus(@Field("npm") String npm);


}
