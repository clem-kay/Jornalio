package org.amalitech.jornalio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Activity_poster extends Activity {
    //initialise the relativelayouts
    RelativeLayout activity_inputer_parent_id_rl;

    //initialise the button
    Button bttn_new_post;

    //intialise the cancel button
    ImageView iv_img_cancel;

    Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_poster);

        ctx=Activity_poster.this;

        //now reference all the elements in the UI
        activity_inputer_parent_id_rl =(RelativeLayout)findViewById(R.id.activity_inputer_parent_id);

        bttn_new_post=(Button)findViewById(R.id.base_bttn_0);

        iv_img_cancel = (ImageView)findViewById(R.id.iv_img_cancel);

        bttn_new_post.setText(getResources().getString(R.string.new_post));

        for(int x=0; x<3; x++) {

            //because we are in the Activity_MainNewsPage,
            //turn off all the views under the tv except
            //the first one.
            if(x==1){//trending
                nav_V(3, "nav_v_", x).setVisibility(View.VISIBLE);
            }else{
                nav_V(3, "nav_v_", x).setVisibility(View.INVISIBLE);
            }

        }
        for(int i=0;i<3;i++){

            if (i==0){
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
                                Intent activity_Post_intent = new Intent(Activity_poster.this, Activity_MainNewsPage.class);
                                startActivity(activity_Post_intent);

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

            if(i==2){

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
                                Intent activity_Post_intent = new Intent(Activity_poster.this, Activity_Profile.class);
                                startActivity(activity_Post_intent);

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

        bttn_new_post.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(v.getId()==bttn_new_post.getId()) {
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
                            //check the parent layout and if it is
                            //not visible, make it visible.
                            if( !activity_inputer_parent_id_rl.isShown() ) {
                                activity_inputer_parent_id_rl.setVisibility(View.VISIBLE);
                            }

                            break;
                        }
                        case MotionEvent.ACTION_MOVE:{

                            //finger moved : deactivate the whole action

                            break;
                        }
                    }
                }

                return true;
            }
        });

        iv_img_cancel.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(v.getId()==iv_img_cancel.getId()) {
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
                            //check the parent layout and if it is
                            //not visible, make it visible.
                            if( activity_inputer_parent_id_rl.isShown() ) {
                                activity_inputer_parent_id_rl.setVisibility(View.GONE);
                            }

                            break;
                        }
                        case MotionEvent.ACTION_MOVE:{

                            //finger moved : deactivate the whole action

                            break;
                        }
                    }
                }

                return true;
            }
        });

    }

    private View nav_V(int total_num_i, String prefix_str, int v_i) {
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

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
    }

    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        super.onRestart();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        if(activity_inputer_parent_id_rl.isShown()) {
            activity_inputer_parent_id_rl.setVisibility(View.GONE);
        }else {
            super.onBackPressed();
        }
    }

}

