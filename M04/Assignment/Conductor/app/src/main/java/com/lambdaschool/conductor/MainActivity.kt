package com.lambdaschool.conductor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.lambdaschool.conductor.controllers.RootController

class MainActivity : AppCompatActivity() {

    private lateinit var router: Router
    private val container: ViewGroup by lazy {
        this.findViewById<ViewGroup>(R.id.activity_main_parent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        router = Conductor.attachRouter(this, container, savedInstanceState)
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(RootController()))
        }
    }

    override fun onBackPressed() {
        if (!router.handleBack())
        super.onBackPressed()
    }
}
