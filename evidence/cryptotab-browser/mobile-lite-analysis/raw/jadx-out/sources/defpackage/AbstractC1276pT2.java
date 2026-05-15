package defpackage;

/* JADX INFO: renamed from: pT2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1276pT2 {
    public static volatile AbstractC1153nU2 a = C0964kU2.t;
    public static final Object b = new Object();

    /* JADX WARN: Can't wrap try/catch for region: R(11:19|(1:21)(8:22|(1:24)(1:25)|26|(0)|36|37|38|39)|31|44|32|33|(1:35)|36|37|38|39) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(android.content.Context r5, android.net.Uri r6) {
        /*
            java.lang.String r6 = r6.getAuthority()
            java.lang.String r0 = "com.google.android.gms.phenotype"
            boolean r0 = r0.equals(r6)
            r1 = 0
            if (r0 != 0) goto L1d
            java.lang.String r5 = "PhenotypeClientHelper"
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r0 = " is an unsupported authority. Only com.google.android.gms.phenotype authority is supported."
            java.lang.String r6 = r6.concat(r0)
            android.util.Log.e(r5, r6)
            return r1
        L1d:
            nU2 r6 = defpackage.AbstractC1276pT2.a
            boolean r6 = r6.b()
            if (r6 == 0) goto L32
            nU2 r5 = defpackage.AbstractC1276pT2.a
            java.lang.Object r5 = r5.a()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            return r5
        L32:
            java.lang.Object r6 = defpackage.AbstractC1276pT2.b
            monitor-enter(r6)
            nU2 r0 = defpackage.AbstractC1276pT2.a     // Catch: java.lang.Throwable -> L4b
            boolean r0 = r0.b()     // Catch: java.lang.Throwable -> L4b
            if (r0 == 0) goto L4d
            nU2 r5 = defpackage.AbstractC1276pT2.a     // Catch: java.lang.Throwable -> L4b
            java.lang.Object r5 = r5.a()     // Catch: java.lang.Throwable -> L4b
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch: java.lang.Throwable -> L4b
            boolean r5 = r5.booleanValue()     // Catch: java.lang.Throwable -> L4b
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L4b
            return r5
        L4b:
            r5 = move-exception
            goto La5
        L4d:
            java.lang.String r0 = "com.google.android.gms"
            java.lang.String r2 = r5.getPackageName()     // Catch: java.lang.Throwable -> L4b
            boolean r0 = r0.equals(r2)     // Catch: java.lang.Throwable -> L4b
            if (r0 == 0) goto L5a
            goto L7b
        L5a:
            android.content.pm.PackageManager r0 = r5.getPackageManager()     // Catch: java.lang.Throwable -> L4b
            java.lang.String r2 = "com.google.android.gms.phenotype"
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L4b
            r4 = 29
            if (r3 >= r4) goto L68
            r3 = r1
            goto L6a
        L68:
            r3 = 268435456(0x10000000, float:2.524355E-29)
        L6a:
            android.content.pm.ProviderInfo r0 = r0.resolveContentProvider(r2, r3)     // Catch: java.lang.Throwable -> L4b
            if (r0 == 0) goto L8c
            java.lang.String r2 = "com.google.android.gms"
            java.lang.String r0 = r0.packageName     // Catch: java.lang.Throwable -> L4b
            boolean r0 = r2.equals(r0)     // Catch: java.lang.Throwable -> L4b
            if (r0 != 0) goto L7b
            goto L8c
        L7b:
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch: java.lang.Throwable -> L4b
            java.lang.String r0 = "com.google.android.gms"
            android.content.pm.ApplicationInfo r5 = r5.getApplicationInfo(r0, r1)     // Catch: java.lang.Throwable -> L4b android.content.pm.PackageManager.NameNotFoundException -> L8c
            int r5 = r5.flags     // Catch: java.lang.Throwable -> L4b
            r5 = r5 & 129(0x81, float:1.81E-43)
            if (r5 == 0) goto L8c
            r1 = 1
        L8c:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L4b
            pU2 r0 = new pU2     // Catch: java.lang.Throwable -> L4b
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L4b
            defpackage.AbstractC1276pT2.a = r0     // Catch: java.lang.Throwable -> L4b
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L4b
            nU2 r5 = defpackage.AbstractC1276pT2.a
            java.lang.Object r5 = r5.a()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            return r5
        La5:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L4b
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AbstractC1276pT2.a(android.content.Context, android.net.Uri):boolean");
    }
}
