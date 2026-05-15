package defpackage;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

/* JADX INFO: renamed from: cR2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0472cR2 implements Thread.UncaughtExceptionHandler {
    public final String a;
    public final /* synthetic */ C0899jR2 b;

    public C0472cR2(C0899jR2 c0899jR2, String str) {
        this.b = c0899jR2;
        Preconditions.checkNotNull(str);
        this.a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        WO2 wo2 = this.b.a.i;
        C1391rR2.k(wo2);
        wo2.f.b(th, this.a);
    }
}
