package org.amalitech.jornalio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class Activity_MainNewsPage extends Activity {
    Context ctx;
    int i;
    boolean doubleBackToExitPressedOnce=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__main_news_page);
        ctx = Activity_MainNewsPage.this;
        for (int x = 0; x < 3; x++) {

            //because we are in the Activity_MainNewsPage,
            //turn off all the views under the tv except
            //the first one.
            if (x == 0) {//trending
                nav_V(3, "nav_v_", x).setVisibility(View.VISIBLE);
            } else {
                nav_V(3, "nav_v_", x).setVisibility(View.INVISIBLE);
            }

        }

        for (i = 0; i < 3; i++) {
            if (i == 1) {
                nav_TV(3, "nav_tv_", i).setOnTouchListener(new View.OnTouchListener() {

                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        switch (event.getActionMasked()) {

                            case MotionEvent.ACTION_DOWN:
                            case MotionEvent.ACTION_POINTER_DOWN: {
                                //change color or background  ( new )

                                break;
                            }

                            case MotionEvent.ACTION_UP:
                            case MotionEvent.ACTION_POINTER_UP: {

                                //change color to default

                                //do the action
                                Intent i = new Intent(Activity_MainNewsPage.this, Activity_poster.class);
                                startActivity(i);

                                break;
                            }
                            case MotionEvent.ACTION_MOVE: {

                                //finger moved : deactivate the whole action

                                break;
                            }
                        }

                        return true;
                    }
                });

            }

            if (i == 2) {
                nav_TV(3, "nav_tv_", i).setOnTouchListener(new View.OnTouchListener() {

                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        switch (event.getActionMasked()) {

                            case MotionEvent.ACTION_DOWN:
                            case MotionEvent.ACTION_POINTER_DOWN: {
                                //change color or background  ( new )
                                break;
                            }

                            case MotionEvent.ACTION_UP:
                            case MotionEvent.ACTION_POINTER_UP: {

                                //change color to default

                                //do the action
                                Intent i = new Intent(Activity_MainNewsPage.this, Activity_Profile.class);
                                startActivity(i);

                                break;
                            }
                            case MotionEvent.ACTION_MOVE: {

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
        @Override
        public void onBackPressed(){
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce=false;
                }
            }, 2000);
        }

     public View nav_V(int total_num_i, String prefix_str, int v_i){

        String[] view_ids = new String[total_num_i];

        View[] view_full_IDs = new View[total_num_i];

        view_ids[v_i] = prefix_str+Integer.toString(v_i);

        int view_ID = ctx.getResources().getIdentifier(view_ids[v_i], "id", "org.amalitech.jornalio");
        view_full_IDs[v_i] = (View)findViewById(view_ID);

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
