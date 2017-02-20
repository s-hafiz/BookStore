package com.begginers.bookstore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {
    EditText edId,edName,edBookId,edQuantity;
    DatabaseHelper myDataHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        myDataHelper=new DatabaseHelper(this);
        initView();
    }

    private void initView() {
        edId= (EditText) findViewById(R.id.edIdUp);
        edName= (EditText) findViewById(R.id.edNameUp);
        edBookId= (EditText) findViewById(R.id.edBookIdUp);
        edQuantity= (EditText) findViewById(R.id.edQuantityUp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                boolean isUpdated=myDataHelper.updateData(edId.getText().toString(),edName.getText().toString(),
                        edBookId.getText().toString(),edQuantity.getText().toString());
                if (!edId.getText().toString().isEmpty() && !edName.getText().toString().isEmpty() && !edBookId.getText().toString().isEmpty() && !edQuantity.getText().toString().isEmpty())
                {
                    if (isUpdated==true){
                        Toast.makeText(Update.this,"Data updated",Toast.LENGTH_LONG).show();
                    }
                }

                else
                    Toast.makeText(Update.this,"Data not updated",Toast.LENGTH_LONG).show();
                edId.setText(" ");
                edName.setText(" ");
                edBookId.setText(" ");
                edQuantity.setText(" ");
                edId.requestFocus();
                return true;
            default:
                return super.onOptionsItemSelected(item);


        }
    }
}
