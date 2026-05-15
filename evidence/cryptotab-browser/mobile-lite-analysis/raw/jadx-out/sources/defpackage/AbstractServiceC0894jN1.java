package defpackage;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import org.chromium.base.BundleUtils;
import org.chromium.chrome.browser.base.SplitChromeApplication;

/* JADX INFO: renamed from: jN1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractServiceC0894jN1 extends Service {
    public final String t;
    public AbstractC0835iN1 u;

    public AbstractServiceC0894jN1(String str) {
        this.t = str;
    }

    public static int a(AbstractServiceC0894jN1 abstractServiceC0894jN1, Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    public static boolean b(AbstractServiceC0894jN1 abstractServiceC0894jN1, Intent intent) {
        return super.onUnbind(intent);
    }

    @Override // android.app.Service, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Context contextB = SplitChromeApplication.b(context);
        AbstractC0835iN1 abstractC0835iN1 = (AbstractC0835iN1) BundleUtils.g(contextB, this.t);
        this.u = abstractC0835iN1;
        abstractC0835iN1.a = this;
        super.attachBaseContext(contextB);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.u.a();
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.u.b();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.u.c();
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public final void onLowMemory() {
        super.onLowMemory();
        this.u.d();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        return this.u.e(intent, i, i2);
    }

    @Override // android.app.Service
    public final void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        this.u.f();
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return this.u.g(intent);
    }
}
