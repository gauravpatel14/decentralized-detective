package defpackage;

import java.lang.ref.WeakReference;
import org.chromium.base.Callback;

/* JADX INFO: renamed from: a51, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0331a51 {
    public final Z41 a;
    public final WeakReference b;
    public final Callback c;

    public C0331a51(F21 f21, Callback callback) {
        Z41 z41 = new Z41(this);
        this.a = z41;
        this.b = new WeakReference(f21);
        this.c = callback;
        f21.k(z41);
    }
}
