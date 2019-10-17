package com.lambdaschool.advancedkotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    lateinit var toastString: String

    val textView by lazy {
        this.showToast("lazy init text view")
        findViewById<TextView>(R.id.textView)
    }

    private var custom: Int = 0
    get() {
        return when {
            field == 0 -> field
            field > 0 -> 1
            else -> -1
        }
    }
    set(value) {
        field = value
        this.showToast("Custom is now $field")
    }

    private val whales = listOf(
        Whale("Blue"),
        Whale("Humpback"),
        Whale("Whale Shark")
    )
    private val dolphins = listOf(
        Dolphin("Bottlenose"),
        Dolphin("Amazon river dolphin"),
        Dolphin("Dan Marino")
    )
    private val otters = listOf(
        Otter("Sea otter"),
        Otter("Marine otter"),
        Otter("Emmett otter and his jug band")
    )

    private lateinit var marineMammals: List<MarineMammal>

    private var listType: MarineMammal by Delegates.observable(Whale("")) {
        _, _: MarineMammal, new: MarineMammal ->
        marineMammals = when (new) {
            is Whale -> whales
            is Dolphin -> dolphins
            is Otter -> otters
        }
        textView.text = marineMammals.joinToString(", ") { it.name }
        setTitleForType(marineMammals)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        textView.text = "Test 1"
//        textView.text = "Test 2"
        button.setOnClickListener{
            listType = listOf(Whale("whale"), Dolphin("dolphin"), Otter("otter")).random()
        }
    }

    override fun onStart() {
        super.onStart()

        toastString = "Testing out the lateinit"
        this.showToast(toastString)

        custom = 10
        println("Custom: $custom")
        custom = 0
        println("Custom: $custom")
        custom = -10
        println("Custom: $custom")
    }

    private inline fun <reified T: MarineMammal> setTitleForType(mammalList: List<T>){
        when {
            mammalList[0] is Whale -> this.title = "Whales"
            mammalList[0] is Dolphin -> this.title = "Dolphins"
            mammalList[0] is Otter -> this.title = "Otters"
        }
    }
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}