package com.t3h.bt_buoi5;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {


    public static final String EXTRA_NAME = "extra.name";
    public static final String EXTRA_MSV = "extra.msv";
    public static final String EXTRA_CLASS_ROOM = "extra.class.room";
    public static final String EXTRA_SCORE = "extra.score";

    private EditText edtName;
    private EditText edtMsv;
    private EditText edtClassroom;
    private EditText edtScore;

    private Button btnOk;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_add);
        initViews();
    }

    private void initViews() {

        edtName = findViewById(R.id.edt_name);
        edtMsv = findViewById(R.id.edt_msv);
        edtClassroom = findViewById(R.id.edt_classroom);
        edtScore = findViewById(R.id.edt_score);
        btnOk=findViewById(R.id.btn_ok);

        btnOk.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        String name = edtName.getText().toString();
        String msv = edtMsv.getText().toString();
        String classroom = edtClassroom.getText().toString();
        String score = edtScore.getText().toString();

        if(name.isEmpty()||msv.isEmpty()||classroom.isEmpty()||score.isEmpty()){

            Toast.makeText(this, "Data is empty", Toast.LENGTH_SHORT).show();

            return;
        }


        Intent intent = new Intent();
        intent.putExtra(EXTRA_NAME,name);
        intent.putExtra(EXTRA_MSV,msv);
        intent.putExtra(EXTRA_CLASS_ROOM,classroom);
        intent.putExtra(EXTRA_SCORE,score);

        setResult(RESULT_OK,intent);
        finish();


    }
}
