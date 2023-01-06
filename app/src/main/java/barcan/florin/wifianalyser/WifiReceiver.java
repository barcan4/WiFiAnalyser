package barcan.florin.wifianalyser;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import barcan.florin.wifianalyser.Model.WiFiPoint;
import barcan.florin.wifianalyser.Repository.WiFiPointRepository;

public class WifiReceiver extends BroadcastReceiver {
    WifiManager wifiManager;
    ListView listView;
    WiFiPointRepository repository;

    public WifiReceiver(WifiManager wifiManager, ListView listView) {
        this.wifiManager = wifiManager;
        this.listView = listView;
        this.repository = new WiFiPointRepository(new ArrayList<>());
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (WifiManager.SCAN_RESULTS_AVAILABLE_ACTION.equals(action)) {
            List<ScanResult> wifiList = wifiManager.getScanResults();
            ArrayList<WiFiPoint> deviceList = new ArrayList<>();

            for (ScanResult scanResult : wifiList) {
                WiFiPoint wiFiPoint = new WiFiPoint(scanResult.SSID,
                        scanResult.BSSID,
                        Integer.toString(scanResult.level),
                        Integer.toString(scanResult.channelWidth),
                        Integer.toString(scanResult.frequency),
                        scanResult.capabilities);
                deviceList.add(wiFiPoint);
            }
            repository.setWiFiPointList(deviceList);
//            Toast.makeText(context, deviceList.toString(), Toast.LENGTH_SHORT).show();
            ArrayAdapter adapter = new ArrayAdapter<WiFiPoint>(context, android.R.layout.simple_list_item_1, deviceList) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    WiFiPoint wiFiPoint = getItem(position);

                    if (convertView == null) {
                        convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
                    }

                    if (Integer.parseInt(wiFiPoint.getStrength()) > -30)
                        convertView.setBackgroundColor(Color.GREEN);
                    if (Integer.parseInt(wiFiPoint.getStrength()) <= -30 && Integer.parseInt(wiFiPoint.getStrength()) > -67)
                        convertView.setBackgroundColor(Color.BLUE);
                    if (Integer.parseInt(wiFiPoint.getStrength()) <= -67 && Integer.parseInt(wiFiPoint.getStrength()) > -70)
                        convertView.setBackgroundColor(Color.YELLOW);
                    if (Integer.parseInt(wiFiPoint.getStrength()) <= -70 && Integer.parseInt(wiFiPoint.getStrength()) > -80)
                        convertView.setBackgroundColor(Color.rgb(255,165,0));
                    if (Integer.parseInt(wiFiPoint.getStrength()) <= -80 && Integer.parseInt(wiFiPoint.getStrength()) > -90)
                        convertView.setBackgroundColor(Color.RED);
                    if (Integer.parseInt(wiFiPoint.getStrength()) <= -90)
                        convertView.setBackgroundColor(Color.GRAY);

                    TextView view = (TextView) super.getView(position, convertView, parent);
                    view.setText(getItem(position).getSSID());
                    view.setTextColor(Color.BLACK);
                    return view;
                }
            };
            listView.setAdapter(adapter);
        }
    }
}
