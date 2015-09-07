package com.techipost.imageslider;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class SliderActivity extends Activity {
	
	public int currentimageindex=0;
	Timer timer;
	TimerTask task;
	ImageView slidingimage;
    public int count = 0;
    public int time =0;
	
	private int[] IMAGE_IDS = {
			 R.drawable.splash1, R.drawable.splash2,
			R.drawable.splash3
		};
	
	
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mygame);
        final RelativeLayout layout =(RelativeLayout)findViewById(R.id.img);
        layout.setBackgroundResource(R.drawable.splash2);
        final Handler mHandler = new Handler();


        Calendar c = Calendar.getInstance();
        int minute = c.get(Calendar.MINUTE);
        minute = minute % 10;

        if (minute >5)
        {
            time = 10- minute;
        }
        else
           time = 5- minute;





        // Create runnable for posting
        final Runnable mUpdateResults = new Runnable() {
            public void run() {

                if ( count == 0)
                {
                    layout.setBackgroundResource(R.drawable.splash2);
                    count++;
                }
                else if (count == 1)
                {
                    layout.setBackgroundResource(R.drawable.splash1);
                    count++;
                }
                else if (count == 2)
                {
                    layout.setBackgroundResource(R.drawable.splash3);
                    count++;
                }
                else if (count == 3)
                    count = 0;
            //	AnimateandSlideShow();
            	
            }
        };
		
        int delay = 1000; // delay for 1 sec.

        int period = 100000000; // repeat every 10 sec.

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

        public void run() {

        	 mHandler.post(mUpdateResults);

        }

        }, delay, period);
        
		 
		       
    }

    public void onClick(View v) {
    
     //   finish();
     //   android.os.Process.killProcess(android.os.Process.myPid());
      }
    
    /**
     * Helper method to start the animation on the splash screen
     */
  /*  private void AnimateandSlideShow() {
    	
    	
    	slidingimage = (ImageView)findViewById(R.id.ImageView3_Left);
   		slidingimage.setImageResource(IMAGE_IDS[currentimageindex % IMAGE_IDS.length]);
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH ){
            slidingimage.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        }
        else if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB )
            slidingimage.setSystemUiVisibility( View.STATUS_BAR_HIDDEN );
        else{}
       // slidingimage.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
       // slidingimage.setAdjustViewBounds(true);
   		
   		currentimageindex++;
    	

      //  Animation rotateimage = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
    	  
        
    	//  slidingimage.startAnimation(null);
          
          	 
        
    }*/
    
     
    
    
}