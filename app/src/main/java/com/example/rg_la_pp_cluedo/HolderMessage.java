package com.example.rg_la_pp_cluedo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rg_la_pp_cluedo.BBDD.DataBaseConnection;
import com.google.firebase.database.DatabaseReference;

public class HolderMessage extends RecyclerView.ViewHolder {

    private TextView tvPlayerName;
    private TextView tvMessageView;
    private TextView tvMessageDate;
    private ImageView imgViewPlayer;
    private DatabaseReference ref;

    public HolderMessage(@NonNull View itemView) {
        super(itemView);
        tvPlayerName = itemView.findViewById(R.id.tvPlayerName);
        tvMessageView = itemView.findViewById(R.id.tvMessageView);
        tvMessageDate = itemView.findViewById(R.id.tvMessageDate);
        imgViewPlayer = itemView.findViewById(R.id.imgViewPlayer);

        //FIXME: dinamic image profile
        imgViewPlayer.setImageResource(R.drawable.personaje_amapola);


    }

    public TextView getTvPlayerName() {
        return tvPlayerName;
    }

    public void setTvPlayerName(TextView tvPlayerName) {
        this.tvPlayerName = tvPlayerName;
    }

    public TextView getTvMessageView() {
        return tvMessageView;
    }

    public void setTvMessageView(TextView tvMessageView) {
        this.tvMessageView = tvMessageView;
    }

    public TextView getTvMessageDate() {
        return tvMessageDate;
    }

    public void setTvMessageDate(TextView tvMessageDate) {
        this.tvMessageDate = tvMessageDate;
    }

    public ImageView getImgViewPlayer() {
        return imgViewPlayer;
    }

    public void setImgViewPlayer(ImageView imgViewPlayer) {
        this.imgViewPlayer = imgViewPlayer;
    }
}
