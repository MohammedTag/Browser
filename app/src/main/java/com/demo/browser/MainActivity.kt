package com.demo.browser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demo.browser.app.App

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as App).compnant.inject(this)
    }
}
