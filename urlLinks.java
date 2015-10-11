package com.theTeaCakeProject.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class FbLinks extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fblinks);
    }

    public void goToULSU (View view)
    {
        goToUrl("https://www.facebook.com/ulstudentsunion?fref=ts");
    }

    public void goToStables (View view)
    {
        goToUrl("https://www.facebook.com/stablesclub?fref=ts");
    }

    public void goToEnts (View view)
    {
        goToUrl("https://www.facebook.com/ULSUEnts?fref=ts");
    }
    public void goToScholars (View view)
    {
        goToUrl("https://www.facebook.com/pages/The-Scholars-Club/113836492011118?fref=ts");
    }

    public void goToUrl (String url)
    {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser =  new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}

