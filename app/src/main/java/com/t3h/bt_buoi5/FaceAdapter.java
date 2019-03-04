package com.t3h.bt_buoi5;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FaceAdapter extends RecyclerView.Adapter<FaceAdapter.FaceHolder> {

    private LayoutInflater inflater;//anh xa item_face thanh 1 view
    private ArrayList<Face> data;
    private FaceItemListener listener;

    public FaceAdapter(Context context, ArrayList<Face> data) {
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    public void setListener(FaceItemListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public FaceHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View v = inflater.inflate(R.layout.item_face,
                viewGroup, false);
        FaceHolder holder = new FaceHolder(v);//anh xa layout  ra roi truyen vao holder
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FaceHolder faceHolder, final int position) {

        Face f = data.get(position);
        faceHolder.bindData(f);
        faceHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });

        faceHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if (listener != null) {
                    listener.onLongClick(position);
                }
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class FaceHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvMsv;
        private TextView tvClassroom;
        private TextView tvScore;

        public FaceHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvMsv = itemView.findViewById(R.id.tv_msv);
            tvClassroom = itemView.findViewById(R.id.tv_classroom);
            tvScore = itemView.findViewById(R.id.tv_score);

        }

        public void bindData(Face face) {
            tvName.setText(face.getName());
            tvMsv.setText(face.getMsv());
            tvClassroom.setText(face.getClassroom());
            tvScore.setText(face.getScore().toString());

        }

    }

    //xu ly su kien click hay longclick
    public interface FaceItemListener {
        void onClick(int position);

        void onLongClick(int position);
    }

}
