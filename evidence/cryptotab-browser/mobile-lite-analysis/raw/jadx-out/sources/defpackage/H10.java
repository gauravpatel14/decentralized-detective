package defpackage;

import android.content.IntentFilter;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class H10 {
    public static final J10 a;

    static {
        J10 j10 = new J10();
        j10.f = new ArrayList();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.MEDIA_REMOVED");
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        AbstractC1499tM.d(AbstractC1499tM.a, new G10(j10), intentFilter);
        a = j10;
    }
}
