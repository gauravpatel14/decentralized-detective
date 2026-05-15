package defpackage;

import android.content.Context;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;

/* JADX INFO: renamed from: cJ2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0460cJ2 {
    public final boolean a;
    public final C1797yf0 b;

    public C0460cJ2(Context context) {
        try {
            TransportRuntime.initialize(context);
            this.b = ((C1857zf0) TransportRuntime.getInstance().newFactory(CCTDestination.INSTANCE)).a();
        } catch (Throwable unused) {
            this.a = true;
        }
    }

    public final void a(TS2 ts2) {
        if (this.a) {
            AbstractC1659wF2.e("BillingLogger", "Skipping logging since initialization failed.");
            return;
        }
        try {
            this.b.getClass();
        } catch (Throwable unused) {
            AbstractC1659wF2.e("BillingLogger", "logging failed.");
        }
    }
}
