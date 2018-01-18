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
import static android.R.attr.descendantFocusability;

/**
 * A simple {@link Fragment} subclass.
 */
public class BarBeachesFragment extends Fragment {


    public BarBeachesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create a list of words
        final List<Word> words = new ArrayList<>();


        words.add(new Word("COCONUT BEACH", " Off Lagos-Badagry Expressway, Lagos"
                , R.drawable.coconut_beach));

        words.add(new Word("ATICAN BEACH", "Abraham Adesanya Estate Road, Eti-Osa, Lekki, Nigeria"
                , R.drawable.atic));

        words.add(new Word("HALESOM BEACH", "3, Lekki Road, Victoria Island, Lagos, Nigeria", R.drawable.halesom_beach));

        words.add(new Word("KURAMO BEACH", "4 Lawrence Road, Ikoyi, Lagos, Nigeria", R.drawable.kuramobeach));

        words.add(new Word("ELEGUSHI BEACH", "", R.drawable.elegush_beach));

        words.add(new Word("ELEKO BEACH", "56 km, Lekki-Epe Expressway Lagos", R.drawable.eleko_beach));


        //create a custom  adapter whose data set is a list of words
        WordAdapter wordAdapter = new WordAdapter(getActivity(), words, R.color.color_bar_beaches);

        //find the list view by its id
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        //set the adapter on the list view
        listView.setAdapter(wordAdapter);


        //Hide or show tool bar when scrolling with another view .Coordinator layout
        //does not work with list or grid view by default.Nested Scrolling needs to be enabled
        //on them.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
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

                                                switch (position) {
                                                    case 0:
                                                        phoneNumber = "0708 0326 697";
                                                        description = "Aptly named for its Coconut trees, this is a favourite beach in the coastal town of Badagry. The beach is located about 20 miles towards the border of Nigeria and the Republic of Benin. It is a great place to visit as a couple because Coconut Beach far removed from the noise of suburbia and is instead surrounded by holiday resorts, vacation huts, fresh air, palm trees, fresh air and an open sky." +
                                                                "The environment portrays an idyll defined by rural nature and nostalgia, a place where you can walk barefooted on the beach-white sand.";

                                                        break;
                                                    case 1:
                                                        phoneNumber = "+2348136774408, +234 818603452";
                                                        description = "Atican Beach resort is a pristine ocean-side destination in Lekki. The private beach resort is a centre for fun and relaxation. Its clean white sand and beautiful Carribean style layout make it a great destination for romantic getaways, group hang out and family outings.  It has lodges and a restaurant too! Whether you are looking for a great barbeque or cook-out location or a swimming pool with a great view, Atican Beach where you want to be.";
                                                        break;
                                                    case 2:
                                                        phoneNumber = "0905 456 3423";
                                                        description = "Every once in a while, people tend to crave a little peace and quiet; some ‘alone time’. I’m basically talking about the occasional need to get away from the hustle and bustle of the everyday working life. The Halemson Beach Resort is the ready-made haven for such occasions. Located on an exclusive beach overlooking the Atlantic Ocean, the resort provides a natural atmosphere of comfort, peace of mind, leisure and of course, fun.\n" +
                                                                "\n" +
                                                                "The resort is not just for the cool and calm, fun seekers are very well provided for too. Fully equipped with several indoor and outdoor recreational facilities such as a tennis court, badminton, ludo, chess, bikes for riding, card games, rope climbing exercises, monopoly, darts, a basketball court, volleyball, a football field and even a golf bunker. So if you’re looking to have fun during your “away” time, your needs will be very well catered for.";
                                                        break;
                                                    case 3:
                                                        phoneNumber = "0203 027 9779";
                                                        description = "Kuramo beach is a quiet, relaxing beach far removed from the hustle and bustle of Lagos. It offers a wide range of sporting activities to visitors. Everyone is invited whether you are here to converse with nature or to put your foot prints in the sands eternal";
                                                        break;
                                                    case 4:
                                                        phoneNumber = "01 236 66666";
                                                        description = "Eleko beach is a quiet, relaxing beach far removed from the hustle and bustle of Lagos. It offers a wide range of sporting activities to visitors. Everyone is invited whether you are here to converse with nature or to put your foot prints in the sands eternal";
                                                        break;
                                                    case 5:
                                                        phoneNumber = "0807 475 4455";
                                                        description = "Elegushi beach is a quiet, relaxing beach far removed from the hustle and bustle of Lagos. It offers a wide range of sporting activities to visitors. Everyone is invited whether you are here to converse with nature or to put your foot prints in the sands eternal.";
                                                        break;

                                                    default:
                                                        phoneNumber = "";
                                                        description = "";


                                                }
                                                // Pass information to DetailActivity in order to show the chosen image and its details
                                                intent.putExtra("picture", picture);
                                                intent.putExtra("name", name);
                                                intent.putExtra("address", address);
                                                intent.putExtra("phoneNumber", phoneNumber);
                                                intent.putExtra("description", description);

                                                //start DetailsActivity passing on the corresponding information
                                                startActivity(intent, options.toBundle());
                                            }

                                        }
        );


        return rootView;
    }

}
