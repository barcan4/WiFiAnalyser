package barcan.florin.wifianalyser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import barcan.florin.wifianalyser.Model.WiFiPoint;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        WiFiPoint wiFiPoint = (WiFiPoint) getIntent().getSerializableExtra("WIFI_POINT");
        Toast.makeText(ItemActivity.this, "Got wifi point " + wiFiPoint.getSSID(), Toast.LENGTH_LONG).show();

        TextView ssid = findViewById(R.id.ssid);
        TextView bssid = findViewById(R.id.bssid);
        TextView strength = findViewById(R.id.strength);
        TextView frequency = findViewById(R.id.frequency);
        TextView channel = findViewById(R.id.channel);
        TextView security = findViewById(R.id.security);

        ssid.setText("SSID: " + wiFiPoint.getSSID());
        bssid.setText("MAC Address: " + wiFiPoint.getMACAddress());
        strength.setText("Signal Strength: " + wiFiPoint.getStrength());
        frequency.setText("Frequency: " + wiFiPoint.getFrequency());
        channel.setText("Channel used: " + wiFiPoint.getChannel());
        security.setText("Security: " + wiFiPoint.getSecurity());
    }
}