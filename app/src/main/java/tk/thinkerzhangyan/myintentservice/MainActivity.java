package tk.thinkerzhangyan.myintentservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton  = (Button) findViewById(R.id.button);

        InitIntent initIntent = new InitIntent().invoke();

        final Intent intentA = initIntent.getIntentA();
        final Intent intentB = initIntent.getIntentB();
        final Intent intentC = initIntent.getIntentC();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intentA);
                startService(intentB);
                startService(intentC);
            }
        });
    }

    private class InitIntent {

        private Intent mIntentA;
        private Intent mIntentB;
        private Intent mIntentC;

        public Intent getIntentA() {
            return mIntentA;
        }

        public Intent getIntentB() {
            return mIntentB;
        }

        public Intent getIntentC() {
            return mIntentC;
        }

        public InitIntent invoke() {
            mIntentA = new Intent(MainActivity.this,MyService.class);
            mIntentA.putExtra("name","intentA");

            mIntentB = new Intent(MainActivity.this, MyService.class);
            mIntentB.putExtra("name","intentB");

            mIntentC = new Intent(MainActivity.this, MyService.class);
            mIntentC.putExtra("name","intentC");
            return this;
        }
    }
}

