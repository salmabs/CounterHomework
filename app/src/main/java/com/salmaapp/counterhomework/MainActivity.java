package com.salmaapp.counterhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.MediaRouteButton;
import android.app.assist.AssistStructure;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStructure;
import android.widget.TextView;
import android.util.Log;

import java.text.BreakIterator;

import static com.salmaapp.counterhomework.R.id.textView;

public class MainActivity extends AppCompatActivity {
    int mCount=0 ;
    private TextView mShowCount;
    private View mMessageEditText;

    private static final String TAG= MainActivity.class.getSimpleName();
    private Log log;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(textView);
        mMessageEditText = findViewById(R.id.textview);

        log.d(TAG,"Question1 : si on fait pivoter le périphérique avant d'implementer onSaveInstanceState(): Le compteur est réinitialisé à 0, mais le contenu de l'EditText est préservé. ");
        log.d(TAG,"Question2:  lorsqu'un changement de configuration de périphérique (tel qu'une rotation) se produit : Android arrête votre activité en appelant onPause(), onStop() et onDestroy(), puis redémarre l'opération en appelant onCreate(), onStart() et onResume().");
        log.d(TAG,"Question 3 : Lorsque dans le cycle de vie de l'activité, onSaveInstanceState() est appelé : onSaveInstanceState() est appelée avant la méthode onDestroy()");
        log.d(TAG,"Question 4 : les méthodes de cycle de vie d'Activité sont les meilleures à utiliser pour enregistrer des données avant la fin ou la destruction de l'activité : onPause() ou onStop()");



        // Restore the saved state.
        // See onSaveInstanceState() for what gets saved.
        if (savedInstanceState != null) {
            boolean isVisible =
                    savedInstanceState.getBoolean("reply_visible");
            // Show both the header and the message views. If isVisible is
            // false or missing from the bundle, use the default layout.
            if (isVisible) {
                mShowCount.setVisibility(View.VISIBLE);
                mShowCount.setText(savedInstanceState
                        .getString("reply_text"));
                mShowCount.setVisibility(View.VISIBLE);
            }
        }
    }

    public void countUp(View view) {
        mCount++;
       // if (mShowCount != null) {
          mShowCount.setText(Integer.toString(mCount));
        }
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // If the heading is visible, message needs to be saved.
        // Otherwise we're still using default layout.
        AssistStructure.ViewNode mReplyHeadTextView;
        if (mShowCount.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            BreakIterator mReplyTextView;
            outState.putString("reply_text",
                    mShowCount.getText().toString());
        }
    }}