package com.htamta.gamesfinder.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;
import com.htamta.gamesfinder.Model.GameJSON.ResponseGames;
import com.htamta.gamesfinder.Model.GameViewModel;
import com.htamta.gamesfinder.R;
import com.htamta.gamesfinder.adapters.GamesRecycler;
import com.htamta.gamesfinder.databinding.ActivityMainBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;


public class MainActivity extends AppCompatActivity implements GamesRecycler.ListItemClickListener, NavigationView.OnNavigationItemSelectedListener {
    private GameViewModel viewModel;
    private ActivityMainBinding b;
    private List<ResponseGames> GamesList=new ArrayList<>();
    private MainActivity s = this;
    private String Genre=null;
    private String PageNumber=null;
    private String Platform;
    private String Order;
    private String SearchText="";
    private boolean isSearchingNow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(GameViewModel.class);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        b.text.setLayoutManager(gridLayoutManager);
        spinnerHandler();
        spinnerPlHandler();
        HandleSearch();
        setAdapter();
        NavigationDrawer();
        HandlePages();
    }

    private void NavigationDrawer() {
        b.nav.bringToFront();
        b.nav.setItemIconTintList(null);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,b.DrawerLayout,R.string.open,R.string.close);
        b.DrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        b.imageView.setOnClickListener(v -> b.DrawerLayout.openDrawer(GravityCompat.END));
        b.nav.setNavigationItemSelectedListener(this);
    }

    private void setAdapter() {
        viewModel.gamesMutableLiveData.observe(this, games -> {
            setButtonsVisiblity(games);
            if(games!=null){
            b.progressBar.setVisibility(View.INVISIBLE);
            GamesList.clear();
            GamesList.add(games);
            GamesRecycler adapter = new GamesRecycler(s,games.getResults().size(),games.getResults());
            b.text.setAdapter(adapter);
            }
        });


    }

    private void setButtonsVisiblity(ResponseGames games) {
        if(PageNumber==null||games.getPrevious()==null){
            b.back.setVisibility(View.INVISIBLE);
        }else if(PageNumber.equals("0")){
            b.back.setVisibility(View.INVISIBLE);
        }else {
            b.back.setVisibility(View.VISIBLE);
        }
        if(games.getNext()==null){
            b.next.setVisibility(View.INVISIBLE);
        }else {
            b.next.setVisibility(View.VISIBLE);
        }
    }

    @SuppressLint("CheckResult")
    void HandleSearch(){
        Observable.create(emitter -> b.search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                emitter.onNext(s);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        })).doOnNext(c->b.progressBar.setVisibility(View.VISIBLE))
           .debounce(1500, TimeUnit.MILLISECONDS,AndroidSchedulers.mainThread())
           .subscribeOn(AndroidSchedulers.mainThread())
           .subscribe(c->{
               if(!c.toString().equals("")){
               isSearchingNow=true;
               PageNumber="1";
               SearchText=c.toString();
               viewModel.getSearchResults(c.toString(),PageNumber);
               b.search.setText("");
               b.spinner.setSelection(4);
               }
           });

    }
    private void spinnerHandler(){
        String[] arraySpinner = new String[] {
                "Popular", "Name","Release","Rating","Searching"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.spinner_custom, arraySpinner);
        adapter.setDropDownViewResource(R.layout.custom_drop_down);
        b.spinner.setAdapter(adapter);
        b.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                b.progressBar.setVisibility(View.VISIBLE);
                PageNumber="1";
                switch (position){
                    case 0:
                        Order = "-added";
                        isSearchingNow=false;
                        viewModel.getGames(Order,Platform,Genre,null);
                        break;
                    case 1:
                        Order = "name";
                        isSearchingNow=false;
                        viewModel.getGames(Order,Platform,Genre,null);
                        break;
                    case 2:
                        Order = "-released";
                        isSearchingNow=false;
                        viewModel.getGames(Order,Platform,Genre,null);
                        break;
                    case 3:
                        Order = "-rating";
                        isSearchingNow=false;
                        viewModel.getGames(Order,Platform,Genre,null);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    private void spinnerPlHandler(){
        String[] arraySpinner2 = new String[] {
                "Any","PC","PS","XBOX"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.spinner_custom, arraySpinner2);
        adapter.setDropDownViewResource(R.layout.custom_drop_down);
        b.spinner2.setAdapter(adapter);
        b.spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                b.progressBar.setVisibility(View.VISIBLE);
                SearchText="";
                PageNumber="1";
                switch (position){
                    case 0:
                        Platform = null;
                        viewModel.getGames(Order,Platform,Genre,null);
                        break;
                    case 1:
                        Platform = "1";
                        viewModel.getGames(Order,Platform,Genre,null);
                        break;
                    case 2:
                        Platform = "2";
                        viewModel.getGames(Order,Platform,Genre,null);
                        break;
                    case 3:
                        Platform = "3";
                        viewModel.getGames(Order,Platform,Genre,null);
                        break;
                    default:viewModel.getGames("-added",null,null,null);
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(b.DrawerLayout.isDrawerOpen(GravityCompat.END)){
            b.DrawerLayout.closeDrawer(GravityCompat.END);
        }else {
        super.onBackPressed();
        }
    }

    void HandlePages(){
        b.next.setOnClickListener(v -> {
            if(PageNumber==null){
                PageNumber = "0";
            }
            PageNumber = String.valueOf(1+Integer.parseInt(PageNumber));
            CheckSearchForPageButtons();
        });
        b.back.setOnClickListener(v -> {
            PageNumber = String.valueOf(Integer.parseInt(PageNumber)-1);
            CheckSearchForPageButtons();
        });
    }

    private void CheckSearchForPageButtons() {
        b.progressBar.setVisibility(View.VISIBLE);
        if (!isSearchingNow) {
            viewModel.getGames(Order, Platform, Genre, PageNumber);
        } else {
            viewModel.getSearchResults(SearchText, PageNumber);
        }
        Toast.makeText(MainActivity.this, "Page" + PageNumber, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Action:
                Genre="action";
                HandleMenu();
                return true;
            case R.id.Strategy:
                Genre="strategy";
                HandleMenu();
                return true;
            case R.id.RPG:
                Genre="role-playing-games-rpg";
                HandleMenu();
                return true;
            case R.id.Shooter:
                Genre="shooter";
                HandleMenu();
                return true;
            case R.id.Adventure:
                Genre="adventure";
                HandleMenu();
                return true;
            case R.id.Puzzle:
                Genre="puzzle";
                HandleMenu();
                return true;
            case R.id.Racing:
                Genre="racing";
                HandleMenu();
                return true;
            case R.id.Sport:
                Genre="sports";
                HandleMenu();
                return true;
            case R.id.All:
                Genre=null;
                HandleMenu();
                return true;
            default:
                return true;
        }
    }

    private void HandleMenu() {
        isSearchingNow = false;
        b.progressBar.setVisibility(View.VISIBLE);
        b.spinner.setSelection(0);
        viewModel.getGames(Order, Platform, Genre, null);
        b.DrawerLayout.closeDrawer(GravityCompat.END);
    }

    @Override
    public void onClickListener(int clickedItemIndex) {
        Intent intent = new Intent(MainActivity.this,GameDetailActivity.class);
        intent.putExtra("id",GamesList.get(0).getResults().get(clickedItemIndex).getId());
        startActivity(intent);
    }

}

