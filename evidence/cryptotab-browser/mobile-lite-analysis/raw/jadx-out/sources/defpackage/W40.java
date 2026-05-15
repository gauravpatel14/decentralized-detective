package defpackage;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class W40 {
    public final CountDownLatch a = new CountDownLatch(1);
    public final AtomicBoolean b = new AtomicBoolean();
    public final AtomicReference c = new AtomicReference();

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.content.Intent r6) {
        /*
            r5 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.b
            r1 = 1
            r0.set(r1)
            java.lang.Class<hf0> r0 = defpackage.C0793hf0.class
            monitor-enter(r0)
            cf0 r1 = defpackage.C0488cf0.c()     // Catch: java.lang.Throwable -> L67
            java.lang.Class<hf0> r2 = defpackage.C0793hf0.class
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L67
            java.lang.Class<hf0> r3 = defpackage.C0793hf0.class
            java.lang.Object r1 = r1.b(r3)     // Catch: java.lang.Throwable -> L64
            hf0 r1 = (defpackage.C0793hf0) r1     // Catch: java.lang.Throwable -> L64
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L67
            monitor-exit(r0)
            r0 = 0
            if (r6 == 0) goto L25
            r1.getClass()
            java.lang.String r2 = r6.getDataString()
            goto L26
        L25:
            r2 = r0
        L26:
            gf0 r3 = new gf0
            kn1 r4 = r1.b
            r3.<init>(r4, r2)
            Z40 r1 = r1.a
            G62 r1 = r1.doWrite(r3)
            if (r6 == 0) goto L4c
            java.lang.String r2 = "com.google.firebase.dynamiclinks.DYNAMIC_LINK_DATA"
            android.os.Parcelable$Creator r3 = com.google.firebase.dynamiclinks.internal.DynamicLinkData.CREATOR
            com.google.android.gms.common.internal.safeparcel.SafeParcelable r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer.deserializeFromIntentExtra(r6, r2, r3)
            com.google.firebase.dynamiclinks.internal.DynamicLinkData r6 = (com.google.firebase.dynamiclinks.internal.DynamicLinkData) r6
            if (r6 == 0) goto L46
            We1 r0 = new We1
            r0.<init>(r6)
        L46:
            if (r0 == 0) goto L4c
            k33 r1 = defpackage.Y62.e(r0)
        L4c:
            U40 r6 = new U40
            r6.<init>(r5)
            k33 r1 = (defpackage.C0939k33) r1
            r1.getClass()
            L23 r0 = defpackage.K62.a
            r1.e(r0, r6)
            U40 r6 = new U40
            r6.<init>(r5)
            r1.b(r6)
            return
        L64:
            r6 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L64
            throw r6     // Catch: java.lang.Throwable -> L67
        L67:
            r6 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L67
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.W40.a(android.content.Intent):void");
    }
}
