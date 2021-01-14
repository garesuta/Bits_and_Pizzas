package com.example.bitsandpizzas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Inflate menu , this add items to th app bar
        getMenuInflater().inflate(R.menu.menu_main,menu);
        MenuItem item = menu.findItem(R.id.action_share);
        shareActionProvider =(ShareActionProvider) MenuItemCompat.getActionProvider(item);
        setShareActionIntent("Want to join me for pizza?");
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.action_create_order){
                Intent intent = new Intent(this, OrderActivity.class);
                startActivity(intent);
                return true;
        }
        else{
                return super.onOptionsItemSelected(item);
        }
    }
    private void setShareActionIntent(String text){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,text);
        shareActionProvider.setShareIntent(intent);
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter{
        public SectionsPagerAdapter(FragmentManager fm){
                super(fm);
            }
            @Override
            public int getCount() {
                return 4;
            }
            @Override
            public Fragment getItem(int position){
                if(position==0){
                    return new TopFragment();}
                else if (position ==1){
                    return new PizzaFragment();}
                else if (position ==2 ){
                    return new PastaFragment();}
                else{
                    return new StroresFragment();
                }
            }
            @Override
            public CharSequence getPageTitle(int position){
            if (position ==0){
                    return  getResources().getText(R.string.home_tab);}
            else if(position ==1) {
                    return getResources().getText(R.string.pizza_tab);}
            else if(position ==2){
                    return getResources().getText(R.string.pasta_tab);}
            else{
                    return getResources().getText(R.string.store_tab); }
            }
        }

}