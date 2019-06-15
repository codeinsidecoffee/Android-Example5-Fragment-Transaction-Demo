package com.mrlonewolfer.example35;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment implements View.OnClickListener {

  EditText edtName;
  Button btnSubmit;
    String Name="";
  Context context;
    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context=getActivity();
        View view= inflater.inflate(R.layout.fragment_first, container, false);
        edtName=view.findViewById(R.id.edtName);
        btnSubmit=view.findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(edtName.getText()!=null){
            String newName=edtName.getText().toString();
            Name=Name+newName+"\n";
            FragmentManager fragmentManager=getFragmentManager();
            SecondFragment secondFragment=
                    (SecondFragment) fragmentManager.findFragmentById(R.id.secondFragment);
            secondFragment.setMessageMethod(Name);
            edtName.setText("");
        }

    }
}
