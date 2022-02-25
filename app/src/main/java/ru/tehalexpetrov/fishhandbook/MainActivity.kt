package ru.tehalexpetrov.fishhandbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*
import ru.tehalexpetrov.fishhandbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        nav_view.setNavigationItemSelectedListener(this)

        var list = ArrayList<ListItem>()
        list.add(ListItem(R.drawable.shuca, "Щука", "Хищная рыба"))
        list.add(ListItem(R.drawable.caras, "Карась", "Речная рыба"))
        list.add(ListItem(R.drawable.nalim, "Налим", "Речная рыба"))
        list.add(ListItem(R.drawable.som, "Сом", "Речная рыба"))
        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        rcView.adapter = MyAdapter(list, this )
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