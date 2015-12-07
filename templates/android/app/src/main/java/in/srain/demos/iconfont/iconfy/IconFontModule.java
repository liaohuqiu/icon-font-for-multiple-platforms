package in.srain.demos.iconfont.iconfy;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

public class IconFontModule implements IconFontDescriptor {

    @Override
    public String ttfFileName() {
        // "$font_name".ttf
        return "{{ font_name }}.ttf";
    }

    @Override
    public Icon[] characters() {
        return IconFontIcons.values();
    }
}
