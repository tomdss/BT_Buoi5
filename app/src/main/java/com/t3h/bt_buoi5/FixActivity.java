package com.t3h.bt_buoi5;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FixActivity extends AppCompatActivity implements View.OnClickListener {

//    public static final String EXTRA_NAME = "extra.name";
//    public static final String EXTRA_MSV = "extra.msv";
//    public static final String EXTRA_CLASS_ROOM = "extra.class.room";
//    public static final String EXTRA_SCORE = "extra.score";

    private EditText edtName;
    private EditText edtMsv;
    private EditText edtClassroom;
    private EditText edtScore;

    private Button btnOkk;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_fix);
        initViews();
    }

    private void initViews() {

        edtName = findViewById(R.id.edt_name);
        edtMsv = findViewById(R.id.edt_msv);
        edtClassroom = findViewById(R.id.edt_classroom);
        edtScore = findViewById(R.id.edt_score);
        btnOkk = findViewById(R.id.btn_okk);

        btnOkk.setOnClickListener(this);

//        edtName.setOnClickListener(this);
//        edtMsv.setOnClickListener(this);
//        edtClassroom.setOnClickListener(this);
//        edtScore.setOnClickListener(this);


        Intent intent = getIntent();


        edtName.setText(intent.getStringExtra(AddActivity.EXTRA_NAME));
        edtMsv.setText(intent.getStringExtra(AddActivity.EXTRA_MSV));
        edtClassroom.setText(intent.getStringExtra(AddActivity.EXTRA_CLASS_ROOM));
        edtScore.setText(intent.getStringExtra(AddActivity.EXTRA_SCORE));


    }

    @Override
    public void onClick(View v) {


        String name = edtName.getText().toString();
        String msv = edtMsv.getText().toString();
        String classroom = edtClassroom.getText().toString();
        String score = edtScore.getText().toString();

        if (name.isEmpty() || msv.isEmpty() || classroom.isEmpty() || score.isEmpty()) {

            Toast.makeText(this, "Data is empty", Toast.LENGTH_SHORT).show();

            return;
        }


        Intent intent = new Intent();
        intent.putExtra(AddActivity.EXTRA_NAME, name);
        intent.putExtra(AddActivity.EXTRA_MSV, msv);
        intent.putExtra(AddActivity.EXTRA_CLASS_ROOM, classroom);
        intent.putExtra(AddActivity.EXTRA_SCORE, score);

        setResult(RESULT_OK, intent);
        finish();


    }

}
