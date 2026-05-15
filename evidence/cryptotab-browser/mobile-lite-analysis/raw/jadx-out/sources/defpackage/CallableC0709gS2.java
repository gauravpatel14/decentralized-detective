package defpackage;

import com.google.android.gms.measurement.internal.zzaw;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: gS2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class CallableC0709gS2 implements Callable {
    public final /* synthetic */ MS2 a;

    public CallableC0709gS2(MS2 ms2, zzaw zzawVar, String str) {
        this.a = ms2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        MS2 ms2 = this.a;
        ms2.t.a();
        QU2 qu2 = ms2.t.h;
        QX2.H(qu2);
        qu2.g();
        throw new IllegalStateException("Unexpected call on client side");
    }
}
