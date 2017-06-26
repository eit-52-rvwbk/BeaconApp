package com.example.rominakehl.bildung_4_0;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by david on 19.06.17.
 */

public class MeasurementActivity extends AppCompatActivity {
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

    public String transferedJson;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        transferedJson = this.getIntent().getExtras().getString("transferedJson");
        try {
            qrCode = new JSONObject(transferedJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_layout);
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
                    String heightShank1 = getExpectedHeight("Schenkel1");
                    String heightShank2 = getExpectedHeight("Schenkel2");
                    String heightShank3 = getExpectedHeight("Schenkel3");
                    try {
                        if (Double.parseDouble(length1.getText().toString()) < Double.parseDouble(lengthShank1.split("-")[0])) {
                            outOfTolerance = true;
                        }
                        if (Double.parseDouble(length1.getText().toString()) > Double.parseDouble(lengthShank1.split("-")[1])) {
                            outOfTolerance = true;
                        }
                        if (Double.parseDouble(length2.getText().toString()) < Double.parseDouble(lengthShank2.split("-")[0])) {
                            outOfTolerance = true;
                        }
                        if (Double.parseDouble(length2.getText().toString()) > Double.parseDouble(lengthShank2.split("-")[1])) {
                            outOfTolerance = true;
                        }
                        if (Double.parseDouble(length3.getText().toString()) < Double.parseDouble(lengthShank3.split("-")[0])) {
                            outOfTolerance = true;
                        }
                        if (Double.parseDouble(length3.getText().toString()) > Double.parseDouble(lengthShank3.split("-")[1])) {
                            outOfTolerance = true;
                        }
                        if (Double.parseDouble(width1.getText().toString()) < Double.parseDouble(widthShank1.split("-")[0])) {
                            outOfTolerance = true;
                        }
                        if (Double.parseDouble(width1.getText().toString()) > Double.parseDouble(widthShank1.split("-")[1])) {
                            outOfTolerance = true;
                        }
                        if (Double.parseDouble(width2.getText().toString()) < Double.parseDouble(widthShank2.split("-")[0])) {
                            outOfTolerance = true;
                        }
                        if (Double.parseDouble(width2.getText().toString()) > Double.parseDouble(widthShank2.split("-")[1])) {
                            outOfTolerance = true;
                        }
                        if (Double.parseDouble(width3.getText().toString()) < Double.parseDouble(widthShank3.split("-")[0])) {
                            outOfTolerance = true;
                        }
                        if (Double.parseDouble(width3.getText().toString()) > Double.parseDouble(widthShank3.split("-")[1])) {
                            outOfTolerance = true;
                        }
                        if (Double.parseDouble(height1.getText().toString()) < Double.parseDouble(heightShank1.split("-")[0])) {
                            outOfTolerance = true;
                        }
                        if (Double.parseDouble(height1.getText().toString()) > Double.parseDouble(heightShank1.split("-")[1])) {
                            outOfTolerance = true;
                        }
                        if (Double.parseDouble(height2.getText().toString()) < Double.parseDouble(heightShank2.split("-")[0])) {
                            outOfTolerance = true;
                        }
                        if (Double.parseDouble(height2.getText().toString()) > Double.parseDouble(heightShank2.split("-")[1])) {
                            outOfTolerance = true;
                        }
                        if (Double.parseDouble(height3.getText().toString()) < Double.parseDouble(heightShank3.split("-")[0])) {
                            outOfTolerance = true;
                        }
                        if (Double.parseDouble(height3.getText().toString()) > Double.parseDouble(heightShank3.split("-")[1])) {
                            outOfTolerance = true;
                        }
                    } catch(NumberFormatException ex) {
                        Toast.makeText(((MeasurementActivity) v.getContext()), "Fehler: Ungueltige Daten eingegeben!\n", Toast.LENGTH_LONG).show();
                        return;
                    }
                    if (outOfTolerance) {
                        Toast.makeText(((MeasurementActivity) v.getContext()), "Fehler: Messwert ausserhalb der Toleranzen\n", Toast.LENGTH_LONG).show();
                    }
                    else {
                        ContentValues values = new ContentValues();
                        values.put(DataSource.COLUMN_L1, length1.getText().toString());
                        values.put(DataSource.COLUMN_L2, length2.getText().toString());
                        values.put(DataSource.COLUMN_L3, length3.getText().toString());
                        values.put(DataSource.COLUMN_H1, height1.getText().toString());
                        values.put(DataSource.COLUMN_H2, height2.getText().toString());
                        values.put(DataSource.COLUMN_H3, height3.getText().toString());
                        values.put(DataSource.COLUMN_B1,  width1.getText().toString());
                        values.put(DataSource.COLUMN_B2,  width2.getText().toString());
                        values.put(DataSource.COLUMN_B3,  width3.getText().toString());
                        values.put(DataSource.COLUMN_COLOR, qrCode.getString("Farbe"));
                        values.put(DataSource.COLUMN_CUSTOMER, qrCode.getString("Auftraggeber"));
                        DatabaseHelper dbHelper = new DatabaseHelper(v.getContext());
                        SQLiteDatabase db = dbHelper.getWritableDatabase();
                        long newRowId = db.insert(DataSource.TABLENAME, null, values);
                        Toast.makeText(((MeasurementActivity) v.getContext()), "Daten erfolgreich eingetragen!\n", Toast.LENGTH_LONG).show();
                    }
                    length1.setText("");
                    length2.setText("");
                    length3.setText("");
                    height1.setText("");
                    height2.setText("");
                    height3.setText("");
                    width1.setText("");
                    width2.setText("");
                    width3.setText("");

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
