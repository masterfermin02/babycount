package com.babycount.fpapp.babycount.Counts;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.babycount.fpapp.babycount.BabyCount;
import com.babycount.fpapp.babycount.BiberonAdapter;
import com.babycount.fpapp.babycount.R;

import java.util.Locale;

import static com.babycount.fpapp.babycount.BabyCount.LOCALE_KEY;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CountFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CountFragment extends Fragment implements CountContract.View, BabyCount {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private CountContract.Presenter mPresenter;
    private TextToSpeech ttobj;
    private static int count = 0;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CountFragment newInstance(String param1, String param2) {
        CountFragment fragment = new CountFragment();
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
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(@NonNull CountContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_count, container, false);




        Button btn = (Button) root.findViewById(R.id.btnOne);
        ImageButton btnReplay = (ImageButton) root.findViewById(R.id.btnReplay);
        final GridView gridV = (GridView) root.findViewById(R.id.biberonGridview);
        final BiberonAdapter biberonAdapter = new BiberonAdapter(getActivity());
        gridV.setAdapter(biberonAdapter);
        final TextView counter = (TextView) root.findViewById(R.id.lblCounter);

        btn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                count++;
                if(count > COUNT_LIMIT) {
                    count = 1;
                    biberonAdapter.resetBiberones();
                }
                counter.setText(String.valueOf(count));
                //ttobj.speak(strcount, TextToSpeech.QUEUE_FLUSH, null);
                biberonAdapter.addBiberon(count);

            }

        });

        btnReplay.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                //ttobj.speak(strcount, TextToSpeech.QUEUE_FLUSH, null);

            }

        });
        // Inflate the layout for this fragment
        return root;
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
       /* if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
