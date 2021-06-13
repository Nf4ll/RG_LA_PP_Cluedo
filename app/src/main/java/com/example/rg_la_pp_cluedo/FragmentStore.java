package com.example.rg_la_pp_cluedo;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rg_la_pp_cluedo.BBDD.DataBaseConnection;
import com.example.rg_la_pp_cluedo.BBDD.Match;
import com.example.rg_la_pp_cluedo.BBDD.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;

import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FragmentStore extends Fragment {

    SharedPreferences shSettings;
    FirebaseAuth mAuth;
    DatabaseReference database, userRef;

    ImageView iv1,iv2,iv3,iv4,iv5,iv6;
    Button bt1,bt2,bt3,bt4,bt5,bt6;
    TextView tvPoints;
    User user;
    String userName;

    public FragmentStore() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        database = DataBaseConnection.getFirebase();
        mAuth = FirebaseAuth.getInstance();
        shSettings = this.getActivity().getSharedPreferences(getString(R.string.PREFsetttings), 0);
        userName = shSettings.getString("userName","");

        //TODO: preferancias idioma y sonido
        shSettings.getString("appLanguage","");
        shSettings.getBoolean("appSound",true);


        iv1 = getView().findViewById(R.id.imageView1);
        iv2 = getView().findViewById(R.id.imageView2);
        iv3 = getView().findViewById(R.id.imageView3);
        iv4 = getView().findViewById(R.id.imageView4);
        iv5 = getView().findViewById(R.id.imageView5);
        iv6 = getView().findViewById(R.id.imageView6);

        bt1 = getView().findViewById(R.id.btn_pista1);
        bt2 = getView().findViewById(R.id.btn_pista2);
        bt3 = getView().findViewById(R.id.btn_pista3);
        bt4 = getView().findViewById(R.id.btn_pista4);
        bt5 = getView().findViewById(R.id.btn_pista5);
        bt6 = getView().findViewById(R.id.btn_pista6);


        tvPoints = getView().findViewById(R.id.textView4);

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null && !userName.isEmpty()){
            userRef = database.getDatabase().getReference("Users/"+userName+"/User");
            userRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    user = task.getResult().getValue(User.class);
                    tvPoints.setText(tvPoints.getText()+String.valueOf(user.getPoints()));
                }
            });

            bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comprar(v);
                }
            });

            bt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comprar(v);
                }
            });

            bt3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comprar(v);
                }
            });

            bt4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comprar(v);
                }
            });

            bt5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comprar(v);
                }
            });

            bt6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comprar(v);
                }
            });

        } else {
            Toast.makeText(getContext(),getString(R.string.no_play_sin_login),Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_store, container, false);
    }

    public void comprar (View view) {
        switch (view.getId()) {
            case R.id.btn_pista1:
                Integer p = user.getPoints();
                if (p>=100){
                    user.setAvatar(R.drawable.avatar1);
                    user.setPoints(p-100);
                    userRef.setValue(user);
                } else {
                    Toast.makeText(getContext(), getString(R.string.no_points),  Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_pista2:
                Integer p2 = user.getPoints();
                if (p2>=200){
                    user.setAvatar(R.drawable.avatar10);
                    user.setPoints(p2-200);
                    userRef.setValue(user);
                } else {
                    Toast.makeText(getContext(), getString(R.string.no_points),  Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_pista3:
                Integer p3 = user.getPoints();
                if (p3>=300){
                    user.setAvatar(R.drawable.avatar2);
                    user.setPoints(p3-100);
                    userRef.setValue(user);
                } else {
                    Toast.makeText(getContext(), getString(R.string.no_points),  Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_pista4:
                Integer p4 = user.getPoints();
                if (p4>=100){
                    user.setAvatar(R.drawable.avatar3);
                    user.setPoints(p4-100);
                    userRef.setValue(user);
                } else {
                    Toast.makeText(getContext(), getString(R.string.no_points),  Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_pista5:
                Integer p5 = user.getPoints();
                if (p5>=200){
                    user.setAvatar(R.drawable.avatar6);
                    user.setPoints(p5-200);
                    userRef.setValue(user);
                } else {
                    Toast.makeText(getContext(), getString(R.string.no_points),  Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_pista6:
                Integer p6 = user.getPoints();
                if (p6>=300){
                    user.setAvatar(R.drawable.avatar9);
                    user.setPoints(p6-300);
                    userRef.setValue(user);
                } else {
                    Toast.makeText(getContext(), getString(R.string.no_points),  Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


}