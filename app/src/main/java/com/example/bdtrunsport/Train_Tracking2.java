package com.example.bdtrunsport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.animation.LayoutTransition;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Train_Tracking2 extends AppCompatActivity {
    Button sendBtn;
    TextInputEditText etPhoneNo,etEnterSMS;
    TextView detailsText,detailsText2,detailsText3,detailsText4,detailsText5,detailsText6,detailsText7;
    LinearLayout expandLayout,expandLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_tracking2);

        detailsText = findViewById(R.id.details);
        detailsText2 = findViewById(R.id.details2);
        detailsText3 = findViewById(R.id.details3);
        detailsText4 = findViewById(R.id.details4);
        detailsText5 = findViewById(R.id.details5);
        detailsText6 = findViewById(R.id.details6);
        detailsText7 = findViewById(R.id.details7);


        expandLayout = findViewById(R.id.expandLayout);
        expandLayout2 = findViewById(R.id.expandLayout2);

        expandLayout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        expandLayout2.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        etPhoneNo = (TextInputEditText) findViewById(R.id.phoneNo);
        etEnterSMS = (TextInputEditText) findViewById(R.id.etEnterSMS);
        sendBtn = (Button) findViewById(R.id.sendBtn);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(Train_Tracking2.this
                        , Manifest.permission.SEND_SMS)
                        == PackageManager.PERMISSION_GRANTED){
                    sendMessage();
                }else {
                    ActivityCompat.requestPermissions(Train_Tracking2.this,
                            new String[]{Manifest.permission.SEND_SMS},100);
                }
            }
        });

    }

    private void sendMessage() {
        String sPhone = etPhoneNo.getText().toString().trim();
        String sMessage = etEnterSMS.getText().toString().trim();

        if ( !sPhone.equals("") && !sMessage.equals("")){
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(sPhone,null,sMessage,
                    null,null);
            Toast.makeText(getApplicationContext(), "SMS sent successfully!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(), "Enter Information.", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100 && grantResults.length > 0 && grantResults[0]
                == PackageManager.PERMISSION_GRANTED){
            sendMessage();
        }else {
            Toast.makeText(getApplicationContext(), "Permission Denied!", Toast.LENGTH_SHORT).show();
        }
    }

    public void expand(View view) {

        int a = (detailsText.getVisibility() == View.GONE)? View.VISIBLE : View.GONE;
        TransitionManager.beginDelayedTransition(expandLayout,new AutoTransition());
        detailsText.setVisibility(a);
        int b = (detailsText2.getVisibility() == View.GONE)? View.VISIBLE : View.GONE;
        TransitionManager.beginDelayedTransition(expandLayout,new AutoTransition());
        detailsText2.setVisibility(b);
        int c = (detailsText3.getVisibility() == View.GONE)? View.VISIBLE : View.GONE;
        TransitionManager.beginDelayedTransition(expandLayout,new AutoTransition());
        detailsText3.setVisibility(c);
    }

    public void expand2(View view) {

        int d = (detailsText4.getVisibility() == View.GONE)? View.VISIBLE : View.GONE;
        TransitionManager.beginDelayedTransition(expandLayout,new AutoTransition());
        detailsText4.setVisibility(d);
        int e = (detailsText5.getVisibility() == View.GONE)? View.VISIBLE : View.GONE;
        TransitionManager.beginDelayedTransition(expandLayout,new AutoTransition());
        detailsText5.setVisibility(e);
        int f = (detailsText6.getVisibility() == View.GONE)? View.VISIBLE : View.GONE;
        TransitionManager.beginDelayedTransition(expandLayout,new AutoTransition());
        detailsText6.setVisibility(f);
        int g = (detailsText7.getVisibility() == View.GONE)? View.VISIBLE : View.GONE;
        TransitionManager.beginDelayedTransition(expandLayout,new AutoTransition());
        detailsText7.setVisibility(g);
    }
}
