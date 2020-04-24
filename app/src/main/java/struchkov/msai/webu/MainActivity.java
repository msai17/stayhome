package struchkov.msai.webu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {

    private WebView MyWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.action_settings);

        MyWebView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = MyWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        MyWebView.loadUrl("http://msai17.github.io/11/");
        MyWebView.setWebViewClient(new WebViewClient());


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent myintent = new Intent(MainActivity.this,
                    Oprilozhenii.class);
            startActivity(myintent);

            return false;
        }
        
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        if (MyWebView.canGoBack()) {
            MyWebView.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
