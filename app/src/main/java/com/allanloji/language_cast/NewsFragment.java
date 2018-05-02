package com.allanloji.language_cast;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.allanloji.language_cast.pojo.Event;
import com.allanloji.language_cast.pojo.News;

import java.util.ArrayList;
import java.util.List;

import static com.facebook.FacebookSdk.getApplicationContext;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NewsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class NewsFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private List<News> newsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private NewsAdapter mAdapter;


    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*initData();
        recyclerView = (RecyclerView) container.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(container.getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new NewsRecyclerViewAdapter(listEvent);
        recyclerView.setAdapter(adapter);*/
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false);
        

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerView = (RecyclerView) view.findViewById(R.id.newsRecycler_view);

        mAdapter = new NewsAdapter(newsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                News news = newsList.get(position);
                Intent intent = new Intent(getActivity(), EventDetailActivity.class);
                intent.putExtra("event_title", news.getTitle());
                intent.putExtra("event_image", news.getImage());
                intent.putExtra("event_description", news.getDescription());
                intent.putExtra("event_direction", news.getDirection());
                intent.putExtra("event_date", news.getDate());

                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareNewsData();

    }

    private void prepareNewsData() {
        News news = new News("Mad Max: Fury Road", "Language Cast Picnic Edition",
                "07 de Abril de 2018 de 15:00 a 18:00", "Asiste a esta experiencia para aprender y practicar idiomas a la vez que conocemos gente con gustos afines. \n" +
                "\n" +
                "Prepara tu mantel de cuadritos, tu canasta de caperucita roja, tu emparedado de crema de maní, tu botella de vino y asiste a nuestra primera edición de Language Cast en el bosque de Chapultepec.\n" +
                "\n" +
                "Nos vemos a las 3:00PM en la entrada del chapultepec sobre reforma donde estan los leones, es la entrada mas cercana al centro de cultura digital (la suavicrema) y de ahi nos metos al bosque de chapultepec. (Mapa: https://goo.gl/maps/8ZAaZqofdCJ2)\n" +
                "\n" +
                "Contaremos con juegos de mesa, cartas y otras dinamicas de integración, y si nos da tiempo hasta nos subimos a las lanchitas.\n" +
                "\n" +
                "Al ser al aire libre, te pedimos por favor que traigas lo que quieras consumir :)", "Entrada Los Leones 1a Seccion De Chapultepec," +
                "Ciudad de México");

        newsList.add(news);

        /*news = new News("Inside Out", "Animation, Kids & Family", "2015", "sdadasdsadasdadsadas");
        newsList.add(news);

        news = new News("Inside Out", "Animation, Kids & Family", "2015", "sdadasdsadasdadsadas");
        newsList.add(news);

        news = new News("Inside Out", "Animation, Kids & Family", "2015", "sdadasdsadasdadsadas");
        newsList.add(news);

        news = new News("Inside Out", "Animation, Kids & Family", "2015", "sdadasdsadasdadsadas");
        newsList.add(news);

        news = new News("Inside Out", "Animation, Kids & Family", "2015", "sdadasdsadasdadsadas");
        newsList.add(news);*/

        mAdapter.notifyDataSetChanged();
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
