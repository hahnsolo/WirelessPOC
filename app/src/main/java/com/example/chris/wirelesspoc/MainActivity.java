package com.example.chris.wirelesspoc;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText mainText;
        mainText = (EditText) findViewById(R.id.txtSignal);
        WifiManager wifi  = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        String ssid = wifi.getConnectionInfo().getSSID(); // for geting SSID
        String bssid = wifi.getConnectionInfo().getBSSID(); // for geting BSSID
        int ipAddress = wifi.getConnectionInfo().getIpAddress(); // for geting IP Address
        int rssi = wifi.getConnectionInfo().getRssi(); // for geting RSSI
        StringBuilder sb = new StringBuilder();
        sb.append("RSSI -"+rssi+"");
        mainText.setText(sb.toString());
    }

    public void update(View view){
        EditText main;
        main = (EditText) findViewById((R.id.txtSignal));
        WifiManager wifi  = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        int rssi = wifi.getConnectionInfo().getRssi();
        String ssid = wifi.getConnectionInfo().getSSID(); // for geting SSID
        String bssid = wifi.getConnectionInfo().getBSSID(); // for geting BSSID
        String poop = "RSSI : " + rssi +" SSID : "+ ssid +" BSSID : "+bssid;
        main.setText(poop);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
