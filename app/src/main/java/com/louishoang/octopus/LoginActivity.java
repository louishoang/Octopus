package com.louishoang.octopus;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by louishoang on 4/7/17.
 */

public class LoginActivity extends AppCompatActivity {
  private EditText mUsernameField;
  private EditText mPasswordField;
  private Button mLoginButton;
  private TextView mNotificationText;
  private static final String TAG = LoginActivity.class.getSimpleName();

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
        if(mUsernameField.getText().toString().equals("") || mPasswordField.getText().toString().equals("")){
          mNotificationText.setText(R.string.enter_username_password);
          mNotificationText.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.alertDanger));
          return;
        }


      }
    });
  }
}
