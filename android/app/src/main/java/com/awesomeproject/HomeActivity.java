package com.awesomeproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class HomeActivity extends Activity {

    private Map<Integer, String> idPageMap = new HashMap();
    {
        idPageMap.put(R.id.go_first, "FirstPage");
        idPageMap.put(R.id.go_second, "SecondPage");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void clickHandler(View source) {
        Button target  = (Button) source;
        String newPage = idPageMap.get(target.getId());
        Toast.makeText(this, newPage, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), MainActivity.class);
        intent.putExtra("data", newPage);
        startActivity(intent);
        finish();
        overridePendingTransition(0, 0);
    }
}
