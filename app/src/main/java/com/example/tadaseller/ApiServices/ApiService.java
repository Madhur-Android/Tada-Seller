package com.example.tadaseller.ApiServices;

import com.example.tadaseller.AppModals.SellerForgotPassword;
import com.example.tadaseller.AppModals.SellerLogin;
import com.example.tadaseller.AppModals.SellerSignUp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("user-login")
    Call<SellerLogin> loginSeller(
            @Field("email") String email,
            @Field("password") String password);

    @FormUrlEncoded
    @POST("user-registration")
    Call<SellerSignUp> signUpSeller(
            @Field("user_name") String userName,
            @Field("user_email") String email,
            @Field("user_password") String password,
            @Field("role") String role);

    @FormUrlEncoded
    @POST("change-password")
    Call<SellerForgotPassword> forgotSeller(
            @Field("email")String email);

//    @FormUrlEncoded
//    @POST("add-product")
//    Call<AddProductResponse> addProduct(
//            @Field("product_name")String product_name,
//            @Field ("description")String description,
//            @Field("price")String price,
//            @Field("color")String color,
//            @Field("size")String size,
//            @Field("quantity")String quantity,
//            @Field("category")String category,
//            @Field("product_type")String product_type,
//            @Field("image1")String image1,
//            @Field("image2")String image2,
//            @Field("image3")String image3,
//            @Field("image4")String image4);

}
