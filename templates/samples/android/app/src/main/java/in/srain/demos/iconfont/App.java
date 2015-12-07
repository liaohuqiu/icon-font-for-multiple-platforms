package in.srain.demos.iconfont;

import android.app.Application;
import com.joanzapata.iconify.Iconify;
import in.srain.demos.iconfont.iconfy.IconFontModule;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Iconify.with(new IconFontModule());
    }
}