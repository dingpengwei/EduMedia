package com.edumedia.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends BaseActivity{
	
	private WebView mWebView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_web);
		this.mWebView = (WebView) this.findViewById(R.id.wbv_activity_web_show_html);
		this.mWebView.loadUrl("http://www.baidu.com/");
		this.mWebView.getSettings().setJavaScriptEnabled(true);
		this.mWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		this.mWebView.setWebViewClient(new WebViewClient(){       
            public boolean shouldOverrideUrlLoading(WebView view, String url) {       
                view.loadUrl(url);       
                return true;       
            }       
		}); 
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {       
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {       
        	mWebView.goBack();       
            return true;       
        }else if((keyCode == KeyEvent.KEYCODE_BACK) && !mWebView.canGoBack()){
        	this.finish();
        	return true;
        }       
        return super.onKeyDown(keyCode, event);       
    }  

}
