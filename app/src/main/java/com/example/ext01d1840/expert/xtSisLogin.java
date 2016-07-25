package com.example.ext01d1840.expert;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.FileNameMap;

public class xtSisLogin extends Fragment
 {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    public xtSisLogin() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static xtSisLogin newInstance(String param1, String param2) {
        xtSisLogin fragment = new xtSisLogin();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


        //userEt =(EditText) userEt.findViewById(R.id.etLoginUser);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_xt_sis_login, container, false);

        final EditText user = (EditText) view.findViewById(R.id.etLoginUser);
        final EditText password =(EditText) view.findViewById(R.id.etSifre);
        final Button login =(Button) view.findViewById(R.id.btnGiris);


        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user.setText("");
                user.setTextColor(Color.parseColor("#556f7b"));

            }
        });

        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password.setText("");
                password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                password.setEms(10);
                password.setTextColor(Color.parseColor("#556f7b"));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userText =user.getText().toString();
                String passText =password.getText().toString();

                if (user.getText().toString().equals("experteam")   ){

                    if (password.getText().toString().equals("welcome")){

                        Toast.makeText(getContext(),"Hoşgeldin",Toast.LENGTH_SHORT).show();

                        /*ayesil sistem login bilgisi set edilir*/
                        GlobalVariable global = (GlobalVariable)getActivity().getApplication();
                        global.setCheckLogin(true);
                        /*ayesil*/

                        Intent main = new Intent(getContext(),MainActivity.class);
                        startActivity(main);

                    }
                    else {
                        Toast.makeText(getContext(),"Hatalı kullanıcı/şifre",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getContext(),"Hatalı kullanıcı/şifre",Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;

        //return inflater.inflate(R.layout.fragment_xt_sis_login, container, false);


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
