package in.srain.demos.iconfont;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        displayAllStringDefinedInJavaCode();
        displayAllStringDefinedInStringXml();
    }

    /**
     * Using unicode from {@link IconFontData}
     */
    private void displayAllStringDefinedInJavaCode() {

        SimpleIconFontTextView textView = (SimpleIconFontTextView) findViewById(R.id.text_view_1);
        List<String> list = new ArrayList<>();

        /* generated code begin */
        list.add(IconFontData.unicode.gems_logo);
        list.add(IconFontData.unicode.android);
        list.add(IconFontData.unicode.heart);
        /* generated code end */

        String text = TextUtils.join(" ", list);
        textView.setText(text);
    }

    /**
     * display the string defined in the string xml file: iconfont_string.xml
     */
    private void displayAllStringDefinedInStringXml() {
        SimpleIconFontTextView textView = (SimpleIconFontTextView) findViewById(R.id.text_view_2);
        List<String> list = new ArrayList<>();

        /* generated code begin */
        list.add(getString(R.string.cubeicon_gems_logo));
        list.add(getString(R.string.cubeicon_android));
        list.add(getString(R.string.cubeicon_heart));
        /* generated code end */

        String text = TextUtils.join(" ", list);
        textView.setText(text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_about) {
            String url = "https://github.com/liaohuqiu/icon-font-for-multiple-platforms";
            Intent openAboutIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(openAboutIntent);
            return true;
        }

        if (id == R.id.action_iconfy_style) {
            Intent openIconfyStyleIntent = new Intent(this, IconfyStyleActivity.class);
            startActivity(openIconfyStyleIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
