package com.example.stopwatchv2;



import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button start=(Button)findViewById(R.id.button2);
	    Button pause=(Button)findViewById(R.id.pauseButton);
	    Button reset=(Button)findViewById(R.id.button4);
	    Button split=(Button)findViewById(R.id.button3);
	    final Chronometer time=(Chronometer)findViewById(R.id.chronometer1);
	    final TextView splitText=(TextView)findViewById(R.id.textView1); 
	    start.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int stoppedMilliseconds = 0;
				String chronoText = time.getText().toString();
				String array[] = chronoText.split(":");
				if (array.length == 2) 
				{
					 stoppedMilliseconds = Integer.parseInt(array[0]) * 60 * 1000 + Integer.parseInt(array[1]) * 1000;
				}
				else if (array.length == 3)
				{
					 stoppedMilliseconds = Integer.parseInt(array[0]) * 60 * 60 * 1000 + Integer.parseInt(array[1]) * 60 * 1000 + Integer.parseInt(array[2]) * 1000;
				}
				time.setBase(SystemClock.elapsedRealtime() - stoppedMilliseconds);

				time.start();	
			}
		});
	    pause.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				time.stop();
			}
		});
	    reset.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				time.setBase(SystemClock.elapsedRealtime());	
				 time.stop();
			}
		}); 
	    split.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String splitTime=time.getText().toString();
				splitText.setText(splitTime);
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
