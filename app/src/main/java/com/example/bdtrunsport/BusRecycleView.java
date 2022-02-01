package com.example.bdtrunsport;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bdtrunsport.adapter.BusListAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BusRecycleView extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Buslist> buslistArrayList;
    BusListAdapter busListAdapter;
    String[] busName,briefRoutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_recycle_view);

        recyclerView = findViewById(R.id.busRecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        buslistArrayList = new ArrayList<Buslist>();



         busName = new String[]{
                "Achim Paribahan",
                "Agradut-Paribahan",
                "Airport Bangabandhu Avenue",
                 "Akash Enterprise",
                 "Akik Paribahan",
                 "Al Madina Plus One",
                 "Al Makka Transport",
                 "Alif Enterprise",
                 "Alike",
                 "Anabil",
                 "Ashian Transport",
                 "Ashirbad Paribahan",
                 "Ashulia Classic",
                 "Asmani Paribahan",
                 "Ayat",
                 //A-15
                "BRTC",
                 "Balaka Pribahan",
                "Basumati Transport",
                 "Best Shatabdi",
                 "Best Transport",
                 "Bhuiyan Paribahan",
                 "Bihanga",
                "Bikalpa",
                 "Bikash",
                 //B-9
                 "Cantonment Bus Service",
                 "Cantonment Mini Servvice",
                 "Champion",
                 "City Link",
                 //c-4
                 "D-Link",
                 "Deepan",
                 "Desh Bangla",
                 "Dhaka Chaka 1",
                 "Dhaka Chaka 2",
                 "Dhaka Metro Services",
                 "Dipon",
                 "Dishari",
                 //d-8
                 "Elite",
                 "ETC Transport",
                 "Everest Transport",
                 //e-3
                 "First Ten",
                 "FTCL 1",
                 "FTCL 2",
                 //f-3
                 "Gazipur Paribahan",
                 "Grameen",
                 "Gulshan Dhaka",
                 "Green Dhaka",
                 //g-4
                 "Hazi Transport",
                 "Himachal",
                 "Himalay",
                 //h-3
                 "Itihas",
                 //i-1
                 "JM Super Paribahan",
                 "Jabalenur Paribahan 1",
                 "Jabalenur Paribahan 2",
                 "Janjabil",
                 //j-4
                 "Kamal Plus Paribahan",
                 "Kanak",
                 "Khajababa",
                 "Kiron Mala Paribahan",
                 //k-4
                 "Labbayek",
                 "Lal Sobuj",
                 "Lams Paribahan",
                 //L-3
                 "Malancha",
                 "Manjil Express",
                 "Meghla Transport",
                 "Midline",
                 "Mirpur Link",
                 "Mirpur Mission",
                 "Moitri",
                 //m-7
                 "New Vision",
                 "Nilachal",
                 "Nisorgo",
                 "No 7",
                 "No 13",
                 "No 4",
                 "No 6",
                 "No 8",
                 "No 9",
                 //n-9
                 "Pallabi",
                 "Pallabi Super",
                 "Projapoti",
                 //p-3
                 "Rajanigandha",
                 "Ramjan",
                 "Robrob",
                 //r-3
                 "Salsabil",
                 "Savar Poribahan",
                 "Shadhin",
                 "Savar Poribahan 2",
                 //s-4
                 "Taranga Plus",
                 "Thikana",
                 "Titas",
                 "Trust",
                 //t-4
                 "VIP 27",
                 //v-1
                 "Welcome",
                 "Winner",

         };

        briefRoutes = new String[]{
                getString(R.string.Achim),
                getString(R.string.Agradut),
                getString(R.string.Airport),
                getString(R.string.Akash),
                getString(R.string.Akik),
                getString(R.string.AlMadina),
                getString(R.string.AlMakka),
                getString(R.string.Alif),
                getString(R.string.Alike),
                getString(R.string.Anabil),
                getString(R.string.Ashian),
                getString(R.string.Ashirbad),
                getString(R.string.Ashulia),
                getString(R.string.Asmani),
                getString(R.string.Ayat),

                getString(R.string.BRTC),
                getString(R.string.Bolaka),
                getString(R.string.BasumatiTransport),
                getString(R.string.BestShatabdi),
                getString(R.string.BestTransport),
                getString(R.string.BhuiyanParibahan),
                getString(R.string.Bihanga),
                getString(R.string.Bikalpa),
                getString(R.string.Bikash),

                getString(R.string.CBS),
                getString(R.string.CMS),
                getString(R.string.Champion),
                getString(R.string.CityLink),

                getString(R.string.DLink),
                getString(R.string.Deepan),
                getString(R.string.DeshBangla),
                getString(R.string.DhakaChaka1),
                getString(R.string.DhakaChaka2),
                getString(R.string.DhakaMetroService),
                getString(R.string.Dipon),
                getString(R.string.Dishari),

                getString(R.string.Elite),
                getString(R.string.ETCTransport),
                getString(R.string.EverestParibahan),

                getString(R.string.FirstTen),
                getString(R.string.FTCL1),
                getString(R.string.FTCL2),

                getString(R.string.Gazipurparibahan),
                getString(R.string.Grameen),
                getString(R.string.GulshanDhaka),
                getString(R.string.GreenDhaka),

                getString(R.string.HajiTransport),
                getString(R.string.Himachal),
                getString(R.string.Himalaya),

                getString(R.string.Itihash),

                getString(R.string.JMSuperParibahan),
                getString(R.string.JabalaNoorParibahan1),
                getString(R.string.JabalaNoorParibahan2),
                getString(R.string.Janjabil),

                getString(R.string.KamalPlusParibahan),
                getString(R.string.Kanak),
                getString(R.string.Khajababa),
                getString(R.string.kironmalaParibahan),

                getString(R.string.Labbayek),
                getString(R.string.LalSobuj),
                getString(R.string.LamsParibahan),

                getString(R.string.Malancha),
                getString(R.string.ManjilExpress),
                getString(R.string.MeghlaTransport),
                getString(R.string.Midline),
                getString(R.string.MirpurLink),
                getString(R.string.MirpurMission),
                getString(R.string.Moitri),

                getString(R.string.NewVision),
                getString(R.string.Nilachal),
                getString(R.string.Nishorgo),
                getString(R.string.no7),
                getString(R.string.No13),
                getString(R.string.No4),
                getString(R.string.No6),
                getString(R.string.No8),
                getString(R.string.No9),

                getString(R.string.Pallabi),
                getString(R.string.PallabiSuper),
                getString(R.string.Projapoti),

                getString(R.string.Rajanigandha),
                getString(R.string.Ramjan),
                getString(R.string.Robrob),

                getString(R.string.Salsabil),
                getString(R.string.SavarParibahan),
                getString(R.string.Shadhin),
                getString(R.string.SavarParibahan2),

                getString(R.string.TarangaPlus),
                getString(R.string.Thikana),
                getString(R.string.Titas),
                getString(R.string.Trust),

                getString(R.string.VIP27),

                getString(R.string.Welcome),
                getString(R.string.Winner)

        };

        getdata();
    }

    private void getdata() {

        for (int i=0;i<busName.length;i++){
            Buslist buslist = new Buslist(busName[i],briefRoutes[i]);
            buslistArrayList.add(buslist);
        }


        Collections.sort(buslistArrayList, new Comparator<Buslist>() {
            @Override
            public int compare(Buslist o1, Buslist o2) {

                return  o1.BusName.compareToIgnoreCase(o2.BusName);

            }
        });

        busListAdapter = new BusListAdapter(this,buslistArrayList);
        recyclerView.setAdapter(busListAdapter);
        busListAdapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {

        getMenuInflater().inflate(R.menu.bus_search,menu);
        MenuItem menuItem = menu.findItem(R.id.search_action);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Search here");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                busListAdapter.getFilter().filter(newText);
                return false;

            }
        });

        return super.onCreatePanelMenu(featureId, menu);
    }
}