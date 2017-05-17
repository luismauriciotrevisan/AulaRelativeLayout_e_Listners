package com.example.aularelativelayout_e_listners;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button bt_1, bt_2, bt_3, bt_4;
    TextView tv_01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_1 = (Button)findViewById(R.id.bt_01);
        bt_2 = (Button)findViewById(R.id.bt_02);
        bt_3 = (Button)findViewById(R.id.bt_03);
        bt_4 = (Button)findViewById(R.id.bt_04);

        //Listener é a própria Activity
        bt_1.setOnClickListener(this);

        //Listener de Classe Membro
        HandleClick handle = new HandleClick();
        bt_2.setOnClickListener(handle);

        //Listener do tipo interface
        View.OnClickListener h3 = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Button bt = (Button) view;
                Toast.makeText(MainActivity.this, "bt_3 Texto é:" + bt.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        };
        bt_3.setOnClickListener(h3);

        //Listener de classe anônima
        bt_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button bt = (Button) view;
                Toast.makeText(MainActivity.this, "bt_4 Texto é:" + bt.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onClick(View view){
        Button bt = (Button) view;
        Toast.makeText(this, "Texto é:" + bt.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    public class HandleClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Button bt = (Button) view;
            Toast.makeText(MainActivity.this, "bt_2  Texto é:" + bt.getText().toString(), Toast.LENGTH_SHORT).show();

        }
    }
}
