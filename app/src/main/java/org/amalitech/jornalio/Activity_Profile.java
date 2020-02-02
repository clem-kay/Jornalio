package org.amalitech.jornalio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
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
        for (int i = 0; i < 3; i++) {
            relative_rl(3, "nav_rl_", i).setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    for (int j = 0; j < 3; j++) {

                        if (v.getId() == relative_rl(3, "nav_rl_", j).getId()) {
                            switch (event.getActionMasked()) {

                                case MotionEvent.ACTION_DOWN:
                                case MotionEvent.ACTION_POINTER_DOWN: {
                                    //change color or background  ( new )
                                    relative_rl(3, "nav_rl_", j).setBackgroundColor(Color.parseColor("#e8ffc4"));
                                    break;
                                }
                                case MotionEvent.ACTION_UP:
                                case MotionEvent.ACTION_POINTER_UP: {

                                    switch (j) {
                                        //change color to default
                                        case 0:
                                            //Take us to the main news page
                                            Intent activity_Main_intent = new Intent(Activity_Profile.this, Activity_MainNewsPage.class);
                                            startActivity(activity_Main_intent);
                                            break;
                                        case 1:
                                            //do the action
                                            Intent activity_Poster_intent = new Intent(Activity_Profile.this, Activity_poster.class);
                                            startActivity(activity_Poster_intent);
                                            break;
                                        case 2:
                                            //this should take us to "My Profile"

                                            break;
                                        default:
                                            //DO NOTHING . . .
                                            break;

                                    }
                                    break;
                                }
                                case MotionEvent.ACTION_MOVE: {

                                    //finger moved : deactivate the whole action
                                    relative_rl(3, "nav_rl_", j).setBackgroundColor(Color.parseColor("#6FCEFA"));
                                    break;
                                }
                            }
                        }

                    }
                    return true;
                }
            });//END OF onTouch
        }//END OF for(){...}
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
    public RelativeLayout relative_rl(int total_num_i, String prefix_str, int tv_i){

        String[] relativeview_tv_ids = new String[total_num_i];

        RelativeLayout[] relativeview_full_IDs = new RelativeLayout[total_num_i];

        relativeview_tv_ids[tv_i] = prefix_str+Integer.toString(tv_i);

        int relative_tv_ID = ctx.getResources().getIdentifier(relativeview_tv_ids[tv_i], "id", "org.amalitech.jornalio");
        relativeview_full_IDs[tv_i] = (RelativeLayout)findViewById(relative_tv_ID);

        return relativeview_full_IDs[tv_i];
    }
}