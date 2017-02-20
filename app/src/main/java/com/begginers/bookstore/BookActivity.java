package com.begginers.bookstore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class BookActivity extends AppCompatActivity {

    //Creating database instance
    DatabaseHelper myDB;

    //Creating EditText instances
    EditText edName,edBookId,edQuantity;
    //Button btnAddData,btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        myDB=new DatabaseHelper(this);

        //Initialize the views
        initView();

        //Calling the addData method
        //addData();

        //Showing data
        //viewAll();
        /*btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BookActivity.this, Data.class));
            }
        });*/
    }

    private void initView() {
        edName= (EditText) findViewById(R.id.edName);
        edBookId= (EditText) findViewById(R.id.edBookId);
        edQuantity= (EditText) findViewById(R.id.edQuantity);

        //btnAddData= (Button) findViewById(R.id.btnSubmit);
        //btnShow= (Button) findViewById(R.id.btnShow);
    }
    /*public void addData(){
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted=myDB.insertData(edName.getText().toString(),edBookId.getText().toString(),
                        edQuantity.getText().toString());
                if (isInserted=true){
                    Toast.makeText(BookActivity.this,"Data Successfully inserted !",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(BookActivity.this,"Data Not Inserted !",Toast.LENGTH_LONG).show();
                }
                edName.setText(" ");
                edBookId.setText(" ");
                edQuantity.setText(" ");
            }
        });
    }*/


    /*public void viewAll(){
        btnShow.setOnClickListener(new View.OnClickListener() {
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
    }*/

    /*public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }*/

    //Option menu creatin

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                boolean isInserted=myDB.insertData(edName.getText().toString(),edBookId.getText().toString(),
                        edQuantity.getText().toString());
                if (isInserted==true){
                    Toast.makeText(BookActivity.this,"Data Successfully inserted !",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(BookActivity.this,"Data Not Inserted !",Toast.LENGTH_LONG).show();
                }
                edName.setText(" ");
                edBookId.setText(" ");
                edQuantity.setText(" ");
                edName.requestFocus();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
