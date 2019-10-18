package com.lambdaschool.extensionfunctions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.notification()

        iv_photo.loadUrl("https://getinspiredeveryday.com/adventure/wp-content/uploads/sites/6/2016/02/Top-10-Tips-for-Visiting-Glacier-National-Park-GI-365-2.jpg")
    }
}
