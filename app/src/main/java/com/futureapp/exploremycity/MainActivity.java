package com.futureapp.exploremycity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private List<Custom_Items> list;
    public CustomAdapter adapter;
    private Toolbar toolbar;
    private TextView textView;
    NetworkInfo info;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);

        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setSupportActionBar(toolbar);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      //  getSupportActionBar().setDisplayShowHomeEnabled(true);


        dialog = new ProgressDialog(this);


        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(CONNECTIVITY_SERVICE);
        info = cm.getActiveNetworkInfo();
        if (info != null) {

            Toast.makeText(MainActivity.this, "Loading..", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(this, "No Internet Connection!", Toast.LENGTH_LONG).show();

        }

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        list = new ArrayList<>();

        list.add(new Custom_Items("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.euttaranchal.com%2Ftourism%2Fchamba.php&psig=AOvVaw1EL-etZ7KhcEvuJGFW9KJ0&ust=1634018183971000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLCelJ_WwfMCFQAAAAAdAAAAABAD"));
        list.add(new Custom_Items("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.euttaranchal.com%2Ftourism%2Fchamba.php&psig=AOvVaw1EL-etZ7KhcEvuJGFW9KJ0&ust=1634018183971000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLCelJ_WwfMCFQAAAAAdAAAAABAI"));
        list.add(new Custom_Items("https://www.google.com/url?sa=i&url=https%3A%2F%2Fdevdhamyatra.com%2Fblog%2Fchamba-best-hill-station-chamba-in-uttarakhand-travel-guide-2021&psig=AOvVaw1EL-etZ7KhcEvuJGFW9KJ0&ust=1634018183971000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLCelJ_WwfMCFQAAAAAdAAAAABAf"));
        list.add(new Custom_Items("https://www.google.com/url?sa=i&url=https%3A%2F%2Fbugyalvalley.com%2Futtarakhand-tourism%2Fnew-tehri%2Fchamba%2F&psig=AOvVaw1EL-etZ7KhcEvuJGFW9KJ0&ust=1634018183971000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLCelJ_WwfMCFQAAAAAdAAAAABAl"));
        list.add(new Custom_Items("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.holidify.com%2Fplaces%2Fchamba-uttarakhand&psig=AOvVaw1EL-etZ7KhcEvuJGFW9KJ0&ust=1634018183971000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLCelJ_WwfMCFQAAAAAdAAAAABAr"));
        list.add(new Custom_Items("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.crackvacancy.com%2F2021%2F04%2Fchamba-uttarakhand.html&psig=AOvVaw1EL-etZ7KhcEvuJGFW9KJ0&ust=1634018183971000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLCelJ_WwfMCFQAAAAAdAAAAABAx"));
        list.add(new Custom_Items("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.euttaranchal.com%2Ftourism%2Fphotos%2Fchamba-photos.php&psig=AOvVaw1EL-etZ7KhcEvuJGFW9KJ0&ust=1634018183971000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLCelJ_WwfMCFQAAAAAdAAAAABA3"));
        list.add(new Custom_Items("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.nationalheraldindia.com%2Findia%2Fmajor-breakthrough-in-tunnel-beneath-chamba-town-by-bro-in-char-dham-road-project&psig=AOvVaw1EL-etZ7KhcEvuJGFW9KJ0&ust=1634018183971000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLCelJ_WwfMCFQAAAAAdAAAAABA9"));
        list.add(new Custom_Items("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Fhamaruchamba%2F&psig=AOvVaw1EL-etZ7KhcEvuJGFW9KJ0&ust=1634018183971000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLCelJ_WwfMCFQAAAAAdAAAAABBD"));
        list.add(new Custom_Items("https://www.google.com/url?sa=i&url=http%3A%2F%2Fwww.choicemyhotel.com%2Fplaces-to-visit-in-chamba%2F&psig=AOvVaw1EL-etZ7KhcEvuJGFW9KJ0&ust=1634018183971000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLCelJ_WwfMCFQAAAAAdAAAAABBO"));
        list.add(new Custom_Items("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.quora.com%2FHow-is-Chamba-in-Uttarakhand&psig=AOvVaw1EL-etZ7KhcEvuJGFW9KJ0&ust=1634018183971000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLCelJ_WwfMCFQAAAAAdAAAAABBf"));
        list.add(new Custom_Items("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.tripadvisor.in%2FHotel_Review-g1131925-d3686387-Reviews-GMVN_Tourist_Rest_House_Chamba-Chamba_Tehri_Garhwal_District_Uttarakhand.html&psig=AOvVaw1EL-etZ7KhcEvuJGFW9KJ0&ust=1634018183971000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLCelJ_WwfMCFQAAAAAdAAAAABBl"));
        list.add(new Custom_Items("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.tripadvisor.in%2FHotel_Review-g1131925-d4222222-Reviews-Camp_Little_Jaguar-Chamba_Tehri_Garhwal_District_Uttarakhand.html&psig=AOvVaw1EL-etZ7KhcEvuJGFW9KJ0&ust=1634018183971000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLCelJ_WwfMCFQAAAAAdAAAAABBr"));
        list.add(new Custom_Items("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.uttarakhand.ws%2Ftehri%2Fnew-tehri%2Fchamba&psig=AOvVaw1EL-etZ7KhcEvuJGFW9KJ0&ust=1634018183971000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLCelJ_WwfMCFQAAAAAdAAAAABBw"));
        getdata();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }


    private void getdata() {


        adapter = new CustomAdapter(list, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        if (id == R.id.action_exit) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to Exit?");
            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    dialog.cancel();

                }
            });
            AlertDialog d = builder.create();
            d.show();

        }

        if (id == R.id.action_search) {

            finish();
            startActivity(getIntent());
            if (info != null) {
                getdata();

            } else {


                Toast.makeText(this, "Internet Not Connected!", Toast.LENGTH_SHORT).show();
            }


        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.wallpaper) {

            getdata();


        } else if (id == R.id.favorites) {

            getdata();

        }

         else if (id == R.id.rate_us) {
            //rateme();
        } else if (id == R.id.more_app) {

            //MoreApp();
         }  else if (id == R.id.videos) {


            Intent myintent = new Intent(this,videos.class);
           startActivity(myintent);

        }
        else if (id == R.id.Language) {


            Intent myintent = new Intent(this, Language.class);
            startActivity(myintent);
        }
            //Share

        else if (id == R.id.share) {


            Intent myintent = new Intent(Intent.ACTION_SEND);
            myintent.setType("text/plan");

            String shereBoday = "Your Boday Here";

            String shereSub = "\"http://play.google.com/store/apps/details?id=" + getPackageName();
            myintent.putExtra(Intent.EXTRA_SUBJECT, shereBoday);
            myintent.putExtra(Intent.EXTRA_TEXT, shereSub);
            startActivity(Intent.createChooser(myintent, "share Using"));

        }


        //Exit


        else if (id == R.id.exit) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to Exit?");
            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    dialog.cancel();

                }
            });
            AlertDialog d = builder.create();
            d.show();

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void MoreApp() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://developer?id=" + "Account Name!")));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/developer?id=" + "Account Name!")));


        }
    }




    public void rateme() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + "Your Package name!")));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
        }
    }


}