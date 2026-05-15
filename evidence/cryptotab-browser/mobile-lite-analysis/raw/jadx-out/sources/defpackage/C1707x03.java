package defpackage;

import android.os.Trace;
import java.io.Closeable;

/* JADX INFO: renamed from: x03, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1707x03 implements Closeable {
    public static final NC2 u;
    public final boolean t;

    static {
        C1428sC2.a().getClass();
        u = new NC2();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C1707x03(java.lang.String r4) {
        /*
            r3 = this;
            r3.<init>()
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            r1 = 0
            if (r0 == 0) goto L19
            NC2 r0 = defpackage.C1707x03.u
            r0.getClass()
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L19
            r0 = 1
            goto L1a
        L19:
            r0 = r1
        L1a:
            r3.t = r0
            if (r0 == 0) goto L2e
            int r0 = r4.length()
            r2 = 127(0x7f, float:1.78E-43)
            if (r0 > r2) goto L27
            goto L2b
        L27:
            java.lang.String r4 = r4.substring(r1, r2)
        L2b:
            android.os.Trace.beginSection(r4)
        L2e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1707x03.<init>(java.lang.String):void");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.t) {
            Trace.endSection();
        }
    }
}
