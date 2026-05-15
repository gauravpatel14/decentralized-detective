package defpackage;

import android.content.Context;
import android.util.Log;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SB1 {
    public static final TB1 a;

    static {
        TB1 tb1 = new TB1();
        try {
            Context context = AbstractC1499tM.a;
            tb1.a = "https://search.yahoo.com/beacon/geop/p?s=1197812100&hspart=domaindev&hsimp=yhs-domaindev_ddc_extensions&traffic_source=yhs_domaindev_ddc_extensions_search&app_package_name=" + context.getPackageName();
            tb1.b = AbstractC1469sq2.a(context);
        } catch (Exception e) {
            Log.e("SearchUrlStatistics", "Failed to initialize", e);
            tb1.b = null;
        }
        a = tb1;
    }
}
