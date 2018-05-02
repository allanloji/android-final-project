package com.allanloji.language_cast;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView profileHeaderName, profileHeaderLocation, profileNameDetails, profileLocationDetails,
                    profileBioDetails;

    private ImageView profileLanguage1, profileLanguage2, profileLanguage3;

    private SimpleDraweeView profile_pic;


    private OnFragmentInteractionListener mListener;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        profileHeaderName = view.findViewById(R.id.profileHeaderName);
        profileHeaderLocation = view.findViewById(R.id.profileHeaderLocation);
        profileNameDetails = view.findViewById(R.id.profileNameDetails);
        profileLocationDetails = view.findViewById(R.id.profileLocationDetails);
        profileBioDetails = view.findViewById(R.id.profileBioDetails);
        profileLanguage1 = view.findViewById(R.id.profileLanguage1);
        profileLanguage2 = view.findViewById(R.id.profileLanguage2);
        profileLanguage3 = view.findViewById(R.id.profileLanguage3);
        profile_pic = view.findViewById(R.id.profilePic);

        GraphRequest request = GraphRequest.newMeRequest(
                ProfileSingleton.getInstance().getAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        try {
                            ProfileSingleton.getInstance().setCity(object.getJSONObject("hometown").getString("name"));
                            ProfileSingleton.getInstance().setBiography(object.getString("birthday"));
                            ProfileSingleton.getInstance().setEmail(object.getString("email"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "hometown,birthday,email");
        request.setParameters(parameters);
        request.executeAsync();

        profileHeaderName.setText(ProfileSingleton.getInstance().getName());
        profileHeaderLocation.setText(ProfileSingleton.getInstance().getCity());
        profileNameDetails.setText(ProfileSingleton.getInstance().getName());
        profileLocationDetails.setText(ProfileSingleton.getInstance().getCity());
        profileBioDetails.setText(ProfileSingleton.getInstance().getEmail());
        Uri uri = Uri.parse(ProfileSingleton.getInstance().getPhoto());
        profile_pic.setImageURI(uri);

        if(ProfileSingleton.getInstance().getLanguages().size() == 1){
            profileLanguage1.setVisibility(View.VISIBLE);
            setFlag(profileLanguage1,0);
            profileLanguage2.setVisibility(View.INVISIBLE);
            profileLanguage3.setVisibility(View.INVISIBLE);
        }else if(ProfileSingleton.getInstance().getLanguages().size() == 2){
            profileLanguage1.setVisibility(View.VISIBLE);
            profileLanguage2.setVisibility(View.VISIBLE);
            setFlag(profileLanguage1,0);
            setFlag(profileLanguage2,1);
            profileLanguage3.setVisibility(View.INVISIBLE);
        }else if(ProfileSingleton.getInstance().getLanguages().size() > 2){
            profileLanguage1.setVisibility(View.VISIBLE);
            profileLanguage2.setVisibility(View.VISIBLE);
            profileLanguage3.setVisibility(View.VISIBLE);
            setFlag(profileLanguage1,0);
            setFlag(profileLanguage2,1);
            setFlag(profileLanguage3,2);
        }





    }

    public void setFlag(ImageView img, int i){
        switch (ProfileSingleton.getInstance().getLanguages().get(i)){
            case "Espanol":
                img.setImageResource(R.drawable.espanol);
                break;

            case "Ingles":
                img.setImageResource(R.drawable.ingles);
                break;

            case "Italiano":
                img.setImageResource(R.drawable.italiano);
                break;

            case "Frances":
                img.setImageResource(R.drawable.frances);
                break;

            case "Japones":
                img.setImageResource(R.drawable.japones);
                break;

            case "Chino":
                img.setImageResource(R.drawable.chino);
                break;

            case "Coreano":
                img.setImageResource(R.drawable.coreano);
                break;

            case "Aleman":
                img.setImageResource(R.drawable.aleman);
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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
