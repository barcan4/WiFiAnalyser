package barcan.florin.wifianalyser.Repository;

import java.util.List;

import barcan.florin.wifianalyser.Model.WiFiPoint;

public class WiFiPointRepository {
    private List<WiFiPoint> wiFiPointList;

    public WiFiPointRepository(List<WiFiPoint> wiFiPointList) {
        this.wiFiPointList = wiFiPointList;
    }

    public List<WiFiPoint> getWiFiPointList() {
        return wiFiPointList;
    }

    public void setWiFiPointList(List<WiFiPoint> wiFiPointList) {
        this.wiFiPointList = wiFiPointList;
    }
}
