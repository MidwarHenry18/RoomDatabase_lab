package com.example.practicalab7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practicalab7.adapter.SuperHeroAdapter
import com.example.practicalab7.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        val db = AppRoomDatabase.getDatabase(this)
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this,manager.orientation)
        binding.recyclerSuperHero.layoutManager = LinearLayoutManager(this)
        GlobalScope.launch{
            db.superheroresDao().insertHero(SuperHero(1,"Spiderman", "Marvel", "Peter Parker", "https://cursokotlin.com/wp-content/uploads/2017/07/spiderman.jpg"))
            db.superheroresDao().insertHero(SuperHero(2,"Daredevil", "Marvel", "Matthew Michael Murdock", "https://cursokotlin.com/wp-content/uploads/2017/07/daredevil.jpg"))
            db.superheroresDao().insertHero(SuperHero(3,"Wolverine", "Marvel", "James Howlett", "https://cursokotlin.com/wp-content/uploads/2017/07/logan.jpeg"))
            db.superheroresDao().insertHero(SuperHero(4,"Batman", "DC", "Bruce Wayne", "https://cursokotlin.com/wp-content/uploads/2017/07/batman.jpg"))
            db.superheroresDao().insertHero(SuperHero(5,"Thor", "Marvel", "Thor Odinson", "https://cursokotlin.com/wp-content/uploads/2017/07/thor.jpg"))
            db.superheroresDao().insertHero(SuperHero(6,"Flash", "DC", "Jay Garrick", "https://cursokotlin.com/wp-content/uploads/2017/07/flash.png"))
            db.superheroresDao().insertHero(SuperHero(7,"Green Lantern", "DC", "Alan Scott", "https://cursokotlin.com/wp-content/uploads/2017/07/green-lantern.jpg"))
            db.superheroresDao().insertHero(SuperHero(8,"Wonder Woman", "DC", "Princess Diana", "https://cursokotlin.com/wp-content/uploads/2017/07/wonder_woman.jpg"))

            var superheroes = db.superheroresDao().getSuperHero()

            superheroes?.forEach{ println(it)}


            binding.recyclerSuperHero.adapter = SuperHeroAdapter(superheroes)
            binding.recyclerSuperHero.addItemDecoration(decoration)
        }


    }
}