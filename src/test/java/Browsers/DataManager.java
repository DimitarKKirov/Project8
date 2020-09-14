package Browsers;

public class DataManager {
    private LillyDataReader jsonDataReader;
    private EmagDataReader emagDataReader;
    private EmagGmailDataReader emagGmailDataReader;
    public LillyDataReader jsonDataReader() {
        if (jsonDataReader == null) {
            jsonDataReader = new LillyDataReader();
            return jsonDataReader;
        } else {
            return jsonDataReader;
        }
    }
    public EmagDataReader emagDataReader() {
        if (emagDataReader == null) {
            emagDataReader = new EmagDataReader();
            return emagDataReader;
        } else {
            return emagDataReader;
        }
    }
    public EmagGmailDataReader emagGmailDataReader() {
        if (emagGmailDataReader == null) {
            emagGmailDataReader = new EmagGmailDataReader();
            return emagGmailDataReader;
        } else {
            return emagGmailDataReader;
        }
    }
}
