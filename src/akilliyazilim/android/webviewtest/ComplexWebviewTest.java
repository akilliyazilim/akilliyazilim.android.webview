package akilliyazilim.android.webviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class ComplexWebviewTest extends Activity {
	
	final Activity activity = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_PROGRESS);
		setContentView(R.layout.complex_webview);
		
		WebView webview = (WebView) findViewById(R.id.webView1);
		
		webview.getSettings().setJavaScriptEnabled(true);
		
		webview.setWebChromeClient(new WebChromeClient() {
			public void onProgressChanged(WebView view, int progress) {
				
				activity.setTitle("Loading...");
                activity.setProgress(progress * 100);
			}
		});
		webview.setWebViewClient(new WebViewClient() {
			public void onReceivedError(WebView view, int errorCode,String description, String failingUrl) {
				Toast.makeText(activity, "Oh no! " + description,Toast.LENGTH_SHORT).show();
			}
		});

		webview.loadUrl("http://www.akilliyazilim.org");
		
	}

}
