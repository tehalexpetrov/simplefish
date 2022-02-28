package ru.tehalexpetrov.fishhandbook

import android.content.res.TypedArray
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
    var adapter: MyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        nav_view.setNavigationItemSelectedListener(this)
        var list = ArrayList<ListItem>()

        list.addAll(fillArray(resources.getStringArray(R.array.fish),
            resources.getStringArray(R.array.fish),
            getImageArray(R.array.array_image_fish)))
        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(list, this )
        rcView.adapter = adapter
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

    fun fillArray(titleArray:Array<String>, contentArray:Array<String>, imageArray: IntArray):List<ListItem>{
         var listItemArray = ArrayList<ListItem>()
        for (n in 0 .. titleArray.size){
            var listItem = ListItem(imageArray[n] ,titleArray[n], contentArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray
    }

    fun getImageArray(imageArrayId:Int):IntArray{ //Получаем id картинок из массива для любой категории
        var tArray: TypedArray = resources.obtainTypedArray(imageArrayId)
        var count = tArray.length()
        val ids = IntArray(count)
        for (i in ids.indices){
            ids[i] = tArray.getResourceId(i, 0)
        }
        tArray.recycle()
        return ids
    }
}