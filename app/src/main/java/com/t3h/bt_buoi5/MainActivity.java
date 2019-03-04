package com.t3h.bt_buoi5;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FaceAdapter.FaceItemListener {

    private static final int REQUEST_ADD = 1;
    private static final int REQUEST_FIX = 2;
    private ArrayList<Face> dataFace;
    //    private ArrayList<Face> data2;
    private RecyclerView lvFace;
    private FaceAdapter adapter;
    private ImageView imAdd;
    private int posi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        initViews();


    }

    private void initViews() {
        imAdd = findViewById(R.id.imb_add);
        lvFace = findViewById(R.id.lv_face);
        adapter = new FaceAdapter(this, dataFace);
        lvFace.setAdapter(adapter);
        adapter.setListener(this);

        imAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "ADD PLUS", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, AddActivity.class);

                startActivityForResult(intent, REQUEST_ADD);


            }
        });

    }


    public void initData() {

        dataFace = new ArrayList<>();

        dataFace.add(new Face("NGUYỄN VĂN AN", "123700",
                "12A3", 8.5f));
        dataFace.add(new Face("HOÀNG VĂN ĐẠI", "123702",
                "12A3", 7.5f));
        dataFace.add(new Face("NGUYỄN THẾ HẠNH", "123704",
                "12A3", 7.7f));
        dataFace.add(new Face("PHẠM VĂN ĐỨC", "123706",
                "12A3", 6.5f));
        dataFace.add(new Face("NGUYỄN THỊ NGỌC ANH", "123708",
                "12A3", 4.5f));
        dataFace.add(new Face("NGUYỄN NGỌC VŨ", "123700",
                "12A3", 6.5f));
        dataFace.add(new Face("HOÀNG VĂN ĐẠI", "123702",
                "12A3", 9.5f));
        dataFace.add(new Face("NGUYỄN THẾ BÌNH", "123704",
                "12A5", 3.5f));
        dataFace.add(new Face("PHẠM VĂN ĐẠT", "123706",
                "12A5", 7.5f));
        dataFace.add(new Face("NGUYỄN THỊ HUỆ", "123708",
                "12A5", 8.5f));
        dataFace.add(new Face("NGUYỄN VĂN AN", "123700",
                "12A5", 6.5f));
        dataFace.add(new Face("HOÀNG ANH ĐỨC", "123702",
                "12A5", 7.5f));
        dataFace.add(new Face("NGUYỄN THẾ HẠNH", "123704",
                "12A5", 8.5f));
        dataFace.add(new Face("PHẠM VĂN ĐỨC", "123706",
                "12A5", 6.5f));
        dataFace.add(new Face("PHẠM THỊ TRÀ MY", "123708",
                "12A5", 9.2f));
        dataFace.add(new Face("NGUYỄN VĂN ANH", "123700",
                "12A5", 8.5f));
        dataFace.add(new Face("HOÀNG VĂN ĐẠI", "123702",
                "12A6", 7.5f));
        dataFace.add(new Face("NGUYỄN THẾ HẠNH", "123704",
                "12A6", 7.7f));
        dataFace.add(new Face("PHẠM VĂN ĐỨC", "123706",
                "12A6", 6.5f));
        dataFace.add(new Face("NGUYỄN THỊ NGỌC ANH", "123708",
                "12A6", 4.5f));
        dataFace.add(new Face("NGÔ VĂN AN", "123700",
                "12A6", 6.5f));
        dataFace.add(new Face("HOÀNG VĂN ĐẠI", "123702",
                "12A8", 9.5f));
        dataFace.add(new Face("NGUYỄN THẾ HẠNH", "123704",
                "12A8", 3.5f));
        dataFace.add(new Face("PHẠM VĂN ĐỨC", "123706",
                "12A8", 7.5f));
        dataFace.add(new Face("NGUYỄN THỊ NGỌC ANH", "123708",
                "12A8", 8.5f));
        dataFace.add(new Face("NGUYỄN VĂN AN", "123700",
                "12A8", 6.5f));
        dataFace.add(new Face("HOÀNG VĂN ĐẠI", "123702",
                "12A8", 7.5f));
        dataFace.add(new Face("NGUYỄN THẾ HẠNH", "123704",
                "12A8", 8.5f));
        dataFace.add(new Face("PHẠM VĂN ĐỨC", "123706",
                "12A8", 6.5f));
        dataFace.add(new Face("BÙI KIM ANH", "123708",
                "12A8", 9.2f));


    }


    @Override
    public void onClick(int position) {

        posi = position;

        Snackbar.make(lvFace, dataFace.get(position).getName(), Snackbar.LENGTH_LONG).show();

        String name = dataFace.get(position).getName();
        String msv = dataFace.get(position).getMsv();
        String classroom = dataFace.get(position).getClassroom();
        String score = dataFace.get(position).getScore().toString();

//        if(name.isEmpty()||msv.isEmpty()||classroom.isEmpty()||score.isEmpty()){
//
//            Toast.makeText(this, "Data is empty", Toast.LENGTH_SHORT).show();
//
//            return;
//        }
        Intent fix = new Intent(MainActivity.this, FixActivity.class);
        fix.putExtra(AddActivity.EXTRA_NAME, name);
        fix.putExtra(AddActivity.EXTRA_MSV, msv);
        fix.putExtra(AddActivity.EXTRA_CLASS_ROOM, classroom);
        fix.putExtra(AddActivity.EXTRA_SCORE, score);

        startActivityForResult(fix, REQUEST_FIX);


    }

    @Override
    public void onLongClick(final int position) {

        new AlertDialog.Builder(this)
                .setTitle("Delete")
                .setMessage("Do you want to delete?")
                .setCancelable(false)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        dataFace.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_ADD) {
            if (resultCode == RESULT_OK) {

                String name = data.getStringExtra(AddActivity.EXTRA_NAME);
                String msv = data.getStringExtra(AddActivity.EXTRA_MSV);
                String classroom = data.getStringExtra(AddActivity.EXTRA_CLASS_ROOM);
                String score = data.getStringExtra(AddActivity.EXTRA_SCORE);

                Toast.makeText(this, "SUCCESS ADD "
                        + name + "-" + msv + "-" + classroom + "-" + score, Toast.LENGTH_LONG).show();

                dataFace.add(new Face(name, msv, classroom, Float.parseFloat(score)));
                adapter.notifyDataSetChanged();


//                data2 = new ArrayList<>();
//
//                data2.add(new Face(name,msv,classroom,Float.parseFloat(score)));
//                adapter.notifyDataSetChanged();
//                initViews();


            } else {
                Toast.makeText(this, "ADD CANCEL", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == REQUEST_FIX) {
            if (resultCode == RESULT_OK) {

                String name = data.getStringExtra(AddActivity.EXTRA_NAME);
                String msv = data.getStringExtra(AddActivity.EXTRA_MSV);
                String classroom = data.getStringExtra(AddActivity.EXTRA_CLASS_ROOM);
                String score = data.getStringExtra(AddActivity.EXTRA_SCORE);

                Toast.makeText(this, "SUCCESS FIX "
                        + name + "-" + msv + "-" + classroom + "-" + score, Toast.LENGTH_LONG).show();

                dataFace.get(posi).setName(name);
                dataFace.get(posi).setMsv(msv);
                dataFace.get(posi).setClassroom(classroom);
                dataFace.get(posi).setScore(Float.parseFloat(score));


                adapter.notifyDataSetChanged();


            } else {
                Toast.makeText(this, "FIX CANCEL", Toast.LENGTH_SHORT).show();
            }


        }

    }


}
