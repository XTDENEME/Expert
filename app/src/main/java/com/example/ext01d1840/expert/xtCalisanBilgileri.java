package com.example.ext01d1840.expert;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.view.LayoutInflater;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link xtCalisanBilgileri.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link xtCalisanBilgileri#newInstance} factory method to
 * create an instance of this fragment.
 */
public class xtCalisanBilgileri extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    private OnFragmentInteractionListener mListener;

    public xtCalisanBilgileri() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static xtCalisanBilgileri newInstance(String param1, String param2) {

        xtCalisanBilgileri fragment = new xtCalisanBilgileri();

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_xt_calisan_bilgileri, container, false);
        View vchild = inflater.inflate(R.layout.xt_child_layout, container, false);

        ExpandableListView expandableListView = (ExpandableListView) view.findViewById(R.id.exp_listview);

        List<String> Headings = new ArrayList<String>();
        List<String> L1 = new ArrayList<String>();
        List<String> L2 = new ArrayList<String>();
        List<String> L3 = new ArrayList<String>();

        HashMap<String,List<String>> ChildList = new HashMap<String, List<String>>();
        String heading_items[] = getResources().getStringArray(R.array.header_titles);
        String l1[]=getResources().getStringArray(R.array.h1_items);
        String l2[]=getResources().getStringArray(R.array.h2_items);
        String l3[]=getResources().getStringArray(R.array.h3_items);

        for (String title : heading_items)
        {
            Headings.add(title);
        }

        for (String title : l1)
        {
            L1.add(title);
        }

        for (String title : l2)
        {
            //L2.add(title);
            String txtEgAd ="İzin Bilgileri";
            L2.add(""+txtEgAd);
        }

        for (String title : l3)
        {

            String txtEgAd ="Eğitim Adı";
            L3.add(""+txtEgAd);
        }

        ChildList.put(Headings.get(0),L1);
        ChildList.put(Headings.get(1),L2);
        ChildList.put(Headings.get(2),L3);

        xtAdapter myAdapter = new xtAdapter(xtCalisanBilgileri.this.getActivity(),Headings,ChildList);
        expandableListView.setAdapter(myAdapter);

        return view;
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
