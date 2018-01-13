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
public class MuseumFragment extends Fragment {


    public MuseumFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final List<Word> words = new ArrayList<>();


        words.add(new Word("TERRAKULTURE", "3, Lekki Road, Victoria Island, Lagos, Nigeria", R.drawable.te));

        words.add(new Word("NIKE ART GALLERY", "4 Lawrence Road, Ikoyi, Lagos, Nigeria", R.drawable.nikmaam));

        words.add(new Word("ART WORLD", "14 Matthew Street Off Ojuelegba Road Surulere, Lagos State, Nigeria", R.drawable.artworldd));




        words.add(new Word("NEGRO ART GALLERY", "77 Adeniran Ogunsanya St, Surulere, Lagos", R.drawable.negro));



        words.add(new Word("ARTS AND CRAFTS VILLAGE", "1, Kalejaiye Street, Idimu, Alimosho, Lagos, Nigeria, "
                , R.drawable.arts_village));

        words.add(new Word("NATIONAL ARTS THEATRE", " Iganmu, Lagos",  R.drawable.national_arts));





        WordAdapter wordAdapter = new WordAdapter(getActivity(), words,R.color.color_museum);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(wordAdapter);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            listView.setNestedScrollingEnabled(true);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

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
                                                        description = "Terra Kulture Arts and Studios Limited (formerly Terra Kulture Limited – The Nigerian Cultural Centre) is an educational and recreational organization set up in 2003 to promote the richness and diversity of Nigerian languages, arts and culture. Mrs. Bolanle Austen-Peters has an abiding passion and respect for all cultures and observed that there were few institutions effectively supporting Nigerian culture. There were, and remain, few places in Nigeria with the appropriate ambience for Nigerians and foreigners to learn about Nigeria’s cultural and linguistic heritage. In its 11 years of existence Terra Kulture has organized over 200 art exhibitions , 135 plays, 65 book readings and over 10000 individual adults and children, as well as school trips, have attended our language classes. In 2009 Terra Kulture established the Terra Kulture Auction house, one of only 2 art auction houses in Nigeria. The Auction House has organized numerous art auctions in Lagos and Abuja. The rest of the Centre is comprised of the Nigerian language and craft school, reading and documentation centre, food lounge, the Terra art gallery and the Terra Arena a multipurpose Theatre.";
                                                        break;
                                                    case 1:
                                                        phoneNumber = "0801 466 3664";
                                                        description ="Nike Art Gallery is an art gallery in Lagos owned by Nike Davies-Okundaye.[1][2] The gallery is arguably the largest of its kind in West Africa. Housed in a five-storey tall building, it boasts a collection of about 8,000 diverse artworks from various Nigerian artis";
                                                        break;
                                                    case 2:
                                                        phoneNumber = "0905 456 3423";
                                                        description = "AB ARTWORLD is Nigeria’s leading wholesale and retail outlet for fine art, graphics, craft and architectural materials in Nigeria anda leading provider of quality picture and art framing services.\n" +
                                                                "\n" +
                                                                "Headquartered in Lagos, the company has over 7 retail outlets located in Lagos, Benin, Port Harcourt, Ibadan and Abuja.\n" +
                                                                "\n" +
                                                                "AB ARTWORLD enjoys a wide range of technical and trade support from our overseas Partners in the United Kingdom, United States of America and China. We also have sole franchise for the Winsor and Newton range of products in Nigeria (The world’s leading art material company) as well as retail other top brands like Emafyl frames, Rotring, Schneider, Reeves, Polymark and Staedler. In addition, we have a strong retail relationship with over 20 other leading art material retailers nationwide.\n" +
                                                                "\n" +
                                                                "AB ARTWORLD has over the years been involved with various art exhibitions, organized art events and sponsored many art programs both nationally and internationally. Among these various programmed include:";
                                                        break;
                                                    case 3:
                                                        phoneNumber = "08033018769, 07025812396";
                                                        description = "Negro Art is a rich gallery with a wide display of paintings, drawings, sculpture, carvings, artworks from Nigerian and other African artists.";
                                                        break;
                                                    case 4:
                                                        phoneNumber = "08133303481, 07060754184";
                                                        description ="If you have lived all your life in the city of Lagos, I almost too sure you think Abuja is no match when it comes to the number of tourist destinations that are available for you to check out.\n" +
                                                                "\n" +
                                                                "However, you will be surprised at the tourist treasure trove the capital city is fast turning into. If you are a sucker for Nigerian/African art and culture, Abuja is the place to visit. A number of places are available for art lovers to explore, check out the renowned Ladi Kwali Pottery Studio, visit the Ushafa Pottery and Bwari Pottery Village to discover the art of pottery. The National Gallery of Art features contemporary and modern arts while the Nike Art Gallery boasts of an enviable collection of both contemporary and traditional styled colourful batiks.\n" +
                                                                "\n" +
                                                                "A visit to all these places without checking out the Arts and Craft village leaves your trip incomplete. Are you looking for an art souvenir or a piece of decorative art object? The Arts and Crafts Village is the place to see.";
                                                        break;
                                                    case 5:
                                                        phoneNumber = "0203 027 9779";
                                                        description = "The National Arts Theatre is the primary centre for the performing arts in Nigeria. The monument is located in Iganmu, Surulere, Lagos. Her construction was completed in 1976 in preparation for the Festival of Arts and Culture (FESTAC) in 1977. The collection of National Gallery of Modern Nigerian Art is housed in a section of this building.";
                                                        break;

                                                    default:
                                                        phoneNumber ="";
                                                        description="";


                                                }
                                                // Pass information to DetailActivity in order to show the chosen image and its details
                                                intent.putExtra("picture", picture);
                                                intent.putExtra("name", name);
                                                intent.putExtra("address", address);
                                                intent.putExtra("phoneNumber", phoneNumber);
                                                intent.putExtra("description",description);

                                                startActivity(intent, options.toBundle());
                                            }

                                        }
        );


        return rootView;
    }

}
