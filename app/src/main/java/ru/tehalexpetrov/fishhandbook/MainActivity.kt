package ru.tehalexpetrov.fishhandbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.id_fish -> Toast.makeText(this, "Виды рыб", Toast.LENGTH_SHORT).show()
            R.id.id_na -> Toast.makeText(this, "Виды наживки", Toast.LENGTH_SHORT).show()
            R.id.id_sna -> Toast.makeText(this, "Виды снастей", Toast.LENGTH_SHORT).show()
            R.id.id_history -> Toast.makeText(this, "Истории рыбаков", Toast.LENGTH_SHORT).show()
        }

        return true
    }
}