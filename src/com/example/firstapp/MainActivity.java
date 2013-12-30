package com.example.firstapp;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity implements SensorEventListener {
	
    private SensorManager _sensorManager;
    private Sensor _accelerometer;
    private MyView view;
	
	public MainActivity() {
		super();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		view = new MyView(this);
		setContentView(view);
        _sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        _accelerometer = _sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	protected void onResume() {
        super.onResume();
        _sensorManager.registerListener(this, _accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
	
    protected void onPause() {
        super.onPause();
        _sensorManager.unregisterListener(this);
    }

    public void onSensorChanged(SensorEvent event) {
        float axisX = event.values[0];
        float axisY = event.values[1];
        float axisZ = event.values[2];
        
        System.err.println("axisX: " + axisX + "; axisY: " + axisY + "; axisZ: " + axisZ);
        
        view.setCoords(axisX, axisY);
	}

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
	}
}
