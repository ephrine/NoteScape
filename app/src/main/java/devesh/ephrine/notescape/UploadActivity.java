package devesh.ephrine.notescape;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;


public class UploadActivity extends Activity {
    private static final int READ_REQUEST_CODE = 42;
    public Uri uri = null;
    public Uri fileuri = null;
    public ProgressDialog dialog;
    public String fname;
    public String FBname;
    public String subject;
    public String DocType;
    public int no;
    public String title;
    public ProgressBar progressbar;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    public LinearLayout layoutprogress;
    public LinearLayout layoutdata;
    public UploadTask uploadTask;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
  //  private CallbackManager mCallbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        layoutprogress = (LinearLayout) findViewById(R.id.llprogress);
        layoutprogress.setVisibility(View.GONE);
      //  AdLoad();
        GetProfile();
        DatabaseReference total = database.getReference("GPAT/USERS/total");
        total.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("GPAT:", "subject is: " + value);
                no = Integer.parseInt(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("GPAT:", "Failed to read value.", error.toException());
            }
        });
    }

    public static String getMacAddr() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    res1.append(Integer.toHexString(b & 0xFF) + ":");
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ex) {
            //handle exception
        }
        return "";
    }

    public void selectfile(View v) {
        performFileSearch();

    }

    public void upload(View v) {

        //EditText nametx=(EditText)findViewById(R.id.editText);
        EditText subtx = (EditText) findViewById(R.id.editText2);
        EditText titletx = (EditText) findViewById(R.id.editText3);

        if (subtx != null && fileuri != null && titletx != null) {


            layoutdata = (LinearLayout) findViewById(R.id.llview);
            layoutdata.setVisibility(View.INVISIBLE);
            layoutprogress = (LinearLayout) findViewById(R.id.llprogress);
            layoutprogress.setVisibility(View.VISIBLE);
            //   dialog = ProgressDialog.show(UploadActivity.this, "",
            //         "Uploading....Please Wait", true);
      //      AdLoad();
            FirebaseStorage storage = FirebaseStorage.getInstance();

            // Create a storage reference from our app
            StorageReference storageRef = storage.getReferenceFromUrl("gs://gpat-one.appspot.com/GPAT/userupload");

            // Create a reference to "mountains.jpg"

            StorageReference riversRef = storageRef.child("/" + uri.getLastPathSegment());
            uploadTask = riversRef.putFile(fileuri);

// Register observers to listen for when the download is done or if it fails
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle unsuccessful uploads
                    //  dialog.hide();
                    //finish();
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                    Uri downloadUrl = taskSnapshot.getDownloadUrl();
                    Log.i("GPAT", "Success for upload: " + downloadUrl);


                    // EditText nametx = (EditText) findViewById(R.id.editText);
                    EditText subtx = (EditText) findViewById(R.id.editText2);
                    EditText titletx = (EditText) findViewById(R.id.editText3);

                    //      EditText emailtx=(EditText)findViewById(R.id.editText3);

                    // fname = nametx.getText().toString();

                    fname = "By " + FBname;
                    subject = subtx.getText().toString();
                    title = titletx.getText().toString();

                    //      emailid=emailtx.getText().toString();

                    // Write a message to the database

                    DatabaseReference addsub = database.getReference("GPAT/USERS/" + no + "/sub");
                    addsub.setValue(subject.toString());

                    DatabaseReference addtitle = database.getReference("GPAT/USERS/" + no + "/title");
                    addtitle.setValue(title.toString());

                    DatabaseReference addname = database.getReference("GPAT/USERS/" + no + "/user");
                    addname.setValue(fname.toString());

                    DatabaseReference durl = database.getReference("GPAT/USERS/" + no + "/url");
                    durl.setValue(downloadUrl.toString());

                    DatabaseReference addmac = database.getReference("GPAT/USERS/" + no + "/MACAddress");
                    addmac.setValue(getMacAddr().toString());

                    DatabaseReference mac = database.getReference("GPAT/USERS/MACAddress/" + getMacAddr().toString() + "/ban");
                    mac.setValue("f");

                    DatabaseReference docType = database.getReference("GPAT/USERS/" + no + "/type");
                    docType.setValue(DocType);


                    DatabaseReference number = database.getReference("GPAT/USERS/total");
                    no = no + 1;
                    number.setValue("" + no + "");

                    //   dialog.hide();
                    //setContentView();
                    finish();

                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();

                    int i = (int) progress;
                    // String pr = String.valueOf(i);
                    System.out.println("Upload is " + progress + "% done");
                    progressbar = (ProgressBar) findViewById(R.id.progressBar5);
                    progressbar.setProgress(i);
                    //dialog.show();
                }
            });


        } else {
            Log.i("GPAT", "NO INPUT_______________-");
            Toast.makeText(UploadActivity.this, "Please fill above details & select file to share",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Fires an intent to spin up the "file chooser" UI and select an image.
     */
    public void performFileSearch() {

        // ACTION_OPEN_DOCUMENT is the intent to choose a file via the system's file
        // browser.
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);

        // Filter to only show results that can be "opened", such as a
        // file (as opposed to a list of contacts or timezones)
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        // Filter to show only images, using the image MIME data type.
        // If one wanted to search for ogg vorbis files, the type would be "audio/ogg".
        // To search for all documents available via installed storage providers,
        // it would be "*/*".
        intent.setType("*/*");

        startActivityForResult(intent, READ_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,
                                 Intent resultData) {

        // The ACTION_OPEN_DOCUMENT intent was sent with the request code
        // READ_REQUEST_CODE. If the request code seen here doesn't match, it's the
        // response to some other intent, and the code below shouldn't run at all.

        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // The document selected by the user won't be returned in the intent.
            // Instead, a URI to that document will be contained in the return intent
            // provided to this method as a parameter.
            // Pull that URI using resultData.getData().
            if (resultData != null) {
                uri = resultData.getData();
                Log.i("GPAT", "Uri: " + uri.toString());

                String url = uri.toString();
                String extension = url.substring(url.lastIndexOf("."));
                Log.i("GPAT", "file Format: " + extension);
                if (extension.equals(".pdf")) {
                    Log.i("GPAT", "Accepted " + extension);
                    fileuri = uri;
DocType="PDF";
                    Button Fileselect = (Button) findViewById(R.id.buttonFileSelect);
                    Fileselect.setVisibility(View.GONE);
                    LinearLayout LLFile = (LinearLayout) findViewById(R.id.LLFileName);
                    LLFile.setVisibility(View.VISIBLE);

                }
                //PowerPoint
                else if (extension.equals(".pptx")) {
                    Log.i("GPAT", "Accepted " + extension);
                    Button Fileselect = (Button) findViewById(R.id.buttonFileSelect);
                    Fileselect.setVisibility(View.GONE);
                    LinearLayout LLFile = (LinearLayout) findViewById(R.id.LLFileName);
                    LLFile.setVisibility(View.VISIBLE);
                    DocType="PPT";

                    fileuri = uri;
                } else if (extension.equals(".ppt")) {
                    Log.i("GPAT", "Accepted " + extension);
                    Button Fileselect = (Button) findViewById(R.id.buttonFileSelect);
                    Fileselect.setVisibility(View.GONE);
                    LinearLayout LLFile = (LinearLayout) findViewById(R.id.LLFileName);
                    LLFile.setVisibility(View.VISIBLE);
                    DocType="PPT";

                    fileuri = uri;

                } else if (extension.equals(".ppsx")) {
                    Log.i("GPAT", "Accepted " + extension);
                    Button Fileselect = (Button) findViewById(R.id.buttonFileSelect);
                    Fileselect.setVisibility(View.GONE);
                    LinearLayout LLFile = (LinearLayout) findViewById(R.id.LLFileName);
                    LLFile.setVisibility(View.VISIBLE);
                    DocType="PPT";

                    fileuri = uri;
                } else if (extension.equals(".odp")) {
                    Log.i("GPAT", "Accepted " + extension);
                    Button Fileselect = (Button) findViewById(R.id.buttonFileSelect);
                    Fileselect.setVisibility(View.GONE);
                    LinearLayout LLFile = (LinearLayout) findViewById(R.id.LLFileName);
                    LLFile.setVisibility(View.VISIBLE);
                    DocType="PPT";

                    fileuri = uri;
                } else if (extension.equals(".pps")) {
                    Log.i("GPAT", "Accepted " + extension);
                    Button Fileselect = (Button) findViewById(R.id.buttonFileSelect);
                    Fileselect.setVisibility(View.GONE);
                    LinearLayout LLFile = (LinearLayout) findViewById(R.id.LLFileName);
                    LLFile.setVisibility(View.VISIBLE);
                    DocType="PPT";

                    fileuri = uri;
                }
                // Word
                else if (extension.equals(".docx")) {
                    Log.i("GPAT", "Accepted " + extension);
                    Button Fileselect = (Button) findViewById(R.id.buttonFileSelect);
                    Fileselect.setVisibility(View.GONE);
                    LinearLayout LLFile = (LinearLayout) findViewById(R.id.LLFileName);
                    LLFile.setVisibility(View.VISIBLE);
                    DocType="DOC";

                    fileuri = uri;
                } else if (extension.equals(".doc")) {
                    Log.i("GPAT", "Accepted " + extension);
                    Button Fileselect = (Button) findViewById(R.id.buttonFileSelect);
                    Fileselect.setVisibility(View.GONE);
                    LinearLayout LLFile = (LinearLayout) findViewById(R.id.LLFileName);
                    LLFile.setVisibility(View.VISIBLE);
                    DocType="DOC";
                    fileuri = uri;
                } else if (extension.equals(".odt")) {
                    Log.i("GPAT", "Accepted " + extension);
                    Button Fileselect = (Button) findViewById(R.id.buttonFileSelect);
                    Fileselect.setVisibility(View.GONE);
                    LinearLayout LLFile = (LinearLayout) findViewById(R.id.LLFileName);
                    LLFile.setVisibility(View.VISIBLE);
                    DocType="DOC";
                    fileuri = uri;
                } else if (extension.equals(".docm")) {
                    Log.i("GPAT", "Accepted " + extension);
                    Button Fileselect = (Button) findViewById(R.id.buttonFileSelect);
                    Fileselect.setVisibility(View.GONE);
                    LinearLayout LLFile = (LinearLayout) findViewById(R.id.LLFileName);
                    LLFile.setVisibility(View.VISIBLE);
                    DocType="DOC";
                    fileuri = uri;
                } else {
                    Log.i("GPAT", "not Accepted " + extension);
                    Toast.makeText(UploadActivity.this, "Oops!! Only PDF, Word and PowerPoint File Formats are allowed",
                            Toast.LENGTH_LONG).show();
                }


            }
        }
    }

    public final boolean isInternetOn() {

        // get Connectivity Manager object to check connection
        ConnectivityManager connec =
                (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        // Check for network connections
        if (connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED) {

            // if connected with internet

            Toast.makeText(this, " Loading... ", Toast.LENGTH_LONG).show();
            return true;

        } else if (
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.DISCONNECTED) {



            Toast.makeText(this, " Please Connect to internet ", Toast.LENGTH_LONG).show();
            return false;
        }
        return false;
    }

    public void c(View v) {
        uploadTask.cancel();
        Toast.makeText(UploadActivity.this, "Canceled !!",
                Toast.LENGTH_SHORT).show();
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    public void GetProfile() {
        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();

            //   TextView UserName=(TextView)findViewById(R.id.textViewHomeUserName);
            //  ImageView ProfilePic=(ImageView)findViewById(R.id.imageViewPic);

            //   Glide.with(this).load(picURL).into(ProfilePic);
            // UserName.setText(name);

            FBname = name;
        }

    }

    public boolean installed = false;

/*    public void AdLoad() {

        String APPID = getString(R.string.MY_APP_ID);

        MobileAds.initialize(getApplicationContext(), APPID);

        AdView mAdView = (AdView) findViewById(R.id.adView);


        isAppInstalled("devesh.ephrine.gpat.pro");

        if (installed == true) {
            mAdView.setVisibility(View.GONE);
            Log.e("GPAT", " AD Disabled");

        } else {

            Bundle extras = new FacebookAdapter.FacebookExtrasBundleBuilder()
                    .setNativeAdChoicesIconExpandable(false)
                    .build();

            AdRequest adRequest = new AdRequest.Builder()
                    .addNetworkExtrasBundle(FacebookAdapter.class, extras)
                    .build();
          //  AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
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
