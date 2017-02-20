package com.begginers.bookstore;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnSubmit,btnShow,btnDialoge,btnUpdate;
    DatabaseHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating database instance
        myDB=new DatabaseHelper(this);

        //Casting views
        btnSubmit= (Button) findViewById(R.id.btnSubmit);
        btnShow= (Button) findViewById(R.id.btnShow);
        btnDialoge= (Button) findViewById(R.id.btnShowDia);
        btnUpdate= (Button) findViewById(R.id.btnUpdate);

        //Setting listener
        btnShow.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);

        viewAll();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSubmit:
                startActivity(new Intent(MainActivity.this,BookActivity.class));
                break;
            case R.id.btnShow:
                startActivity(new Intent(MainActivity.this,Data.class));
                break;
            case R.id.btnUpdate:
                startActivity(new Intent(MainActivity.this,Update.class));
        }
    }

        public void viewAll(){
        btnDialoge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = myDB.getAllData();
                if (res.getCount() == 0){
                    showMessage("Error","Sorry, No Data Found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("ID : "+res.getString(0)+"\n");
                    buffer.append("NAME : "+res.getString(1)+"\n");
                    buffer.append("BOOKID : "+res.getString(2)+"\n");
                    buffer.append("QUANTITY : "+res.getString(3)+"\n\n");
                }

                showMessage("Data",buffer.toString());
            }
        });
    }

    public void showMessage(String title,String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        View mView = getLayoutInflater().inflate(R.layout.alert_dialog,null);
        TextView textViewTwo=(TextView)mView.findViewById(R.id.textViewNew);
        textViewTwo.setText(Message+"\n");
        builder.setView(mView);
        builder.setPositiveButton("OK",null);
        AlertDialog dialog = builder.create();
        dialog.show();

    }
}
