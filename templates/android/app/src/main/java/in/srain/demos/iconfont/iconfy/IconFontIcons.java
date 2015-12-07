package in.srain.demos.iconfont.iconfy;

import com.joanzapata.iconify.Icon;

public enum IconFontIcons implements Icon {

    /* generated code begin */{% for glyph in glyphs %}
    {{ glyph.name_no_dash }}('\u{{glyph.unicode}}'){% if loop.last %};{% else %},{% endif %}{% endfor %}
    /* generated code end */

    char mCharacter;

    IconFontIcons(char character) {
        this.mCharacter = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return mCharacter;
    }
}
