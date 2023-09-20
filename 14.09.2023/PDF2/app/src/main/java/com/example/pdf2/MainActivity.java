package com.example.pdf2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Panel Pa;
    Paint tlo1 = new Paint();
    Paint tlo2 = new Paint();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(Pa = new Panel(this));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
            if(id == R.id.ja) {
                Context context = getApplicationContext();
                CharSequence text = "Twórca: Bartosz Lauer";
                int czas = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, czas);
                toast.setGravity(Gravity.BOTTOM | Gravity.BOTTOM, 0, 0);
                toast.show();
                return true;
            }
            else if (id == R.id.odejscie) {
                finish();
                return true;
            }
            else if (id == R.id.kolorek1) {
                tlo1.setColor(Color.BLACK);
                tlo2.setColor(Color.WHITE);
                Pa.postInvalidate();
                return true;
            }
            else if ( id == R.id.kolorek2){
                tlo1.setColor(Color.RED);
                tlo2.setColor(Color.YELLOW);
                Pa.postInvalidate();
                return true;
            }
                return super.onOptionsItemSelected(item);
        }
    public class Panel extends View {

        public Panel(MainActivity context) {
            super(context);
            tlo1.setColor(Color.BLACK);
            tlo2.setColor(Color.WHITE);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.GRAY);
            float width = getWidth();
            float height = getHeight();

            float minSize = Math.min(width, height);

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if ((i + j) % 2 == 0) {
                        canvas.drawRect(i * minSize / 8, j * minSize / 8, (i + 1) * minSize / 8, (j + 1) * minSize / 8, tlo1);
                    } else {
                        canvas.drawRect(i * minSize / 8, j * minSize / 8, (i + 1) * minSize / 8, (j + 1) * minSize / 8, tlo2);
                    }
                }
            }
        }

    }
}



