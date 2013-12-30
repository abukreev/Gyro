package com.example.firstapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class MyView extends View {

	private Paint _paint;
	float _cx = 0.f;
	float _cy = 0.f;
	final float MaxG = 10.0f;
	
	public MyView(Context context) {
		super(context);
		_paint = new Paint();
	}	

	@SuppressLint("DrawAllocation")
	protected void onDraw(Canvas canvas) {
	    super.onDraw(canvas);
	    final Rect bounds = canvas.getClipBounds();
	    float x = _cx * bounds.width()  / 2.0f + bounds.centerX();
	    float y = _cy * bounds.height() / 2.0f + bounds.centerY();
	    System .err.println("x: " + x + "; y: " + y);
	    _paint.setColor(Color.RED);
	    canvas.drawCircle(x, y, 10, _paint);
	    _paint.setColor(Color.BLACK);
	    canvas.drawText("" + _cx + ":" + _cy, 5, 20, _paint);
	}
	
	public void setCoords(float x, float y) {
		_cx = Math.min(x, MaxG) / MaxG;
		_cy = Math.min(y, MaxG) / MaxG;
	    System .err.println("_x: " + _cx + "; _y: " + _cy);
	}
}
