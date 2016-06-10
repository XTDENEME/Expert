package com.example.ext01d1840.expert;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;

import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link xtAnaSayfa.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link xtAnaSayfa#newInstance} factory method to
 * create an instance of this fragment.
 */
public class xtAnaSayfa extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public xtAnaSayfa() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment xtAnaSayfa.
     */
    // TODO: Rename and change types and number of parameters
    public static xtAnaSayfa newInstance(String param1, String param2) {
        xtAnaSayfa fragment = new xtAnaSayfa();
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

       View view = inflater.inflate(R.layout.fragment_xt_ana_sayfa, container, false);

        final ArrayList<xtHaber> xthaber =new ArrayList<xtHaber>();
        xtHaber p1 = new xtHaber("Coke",10,10);
        xtHaber p2 = new xtHaber("Pepsi",10,10);
        xtHaber p3 = new xtHaber("Gazoz",10,10);
        xtHaber p4 = new xtHaber("MSuyu",10,10);
        xtHaber p5 = new xtHaber("Ayran",10,10);
        xtHaber p6 = new xtHaber("Şalgam",10,10);
        xtHaber p7 = new xtHaber("Coke",10,10);
        xtHaber p8 = new xtHaber("Pepsi",10,10);
        xtHaber p9 = new xtHaber("Gazoz",10,10);
        xtHaber p10 = new xtHaber("MSuyu",10,10);
        xtHaber p11 = new xtHaber("Ayran",10,10);
        xtHaber p12 = new xtHaber("Şalgam",10,10);

        xthaber.add(p1);
        xthaber.add(p2);
        xthaber.add(p3);
        xthaber.add(p4);
        xthaber.add(p5);
        xthaber.add(p6);
        xthaber.add(p7);
        xthaber.add(p8);
        xthaber.add(p9);
        xthaber.add(p10);
        xthaber.add(p11);
        xthaber.add(p12);

        BindDictionary<xtHaber> dictionary = new BindDictionary<xtHaber>();
        dictionary.addStringField(R.id.tvName, new StringExtractor<xtHaber>() {
            @Override
            public String getStringValue(xtHaber xtHaber, int position) {
                return xtHaber.getName();
            }
        });

        dictionary.addStringField(R.id.tvAdet, new StringExtractor<xtHaber>() {
            @Override
            public String getStringValue(xtHaber xtHaber, int position) {
                return ""+xtHaber.getQty();
            }
        });

        dictionary.addStringField(R.id.tvTutar, new StringExtractor<xtHaber>() {
            @Override
            public String getStringValue(xtHaber xtHaber, int position) {
                return ""+xtHaber.getPrice();
            }
        });


       // ArrayAdapter<xtHaber> adapter=new ArrayAdapter<xtHaber>(xtAnaSayfa.this.getActivity(),android.R.layout.simple_list_item_1,xthaber);
        FunDapter adapter = new FunDapter(xtAnaSayfa.this.getActivity(),xthaber,R.layout.xthaber_ana,dictionary);


        ListView listView = (ListView)view.findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                xtHaber selectedProduct = xthaber.get(position);
                Toast.makeText(xtAnaSayfa.this.getActivity(),selectedProduct.getName(),Toast.LENGTH_SHORT).show();

            }
        });




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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
