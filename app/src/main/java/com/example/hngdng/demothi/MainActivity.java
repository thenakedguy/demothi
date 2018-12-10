package com.example.hngdng.demothi;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hngdng.demothi.DatabaseHelper.DatabaseHelper;

public class MainActivity extends AppCompatActivity {
    private EditText edtMaSV;
    private EditText edtTenSV;
    private SinhVienAdapter sinhVienAdapter;
    private SQLiteDatabase mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        mDatabase = databaseHelper.getReadableDatabase();

        RecyclerView recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        sinhVienAdapter = new SinhVienAdapter(this,getAllItems());
        recyclerView.setAdapter(sinhVienAdapter);

        edtMaSV = (EditText)findViewById(R.id.edtMaSV);
        edtTenSV = (EditText)findViewById(R.id.edtTenSV);
        Button btnThem = (Button)findViewById(R.id.btnThem);
        Button btnSua = (Button)findViewById(R.id.btnSua);
        Button btnXoa = (Button)findViewById(R.id.btnXoa);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }

            private void addItem() {

                String tenSV  = edtTenSV.getText().toString();
                String maSV  = edtMaSV.getText().toString();
                ContentValues contentValues = new ContentValues();
                contentValues.put(SinhVien.SinhVienEntry.COL_MASV,maSV);
                contentValues.put(SinhVien.SinhVienEntry.COL_TENSV,tenSV);
                mDatabase.insert(SinhVien.SinhVienEntry.TABLE_NAME,null,contentValues);

            }

        });
    }

    private Cursor getAllItems() {
        return  mDatabase.query(
                SinhVien.SinhVienEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null

        );
    }
}
