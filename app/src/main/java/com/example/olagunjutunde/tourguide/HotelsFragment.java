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
public class HotelsFragment extends Fragment {


    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View rootView = inflater.inflate(R.layout.word_list,container,false);

        // Create a list of words
      final  List<Word> words = new ArrayList<>();


   words.add( new Word("FEDERAL PLACE HOTEL ","6-8, Ahmadu Bellow Way, Victoria Island, Victoria Island, Lagos ,Nigeria. "
           ,R.drawable.federal_place_hotel));

        words.add( new Word("THE GEORGE","30 Lugard Avenue, Ikoyi, Lagos, Nigeria"
                ,R.drawable.the_george));

        words.add( new Word("LAGOS ORIENTAL","3, Lekki Road, Victoria Island, Lagos, Nigeria",R.drawable.lagos_oriental));

        words.add( new Word("THE WHEATBAKER","4 Lawrence Road, Ikoyi, Lagos, Nigeria",R.drawable.the_wheatbreaker));

        words.add( new Word("INTERCONTINENTAL LAGOS","Kofo Abayomi Street - Plot 52,victoria Island, Lagos",R.drawable.intercontinental));


        words.add( new Word("PROTEA HOTEL","42/44 Isaac John Street, GRA, Ikeja, Lagos, Nigeria",R.drawable.the_proteajpg));
        words.add( new Word("SHERATON","30 Mobolaji Bank Anthony Way, Airport Road, Ikeja, Lagos, Nigeria",R.drawable.sheratonjpg));
        words.add( new Word("MAISON FAHRENHEIT","80 Adetokunbo Ademola Street, Victoria Island, Lagos, Nigeria",R.drawable.maison));
        words.add( new Word("DE SANTOS HOTEL","7 Shasha Road, Akowonjo Roundabout, Lagos, Nigeria,",R.drawable.de_santos));


        //create a custom  adapter whose data set is a list of words
        WordAdapter wordAdapter = new WordAdapter(getActivity(),words,R.color.color_hotels);

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

                //get the image at that position
                int picture = word.getImgResourceId();
                //get the name at that position
                String name = word.getName();
                //get the address at the current position
                String address = word.getAddress();

                Intent intent = new Intent(getActivity(), DetailsActivity.class);

                // Create an object containing information about our scene transition animation
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(), view,
                        getString(R.string.picture_transition_name));

                String phoneNumber;
                String description;

                switch(position) {
                    case 0:
                        phoneNumber = "01 277 9000";
                        description =  " Located in a serene part of the city, it offers a sight of breathtaking beauty with its architectural design and surrounding lush green landscape.\n" +
                                "\n" +
                                "The Federal Palace Hotel offers an assortment of rooms that fall into room categories of: Twin rooms, King rooms, Junior Suite, 1 bedroom apartments and 2 bedroom apartments. These rooms are adorned with an exquisite interior decor and high-grade facilities which include air conditioning, flat screen television sets with multi-channel satellite connection, key card security system, luxurious beds, sofas, wireless internet connection, en-suite bathroom with jacuzzi plus work desks and chairs.\n" +
                                "\n" +
                                "An array of excellent hotel services is also provided for guests at the Federal Palace Hotel. These include: restaurants with top standard culinary outputs over a wide variety of local and intercontinental cuisines, outdoor pool, casino, bar/lounge well stocked with the finest quality wines, spirits and other beverages, adequate security arrangement, event hall, convenient parking arrangements, conference facilities, meeting and executive boardrooms plus a well-equipped gym.\n" +
                                "\n" +
                                "Extra services offered at the Federal Palace Hotels include: 24 hours front desk, room service, laundry and shuttle services, gift shop and a business centr";

                        break;
                        case 1:
                            phoneNumber = "01 466 3660";
                            description = "Situated in Lagos and with Sport Centre reachable within 900 metres, The George Hotel features an outdoor swimming pool, non-smoking rooms, free WiFi throughout the property and a fitness centre. Boasting a 24-hour front desk, this property also boasts a restaurant and a terrace. Located in the Ikoyi district, the hotel is within 1.5 km of Police Medical Centre.\n" +
                                    "The rooms feature air conditioning, a seating area, a flat-screen TV with satellite channels, a kitchenette, a dining area and a private bathroom with free toiletries, a shower and a hairdryer. The rooms are fitted with a coffee machine, while some rooms have a terrace and others also feature pool views. All rooms have a desk.\n" +
                                    "\n" +
                                    "Guests at the hotel can enjoy a continental breakfast.\n" +
                                    "\n" +
                                    "Falomo Bridge Jetty is 2.1 km from The George Hotel, while Muri Okunola Park is 2.2 km away. \n" +
                                    "\n" +
                                    "Ikoyi is a great choice for travellers interested in business, friendly locals and beaches.\n" +
                                    "\n" +
                                    "We speak your language!";
                            break;
                    case 2:
                        phoneNumber = "01 280 6600";
                        description = "When entering the Lagos Oriental Hotel, you feel an atmosphere inspired by a dynamic modernity.\n" +
                                "All facilities, from the Chinese Restaurant, the Japanese Gourmet Restaurant, the Lobby Lounge & Bar’s and the Grand Ballroom to the guest rooms and suites, meet the most exacting demands for comfort and service. Hospitality in the best Lagos Oriental Hotel tradition has been reborn.\n" +
                                "Lagos Oriental Hotel promises excellent accommodation, business and leisure experiences with 64 guestrooms including 9 spacious suites.\n" +
                                "\n" +
                                "With enchanting views of the lagoon each one of our guestrooms offers guests a unique combination of luxury and style and ranging in size from 60 to 300 square meters.\n" +
                                "\n" +
                                "Where modern style meets unquestionable comfort, Lagos Oriental Hotel’s guestrooms feature original artwork complimenting the Asian furnishings. The muted colour schemes contrast with a backdrop of city lights and skyscrapers. All our rooms have LCD flat screen televisions, wired or wireless internet access, individual air conditioning control, In room safe, complimentary tea and coffee making facilities, luxurious bathrobes and slippers.";
                        break;
                    case 3:
                        phoneNumber = " 01 277 3560";
                        description ="The Wheatbaker Hotel offers quality accommodation and a great service. Set in a prime location just five kilometres from the city and 30 kilometres from the airport, this 4.5-star hotel attracts numerous travellers each year. The British Council, Bitts Travel & Tours, and National Museum are all located within a short distance. At The Wheatbaker Hotel, all rooms are tastefully furnished to provide the highest degree of comfort and convenience. The hotel offers standard facilities such as hair dryer, in room safe, separate shower and tub, bathrobes, and mini bar in each room. The excellent service and superior facilities make for an unforgettable stay. To provide guests with the greatest comfort, the hotel provides a concierge, laundry service/dry cleaning, a poolside bar, parking lot and a business centre. In addition, guests can relax in the spa, sauna, steam room, massage parlour, and the outdoor pool. ";
                        break;
                    case 4:
                        phoneNumber = "01 236 66666";
                        description ="Intercontinental Hotel Lagos is a 5-Star hotel lying in the popular high-brow area of Lagos, at Plot 52, Kofo Abayomi Street, Victoria Island, Lagos, Nigeria. It is the tallest hospitality building in Nigeria, and with its terraces, it offers splendid views of the Lagos city, most importantly the Lagos Port and Lagos skyline. It is a 30-minute drive away from Ikoyi Club; with its proximity to Silverbird Cinemas and Embassies also, it has the right location for guests to enjoy their stay. \n" +
                                "\n" +
                                "The 23-storey houses 358 exquisite rooms and suites categorised into: King Superior, Intercontinental Club, Club King, One Bedroom Ambassador Suite, and One Bedroom Deluxe Suite. Rooms in Intercontinental Hotel Lagos are luxurious and exquisitely furnished with king-size beds, fine tapestries from around the world, air -conditioners, ornate lampshade, DVD-player, a refrigerator, a flat-screen TV with satellite reception, a work desk and chair, a wardrobe and a balcony that offers a breath-taking view of the surrounding. The rooms also come with a bathtub, a private bathroom with a hairdryer and a bathrobe.\n" +
                                "\n" +
                                "Guests can enjoy the free Wi-Fi access and the swimming sessions at the Intercontinental Hotel Lagos outdoor swimming pool, and workout session at the ultramodern fitness centre. It also houses a spa that offers a variety of services ranging from facials, hairstyling, and general body grooming. Intercontinental Hotel Lagos provides families with free cribs/infant beds, free rollaway/extra beds and a connecting/adjoining rooms which ensure that family members are not separated. It provides a 24-hour front desk service and has 4 restaurants that serve local and continental meals. Breakfast is available but at a surcharge. Milano Restaurant offers a fine Italian experience. The Ekaabo restaurant serves a buffet of Nigerian, Italian, Chinese and Indian specialities. A variety of alcoholic and non-alcoholic drinks are available at the Ariya Terrace and Milano Bar. Guests can also enjoy the 24-hour room service. ";
                        break;
                    case 5:
                        phoneNumber = "0203 027 9779";
                        description = "Protea Hotel is an elegant 4-Star hotel located in the calm and secure residential area of 42/44 Isaac John Street, GRA, Ikeja. It is the place to be for excellent customer service and a wonderful shopping experience. It is arranged over three floors, making it a visible structure around its surroundings.\n" +
                                "\n" +
                                "Protea Hotel Ikeja features 92 rooms that are exquisitely fitted with LCD TVs, high-speed internet connection, air conditioners, comfortable beds and sofas, en-suite bathrooms, minibars, worktables and chairs, refrigerators, in-room safes, and coffee making facilities. The rooms are classified into: Standard Room, Deluxe, Junior Suite, Presidential Suite and Executive Suite.\n" +
                                "\n" +
                                "Protea Hotel Ikeja offers a variety of local, African, and continental dishes which are served at the restaurant, as well as a bar that houses an array of assorted alcoholic and non-alcoholic drinks. There is a common area where guests can have coffee or tea as well as a buffet service. It owns an outdoor pool where guests can relax with cocktails ordered from the poolside bar. Guests can also undergo fitness exercises at the fully equipped gymnasium, and get a nerve calming massage at the body spa. Four flexible event facilities with complimentary Wi-Fi are available for guests depending on the occasion, whether it is a business or a social gathering.";
                        break;

                    case 6:
                        phoneNumber = "0809 675 4567";
                        description = "Located at 30 Mobolaji Bank Anthony Way, close to the Murtala Muhammed International Airport, Sheraton Lagos Hotel offers luxury accommodation to its guests. This 5-star hotel is a favourite amongst the elite and treats its guest to recreational activities at its tennis court and casino.\n" +
                                "\n" +
                                "Sheraton Lagos Hotel has a total of 325 guest rooms and 7 Suites furnished with signature Sheraton beds, providing superior comfort to lodgers. The rooms are classified into Junior Suite, Club Room, Classic Room, Business Suite, Diplomatic Suite and Presidential Suite. Each elegant room includes a flat-screen TV with cable connection, air conditioning, ornate lampshades, a work area, a seating area, and a dining area. Guests are also provided with an electric kettle or coffee machine, a hairdryer, and free toiletries. Free Wi-Fi access is available throughout the hotel premises. \n" +
                                "\n" +
                                "At Sheraton Lagos, guests can take a dip in the swimming pool, enjoy a game of tennis or break a sweat at the fitness centre. It also boasts of modern event and conference facilities with Wi-Fi access and hi-tech audiovisual equipment in each of the four meeting spaces and ballrooms. Sheraton Lagos Hotel has several restaurants and bars called the Goodies Pub, La Giara, Terrace Bar and the Crock Pot. The Goodies Pub offers evening cocktail. Local Nigeria Cuisine is served at the Crock Pot Restaurant. At dinner time, La Giara serves Italian delights, home-made pizzas and wine. Drinks and fun are available at the Oasis Pool Terrace Bar, especially on Wazobia nights. Guests may also make use of the ATM for financial transactions.\n" +
                                "\n" +
                                "Sheraton Hotel offers on-site parking, car hire and airport shuttle services. Guests at Sheraton Lagos also enjoy 24-hour room service, concierge services, laundry services, and daily housekeeping services. Guests may also make use of the safety deposit boxes available at the hotel. The complex is guarded round the clock by professional security officials.\n";
                        break;
                    case 7:
                        phoneNumber = "01 905 4800";
                        description = "Maison Fahrenheit Hotel is a complete package of luxury, elegance and serenity. It offers a unique blend of Western and unique African hospitality treatment. It is situated within the corridors of core business activities at 80 Ademola Adetokunbo Street, Victoria Island, Lagos. It has luxurious rooms and facilities well suited to the needs of every guest.\n" +
                                "\n" +
                                "The massive structure of the hotel houses 26 rooms and 4 suites categorised as Standard, Deluxe, Executive and Wow suites. All rooms are well-appointed with an eclectic fusion of ultramodern and vintage decor as well as in-room amenities such as air purifier, work table, comfortable beds, air conditioners and flat HD TV sets. Each room has a sitting area, designer bathrooms and offers a unique ocean view. Checked-in guests are treated to a lavish complimentary breakfast.";
                        break;
                    case 8:
                        phoneNumber = "0817 204 2990";
                        description ="De Santos Hotel is a 3-Star hotel perfect for leisure guests and business travellers. De Santos Hotel Limited is located in 7, Shasha Road, Akowonjo Roundabout, Dopemu, Agege, Lagos, Nigeria. \n" +
                                "\n" +
                                "De Santos Hotel has rooms that come furnished with soft beds, ensuite toilet and bath, sofas, air conditioner, and side dressers. It has rooms of varying sizes, with different facilities all fitted for comfort. The rooms come as: Standard Rooms, Deluxe Rooms, Super Deluxe Rooms, Executive Rooms and De Santos Suites. \n" +
                                "\n" +
                                "A number of facilities are available at De Santos Hotel. These include a restaurant and bar. The restaurant serves up mouth-watering dishes, and the bar is stocked with a variety of alcoholic and non-alcoholic drinks. Guests can relax, mingle or enjoy light snacks in the lounge. At De Santos Hotel, guests can enjoy swimming or just a quiet time by the pool. The outdoor pool is available for both swimming and relaxing. Onsite parking and security are available at the hotel to ensure the safety of lives and property. \n" +
                                "\n" +
                                "The hotel offers additional services on request such as laundry service and car hire services, all available at an added charge.";
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


                //start the details activity passing on the corresponding information for each position
                startActivity(intent, options.toBundle());
            }

            }
        );


                return rootView;
    }

}
