package com.example.rominakehl.bildung_4_0;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by david on 19.06.17.
 */

public class measurement_activity extends AppCompatActivity {
    private Button measurements_sendInputs = null;
    private Button measurements_show3D = null;
    private EditText width1 = null;
    private EditText width2 = null;
    private EditText width3 = null;
    private EditText height1 = null;
    private EditText height2 = null;
    private EditText height3 = null;
    private EditText length1 = null;
    private EditText length2 = null;
    private EditText length3 = null;
    private JSONObject qrCode = null;

    public String transferedJson = this.getIntent().getExtras().getString("transferedJson");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        try {
            qrCode = new JSONObject(transferedJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.measurements_sendInputs = (Button) findViewById(R.id.measurements_sendInputs);
        this.measurements_show3D = (Button) findViewById(R.id.measurements_show3D);
        this.length1 = (EditText) findViewById(R.id.measurement_length1_input);
        this.length2 = (EditText) findViewById(R.id.measurement_length2_input);
        this.length3 = (EditText) findViewById(R.id.measurement_length3_input);
        this.width1 = (EditText) findViewById(R.id.measurement_width1_input);
        this.width2 = (EditText) findViewById(R.id.measurement_width2_input);
        this.width3 = (EditText) findViewById(R.id.measurement_width3_input);
        this.height1 = (EditText) findViewById(R.id.measurement_height1_input);
        this.height2 = (EditText) findViewById(R.id.measurement_height2_input);
        this.height3 = (EditText) findViewById(R.id.measurement_height3_input);
        try {
            this.length1.setHint(getExpectedLength("Schenkel1"));
            this.length2.setHint(getExpectedLength("Schenkel2"));
            this.length3.setHint(getExpectedLength("Schenkel3"));
            this.width1.setHint(getExpectedWidth("Schenkel1"));
            this.width2.setHint(getExpectedWidth("Schenkel2"));
            this.width3.setHint(getExpectedWidth("Schenkel3"));
            this.height1.setHint(getExpectedHeight("Schenkel1"));
            this.height2.setHint(getExpectedHeight("Schenkel2"));
            this.height3.setHint(getExpectedHeight("Schenkel3"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Implementation of onClick-Listener
        measurements_sendInputs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean outOfTolerance = false;
                try {
                    String lengthShank1 = getExpectedLength("Schenkel1");
                    String lengthShank2 = getExpectedLength("Schenkel2");
                    String lengthShank3 = getExpectedLength("Schenkel3");
                    String widthShank1 = getExpectedWidth("Schenkel1");
                    String widthShank2 = getExpectedWidth("Schenkel2");
                    String widthShank3 = getExpectedWidth("Schenkel3");
                    String heigthShank1 = getExpectedHeight("Schenkel1");
                    String heigthShank2 = getExpectedHeight("Schenkel2");
                    String heigthShank3 = getExpectedHeight("Schenkel3");
                    /*if (length1 < getExpectedLength("Schenkel1").substring()) {

                    }*/
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    private String getExpectedLength(String shank) throws JSONException {
        JSONObject selectedShank = qrCode.getJSONObject(shank);
        JSONObject length = selectedShank.getJSONObject("Laenge");

        Double beginning = length.getDouble("Value") - length.getDouble("ToleranzM");
        Double ending = length.getDouble("Value") + length.getDouble("ToleranzP");

        String result = beginning.toString() + "-" + ending.toString();

        return result;
    }
    private String getExpectedWidth(String shank) throws JSONException {
        JSONObject selectedShank = qrCode.getJSONObject(shank);
        JSONObject width = selectedShank.getJSONObject("Breite");

        Double beginning = width.getDouble("Value") - width.getDouble("ToleranzM");
        Double ending = width.getDouble("Value") + width.getDouble("ToleranzP");

        String result = beginning.toString() + "-" + ending.toString();

        return result;
    }
    private String getExpectedHeight(String shank) throws JSONException {
        JSONObject selectedShank = qrCode.getJSONObject(shank);
        JSONObject height = selectedShank.getJSONObject("Hoehe");

        Double beginning = height.getDouble("Value") - height.getDouble("ToleranzM");
        Double ending = height.getDouble("Value") + height.getDouble("ToleranzP");

        String result = beginning.toString() + "-" + ending.toString();

        return result;
    }
}
