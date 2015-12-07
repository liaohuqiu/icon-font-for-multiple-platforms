package in.srain.demos.iconfont.iconfy;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

public class IconFontModule implements IconFontDescriptor {

    @Override
    public String ttfFileName() {
        return "cube-icons.ttf";
    }

    @Override
    public Icon[] characters() {
        return IconFontIcons.values();
    }
}