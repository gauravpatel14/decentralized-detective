package org.chromium.chrome.browser.customtabs;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import defpackage.BinderC1392rT;
import defpackage.UJ1;
import defpackage.VM1;
import org.chromium.base.BundleUtils;
import org.chromium.chrome.browser.base.SplitChromeApplication;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class CustomTabsConnectionService extends Service {
    public final UJ1 t = new UJ1(0);
    public final BinderC1392rT u = new BinderC1392rT(this);
    public final String v = "kT";
    public VM1 w;

    @Override // android.app.Service, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Context contextB = SplitChromeApplication.b(context);
        VM1 vm1 = (VM1) BundleUtils.g(contextB, this.v);
        this.w = vm1;
        vm1.getClass();
        super.attachBaseContext(contextB);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        this.w.f(intent);
        return this.u;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.w.g();
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        this.w.h();
        return false;
    }
}
