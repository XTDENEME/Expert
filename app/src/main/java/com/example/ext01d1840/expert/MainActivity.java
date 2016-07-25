package com.example.ext01d1840.expert;

import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
                   xtAnaSayfa.OnFragmentInteractionListener,
                   xtUrunCozum.OnFragmentInteractionListener ,
                   xtKariyer.OnFragmentInteractionListener,
                   xtIletisim.OnFragmentInteractionListener,
                   xtBekleyenIsler.OnFragmentInteractionListener,
                   xtCalisanBilgileri.OnFragmentInteractionListener,
                   xtTaskAtama.OnFragmentInteractionListener,
                   xtTakibimdekiIsler.OnFragmentInteractionListener,
                   xtSisLogin.OnFragmentInteractionListener
{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        xtAnaSayfa anasayfaFragment = new xtAnaSayfa();
        FragmentManager manager = getSupportFragmentManager();
        //manager.beginTransaction().replace(R.id.relativelayout_for_fragment,anasayfaFragment,anasayfaFragment.getTag()).commit();
        android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.relativelayout_for_fragment, anasayfaFragment).addToBackStack("anasayfa").commit();

        int count = getSupportFragmentManager().getBackStackEntryCount();

        if(count!=0) {
            FragmentManager.BackStackEntry backStackEntry = getSupportFragmentManager().getBackStackEntryAt(count - 1);

            if (backStackEntry.getName().contains("anasayfa")) {
                getSupportFragmentManager().popBackStack();
            }
        }

    }

   /* @Override   Aşağıdaki kod ile değiştirildi.
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }*/
   @Override
   public void onBackPressed() {

       // fragment sayısı bir ise uygulamadan çıkıyor
       if(getSupportFragmentManager().getBackStackEntryCount() != 1)
           super.onBackPressed();

       else {
           finish();
           System.exit(0);
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

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.



        int id = item.getItemId();

        if (id == R.id.itAnaSayfa) {

            xtAnaSayfa anaSayfa = new xtAnaSayfa();
            FragmentManager manager = getSupportFragmentManager();
           // manager.beginTransaction().replace(R.id.relativelayout_for_fragment,anaSayfa,anaSayfa.getTag()).commit();  Aşağıdaki iki satır ile değiştirildi
            android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.relativelayout_for_fragment, anaSayfa).addToBackStack("anasayfa").commit();

            //app bar üzerindeki başlığı değiştiriyoruz.
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());

            int count = getSupportFragmentManager().getBackStackEntryCount();

            if(count!=0) {
                // Son fragment alınıyor
                FragmentManager.BackStackEntry backStackEntry = getSupportFragmentManager().getBackStackEntryAt(count - 1);
                // Son fragment ile seçilen fragment aynı ise eski fragment siliniyor
                if (backStackEntry.getName().contains("anasayfa")) {
                    getSupportFragmentManager().popBackStack();
                }
            }


        } else if (id == R.id.itSistemeGiris) {

            xtSisLogin sisLogin = new xtSisLogin();
            FragmentManager manager = getSupportFragmentManager();
           // manager.beginTransaction().replace(R.id.relativelayout_for_fragment,sisLogin,sisLogin.getTag()).commit(); Aşağıdaki iki satır ile değiştirildi
            android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.relativelayout_for_fragment, sisLogin).addToBackStack("login").commit();
            //app bar üzerindeki başlığı değiştiriyoruz.
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());

            int count = getSupportFragmentManager().getBackStackEntryCount();

            if(count!=0) {
                // Son fragment alınıyor
                FragmentManager.BackStackEntry backStackEntry = getSupportFragmentManager().getBackStackEntryAt(count - 1);

                // Son fragment ile seçilen fragment aynı ise eski fragment siliniyor
                if (backStackEntry.getName().contains("login")) {
                    getSupportFragmentManager().popBackStack();
                }
            }

            /*Intent sistemGiris = new Intent(this,xtSistemeGiris.class);
            startActivity(sistemGiris);*/

        } else if (id == R.id.itKariyer) {

            xtKariyer kariyerFıirsatlari = new xtKariyer();
            FragmentManager manager = getSupportFragmentManager();
           // manager.beginTransaction().replace(R.id.relativelayout_for_fragment,kariyerFıirsatlari,kariyerFıirsatlari.getTag()).commit();
            android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.relativelayout_for_fragment, kariyerFıirsatlari).addToBackStack("kariyer").commit();

            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());

            int count = getSupportFragmentManager().getBackStackEntryCount();

            if(count!=0) {
                // Son fragment alınıyor
                FragmentManager.BackStackEntry backStackEntry = getSupportFragmentManager().getBackStackEntryAt(count - 1);

                // Son fragment ile seçilen fragment aynı ise eski fragment siliniyor
                if (backStackEntry.getName().contains("kariyer")) {
                    getSupportFragmentManager().popBackStack();
                }
            }

        } else if (id == R.id.itUrunCozum) {

            xtUrunCozum urunCozum = new xtUrunCozum();
            FragmentManager manager = getSupportFragmentManager();
            //manager.beginTransaction().replace(R.id.relativelayout_for_fragment,urunCozum,urunCozum.getTag()).commit();
            android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.relativelayout_for_fragment, urunCozum).addToBackStack("urun").commit();

            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());

            int count = getSupportFragmentManager().getBackStackEntryCount();

            if(count!=0) {
                // Son fragment alınıyor
                FragmentManager.BackStackEntry backStackEntry = getSupportFragmentManager().getBackStackEntryAt(count - 1);

                // Son fragment ile seçilen fragment aynı ise eski fragment siliniyor
                if (backStackEntry.getName().contains("urun")) {
                    getSupportFragmentManager().popBackStack();
                }
            }

        } else if (id == R.id.itWebSayfası){

            Uri uri = Uri.parse("https://www.experteam.com.tr/");       //experteam websitesine yönlendirilecektir.
            Intent web = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(web);



        } else if (id == R.id.itIletisim){

            xtIletisim iletisim = new xtIletisim();
            FragmentManager manager = getSupportFragmentManager();
            //manager.beginTransaction().replace(R.id.relativelayout_for_fragment,iletisim,iletisim.getTag()).commit();
            android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.relativelayout_for_fragment, iletisim).addToBackStack("iletisim").commit();

            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());

            int count = getSupportFragmentManager().getBackStackEntryCount();

            if(count!=0) {
                // Son fragment alınıyor
                FragmentManager.BackStackEntry backStackEntry = getSupportFragmentManager().getBackStackEntryAt(count - 1);

                // Son fragment ile seçilen fragment aynı ise eski fragment siliniyor
                if (backStackEntry.getName().contains("iletisim")) {
                    getSupportFragmentManager().popBackStack();
                }
            }

        }
        else if (id == R.id.itCalisanBilgileri) {

            xtCalisanBilgileri calisanBilgileri = new xtCalisanBilgileri();
            FragmentManager manager = getSupportFragmentManager();
            //manager.beginTransaction().replace(R.id.relativelayout_for_fragment,calisanBilgileri,calisanBilgileri.getTag()).commit();
            android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.relativelayout_for_fragment, calisanBilgileri).addToBackStack("calisan").commit();

            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());

            int count = getSupportFragmentManager().getBackStackEntryCount();

            if(count!=0) {
                // Son fragment alınıyor
                FragmentManager.BackStackEntry backStackEntry = getSupportFragmentManager().getBackStackEntryAt(count - 1);

                // Son fragment ile seçilen fragment aynı ise eski fragment siliniyor
                if (backStackEntry.getName().contains("calisan")) {
                    getSupportFragmentManager().popBackStack();
                }
            }

        } else if (id == R.id.itBekleyenIsler) {

            xtBekleyenIsler bekleyenIsler = new xtBekleyenIsler();
            FragmentManager manager = getSupportFragmentManager();
           // manager.beginTransaction().replace(R.id.relativelayout_for_fragment,bekleyenIsler,bekleyenIsler.getTag()).commit();

            android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.relativelayout_for_fragment, bekleyenIsler).addToBackStack("bekleyen").commit();

            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());

            int count = getSupportFragmentManager().getBackStackEntryCount();

            if(count!=0) {
                // Son fragment alınıyor
                FragmentManager.BackStackEntry backStackEntry = getSupportFragmentManager().getBackStackEntryAt(count - 1);

                // Son fragment ile seçilen fragment aynı ise eski fragment siliniyor
                if (backStackEntry.getName().contains("bekleyen")) {
                    getSupportFragmentManager().popBackStack();
                }
            }

        }else if (id == R.id.itTaskAtama) {

            xtTaskAtama taskAtama = new xtTaskAtama();
            FragmentManager manager = getSupportFragmentManager();
            //manager.beginTransaction().replace(R.id.relativelayout_for_fragment,taskAtama,taskAtama.getTag()).commit();

            android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.relativelayout_for_fragment, taskAtama).addToBackStack("task").commit();

            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());

            int count = getSupportFragmentManager().getBackStackEntryCount();



            if(count!=0) {
                // Son fragment alınıyor
                FragmentManager.BackStackEntry backStackEntry = getSupportFragmentManager().getBackStackEntryAt(count - 1);

                // Son fragment ile seçilen fragment aynı ise eski fragment siliniyor
                if (backStackEntry.getName().contains("task")) {
                    getSupportFragmentManager().popBackStack();
                }
            }

        }else if (id == R.id.itTakibimdekiIsler) {

            xtTakibimdekiIsler takibimdekiIsler = new xtTakibimdekiIsler();
            FragmentManager manager = getSupportFragmentManager();
            //manager.beginTransaction().replace(R.id.relativelayout_for_fragment,takibimdekiIsler,takibimdekiIsler.getTag()).commit();

            android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.relativelayout_for_fragment, takibimdekiIsler).addToBackStack("takibim").commit();

            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());

            int count = getSupportFragmentManager().getBackStackEntryCount();

            if(count!=0) {
                // Son fragment alınıyor
                FragmentManager.BackStackEntry backStackEntry = getSupportFragmentManager().getBackStackEntryAt(count - 1);

                // Son fragment ile seçilen fragment aynı ise eski fragment siliniyor
                if (backStackEntry.getName().contains("takibim")) {
                    getSupportFragmentManager().popBackStack();
                }
            }

        }else if(id == R.id.itTelefon){

            Uri uri = Uri.parse("tel:+90 216 427 41 41");
            Intent tel = new Intent(Intent.ACTION_DIAL,uri);
            startActivity(tel);



        }else if (id == R.id.itPaylas){
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND); //Share intentini oluşturuyoruz
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "EXPERTEAM");//share mesaj konusu
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "https://www.experteam.com.tr/");//share mesaj içeriği
            startActivity(Intent.createChooser(sharingIntent, "Paylaşmak İçin Seçiniz"));//Share intentini başlığı ile birlikte başlatıyoruz


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }



}
