package in.srain.demos.iconfont.iconfy;

import com.joanzapata.iconify.Icon;

public enum IconFontIcons implements Icon {

    gems_logo('\uf701'),
    android('\uf702'),
    heart('\uf703');

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
