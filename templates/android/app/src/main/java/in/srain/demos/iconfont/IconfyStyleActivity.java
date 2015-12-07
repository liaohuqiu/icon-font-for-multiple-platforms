package in.srain.demos.iconfont;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import in.srain.demos.iconfont.iconfy.IconFontIcons;

import java.util.ArrayList;
import java.util.List;

public class IconfyStyleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iconfy_style);
        setTitle(R.string.title_iconfy_style);

        TextView iconTextView = (TextView) findViewById(R.id.text_view);

        List<String> stringList = new ArrayList<>();
        /* generated code begin */{% for glyph in glyphs %}
        stringList.add(IconFontIcons.{{ glyph.name_no_dash }}.key());{% endfor %}
        /* generated code end */

        // $text will be like: {gems-logo} {android} {heart}
        String text = "{" + TextUtils.join("} {", stringList) + "}";
        iconTextView.setText(text);
    }
}
