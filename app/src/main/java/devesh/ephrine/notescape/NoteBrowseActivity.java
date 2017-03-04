package devesh.ephrine.notescape;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
//---
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NoteBrowseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView title1;
    TextView title2;
    TextView title3;
    TextView title4;
    TextView title5;
    TextView title6;
    TextView title7;
    TextView title8;
    TextView title9;
    TextView title10;

    TextView sub1;
    TextView sub2;
    TextView sub3;
    TextView sub4;
    TextView sub5;
    TextView sub6;
    TextView sub7;
    TextView sub8;
    TextView sub9;
    TextView sub10;

    TextView username1;
    TextView username2;
    TextView username3;
    TextView username4;
    TextView username5;
    TextView username6;
    TextView username7;
    TextView username8;
    TextView username9;
    TextView username10;

    /*   ImageView img1;
       ImageView img2;
       ImageView img3;
       ImageView img4;
       ImageView img5;
       ImageView img6;
       ImageView img7;
       ImageView img8;
       ImageView img9;
       ImageView img10;
   */
    int pgno;
    int card1;
    int card2;
    int card3;
    int card4;
    int card5;
    int card6;
    int card7;
    int card8;
    int card9;
    int card10;

    String SliderSubject;

    String title1text;
    String title2text;
    String title3text;
    String title4text;
    String title5text;
    String title6text;
    String title7text;
    String title8text;
    String title9text;
    String title10text;

    String sub1text;
    String sub2text;
    String sub3text;
    String sub4text;
    String sub5text;
    String sub6text;
    String sub7text;
    String sub8text;
    String sub9text;
    String sub10text;

    String username1text;
    String username2text;
    String username3text;
    String username4text;
    String username5text;
    String username6text;
    String username7text;
    String username8text;
    String username9text;
    String username10text;

    String CardUrl1;
    String CardUrl2;
    String CardUrl3;
    String CardUrl4;
    String CardUrl5;
    String CardUrl6;
    String CardUrl7;
    String CardUrl8;
    String CardUrl9;
    String CardUrl10;

    String Doctype1Tx = "PPT";
    String Doctype2Tx = "PPT";
    String Doctype3Tx = "PPT";
    String Doctype4Tx = "PPT";
    String Doctype5Tx = "PPT";
    String Doctype6Tx = "PPT";
    String Doctype7Tx = "PPT";
    String Doctype8Tx = "PPT";
    String Doctype9Tx = "PPT";
    String Doctype10Tx = "PPT";

    ImageView DocImg1;
    ImageView DocImg2;
    ImageView DocImg3;
    ImageView DocImg4;
    ImageView DocImg5;
    ImageView DocImg6;
    ImageView DocImg7;
    ImageView DocImg8;
    ImageView DocImg9;
    ImageView DocImg10;


    CardView cardview1;
    CardView cardview2;
    CardView cardview3;
    CardView cardview4;
    CardView cardview5;
    CardView cardview6;
    CardView cardview7;
    CardView cardview8;
    CardView cardview9;
    CardView cardview10;


    int tot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_browse);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


// Code


        Toast.makeText(this, "Connecting to Server... Please Wait", Toast.LENGTH_LONG).show();


        Log.w("Note Scape:", "log start");
        //  AdLoad();
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference totalFiles = database.getReference("PHARMA/sub/total");
        totalFiles.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "total is: " + value);
                int d = Integer.parseInt(value);
                tot = d;

                if (tot <= 10) {
                    card1 = 1;
                    card2 = 2;
                    card3 = 3;
                    card4 = 4;
                    card5 = 5;
                    card6 = 6;
                    card7 = 7;
                    card8 = 8;
                    card9 = 9;
                    card10 = 10;

                } else {
                    card1 = tot - 1;
                    card2 = tot - 2;
                    card3 = tot - 3;
                    card4 = tot - 4;
                    card5 = tot - 5;
                    card6 = tot - 6;
                    card7 = tot - 7;
                    card8 = tot - 8;
                    card9 = tot - 9;
                    card10 = tot - 10;

                }

                Log.d("Note Scape:", "Card1: " + card1);
                Log.d("Note Scape:", "Card2: " + card2);
                Log.d("Note Scape:", "Card3: " + card3);
                Log.d("Note Scape:", "Card4: " + card4);
                Log.d("Note Scape:", "Card5: " + card5);
                Log.d("Note Scape:", "Card6: " + card6);
                Log.d("Note Scape:", "Card7: " + card7);
                Log.d("Note Scape:", "Card8: " + card8);
                Log.d("Note Scape:", "Card9: " + card9);
                Log.d("Note Scape:", "Card10: " + card10);

                collectDataBase();

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        pgno = 1;

        new Thread(new Runnable() {
            public void run() {
                collectDataBase();
                notesLoad();
            }
        }).start();
        //notesLoad();


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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.note_browse, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
  /*      if (id == R.id.action_settings) {
            return true;
        }
*/
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

       if (id == R.id.shareNotes) {
            Intent intent = new Intent(this, UploadActivity.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.pharmabusiness) {

            SliderSubject = "pharmabusiness";
            CardNoReset();


        } else if (id == R.id.pharmaceutical_chemistry) {
            SliderSubject = "pharmaceuticalchemistry";
            CardNoReset();

        } else if (id == R.id.pharmaceutics) {
            SliderSubject = "pharmaceutics";
            CardNoReset();

        } else if (id == R.id.pharmacognosy) {
            SliderSubject = "pharmacognosy";
            CardNoReset();

        } else if (id == R.id.pharmacology) {
            SliderSubject = "pharmacology";
            CardNoReset();

        } else if (id == R.id.lifescience) {
            SliderSubject = "lifescience";
            CardNoReset();

        } else if (id == R.id.general) {
            SliderSubject = "generalpharmacy";
            CardNoReset();

        } else if (id == R.id.clinicalpharma) {
            SliderSubject = "clinicalpharma";
            CardNoReset();

        } else if (id == R.id.hospitalpharma) {
            SliderSubject = "hospitalpharma";
            CardNoReset();

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    // code---------------


    public void upload(View v) {
        //  Intent intent = new Intent(this, UploadActivity.class);
        //  startActivity(intent);
    }

    public void next(View v) {
        pgno = pgno + 1;
        Log.d("Note Scape:", "pgno: " + pgno);

        card1 = card1 + 10;
        card2 = card2 + 10;
        card3 = card3 + 10;
        card4 = card4 + 10;
        card5 = card5 + 10;
        card6 = card6 + 10;
        card7 = card7 + 10;
        card8 = card8 + 10;
        card9 = card9 + 10;
        card10 = card10 + 10;
        collectDataBase();
        FloatingActionButton Prev = (FloatingActionButton) findViewById(R.id.floatingActionButtonPrev);
        FloatingActionButton Next = (FloatingActionButton) findViewById(R.id.floatingActionButtonNext);

        if (card1 > 0 || card2 > 0 || card3 > 0 || card4 > 0 || card5 > 0) {
            Prev.setVisibility(View.VISIBLE);

        }
        Log.e("GPAT----", String.valueOf(card1));

        int t = tot - 1;
        if (card1 >= t || card2 >= t || card3 >= t || card4 >= t || card5 >= t || card6 >= t || card7 >= t || card8 >= t || card9 >= t || card10 >= t) {
            Next.setVisibility(View.GONE);

        }


    }

    public void prev(View v) {
        pgno = pgno - 1;
        Log.d("Note Scape:", "pgno: " + pgno);

        card1 = card1 - 10;
        card2 = card2 - 10;
        card3 = card3 - 10;
        card4 = card4 - 10;
        card5 = card5 - 10;
        card6 = card6 - 10;
        card7 = card7 - 10;
        card8 = card8 - 10;
        card9 = card9 - 10;
        card10 = card10 - 10;
        collectDataBase();
        FloatingActionButton Prev = (FloatingActionButton) findViewById(R.id.floatingActionButtonPrev);
        FloatingActionButton Next = (FloatingActionButton) findViewById(R.id.floatingActionButtonNext);

        if (card1 <= 0 || card2 <= 0 || card3 <= 0 || card4 <= 0 || card5 <= 0) {
            Prev.setVisibility(View.GONE);

        }


        if (card1 < tot || card2 < tot || card3 < tot || card4 < tot || card5 < tot || card6 < tot || card7 < tot || card8 < tot || card9 < tot || card10 < tot) {
            Next.setVisibility(View.VISIBLE);

        }

    }

    public void collectDataBase() {

        cardview1 = (CardView) findViewById(R.id.cardView1);
        cardview2 = (CardView) findViewById(R.id.cardView2);
        cardview3 = (CardView) findViewById(R.id.cardView3);
        cardview4 = (CardView) findViewById(R.id.cardView4);
        cardview5 = (CardView) findViewById(R.id.cardView5);
        cardview6 = (CardView) findViewById(R.id.cardView6);
        cardview7 = (CardView) findViewById(R.id.cardView7);
        cardview8 = (CardView) findViewById(R.id.cardView8);
        cardview9 = (CardView) findViewById(R.id.cardView9);
        cardview10 = (CardView) findViewById(R.id.cardView10);

        Log.w("Note Scape:", "collect data");

        FirebaseDatabase database = FirebaseDatabase.getInstance();

//card1 ----------------------------------------

        //TITLE----
        //   DatabaseReference title = database.getReference("PHARMA/sub/"+SliderSubject+"/"++card1+"/title");
        DatabaseReference title = database.getReference("PHARMA/sub/" + SliderSubject + "/" + card1 + "/title");
        // Read from the database
        title.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "Title1 is: " + value);
                title1text = value;

                notesLoad();


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });

        // SUBJECT


        DatabaseReference sub = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card1 + "/sub");
        sub.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "subject is: " + value);
                sub1text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });

        // url
        DatabaseReference downurl = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card1 + "/url");
        downurl.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "url is: " + value);
                CardUrl1 = value;

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });

        // username
        DatabaseReference username = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card1 + "/user");
        username.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "user is: " + value);
                username1text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });

        // Doc Type
        DatabaseReference doctype = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card1 + "/type");
        doctype.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "user is: " + value);

                if (value != null) {
                    Doctype1Tx = value;
                    notesLoad();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });

        //  DatabaseReference totalFiles = database.getReference("PHARMA/sub/total");


//card2 ----------------------------------------
        // String card=String.valueOf(card1);

        //TITLE----
        DatabaseReference title2 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card2 + "/title");
        // Read from the database
        title2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "Title1 is: " + value);
                title2text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // SUBJECT
        DatabaseReference sub2 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card2 + "/sub");
        sub2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "subject is: " + value);
                sub2text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // url
        DatabaseReference downurl2 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card2 + "/url");
        downurl2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "url is: " + value);
                CardUrl2 = value;

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // username
        DatabaseReference username2 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card2 + "/user");
        username2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "user is: " + value);
                username2text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });


        DatabaseReference doctype2 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card2 + "/type");
        doctype2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "user is: " + value);
                if (value != null) {
                    Doctype2Tx = value;
                    notesLoad();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });


        //card3 ----------------------------------------
        // String card=String.valueOf(card1);

        //TITLE----
        DatabaseReference title3 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card3 + "/title");
        // Read from the database
        title3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "Title1 is: " + value);
                title3text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // SUBJECT
        DatabaseReference sub3 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card3 + "/sub");
        sub3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "subject is: " + value);
                sub3text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // url
        DatabaseReference downurl3 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card3 + "/url");
        downurl3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "url is: " + value);
                CardUrl3 = value;
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // username
        DatabaseReference username3 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card3 + "/user");
        username3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "user is: " + value);
                username3text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });

        DatabaseReference doctype3 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card3 + "/type");
        doctype3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "user is: " + value);
                if (value != null) {
                    Doctype3Tx = value;
                    notesLoad();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });


        //card4 ----------------------------------------
        // String card=String.valueOf(card1);

        //TITLE----
        DatabaseReference title4 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card4 + "/title");
        // Read from the database
        title4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "Title1 is: " + value);
                title4text = value;
                notesLoad();

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // SUBJECT
        DatabaseReference sub4 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card4 + "/sub");
        sub4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "subject is: " + value);
                sub4text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // url
        DatabaseReference downurl4 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card4 + "/url");
        downurl4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "url is: " + value);
                CardUrl4 = value;

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // username
        DatabaseReference username4 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card4 + "/user");
        username4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "user is: " + value);
                username4text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });

        DatabaseReference doctype4 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card4 + "/type");
        doctype4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "user is: " + value);
                if (value != null) {
                    Doctype4Tx = value;
                    notesLoad();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });


        //card5 ----------------------------------------
        //TITLE----
        DatabaseReference title5 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card5 + "/title");
        // Read from the database
        title5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "Title1 is: " + value);
                title5text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // SUBJECT
        DatabaseReference sub5 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card5 + "/sub");
        sub5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "subject is: " + value);
                sub5text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // url
        DatabaseReference downurl5 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card5 + "/url");
        downurl5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "url is: " + value);
                CardUrl5 = value;

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // username
        DatabaseReference username5 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card5 + "/user");
        username5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "user is: " + value);
                username5text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });

        // Doc type
        DatabaseReference doctype5 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card5 + "/type");
        doctype5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "user is: " + value);
                if (value != null) {
                    Doctype5Tx = value;
                    notesLoad();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });


//card6 ----------------------------------------
        //TITLE----
        DatabaseReference title6 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card6 + "/title");
        // Read from the database
        title6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "Title1 is: " + value);
                title6text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // SUBJECT
        DatabaseReference sub6 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card6 + "/sub");
        sub6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "subject is: " + value);
                sub6text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // url
        DatabaseReference downurl6 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card6 + "/url");
        downurl6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "url is: " + value);
                CardUrl6 = value;

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // username
        DatabaseReference username6 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card6 + "/user");
        username6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "user is: " + value);
                username6text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });

        // Doc type
        DatabaseReference doctype6 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card6 + "/type");
        doctype6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "user is: " + value);
                if (value != null) {
                    Doctype6Tx = value;
                    notesLoad();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });


        //card7 ----------------------------------------
        //TITLE----
        DatabaseReference title7 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card7 + "/title");
        // Read from the database
        title7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "Title1 is: " + value);
                title7text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // SUBJECT
        DatabaseReference sub7 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card7 + "/sub");
        sub7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "subject is: " + value);
                sub7text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // url
        DatabaseReference downurl7 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card7 + "/url");
        downurl7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "url is: " + value);
                CardUrl7 = value;

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // username
        DatabaseReference username7 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card7 + "/user");
        username7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "user is: " + value);
                username7text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });

        // Doc type
        DatabaseReference doctype7 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card7 + "/type");
        doctype7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "user is: " + value);
                if (value != null) {
                    Doctype7Tx = value;
                    notesLoad();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });


        //card8 ----------------------------------------
        //TITLE----
        DatabaseReference title8 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card8 + "/title");
        // Read from the database
        title8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "Title1 is: " + value);
                title8text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // SUBJECT
        DatabaseReference sub8 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card8 + "/sub");
        sub8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "subject is: " + value);
                sub8text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // url
        DatabaseReference downurl8 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card8 + "/url");
        downurl8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "url is: " + value);
                CardUrl8 = value;
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // username
        DatabaseReference username8 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card8 + "/user");
        username8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "user is: " + value);
                username8text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });

        // Doc type
        DatabaseReference doctype8 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card8 + "/type");
        doctype8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "user is: " + value);
                if (value != null) {
                    Doctype8Tx = value;
                    notesLoad();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });


//card9 ----------------------------------------
        //TITLE----
        DatabaseReference title9 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card9 + "/title");
        // Read from the database
        title9.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "Title1 is: " + value);
                title9text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // SUBJECT
        DatabaseReference sub9 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card9 + "/sub");
        sub9.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "subject is: " + value);
                sub9text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // url
        DatabaseReference downurl9 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card9 + "/url");
        downurl9.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "url is: " + value);
                CardUrl9 = value;

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // username
        DatabaseReference username9 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card9 + "/user");
        username9.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "user is: " + value);
                username9text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });

        // Doc type
        DatabaseReference doctype9 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card9 + "/type");
        doctype9.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "user is: " + value);
                if (value != null) {
                    Doctype9Tx = value;
                    notesLoad();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });


//card10 ----------------------------------------
        //TITLE----
        DatabaseReference title10 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card10 + "/title");
        // Read from the database
        title10.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "Title1 is: " + value);
                title10text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // SUBJECT
        DatabaseReference sub10 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card10 + "/sub");
        sub10.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "subject is: " + value);
                sub10text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // url
        DatabaseReference downurl10 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card10 + "/url");
        downurl10.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "url is: " + value);
                CardUrl10 = value;

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
        // username
        DatabaseReference username10 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card10 + "/user");
        username10.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "user is: " + value);
                username10text = value;
                notesLoad();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });

        // Doc type
        DatabaseReference doctype10 = database.getReference("PHARMA/sub/"+SliderSubject+"/" + card10 + "/type");
        doctype10.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "user is: " + value);
                if (value != null) {
                    Doctype10Tx = value;
                    notesLoad();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });


        notesLoad();

    }

    public void notesLoad() {
        Drawable DOCDrawable = getResources().getDrawable(R.drawable.doc);
        Drawable PDFDrawable = getResources().getDrawable(R.drawable.pdf1);
        Drawable PPTDrawable = getResources().getDrawable(R.drawable.ppt);


        //Card 1
        title1 = (TextView) findViewById(R.id.textView30);
        title1.setText(title1text);
        sub1 = (TextView) findViewById(R.id.textView31);
        sub1.setText(sub1text);
        username1 = (TextView) findViewById(R.id.textView29);
        username1.setText(username1text);

        DocImg1 = (ImageView) findViewById(R.id.imageViewCardImg1);
        if (Doctype1Tx.equals("DOC")) {
            DocImg1.setImageDrawable(DOCDrawable);

        } else if (Doctype1Tx.equals("PPT")) {
            DocImg1.setImageDrawable(PPTDrawable);
        } else if (Doctype1Tx.equals("PDF")) {
            DocImg1.setImageDrawable(PDFDrawable);
        } else {
        }

        //Card 2
        title2 = (TextView) findViewById(R.id.textView30c);
        title2.setText(title2text);
        sub2 = (TextView) findViewById(R.id.textView31c);
        sub2.setText(sub2text);
        username2 = (TextView) findViewById(R.id.textView29c);
        username2.setText(username2text);
        DocImg2 = (ImageView) findViewById(R.id.imageViewCardImg2);
        if (Doctype2Tx.equals("DOC")) {
            DocImg2.setImageDrawable(DOCDrawable);
        } else if (Doctype2Tx.equals("PPT")) {
            DocImg2.setImageDrawable(PPTDrawable);
        } else if (Doctype2Tx.equals("PDF")) {
            DocImg2.setImageDrawable(PDFDrawable);
        } else {
        }


        //Card 3
        title3 = (TextView) findViewById(R.id.textView3010);
        title3.setText(title3text);
        sub3 = (TextView) findViewById(R.id.textView311);
        sub3.setText(sub3text);
        username3 = (TextView) findViewById(R.id.textView229);
        username3.setText(username3text);
        DocImg3 = (ImageView) findViewById(R.id.imageViewCardImg3);
        if (Doctype3Tx.equals("DOC")) {
            DocImg3.setImageDrawable(DOCDrawable);
        } else if (Doctype3Tx.equals("PPT")) {
            DocImg3.setImageDrawable(PPTDrawable);
        } else if (Doctype3Tx.equals("PDF")) {
            DocImg3.setImageDrawable(PDFDrawable);
        } else {
        }


        //Card 4
        title4 = (TextView) findViewById(R.id.textView350);
        title4.setText(title4text);
        sub4 = (TextView) findViewById(R.id.textView371);
        sub4.setText(sub4text);
        username4 = (TextView) findViewById(R.id.textView290);
        username4.setText(username4text);
        DocImg4 = (ImageView) findViewById(R.id.imageViewCardImg4);
        if (Doctype4Tx.equals("DOC")) {
            DocImg4.setImageDrawable(DOCDrawable);
        } else if (Doctype4Tx.equals("PPT")) {
            DocImg4.setImageDrawable(PPTDrawable);
        } else if (Doctype4Tx.equals("PDF")) {
            DocImg4.setImageDrawable(PDFDrawable);
        } else {
        }


        //Card 5
        title5 = (TextView) findViewById(R.id.textView830);
        title5.setText(title5text);
        sub5 = (TextView) findViewById(R.id.textView931);
        sub5.setText(sub5text);
        username5 = (TextView) findViewById(R.id.textView0129);
        username5.setText(username5text);
        DocImg5 = (ImageView) findViewById(R.id.imageViewCardImg5);
        if (Doctype5Tx.equals("DOC")) {
            DocImg5.setImageDrawable(DOCDrawable);
        } else if (Doctype5Tx.equals("PPT")) {
            DocImg5.setImageDrawable(PPTDrawable);
        } else if (Doctype5Tx.equals("PDF")) {
            DocImg5.setImageDrawable(PDFDrawable);
        } else {
        }


        //Card 6
        title6 = (TextView) findViewById(R.id.textView330);
        title6.setText(title6text);
        sub6 = (TextView) findViewById(R.id.textView391);
        sub6.setText(sub6text);
        username6 = (TextView) findViewById(R.id.textView259);
        username6.setText(username6text);
        DocImg6 = (ImageView) findViewById(R.id.imageViewCardImg6);
        if (Doctype6Tx.equals("DOC")) {
            DocImg6.setImageDrawable(DOCDrawable);
        } else if (Doctype6Tx.equals("PPT")) {
            DocImg6.setImageDrawable(PPTDrawable);
        } else if (Doctype6Tx.equals("PDF")) {
            DocImg6.setImageDrawable(PDFDrawable);
        } else {
        }


        //Card 7
        title7 = (TextView) findViewById(R.id.textView303);
        title7.setText(title7text);
        sub7 = (TextView) findViewById(R.id.textView312);
        sub7.setText(sub7text);
        username7 = (TextView) findViewById(R.id.textView291);
        username7.setText(username7text);
        DocImg7 = (ImageView) findViewById(R.id.imageViewCardImg7);
        if (Doctype7Tx.equals("DOC")) {
            DocImg7.setImageDrawable(DOCDrawable);
        } else if (Doctype7Tx.equals("PPT")) {
            DocImg7.setImageDrawable(PPTDrawable);
        } else if (Doctype7Tx.equals("PDF")) {
            DocImg7.setImageDrawable(PDFDrawable);
        } else {
        }


        //Card 8
        title8 = (TextView) findViewById(R.id.textView390);
        title8.setText(title8text);
        sub8 = (TextView) findViewById(R.id.textView313);
        sub8.setText(sub8text);
        username8 = (TextView) findViewById(R.id.textView295);
        username8.setText(username8text);
        DocImg8 = (ImageView) findViewById(R.id.imageViewCardImg8);
        if (Doctype8Tx.equals("DOC")) {
            DocImg8.setImageDrawable(DOCDrawable);
        } else if (Doctype8Tx.equals("PPT")) {
            DocImg8.setImageDrawable(PPTDrawable);
        } else if (Doctype8Tx.equals("PDF")) {
            DocImg8.setImageDrawable(PDFDrawable);
        } else {
        }


        //Card 9
        title9 = (TextView) findViewById(R.id.textView306);
        title9.setText(title9text);
        sub9 = (TextView) findViewById(R.id.textView317);
        sub9.setText(sub9text);
        username9 = (TextView) findViewById(R.id.textView293);
        username9.setText(username9text);
        DocImg9 = (ImageView) findViewById(R.id.imageViewCardImg9);
        if (Doctype9Tx.equals("DOC")) {
            DocImg9.setImageDrawable(DOCDrawable);
        } else if (Doctype9Tx.equals("PPT")) {
            DocImg9.setImageDrawable(PPTDrawable);
        } else if (Doctype9Tx.equals("PDF")) {
            DocImg9.setImageDrawable(PDFDrawable);
        } else {
        }

        //Card 10
        title10 = (TextView) findViewById(R.id.textView309);
        title10.setText(title10text);
        sub10 = (TextView) findViewById(R.id.textView361);
        sub10.setText(sub10text);
        username10 = (TextView) findViewById(R.id.textView296);
        username10.setText(username10text);
        DocImg10 = (ImageView) findViewById(R.id.imageViewCardImg10);
        if (Doctype10Tx.equals("DOC")) {
            DocImg10.setImageDrawable(DOCDrawable);
        } else if (Doctype10Tx.equals("PPT")) {
            DocImg10.setImageDrawable(PPTDrawable);
        } else if (Doctype10Tx.equals("PDF")) {
            DocImg10.setImageDrawable(PDFDrawable);
        } else {
        }

        CardVisibility();
    }

    public void CardVisibility() {


        Log.d("Note Scape:", "Visiblity:---> " + title1text);
        Log.d("Note Scape:", "visiblity-----> " + title2text);

        if (title1text != null) {
            Log.d("Note Scape:", "Visiblity:---> " + title1text);

            cardview1.setVisibility(View.VISIBLE);
        }
        if (title2text != null) {
            Log.d("Note Scape:", "visiblity-----> " + title2text);

            cardview2.setVisibility(View.VISIBLE);
        }
        if (title3text != null) {
            cardview3.setVisibility(View.VISIBLE);
        }
        if (title3text != null) {
            cardview3.setVisibility(View.VISIBLE);
        }

        if (title4text != null) {
            cardview4.setVisibility(View.VISIBLE);
        }
        if (title5text != null) {
            cardview5.setVisibility(View.VISIBLE);
        }
        if (title6text != null) {
            cardview6.setVisibility(View.VISIBLE);
        }
        if (title7text != null) {
            cardview7.setVisibility(View.VISIBLE);
        }
        if (title8text != null) {
            cardview8.setVisibility(View.VISIBLE);
        }
        if (title9text != null) {
            cardview9.setVisibility(View.VISIBLE);
        }
        if (title10text != null) {
            cardview10.setVisibility(View.VISIBLE);
        }


        //------------


        if (title1text == null) {
            Log.d("Note Scape:", "Visiblity:---> " + title1text);

            cardview1.setVisibility(View.GONE);
        }
        if (title2text == null) {
            Log.d("Note Scape:", "visiblity-----> " + title2text);

            cardview2.setVisibility(View.GONE);
        }
        if (title3text == null) {
            cardview3.setVisibility(View.GONE);
        }
        if (title3text == null) {
            cardview3.setVisibility(View.GONE);
        }

        if (title4text == null) {
            cardview4.setVisibility(View.GONE);
        }
        if (title5text == null) {
            cardview5.setVisibility(View.GONE);
        }
        if (title6text == null) {
            cardview6.setVisibility(View.GONE);
        }
        if (title7text == null) {
            cardview7.setVisibility(View.GONE);
        }
        if (title8text == null) {
            cardview8.setVisibility(View.GONE);
        }
        if (title9text == null) {
            cardview9.setVisibility(View.GONE);
        }
        if (title10text == null) {
            cardview10.setVisibility(View.GONE);
        }


    }

    public void CardNoReset() {

/*
        String path = "PHARMA/sub/" + SliderSubject + "/total";
        DatabaseReference totalFiles = database.getReference(path);
        totalFiles.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Note Scape:", "total is: " + value);
                int d = Integer.parseInt(value);
                tot = d;

                if (tot <= 10) {
                    card1 = 1;
                    card2 = 2;
                    card3 = 3;
                    card4 = 4;
                    card5 = 5;
                    card6 = 6;
                    card7 = 7;
                    card8 = 8;
                    card9 = 9;
                    card10 = 10;

                } else {
                    card1 = tot - 1;
                    card2 = tot - 2;
                    card3 = tot - 3;
                    card4 = tot - 4;
                    card5 = tot - 5;
                    card6 = tot - 6;
                    card7 = tot - 7;
                    card8 = tot - 8;
                    card9 = tot - 9;
                    card10 = tot - 10;

                }

                Log.d("Note Scape:", "Card1: " + card1);
                Log.d("Note Scape:", "Card2: " + card2);
                Log.d("Note Scape:", "Card3: " + card3);
                Log.d("Note Scape:", "Card4: " + card4);
                Log.d("Note Scape:", "Card5: " + card5);
                Log.d("Note Scape:", "Card6: " + card6);
                Log.d("Note Scape:", "Card7: " + card7);
                Log.d("Note Scape:", "Card8: " + card8);
                Log.d("Note Scape:", "Card9: " + card9);
                Log.d("Note Scape:", "Card10: " + card10);

                collectDataBase();

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Note Scape:", "Failed to read value.", error.toException());
            }
        });
*/
        pgno = 1;


    }

    public void card1click(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(CardUrl1)); //Google play store
        startActivity(intent);
    }

    public void card2click(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(CardUrl2)); //Google play store
        startActivity(intent);
    }

    public void card3click(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(CardUrl3)); //Google play store
        startActivity(intent);
    }

    public void card4click(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(CardUrl4)); //Google play store
        startActivity(intent);
    }

    public void card5click(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(CardUrl5)); //Google play store
        startActivity(intent);
    }

    public void card6click(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(CardUrl6)); //Google play store
        startActivity(intent);
    }

    public void card7click(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(CardUrl7)); //Google play store
        startActivity(intent);
    }

    public void card8click(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(CardUrl8)); //Google play store
        startActivity(intent);
    }

    public void card9click(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(CardUrl9)); //Google play store
        startActivity(intent);
    }

    public void card10click(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(CardUrl10)); //Google play store
        startActivity(intent);
    }


    public boolean installed = false;

  /*  public void AdLoad() {

        String APPID = getString(R.string.MY_APP_ID);

        MobileAds.initialize(getApplicationContext(), APPID);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdView mAdView1 = (AdView) findViewById(R.id.adView1);


        isAppInstalled("devesh.ephrine.gpat.pro");

        if (installed == true) {
            mAdView1.setVisibility(View.GONE);
            Log.e("GPAT", " AD Disabled");

        } else {


            Bundle extras = new FacebookAdapter.FacebookExtrasBundleBuilder()
                    .setNativeAdChoicesIconExpandable(false)
                    .build();

            AdRequest adRequest = new AdRequest.Builder()
                    .addNetworkExtrasBundle(FacebookAdapter.class, extras)
                    .build();
            //  AdRequest adRequest1 = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);


            Bundle extras1 = new FacebookAdapter.FacebookExtrasBundleBuilder()
                    .setNativeAdChoicesIconExpandable(false)
                    .build();

            AdRequest adRequest1 = new AdRequest.Builder()
                    .addNetworkExtrasBundle(FacebookAdapter.class, extras1)
                    .build();
            //  AdRequest adRequest1 = new AdRequest.Builder().build();
            mAdView1.loadAd(adRequest1);
            Log.e("GPAT", " AD Loaded");

        }


    }
*/

    private boolean isAppInstalled(String uri) {
        PackageManager pm = getPackageManager();
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            installed = false;
        }
        return installed;
    }


}
