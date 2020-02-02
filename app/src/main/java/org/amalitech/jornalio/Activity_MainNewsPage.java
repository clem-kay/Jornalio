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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static java.security.AccessController.getContext;

public class Activity_MainNewsPage extends Activity {
    Context ctx;

    TextView news_hd,news_details;
    RelativeLayout activity_outputer_id;
    ImageView iv_img_cancel;
    Button base_bttn_sv_1,base_bttn_sv_0;
    EditText et_outputer;

    boolean doubleBackToExitPressedOnce=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__main_news_page);
        ctx = Activity_MainNewsPage.this;

        news_hd = (TextView)findViewById(R.id.news_hd);
        news_details = (TextView)findViewById(R.id.news_detail);
        activity_outputer_id = (RelativeLayout) findViewById(R.id.activity_outputer_id);
        iv_img_cancel = (ImageView)findViewById(R.id.iv_img_cancel);
        base_bttn_sv_0 = (Button)findViewById(R.id.base_bttn_sv_0);
        base_bttn_sv_1 = (Button)findViewById(R.id.base_bttn_sv_1);
        et_outputer = (EditText)findViewById(R.id.et_outputer);

        //setting text for the base buttons in the news viewer
        base_bttn_sv_0.setText(getResources().getString(R.string.new_comment));
        base_bttn_sv_1.setText(getResources().getString(R.string.view_comment));

        //disabling the news viewer activity during loading of the mai news area;
        activity_outputer_id.setVisibility(View.GONE);


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
        nav_TV(2, "outputer_tv_" , 0).setText("Developer Gets $72.8 Billion");
        nav_TV(2, "outputer_tv_" , 1).setText("\n\nEarlier today, the 4 young"
                + "Ghanaina Developers closed a deal with Sundai Pichai"
                + " of Google for aldafjalkdjfak oi joaidjfo "
                + "ijofaidjoaisdpfoia fyuao ojaodifh ayf9a8dfuoie"
                + "ruqoieroqi hodosifjoa ijfaoidjfo aidfjoaijdpofi"
                + "ajofdijaodfij oijsdoifjo josdijfoijdfajdlfk lask"
                + "jdf ajdfjaoidaohdfiuahdifhqejrkajf;akdhfoahdfoaid "
                + "Earlier today, the 4 young Ghanaina Developers closed "
                + "a deal with Sundai Pichai of Google for aldafjalkdjfak "
                + "oi joaidjfo");

        base_bttn_sv_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_outputer.getText().toString().trim().equals(null)){
                    //Displays an error message

                }
                else
                {
                    nav_TV(2, "outputer_tv_" , 1).setText(nav_TV(2, "outputer_tv_" , 1).getText().toString()+"  "+
                            "\n\n"+et_outputer.getText().toString().trim());

                    //clearing the content of the comment section
                    et_outputer.setText(null);
                }
            }
        });

        for(int i=0; i<3; i++) {
            relative_rl(3, "nav_rl_", i).setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    for(int j=0; j<3; j++) {

                        if(v.getId()==relative_rl(3, "nav_rl_", j).getId()) {
                            switch (event.getActionMasked()){

                                case MotionEvent.ACTION_DOWN:
                                case MotionEvent.ACTION_POINTER_DOWN: {
                                    //change color or background  ( new )
                                    relative_rl(3, "nav_rl_", j).setBackgroundColor(Color.parseColor("#e8ffc4"));
                                    break;
                                }
                                case MotionEvent.ACTION_UP:
                                case MotionEvent.ACTION_POINTER_UP: {

                                    switch(j) {
                                        //change color to default
                                        case 0:
                                            //we are right here . . .dont do anything
                                            break;
                                        case 1:
                                            //do the action
                                            Intent activity_Post_intent = new Intent(Activity_MainNewsPage.this, Activity_poster.class );
                                            startActivity(activity_Post_intent);
                                            break;
                                        case 2:
                                            //this should take us to "My Profile"
                                            Intent activity_Profile_intent = new Intent(Activity_MainNewsPage.this, Activity_Profile.class );
                                            startActivity(activity_Profile_intent);
                                            break;
                                        default:
                                            //DO NOTHING . . .
                                            break;

                                    }
                                    break;
                                }
                                case MotionEvent.ACTION_MOVE:{

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

        news_hd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!activity_outputer_id.isShown()){
                    activity_outputer_id.setVisibility(View.VISIBLE);
                }
            }
        });
        news_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!activity_outputer_id.isShown()){
                    activity_outputer_id.setVisibility(View.VISIBLE);
                }
            }
        });

        iv_img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(activity_outputer_id.isShown()){
                    activity_outputer_id.setVisibility(View.GONE);
                }
            }
        });


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
