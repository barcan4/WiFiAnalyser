package barcan.florin.wifianalyser.Model;

import java.io.Serializable;

public class WiFiPoint implements Serializable {
    private String SSID;
    private String MACAddress;
    private String strength;
    private String channel;
    private String frequency;
    private String security;

    public WiFiPoint(String ssid, String macAddress, String strength, String channel, String frequency, String security) {
        SSID = ssid;
        MACAddress = macAddress;
        this.strength = strength;
        this.channel = channel;
        this.frequency = frequency;
        this.security = security;
    }

    public String getSSID() {
        return SSID;
    }

    public void setSSID(String SSID) {
        this.SSID = SSID;
    }

    public String getMACAddress() {
        return MACAddress;
    }

    public void setMACAddress(String MACAddress) {
        this.MACAddress = MACAddress;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    @Override
    public String toString() {
        return "WiFiPoint{" +
                "SSID='" + SSID + '\'' +
                ", MACAddress='" + MACAddress + '\'' +
                ", strength='" + strength + '\'' +
                ", channel='" + channel + '\'' +
                ", frequency='" + frequency + '\'' +
                ", security='" + security + '\'' +
                '}';
    }
}
