package com.example.notetaker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private boolean isInEditMode = true;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Button saveButton = (Button)findViewById(R.id.saveButton);
		
		saveButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText titleEditText = (EditText)findViewById(R.id.titleEditText);
				EditText noteEditText = (EditText)findViewById(R.id.noteEditText);
				
				if(isInEditMode){
					isInEditMode = false;
					saveButton.setText("Edit");
					titleEditText.setEnabled(false);
					noteEditText.setEnabled(false);
					
					TextView dateTextView = (TextView)findViewById(R.id.dateTextView);
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
					String date = dateFormat.format(Calendar.getInstance().getTime());
					dateTextView.setText(date);
					
				}
				
				else
				{
					isInEditMode = true;
					saveButton.setText("Save");
					titleEditText.setEnabled(true);
					noteEditText.setEnabled(true);
							
				}
			}
		});
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	

}
