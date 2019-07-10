package com.baijiayun.www.payutils.api;

import com.baijiayun.www.payutils.config.HttpUrlConfig;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface BasicsApiService {
    @FormUrlEncoded
    @POST(HttpUrlConfig.LOGINFURL)
    Observable<String> UserRegist(@FieldMap Map<String, String> map);
}
