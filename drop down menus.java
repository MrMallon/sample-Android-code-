package com.theTeaCakeProject.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;

public class Services extends Activity implements View.OnClickListener {
    ImageButton bt;
    ImageButton hc;
    ImageButton saa;
    ImageButton am;
    Button hcBt;
    Button callhc;
    Button exitSaa;
    Button callSAA;
    Button exitAm;
    ScrollView amsv, hcsv, saasv;
    LinearLayout popLayout, saaLayout, amLayout;
    PopupWindow hcWindow, saaWindow, amWindow;
    TextView hcText, hcLink, saaText, saaLinkFb, saaLink, amText, callSM, callFS, callJC;
    String hcWeb = "http://www2.ul.ie/web/WWW/Services/Student_Affairs/Student_Supports/Student_Health_Centre", saaWeb = "http://www2.ul.ie/web/WWW/Services/Student_Affairs/Student_Administration/Student_Academic_Administration/Student%20Information/Requests%20-%20Letter%2C%20Transcripts%2C%20Recheck%20Forms%2C%20Change%20of%20Address", saaFB = "https://www.facebook.com/StudentAcademicAdministration";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.services);
        btInit();
        hcInit();
        saaInit();
        amInit();
        btPopUpWindow();
        hcPopUpWindow();
        saaPopUpWindow();
        amPopUpWindow();
    }
    public void btInit()
    {
        bt = (ImageButton)findViewById(R.id.busTimes);
    }
    public void hcInit()
    {
        hc = (ImageButton) findViewById(R.id.healthCentre);
        hcText = new TextView(this);
        callhc = new Button(this);
        callhc.setText("Call Health Centre");
        callhc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel: 0860857281"));
                startActivity(call);
            }
        });
        hcText.setText("The Student Health Centre is located in C Block, Level M, Main Building.\n Prices:\n \t Doctor Consultation €25 \n \t Physiotherapist Consultation: €25 \n \t Contraceptive  Clinic: €10 \n \t Nurse Consultation €10 \n \t Blood Test: €10 \n \t STI Clinic: €30 \n \t Pregnancy Test €15 \n \n  Contact Details: \n \t  tel: +353 61 202534 \n \t  E-mail: Ria.Toland@ul.ie");
        hcText.setTextSize(20);
        hcText.setTypeface(null, Typeface.BOLD_ITALIC);
        hcText.setTextColor(Color.argb(255,255,255,255));
        hcLink = new TextView(this);
        hcLink.setTextSize(20);
        hcLink.setText("\t Click here for more information");
        hcLink.setTypeface(null, Typeface.BOLD_ITALIC);
        hcLink.setTextColor(-14714714);
        hcBt = new Button(this);
        hcBt.setText("Exit");
        popLayout = new LinearLayout(this);
        popLayout.setBackgroundColor(Color.argb(240,123,14,14));
        popLayout.setOrientation(LinearLayout.VERTICAL);
        popLayout.addView(hcText);
        popLayout.addView(hcLink);
        popLayout.addView(callhc);
        popLayout.addView(hcBt);
        hcsv = new ScrollView(this);
        hcsv.addView(popLayout);
    }
    public void saaInit()
    {
        saa = (ImageButton) findViewById(R.id.StudentAcademicAdmin);
        exitSaa = new Button(this);
        callSAA = new Button(this);
        saaText = new TextView(this);
        saaLinkFb = new TextView(this);
        saaLink = new TextView(this);
        exitSaa.setText("Exit");
        callSAA.setText("Call SAA");
        callSAA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callSaa = new Intent(Intent.ACTION_DIAL);
                callSaa.setData(Uri.parse("tel: 35361202015"));
                startActivity(callSaa);
            }
        });
        saaText.setTextColor(Color.argb(255,255,255,255));
        saaText.setText("The Student Academic Administration is located in Room E0001 in the Main Building. \n The SAA is open from: 9:30-12:30 and 2:30 to 4:30. \n The SAA deals with: \n \t Registration \n \t Requests such as letters, transcripts, recheck forms and change of address \n \t Timetables \n \t Higher Education Grants \n \t End of Semester Exams \n \t Results Information");
        saaText.setTextSize(20);
        saaText.setTypeface(null, Typeface.BOLD_ITALIC);
        saaLinkFb.setText("Visit the SAAs facebook page ");
        saaLinkFb.setTextSize(20);
        saaLinkFb.setTypeface(null, Typeface.BOLD_ITALIC);
        saaLinkFb.setTextColor(-14714714);
        saaLink.setText("For more info about the SAA click here");
        saaLink.setTextSize(20);
        saaLink.setTypeface(null, Typeface.BOLD_ITALIC);
        saaLink.setTextColor(-14714714);
        saaLayout = new LinearLayout(this);
        saaLayout.setBackgroundColor(Color.argb(240,14,20,123));
        saaLayout.setOrientation(LinearLayout.VERTICAL);
        saaLayout.addView(saaText);
        saaLayout.addView(saaLink);
        saaLayout.addView(saaLinkFb);
        saaLayout.addView(callSAA);
        saaLayout.addView(exitSaa);
        saasv = new ScrollView(this);
        saasv.addView(saaLayout);
    }
    public void amInit()
    {
        am = (ImageButton)findViewById(R.id.amenities);
        exitAm = new Button(this);
        exitAm.setText("Exit");
        amText = new TextView(this);
        amText.setText("The local fast food restaurants are:" +" \n \t Supermacs/PapaJohns \n \t Four Seasons \n \t Jumbo Chinese \n \n There are three local spar shops located in \n \t Dromroe Student Village \n \t Students Union Courtyard \n \t Beside Plassey Student Accomadtion \n \t Aldi is located beside travellodge hotel. \n \t Castletroy Pharmacy is located beside Plassey Spar. ");
        callSM = new TextView(this);
        callSM.setText("Call Supermacs");
        callFS = new TextView(this);
        callFS.setText("Call Four Seasons");
        callJC = new TextView(this);
        callJC.setText("Call Jumbo Chinese");
        amText.setTextSize(20);
        callSM.setTextSize(20);
        callFS.setTextSize(20);
        callJC.setTextSize(20);
        amText.setTypeface(null, Typeface.BOLD_ITALIC);
        callSM.setTypeface(null, Typeface.BOLD_ITALIC);
        callFS.setTypeface(null,Typeface.BOLD_ITALIC);
        callJC.setTypeface(null, Typeface.BOLD_ITALIC);
        callSM.setTextColor(-14714714);
        callFS.setTextColor(-14714714);
        callJC.setTextColor(-14714714);
        amText.setTextColor(Color.argb(255,255,255,255));
        amLayout = new LinearLayout(this);
        amLayout.setBackgroundColor(Color.argb(240,96,93,12));
        amLayout.setOrientation(LinearLayout.VERTICAL);
        amLayout.addView(amText);
        amLayout.addView(callSM);
        amLayout.addView(callFS);
        amLayout.addView(callJC);
        amLayout.addView(exitAm);
        amsv = new ScrollView(this);
        amsv.addView(amLayout);
    }
    public void btPopUpWindow()
    {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.buseireann.ie/pdf/1378478984-304.pdf"));
                startActivity(i);
            }
        });
    }
    public void hcPopUpWindow()
    {
        hc.setOnClickListener(this);
        hcBt.setOnClickListener(this);
        hcLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hc = new Intent(Intent.ACTION_VIEW);
                hc.setData(Uri.parse(hcWeb));
                startActivity(hc);
            }
        });
        hcWindow = new PopupWindow(hcsv, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT, true);
        hcWindow.setContentView(hcsv);
    }
    public void saaPopUpWindow()
    {
        saa.setOnClickListener(this);
        exitSaa.setOnClickListener(this);
        saaLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent saa = new Intent(Intent.ACTION_VIEW);
                saa.setData(Uri.parse(saaWeb));
                startActivity(saa);
            }
        });
        saaLinkFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fb = new Intent(Intent.ACTION_VIEW);
                fb.setData(Uri.parse(saaFB));
                startActivity(fb);
            }
        });
        saaWindow = new PopupWindow(saasv, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        saaWindow.setContentView(saasv);
    }
    public void amPopUpWindow()
    {
        am.setOnClickListener(this);
        exitAm.setOnClickListener(this);
        callSM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent amI = new Intent(Intent.ACTION_DIAL);
                amI.setData(Uri.parse("tel: 35361216161"));
                startActivity(amI);
            }
        });
        callFS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fs = new Intent(Intent.ACTION_DIAL);
                fs.setData(Uri.parse("tel: 35361330181"));
                startActivity(fs);
            }
        });
        callJC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jc = new Intent(Intent.ACTION_DIAL);
                jc.setData(Uri.parse("tel: 35361333789"));
                startActivity(jc);

            }
        });
        amWindow = new PopupWindow(amsv, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        amWindow.setContentView(amsv);
    }
    @Override
    public void onClick(View v)
    {
        if(v.getId() == R.id.healthCentre)
        {
            hcWindow.showAsDropDown(hc, 0, 0);
        }
        else
        {
            hcWindow.dismiss();
        }
        if(v.getId() == R.id.StudentAcademicAdmin)
        {
            saaWindow.showAsDropDown(saa,0,0);
        }
        else
        {
            saaWindow.dismiss();
        }
        if(v.getId() == R.id.amenities)
        {
            amWindow.showAsDropDown(am,0,0);
        }
        else
        {
            amWindow.dismiss();
        }
    }
}
