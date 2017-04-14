package com.louishoang.octopus;

import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.json.*;
import com.loopj.android.http.*;

import cz.msebera.android.httpclient.Header;

/**
 * Created by louishoang on 4/7/17.
 */

public class LoginActivity extends AppCompatActivity {
  private EditText mUsernameField;
  private EditText mPasswordField;
  private String mUsername;
  private String mPassword;
  private Button mLoginButton;
  private TextView mNotificationText;
  private static final String TAG = LoginActivity.class.getSimpleName();

  static class LoginModel {
    public final String username;

  }
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    mUsernameField = (EditText)findViewById(R.id.username);
    mPasswordField = (EditText)findViewById(R.id.password);
    mLoginButton = (Button)findViewById(R.id.login_button);
    mNotificationText = (TextView)findViewById(R.id.notification_text);

    mLoginButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        mUsername = mUsernameField.getText().toString();
        mPassword = mPasswordField.getText().toString();

        if(mUsername.equals("") || mPassword.equals("")){
          mNotificationText.setText(R.string.enter_username_password);
          mNotificationText.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.alertDanger));
          return;
        }

        mNotificationText.setText("Logging in...");

        RequestParams params = new RequestParams();

        Map<String, String> user = new HashMap<String, String>();
        user.put("mail", mUsername);
        user.put("password", mPassword);
        params.put("user", user);


        OctopusClient.post("/users/sign_in", params, new JsonHttpResponseHandler(){

          @Override
          public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
            super.onSuccess(statusCode, headers, response);
          }

          @Override
          public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
            mNotificationText.setText(R.string.enter_username_password);
            super.onFailure(statusCode, headers, responseString, throwable);
          }
        });
      }
    });
  }
}
