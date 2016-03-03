package com.example.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	TextView show;
	Button select;
	int limit;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        
        show = (TextView) findViewById(R.id.show);
        select = (Button) findViewById(R.id.select);
        select.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		numberPicker();		
	}
	private void numberPicker(){
		NumberPicker picker = new NumberPicker(this);
		picker.setMaxValue(20000);
		picker.setMinValue(0);
		NumberPicker.OnValueChangeListener myVal = new NumberPicker.OnValueChangeListener() {			
			@Override
			public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
				//newVal is number select
				limit = newVal;
			}
		};
		picker.setOnValueChangedListener(myVal);
		AlertDialog.Builder builder = new AlertDialog.Builder(this).setView(picker);
		builder.setTitle("Select Limit");
			//	.setIcon(R.mipmap.dialog_info);
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
					show.setText(limit+"");
			}
		});
		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
			}
		});
		builder.show();
	}
}
