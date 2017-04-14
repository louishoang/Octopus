package com.louishoang.octopus;
import com.loopj.android.http.*;

/**
 * Created by louishoang on 4/7/17.
 */

public class OctopusClient {
  private static final String BASE_URL = "http://10.10.10.51:3000";
//  Volley, GJSON

  private static AsyncHttpClient sClient = new AsyncHttpClient();

  public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler){
    sClient.get(getAbsoluteUrl(url), params, responseHandler);
  }

  public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler){
    sClient.post(getAbsoluteUrl(url), params, responseHandler);
  }

  private static String getAbsoluteUrl(String relativeUrl) {
    return BASE_URL + relativeUrl;
  }
}
