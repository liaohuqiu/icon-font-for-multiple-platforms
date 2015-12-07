package in.srain.demos.iconfont;

public class IconFontData {

    public static class unicode {
{% for glyph in glyphs %}
        public static final String {{ glyph.name_no_dash }} = "\u{{glyph.unicode}}";{% endfor %}
    }
}
