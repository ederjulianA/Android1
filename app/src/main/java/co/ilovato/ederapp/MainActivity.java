package co.ilovato.ederapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.StrictMode;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    TextView txt;
    EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //StrictMode.ThreadPolicy p = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        //StrictMode.setThreadPolicy(p);

        btn = (Button) findViewById(R.id.btn_login);
        txt = (TextView) findViewById(R.id.texto);
        email = (EditText) findViewById(R.id.email);


        btn.setOnClickListener(this);
        //httpHandler handler = new httpHandler();

       // String txt = handler.post("http://192.168.1.57/tat/public/index.php/android");
        //String txt = handler.post("http://192.168.1.57/app.php");

        //TextView t = (TextView)findViewById(R.id.msgPhp);
        //t.setText(txt);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
                case  R.id.btn_login:
                    String data = email.getText().toString();
                    txt.setText(data);
                    Toast.makeText(getApplicationContext(),"Hola:"+data,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    intent.putExtra("DATO", data);
                    startActivity(intent);
                break;
        }
    }
}
