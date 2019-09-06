package com.demo.browser

import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.demo.browser.app.App
import com.demo.browser.presentation_layer.fragments.webview.WebViewViewModel
import com.demo.browser.presentation_layer.fragments.webview.WebViewViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var webViewViewModelFactory: WebViewViewModelFactory

    private lateinit var webViewViewModel: WebViewViewModel


    lateinit var context: Context
    /**this project is built using android architecture components MVVM and live data, dagger ,adn clean architecture
     * , repository pattern for adding abstraction layers between
     * the levels of the architecture **/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this

        (application as App).compnant.inject(this)

        webViewViewModel = ViewModelProviders.of(this, webViewViewModelFactory).get(WebViewViewModel::class.java)


        this.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        /*activity?.let { activity->webViewViewModel = ViewModelProviders.of(activity, webViewViewModelFactory).get(WebViewViewModel::class.java) }*/

        webViewViewModel = ViewModelProviders.of(this, webViewViewModelFactory).get(WebViewViewModel::class.java)


        searchBTN.setOnClickListener {
            if (!main_edit_text.text.toString().isNullOrBlank()) {
                webViewViewModel.urlHandel(main_edit_text.text.toString())
            }
        }







        progress_bar.max = 100

        webView.settings.javaScriptEnabled = true

        webViewViewModel.urlHandel("https://google.com").observe(this, Observer {
            webView.loadUrl(it)

            if (it != "https://google.com") {
                val list = ArrayList<String>()
                list.add(main_edit_text.text.toString())
                val csvList = StringBuilder()
                for (s in list) {
                    csvList.append(s)
                    csvList.append(",")
                }

                webViewViewModel.saveSuccessfulUrlList(csvList.toString())
                webViewViewModel.retrieveUrlsList()

            }

        })

        webViewViewModel.retrieveUrlsList().observe(this, Observer {
            var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, it)

            main_edit_text?.setAdapter(adapter)

            main_edit_text.setOnItemClickListener { parent, view, position, id ->
                webViewViewModel.urlHandel(it[position])
            }
        })
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                progress_bar.progress = newProgress
            }

            override fun onReceivedTitle(view: WebView?, title: String?) {
                super.onReceivedTitle(view, title)
                supportActionBar?.title = title
            }

        }

    }


    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            finish()
        }
    }
}
