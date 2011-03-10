package com.android.saket.flashlight;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.android.saket.flashlight.R.color;

public class FlashLight extends Activity {
    
	private static final String TAG = "FlashLight"; 
	Button mBtnFlashLight;
	LinearLayout mLayoutFlash;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Log.v(TAG, "Inside Activity");
        mBtnFlashLight = (Button)findViewById(R.id.btnSwitch);
        mLayoutFlash = (LinearLayout)findViewById(R.id.flash_layout);
        
        
        mBtnFlashLight.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String flashStatus = mBtnFlashLight.getText().toString();
				if(flashStatus.equals("FLASH ON")){
					Log.v(TAG, "flash on");
					mBtnFlashLight.setText("FLASH OFF");
					WindowManager.LayoutParams lp = getWindow().getAttributes();
					Float prevScreenBright = lp.screenBrightness;
					Log.v(TAG, "Screen Brightness Prev: "+prevScreenBright.toString());
					
					lp.screenBrightness += 10.0f;
					
					getWindow().setAttributes(lp);
					WindowManager.LayoutParams lp_after = getWindow().getAttributes();
					Float afterScreenBright = lp_after.screenBrightness;
					Log.v(TAG, "Screen Brightness After: "+prevScreenBright.toString());
					mLayoutFlash.setBackgroundResource(color.all_white);
					
		        }else if(flashStatus.equals("FLASH OFF")){
		        	Log.v(TAG, "flash off");
		        	mBtnFlashLight.setText("FLASH ON");
		        	//mLayoutFlash.setBackgroundResource(R.color.all_black);
		        	mLayoutFlash.setBackgroundColor(0x000000);
		        }
			}
		}); 
    }
}