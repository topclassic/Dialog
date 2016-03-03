package com.example.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final String[] format = {"Edit Name","Delete Outlet"};
	TextView show;
	Button select;
	private Button button, button1;
	int limit;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        
        show = (TextView) findViewById(R.id.show);
        select = (Button) findViewById(R.id.select);
        select.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				numberPicker();	
			}
		});
        
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				listDialog();
			}
		});
        
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				showToast(view);
			}
		});
        
        alertDialog();
        
	}
	private void showToast(View view){
		Toast.makeText(this, "Not Outlet", Toast.LENGTH_LONG).show();
	}
	
	// numberPicker Dialog
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
	// end numberPicker Dialog
	
	// listDialog
	private void listDialog(){
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Edit Name, Delete Outlet");
        builder.setItems(format, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				if(which == 0){
					AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
					builder.setTitle("Edit Name")
						   .setMessage("YOU CAN CHOSES");
					builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
							
					}
				});
					builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
						
						
					}
				});
				builder.show();
				}// end if 1
				
				if(which == 0){
					
				}// end if 2
				
			}
		}); 
        builder.show();
	}
	
	private void alertDialog(){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Not Outlet")		
			   .setMessage("Plaese connect outlet")
			   .setIcon(R.drawable.ic_launcher);
		builder.show();
	}
		
}
