package io.github.oceanhuang.bankoo;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.Iterator;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        findViewById(R.id.back_to_browser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String jsonString = "{\n" +
                        "\t\"networkTokenizedCardResponse\": {\n" +
                        "\t\t\"cardholderName\": \"First Last\",\n" +
                        "\t\t\"cardToken\": \"1234567890123456\",\n" +
                        "\t\t\"tokenProviderURL\": \"https://www.masterpass.com/masterpass\",\n" +
                        "\t\t\"tokenExpiryDate\": \"12-22\",\n" +
                        "\t\t\"cryptogram\": \"0064F1DEAB336112C600048DE908B602005514\",\n" +
                        "\t\t\"lastFourOfFPAN\": \"1234\",\n" +
                        "\t\t\"trid\": \"50100000000\",\n" +
                        "\t\t\"typeOfCryptogram\": \"UCAF\"\n" +
                        "\t}\n" +
                        "}";

                Intent result = new Intent();
                Bundle extras = new Bundle();
                extras.putString("methodName", "bankoo");
                extras.putString("details", jsonString);

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
