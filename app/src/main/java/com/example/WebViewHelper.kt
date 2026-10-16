package com.example

import android.annotation.SuppressLint
import android.net.http.SslError
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebViewClient

@SuppressLint("SetJavaScriptEnabled")
fun setupWebView(webView: WebView) {
    val settings = webView.settings
    // Enable JavaScript and DOM Storage
    settings.javaScriptEnabled = true
    settings.domStorageEnabled = true
    
    // Set custom Chrome User-Agent
    settings.userAgentString = "Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/129.0.0.0 Mobile Safari/537.36"
    
    // Allow auto-play
    settings.mediaPlaybackRequiresUserGesture = false

    // SSL handler to proceed despite errors
    webView.webViewClient = object : WebViewClient() {
        override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
            handler?.proceed()
        }
    }
}

// Function to trigger video play
fun playVideoInWebView(webView: WebView) {
    webView.evaluateJavascript("document.getElementsByTagName('video')[0].play();", null)
}
