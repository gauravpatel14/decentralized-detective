package defpackage;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RZ2 {
    public final Context a;
    public final InterfaceC0161Nn1 b;
    public final WI2 c;
    public final C0785hZ2 d = new C0785hZ2(this, true);
    public final C0785hZ2 e = new C0785hZ2(this, false);
    public boolean f;

    public RZ2(Context context, InterfaceC0161Nn1 interfaceC0161Nn1, WI2 wi2) {
        this.a = context;
        this.b = interfaceC0161Nn1;
        this.c = wi2;
    }

    public final void a(boolean z) {
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        IntentFilter intentFilter2 = new IntentFilter("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intentFilter2.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.f = z;
        this.e.a(this.a, intentFilter2);
        if (!this.f) {
            this.d.a(this.a, intentFilter);
            return;
        }
        C0785hZ2 c0785hZ2 = this.d;
        Context context = this.a;
        synchronized (c0785hZ2) {
            try {
                if (!c0785hZ2.a) {
                    if (Build.VERSION.SDK_INT >= 33) {
                        context.registerReceiver(c0785hZ2, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null, true != c0785hZ2.b ? 4 : 2);
                    } else {
                        context.registerReceiver(c0785hZ2, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null);
                    }
                    c0785hZ2.a = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
