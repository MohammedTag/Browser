package com.demo.browser.presentation_layer.fragments.webview


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.demo.browser.R
import com.demo.browser.app.App
import kotlinx.android.synthetic.main.fragment_web_view.*
import javax.inject.Inject


class WebViewFragment : Fragment() {

    @Inject
    lateinit var webViewViewModelFactory: WebViewViewModelFactory

    private lateinit var webViewViewModel: WebViewViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_web_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity?.application as App).compnant.inject(this)
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        activity?.let { activity->webViewViewModel = ViewModelProviders.of(activity, webViewViewModelFactory).get(WebViewViewModel::class.java) }

        progress_bar.max =100

        webView.settings.javaScriptEnabled = true

        webViewViewModel.urlHandel("https://google.com").observe(this, Observer {
            webView.loadUrl(it)
        })

        webView.webViewClient = WebViewClient()
        webView.webChromeClient= object : WebChromeClient(){
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                progress_bar.progress =newProgress
            }

            override fun onReceivedTitle(view: WebView?, title: String?) {
                super.onReceivedTitle(view, title)
                //pass later to the viewmodel
                //supportActionBar?.title = title
            }
        }
    }
}
