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
    Call<SellerLogin> loginSeller(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("user-registration")
    Call<SellerSignUp> signUpSeller(@Field("user_name") String userName, @Field("user_email") String email,
                                    @Field("user_password") String password, @Field("role") String role);

    @FormUrlEncoded
    @POST("change-password")
    Call<SellerForgotPassword> forgotSeller(@Field("email")String email);

}
