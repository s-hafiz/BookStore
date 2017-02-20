package com.begginers.bookstore;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Data extends AppCompatActivity {
    TextView tvOut;
    DatabaseHelper myDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        myDBHelper=new DatabaseHelper(this);
        tvOut= (TextView) findViewById(R.id.tv);

        //Calling method
        viewAll();
    }
    public void viewAll(){
        Cursor res = myDBHelper.getAllData();
        if (res.getCount()==0){
            Toast.makeText(Data.this,"No data found",Toast.LENGTH_LONG).show();
        }
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            buffer.append("ID : "+res.getString(0)+"\n");
            buffer.append("NAME : "+res.getString(1)+"\n");
            buffer.append("BOOKID : "+res.getString(2)+"\n");
            buffer.append("QUANTITY : "+res.getString(3)+"\n\n");
        }
        tvOut.setText(buffer.toString()+"\n");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menusearch,menu);
        MenuItem menuItem = menu.findItem(R.menu.menusearch);


        return super.onCreateOptionsMenu(menu);
    }
}
