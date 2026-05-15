package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Rl0 {
    public static final Rl0 d;
    public Locale a;
    public String b;
    public boolean c;

    static {
        Rl0 rl0 = new Rl0();
        rl0.a = Locale.getDefault();
        d = rl0;
    }

    public final Configuration a(Context context) {
        Configuration configuration = new Configuration();
        configuration.fontScale = 0.0f;
        String str = this.b;
        configuration.setLocales(LocaleList.forLanguageTags(String.format("%1$s,%2$s", str, context.getResources().getConfiguration().getLocales().toLanguageTags().replaceFirst(String.format("(^|,)%1$s$|%1$s,", str), ""))));
        return configuration;
    }

    public final void b(Context context) {
        if (this.c) {
            Configuration configurationA = a(context);
            Resources resources = context.getResources();
            int i = AbstractC1872zv.a;
            if (Bv.a.n) {
                configurationA.densityDpi = resources.getConfiguration().densityDpi;
            }
            resources.updateConfiguration(configurationA, resources.getDisplayMetrics());
            LocaleList.setDefault(configurationA.getLocales());
        }
    }
}
