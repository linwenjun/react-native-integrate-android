package com.awesomeproject;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class JNIntentModule extends ReactContextBaseJavaModule {

    public JNIntentModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "jnIntentModule";
    }

    @ReactMethod
    public void fetchProps(Callback successBack, Callback errorBack ) {
        try {
            Activity currentActivity = getCurrentActivity();
            String result = currentActivity.getIntent().getStringExtra("data");
            if (TextUtils.isEmpty(result)) {
                result = "";
            }
            successBack.invoke(result);
        } catch (Exception e) {
            errorBack.invoke(e.getMessage());
        }
    }

    @ReactMethod
    public void goNative(String data) {
        Toast.makeText(getReactApplicationContext(), data + "", Toast.LENGTH_SHORT).show();
        getCurrentActivity().startActivity(new Intent(getCurrentActivity(), HomeActivity.class));
        getCurrentActivity().finish();
        getCurrentActivity().overridePendingTransition(0, 0);
    }
}
