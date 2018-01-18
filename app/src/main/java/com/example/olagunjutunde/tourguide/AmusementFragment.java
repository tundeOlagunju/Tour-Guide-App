package com.example.olagunjutunde.tourguide;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.animation;

/**
 * A simple {@link Fragment} subclass.
 */
public class AmusementFragment extends Fragment {


    public AmusementFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list,container,false);

        // Create a list of words
        final  List<Word> words = new ArrayList<>();


        words.add( new Word("FUN PLEX"," The Grant Suites/Ticklers, beside CMD, CMD road, Ketu, Lagos "
                ,R.drawable.fun_plex));

        words.add( new Word("TROTTER AND POP WATER PARK","6/18 Lekki-Epe Expressway, Lekki, Lagos Nigeria"
                ,R.drawable.funderland));

        words.add( new Word("FUNTASTICALAND","25, Olusoji Idowu Street, Near Mutual Assurance Building, Ilupeju, Lagos Nigeria",R.drawable.funsta));

        words.add( new Word("FUN FACTORY","Block A10, Plot 4, Admiralty Way, Lekki Estate Phase 1, Lekki, Lagos, Nigeria",R.drawable.funfac));

        words.add( new Word(" PLAYBARN","14C, Ladipo Omotesho Cole Street, Lekki Phase 1, Lekki, Lagos, Nigeria",R.drawable.play));


        words.add( new Word("APAPA AMUSEMENT PARK","34 Randle Close, Apapa, Lagos Nigeria",R.drawable.apapa));



        //create a custom  adapter whose data set is a list of words
        WordAdapter wordAdapter = new WordAdapter(getActivity(),words,R.color.color_amusement);

        //find the list view by its id
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        //set the adapter on the list view
        listView.setAdapter(wordAdapter);

        //Hide or show tool bar when scrolling with another view .Coordinator layout
        //does not work with list or grid view by default.Nested Scrolling needs to be enabled
        //on them.
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)

            // this notifies the coordinator layout when the app bar or list view should be scrolling
            listView.setNestedScrollingEnabled(true);



        //set a clickListener on each item in the list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                                // Get the  Word object at the given position the user clicked on
                                                Word word = words.get(position);

                                                int picture = word.getImgResourceId();
                                                String name = word.getName();
                                                String address = word.getAddress();

                                                Intent intent = new Intent(getActivity(), DetailsActivity.class);

                                                // Create an object containing information about our scene transition animation
                                                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(), view,
                                                        getString(R.string.picture_transition_name));

                                                String phoneNumber;
                                                String description;

                                                switch(position) {
                                                    case 0:
                                                        phoneNumber = "+234 802 224 2228, +234 817 999 1793";
                                                        description =  "Funplex Amusement Park offers great and unique entertainment and hospitality management also giving children a trilling experience.";

                                                        break;
                                                    case 1:
                                                        phoneNumber = "0703 417 0515, 0803 279 7176, 0705 818 6863";
                                                        description = "Trotter and Pop Water Park is a children recreational centre in Funderland Mall providing children with lots of relaxation and fun activities like swimming and other water-fun activities.";
                                                        break;
                                                    case 2:
                                                        phoneNumber = "0818 205 0575, 0803 720 8929 ,01 291 0975";
                                                        description = "FuntasticaLand is a children entertainment centre that offers them with an exciting attractions, play stations, 3D movies, video game arcades, dance machine, bouncy castles and more.";
                                                        break;
                                                    case 3:
                                                        phoneNumber = "0203 027 9779";
                                                        description ="Fun Factory is an amusement park and a recreational center full of fun,entertainment and enjoyment.";
                                                        break;
                                                    case 4:
                                                        phoneNumber = "+234 816 575 8159, +234 817 590 3591";
                                                        description = "Playbarn is a Playground and amusement park for children located in Lekki, Lagos.";
                                                        break;
                                                    case 5:
                                                        phoneNumber = "0903 111 0077, 0709 996 0077";
                                                        description = "Apapa Amusement Park is an amusement and theme park for children providing them with facilities to engage in sports and recreation, kid's rides and gaming experiences.";
                                                        break;

                                                    default:
                                                        phoneNumber ="";
                                                        description ="";


                                                }
                                                // Pass information to DetailActivity in order to show the chosen image and its details
                                                intent.putExtra("picture", picture);
                                                intent.putExtra("name", name);
                                                intent.putExtra("address", address);
                                                intent.putExtra("phoneNumber",phoneNumber);
                                                intent.putExtra("description",description);

                                                //start DetailsActivity passing on the corresponding information
                                                startActivity(intent, options.toBundle());
                                            }

                                        }
        );


        return rootView;
    }

}
