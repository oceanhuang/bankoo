package io.github.oceanhuang.bankoo;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        findViewById(R.id.back_to_browser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent result = new Intent();
                Bundle extras = new Bundle();
                extras.putString("methodName", "bankoo");
                extras.putString("details", "1234");
                result.putExtras(extras);

                setResult(RESULT_OK, result);  // Change to RESULT_CANCELED on failure.
                finish();  // Close the payment activity.
            }
        });

        Intent intent = getIntent();
        String merchantName = intent.getStringExtra("merchantName");
        String total = intent.getStringExtra("total");
        String customData = intent.getStringExtra("data");
        TextView v = (TextView) findViewById(R.id.json_content);
        v.setText(
                "merchantName: " + merchantName + "\n" +
                "total: " + total + "\n" +
                "customData: " + customData
        );
    }
}
