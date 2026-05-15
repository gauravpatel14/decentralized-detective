package defpackage;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import org.chromium.base.BundleUtils;
import org.chromium.chrome.browser.base.SplitChromeApplication;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class eN1 extends IntentService {
    public final String t;
    public dN1 u;

    public eN1(String str, String str2) {
        super(str2);
        this.t = str;
    }

    @Override // android.app.Service, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Context contextB = SplitChromeApplication.b(context);
        dN1 dn1 = (dN1) BundleUtils.g(contextB, this.t);
        this.u = dn1;
        dn1.a = this;
        dn1.b();
        super.attachBaseContext(contextB);
    }

    @Override // android.app.IntentService
    public final void onHandleIntent(Intent intent) {
        this.u.a(intent);
    }
}
