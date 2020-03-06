package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    MyDb DB=new MyDb(this);

    public void click_write(View v)
    {
        EditText name=(EditText) findViewById(R.id.name);
        EditText email=(EditText) findViewById(R.id.email);
        EditText number=(EditText) findViewById(R.id.number);
        TextView text=(TextView) findViewById(R.id.message);
        String str1,str2,str3;
        int int3;
        str1=name.getText().toString();
        str2=email.getText().toString();
        str3=number.getText().toString();
        if(str1.length()==0||str2.length()==0||str3.length()==0)
        {
            Toast ts = Toast.makeText(getBaseContext(),"please enter!",Toast.LENGTH_LONG);
            ts.show();
        }
        else {
            int3 = Integer.parseInt(str3);
            SQLiteDatabase db = DB.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name", str1);
            values.put("email", str2);
            values.put("number", int3);
            long id = db.insert("user_m", null, values);
            db.close();
            Toast ts = Toast.makeText(getBaseContext(),"success!",Toast.LENGTH_LONG);
            ts.show();
        }
    }

    public void click_read(View v)
    {
        String str="name:";
        TextView text=(TextView) findViewById(R.id.message);
        SQLiteDatabase db = DB.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from user_m",null);
        if(cursor!=null&&cursor.getCount()>0)
        {
            while(cursor.moveToNext())
            {
                str=str+cursor.getString(0);
                str=str+",email:";
                str=str+cursor.getString(1);
                str=str+",phone number:";
                str=str+cursor.getString(2);
                str=str+"\n"+"name:";

            }
        }
        text.setText(str);
        cursor.close();
        db.close();
    }

    public void click_update(View v)
    {
        EditText name=(EditText) findViewById(R.id.name);
        EditText email=(EditText) findViewById(R.id.email);
        EditText number=(EditText) findViewById(R.id.number);
        TextView text=(TextView) findViewById(R.id.message);
        String str1,str2,str3;
        int int3;
        str1=name.getText().toString();
        str2=email.getText().toString();
        str3=number.getText().toString();
        if(str1.length()==0||str2.length()==0||str3.length()==0)
        {
            Toast ts = Toast.makeText(getBaseContext(),"please enter!",Toast.LENGTH_LONG);
            ts.show();
        }
        else
        {

        }
    }

    public void click_remove(View v)
    {
        SQLiteDatabase db = DB.getWritableDatabase();
    }
}
