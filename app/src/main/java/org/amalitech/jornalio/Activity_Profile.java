package org.amalitech.jornalio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Activity_Profile extends Activity {
    Context ctx;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = Activity_Profile.this;
        setContentView(R.layout.activity_profile);
        for (int x = 0; x < 3; x++) {

            //because we are in the Activity_MainNewsPage,
            //turn off all the views under the tv except
            //the first one.
            if (x == 2) {//trending
                nav_V(3, "nav_v_", x).setVisibility(View.VISIBLE);
            } else {
                nav_V(3, "nav_v_", x).setVisibility(View.INVISIBLE);
            }

        }
        for(int i=0;i<3;i++){
            if(i==0){
                nav_TV(3,"nav_tv_",i).setOnTouchListener(new View.OnTouchListener() {

                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        switch (event.getActionMasked()){

                            case MotionEvent.ACTION_DOWN:
                            case MotionEvent.ACTION_POINTER_DOWN: {
                                //change color or background  ( new )
                                break;
                            }

                            case MotionEvent.ACTION_UP:
                            case MotionEvent.ACTION_POINTER_UP: {

                                //change color to default

                                //do the action
                                Intent i= new Intent(Activity_Profile.this, Activity_MainNewsPage.class);
                                startActivity(i);
                                break;
                            }
                            case MotionEvent.ACTION_MOVE:{

                                //finger moved : deactivate the whole action

                                break;
                            }
                        }

                        return true;
                    }
                });

            }

            if(i==1){
                nav_TV(3,"nav_tv_",i).setOnTouchListener(new View.OnTouchListener() {

                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        switch (event.getActionMasked()){

                            case MotionEvent.ACTION_DOWN:
                            case MotionEvent.ACTION_POINTER_DOWN: {
                                //change color or background  ( new )
                                break;
                            }

                            case MotionEvent.ACTION_UP:
                            case MotionEvent.ACTION_POINTER_UP: {

                                //change color to default

                                //do the action
                                Intent i= new Intent(Activity_Profile.this, Activity_poster.class );
                                startActivity(i);

                                break;
                            }
                            case MotionEvent.ACTION_MOVE:{

                                //finger moved : deactivate the whole action

                                break;
                            }
                        }

                        return true;
                    }
                });

            }

        }


    }

    public View nav_V(int total_num_i, String prefix_str, int v_i) {

        String[] view_ids = new String[total_num_i];

        View[] view_full_IDs = new View[total_num_i];

        view_ids[v_i] = prefix_str + Integer.toString(v_i);

        int view_ID = ctx.getResources().getIdentifier(view_ids[v_i], "id", "org.amalitech.jornalio");
        view_full_IDs[v_i] = (View) findViewById(view_ID);

        return view_full_IDs[v_i];
    }
    public TextView nav_TV(int total_num_i, String prefix_str, int tv_i){

        String[] textView_tv_ids = new String[total_num_i];

        TextView[] textView_full_IDs = new TextView[total_num_i];

        textView_tv_ids[tv_i] = prefix_str+Integer.toString(tv_i);

        int textView_tv_ID = ctx.getResources().getIdentifier(textView_tv_ids[tv_i], "id", "org.amalitech.jornalio");
        textView_full_IDs[tv_i] = (TextView)findViewById(textView_tv_ID);

        return textView_full_IDs[tv_i];
    }
}