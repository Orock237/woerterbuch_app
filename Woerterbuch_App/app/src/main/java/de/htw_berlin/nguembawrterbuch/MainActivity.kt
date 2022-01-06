package de.htw_berlin.nguembawrterbuch

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import de.hdodenhof.circleimageview.CircleImageView
import de.htw_berlin.nguembawrterbuch.ModelClasses.Users


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var toggle : ActionBarDrawerToggle
    lateinit var copyrightFragment : CopyrightFragment
    lateinit var datenschutzerklaerungFragment : DatenschutzerklaerungFragment
    lateinit var favoritenFragment : FavoritenFragment
    lateinit var forumFragment : ForumFragment
    lateinit var hilfeFragment : HilfeFragment
    lateinit var homeFragment : HomeFragment
    lateinit var impressumFragment : ImpressumFragment
    lateinit var kommentareFragment : KommentareFragment
    lateinit var konjugationFragment : KonjugationFragment
    lateinit var loginFragment : LoginFragment
  //  lateinit var neuPasswortFragment : NeuPasswortFragment
    lateinit var nutzungsbedingungFragment :  NutzungsbedingungFragment
   // lateinit var passvergessenFragment : PassvergessenFragment
    lateinit var personalpronomenFragment : PersonalpronomenFragment
 //   lateinit var resultFragment : ResultFragment
    lateinit var  drawerLayout : DrawerLayout
  // var refUsers: DatabaseReference? =null
    // lateinit var refUsers: DatabaseReference
   // var firebaseUser: FirebaseUser? =null
  //lateinit var firebaseUser: FirebaseUser
    lateinit var profileImageHeader: CircleImageView
    lateinit var userNameHeader: TextView
    lateinit var user: Users



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      //  firebaseUser = FirebaseAuth.getInstance().currentUser
        //refUsers = FirebaseDatabase.getInstance().reference.child("Users").child(firebaseUser!!.uid)


        drawerLayout = findViewById(R.id.drawer_layout)
        val navView : NavigationView = findViewById(R.id.nav_view)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)


        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
        //When we start the app, we see this fragment first
        homeFragment = HomeFragment()
        makeCurrentFragment(homeFragment)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val view: View = navView.inflateHeaderView(R.layout.header)
        profileImageHeader = view.findViewById(R.id.profilImage)
        userNameHeader = view.findViewById(R.id.textNav)

        //Display username and profile picture
      /*  refUsers!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(@NonNull p0: DataSnapshot){

                if (p0.exists()){

                    val user: Users? = p0.getValue(Users::class.java)
                    userNameHeader.text = user!!.getUsername()
                    Picasso.get().load(user.getProfile()).into(profileImageHeader)
                }
            }
            override fun onCancelled(p0: DatabaseError){

            }
        })*/
//Bottom Navigation
        bottomNavigationView.setOnItemSelectedListener{ item ->
            when (item.itemId){
                R.id.forume -> {
                    forumFragment = ForumFragment()
                    makeCurrentFragment(forumFragment)
                }

                R.id.home1 -> {
                    makeCurrentFragment(homeFragment)
                }

            }
            true

        }



    }


    /*override fun onStart() {
        super.onStart()
        val mUser = FirebaseAuth.getInstance().currentUser
        if (mUser == null){
            userNameHeader.text = "Benutzername"
            val homeFragment = HomeFragment()
            makeCurrentFragment(homeFragment)
        }else{
            userNameHeader.text = "Hallo"
            val homeFragment = HomeFragment()
            makeCurrentFragment(homeFragment)
        }

    }*/
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //Put a menu to the ActionBar
        menuInflater.inflate(R.menu.ober_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)){
            return true
        }else if(item.itemId == R.id.loOut){
            FirebaseAuth.getInstance().signOut()
            Toast.makeText(this, "Das Ausloggen war erfolgreich", Toast.LENGTH_LONG).show()
            userNameHeader.text = "Benutzername"
            val homeFragment = HomeFragment()
            makeCurrentFragment(homeFragment)
            return true
        }
        return super.onOptionsItemSelected(item)
    }



     fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {

        when(menuItem.itemId){

            R.id.loginFragment -> {
                loginFragment  = LoginFragment()
                makeCurrentFragment(loginFragment)
            }
            R.id.favoritenFragment -> {
                favoritenFragment = FavoritenFragment()
                makeCurrentFragment(favoritenFragment)
            }
            R.id.kommentareFragment -> {
                kommentareFragment = KommentareFragment()
                makeCurrentFragment(kommentareFragment)
            }
            R.id.appTeilen -> {
                sendApp("https://play.google.com/store")
            }
            R.id.appBewerten -> {
                goToURL("https://play.google.com/store")
                Toast.makeText(applicationContext, "Wir freuen uns auf Ihre tolle Bewertung." + getEmoji(0x1F60A) , Toast.LENGTH_SHORT).show()
            }
            R.id.spenden -> {
                goToURL("https://www.paypal.me/fortune1976")
                Toast.makeText(applicationContext, "Danke für Ihre Unterstützung!" + getEmoji(0x1F60A), Toast.LENGTH_SHORT).show()
            }
            R.id.hilfeFragment -> {
                hilfeFragment  = HilfeFragment()
                makeCurrentFragment(hilfeFragment)
            }
            R.id.personalpronomenFragment -> {
                personalpronomenFragment  = PersonalpronomenFragment ()
                makeCurrentFragment(personalpronomenFragment)
            }
            R.id.konjugationFragment -> {
                konjugationFragment = KonjugationFragment()
                makeCurrentFragment(konjugationFragment)
            }
            R.id.datenschutzerklaerungFragment -> {
                datenschutzerklaerungFragment  = DatenschutzerklaerungFragment()
                makeCurrentFragment(datenschutzerklaerungFragment)
            }
            R.id.nutzungsbedingungFragment -> {
                nutzungsbedingungFragment = NutzungsbedingungFragment ()
                makeCurrentFragment(nutzungsbedingungFragment)
            }
            R.id.impressumFragment -> {
                impressumFragment  = ImpressumFragment ()
                makeCurrentFragment(impressumFragment)
            }
            R.id.copyrightFragment -> {
                copyrightFragment = CopyrightFragment()
                makeCurrentFragment(copyrightFragment)
            }


        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true

    }

    //Convert a character to an emoji
    fun getEmoji(uni : Int): String = String(Character.toChars(uni))

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else {
            super.onBackPressed()
        }

    }

    //Open an URL using a button
    fun goToURL(url:String){
        val uri : Uri = Uri.parse(url)
        val intent  = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    //Send the app
    fun sendApp(url: String){
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT, "Hi! Ich würde gerne mit dir, dieses schönes und praktisches Wörterbuch teilen.\n" + url)
        startActivity(Intent.createChooser(intent, "Via"))
    }


     fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framelayout, fragment)
            commit()
        }






}


