package com.demo.browser

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.demo.browser.app.App
import com.demo.browser.presentation_layer.fragments.webview.WebViewFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this

        (application as App).compnant.inject(this)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_frame, WebViewFragment(), WebViewFragment::javaClass.name)
            .addToBackStack(WebViewFragment::javaClass.name)
            .commit()

    }
}
