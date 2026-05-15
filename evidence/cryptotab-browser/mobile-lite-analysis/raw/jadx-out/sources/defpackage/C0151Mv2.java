package defpackage;

/* JADX INFO: renamed from: Mv2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0151Mv2 {
    public final AbstractC0228Sv2 a;

    /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0151Mv2() {
        /*
            r7 = this;
            r7.<init>()
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 30
            if (r0 < r1) goto L12
            Rv2 r0 = new Rv2
            r0.<init>()
            r7.a = r0
            goto L90
        L12:
            r1 = 29
            if (r0 < r1) goto L1f
            Pv2 r0 = new Pv2
            r0.<init>()
            r7.a = r0
            goto L90
        L1f:
            Nv2 r0 = new Nv2
            r0.<init>()
            boolean r1 = defpackage.C0166Nv2.f
            r2 = 1
            java.lang.Class<android.view.WindowInsets> r3 = android.view.WindowInsets.class
            java.lang.String r4 = "WindowInsetsCompat"
            if (r1 != 0) goto L3e
            java.lang.String r1 = "CONSUMED"
            java.lang.reflect.Field r1 = r3.getDeclaredField(r1)     // Catch: java.lang.ReflectiveOperationException -> L36
            defpackage.C0166Nv2.e = r1     // Catch: java.lang.ReflectiveOperationException -> L36
            goto L3c
        L36:
            r1 = move-exception
            java.lang.String r5 = "Could not retrieve WindowInsets.CONSUMED field"
            android.util.Log.i(r4, r5, r1)
        L3c:
            defpackage.C0166Nv2.f = r2
        L3e:
            java.lang.reflect.Field r1 = defpackage.C0166Nv2.e
            r5 = 0
            if (r1 == 0) goto L58
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.ReflectiveOperationException -> L52
            android.view.WindowInsets r1 = (android.view.WindowInsets) r1     // Catch: java.lang.ReflectiveOperationException -> L52
            if (r1 == 0) goto L58
            android.view.WindowInsets r6 = new android.view.WindowInsets     // Catch: java.lang.ReflectiveOperationException -> L52
            r6.<init>(r1)     // Catch: java.lang.ReflectiveOperationException -> L52
            r5 = r6
            goto L8c
        L52:
            r1 = move-exception
            java.lang.String r6 = "Could not get value from WindowInsets.CONSUMED field"
            android.util.Log.i(r4, r6, r1)
        L58:
            boolean r1 = defpackage.C0166Nv2.h
            if (r1 != 0) goto L71
            java.lang.Class<android.graphics.Rect> r1 = android.graphics.Rect.class
            java.lang.Class[] r1 = new java.lang.Class[]{r1}     // Catch: java.lang.ReflectiveOperationException -> L69
            java.lang.reflect.Constructor r1 = r3.getConstructor(r1)     // Catch: java.lang.ReflectiveOperationException -> L69
            defpackage.C0166Nv2.g = r1     // Catch: java.lang.ReflectiveOperationException -> L69
            goto L6f
        L69:
            r1 = move-exception
            java.lang.String r3 = "Could not retrieve WindowInsets(Rect) constructor"
            android.util.Log.i(r4, r3, r1)
        L6f:
            defpackage.C0166Nv2.h = r2
        L71:
            java.lang.reflect.Constructor r1 = defpackage.C0166Nv2.g
            if (r1 == 0) goto L8c
            android.graphics.Rect r2 = new android.graphics.Rect     // Catch: java.lang.ReflectiveOperationException -> L86
            r2.<init>()     // Catch: java.lang.ReflectiveOperationException -> L86
            java.lang.Object[] r2 = new java.lang.Object[]{r2}     // Catch: java.lang.ReflectiveOperationException -> L86
            java.lang.Object r1 = r1.newInstance(r2)     // Catch: java.lang.ReflectiveOperationException -> L86
            android.view.WindowInsets r1 = (android.view.WindowInsets) r1     // Catch: java.lang.ReflectiveOperationException -> L86
            r5 = r1
            goto L8c
        L86:
            r1 = move-exception
            java.lang.String r2 = "Could not invoke WindowInsets(Rect) constructor"
            android.util.Log.i(r4, r2, r1)
        L8c:
            r0.c = r5
            r7.a = r0
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0151Mv2.<init>():void");
    }
}
