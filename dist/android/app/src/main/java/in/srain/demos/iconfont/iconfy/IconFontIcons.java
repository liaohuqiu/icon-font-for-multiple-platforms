package in.srain.demos.iconfont.iconfy;

import com.joanzapata.iconify.Icon;

public enum IconFontIcons implements Icon {

    /* generated code begin */
    gems_logo('\uF701'),
    android('\uF702'),
    heart('\uF703');
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
