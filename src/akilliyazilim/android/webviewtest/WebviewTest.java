package akilliyazilim.android.webviewtest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;

public class WebviewTest extends Activity implements OnClickListener {

	Button button_onbrowser, button_inside_activity, button_from_html,
			button_complex;
	WebView webview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webview_test);

		webview = new WebView(this);

		button_inside_activity = (Button) findViewById(R.id.button1);
		button_onbrowser = (Button) findViewById(R.id.button2);
		button_from_html = (Button) findViewById(R.id.button3);
		button_complex = (Button) findViewById(R.id.button4);

		button_inside_activity.setOnClickListener(this);
		button_onbrowser.setOnClickListener(this);
		button_from_html.setOnClickListener(this);
		button_complex.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			setContentView(webview);
			webview.loadUrl("http://www.akilliyazilim.org");
			break;

		case R.id.button2:
			Uri uri = Uri.parse("http://www.akilliyazilim.org");
			Intent intent = new Intent(Intent.ACTION_VIEW, uri);
			startActivity(intent);
			break;

		case R.id.button3:
			setContentView(webview);
			String summary = "<html><body>You scored <b>192</b> points.</body></html>";
			webview.loadData(summary, "text/html", null);
			break;

		case R.id.button4:
			Intent i = new Intent(WebviewTest.this,ComplexWebviewTest.class);
			startActivity(i);
			break;

		default:
			break;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.webview_test, menu);
		return true;
	}

}
