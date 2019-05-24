package com.example.tabla_periodica;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;


public class tabla_periodica extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,tabla.OnFragmentInteractionListener{
    public static CharSequence indetificador;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_periodica);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        Fragment fragment=new tabla();
        getSupportFragmentManager().beginTransaction().add(R.id.content_main,fragment).commit();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    return  false;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment miFragment=null;
        boolean fragmentS=false;

        if (id == R.id.nav_b) {

            Intent onClick_1=new Intent(this,busqueda.class);
            startActivity(onClick_1);
        } else if (id == R.id.nav_l) {
            Intent onClick_2=new Intent(this,lista.class);
            startActivity(onClick_2);


        } else if (id == R.id.nav_b_1) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "Instala Tabla_periodica app By System 32 https://www.facebook.com/jesus.JHAPT.3");
            startActivity(Intent.createChooser(intent, "Share with"));

        } else if (id == R.id.nav_b_2) {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","sanhool@live.com.mx", null));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Tabla_App");
            startActivity(Intent.createChooser(emailIntent,"Share email" ));
        } else if (id == R.id.nav_b_3) {

        } else if (id == R.id.nav_b_4) {

        }
        if(fragmentS==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, miFragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    public void onClick(View view){
        btn=findViewById(view.getId());
      indetificador= btn.getText();
        Intent onClick=new Intent(this,prueba.class);
        startActivity(onClick);

    }


}
