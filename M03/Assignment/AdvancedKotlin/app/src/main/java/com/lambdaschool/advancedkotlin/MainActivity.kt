package com.lambdaschool.advancedkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var data: List<Song>

    private val rBHipHop by lazy {
        listOf(
            RBHipHop("Highest in the Room", "Travis Scott"),
            RBHipHop("Truth Hurts", "Lizzo"),
            RBHipHop("No Guidance", "Chris Brown Featuring Drake")
        )
    }

    private val pop by lazy {
        listOf(
            Pop("Truth Hurts", "Lizzo"),
            Pop("Senorita", "Shawn Mendes & Camila Cabello"),
            Pop("Someone You Loved", "Lewis Capaldi")
        )
    }

    private val country by lazy {
        listOf(
            Country("10,000 Hours", "Dan + Shay & Justin Bieber"),
            Country("Prayed For You", "Matt Stell"),
            Country("One Thing Right", "Marshmello & Kane Brown")
        )
    }

    private val rock by lazy {
        listOf(
            Rock("High Hopes", "Panic! At The Disco"),
            Rock("Hey Look Ma, I Made It", "Panic! At The Disco"),
            Rock("The Hype", "twenty one pilots")
        )
    }

    private val dance by lazy {
        listOf(
            Dance("Happier", "Marshmello & Bastille"),
            Dance("Higher Love", "Kygo X Whitney Houston"),
            Dance("Good Things Fall Apart", "Illenium & Jon Bellion")
        )
    }

    private var listType: Song by Delegates.observable(RBHipHop("", "")) {
            _, _: Song, new: Song ->
        data = when (new) {
            is RBHipHop -> rBHipHop
            is Pop -> pop
            is Country -> country
            is Rock -> rock
            is Dance -> dance
        }
        recyclerView.adapter = SongListAdapter(data)
        setTitleForType(data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        data = listOf(RBHipHop("Billboard", "Charts"))

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
            setHasFixedSize(false)
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            adapter = SongListAdapter(data)
        }
    }

    private inline fun <reified T: Song> setTitleForType(song:List<T>) {
        when {
            data[0] is RBHipHop -> this.title = "R&B/Hip-Hop"
            data[0] is Pop -> this.title = "Pop"
            data[0] is Country -> this.title = "Country"
            data[0] is Rock -> this.title = "Rock"
            data[0] is Dance -> this.title = "Dance"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.menu_rbhiphop -> { listType = RBHipHop("", "")}
            R.id.menu_pop -> { listType = Pop ("", "")}
            R.id.menu_country -> { listType = Country("", "")}
            R.id.menu_rock -> { listType = Rock("", "")}
            R.id.menu_dance -> { listType = Dance("", "")}
        }
        return super.onOptionsItemSelected(item)
    }
}