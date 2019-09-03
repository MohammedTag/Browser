package com.demo.browser

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.demo.browser.app.App
import com.demo.browser.presentation_layer.fragments.webview.WebViewFragment
import com.demo.browser.presentation_layer.fragments.webview.WebViewViewModel
import com.demo.browser.presentation_layer.fragments.webview.WebViewViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var webViewViewModelFactory: WebViewViewModelFactory

    private lateinit var webViewViewModel: WebViewViewModel

    lateinit var context: Context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this

        (application as App).compnant.inject(this)

        webViewViewModel = ViewModelProviders.of(this, webViewViewModelFactory).get(WebViewViewModel::class.java)

        searchBTN.setOnClickListener {
            if (!main_edit_text.text.toString().isNullOrBlank()) {
                webViewViewModel.urlHandel(main_edit_text.text.toString())
            }
        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_frame, WebViewFragment(), WebViewFragment::javaClass.name)
            .addToBackStack(WebViewFragment::javaClass.name)
            .commit()

    }
}
