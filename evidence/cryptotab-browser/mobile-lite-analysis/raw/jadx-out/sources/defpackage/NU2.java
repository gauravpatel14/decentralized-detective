package defpackage;

import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class NU2 implements Runnable {
    public final URL t;
    public final /* synthetic */ PU2 u;
    public final C1089mR2 v;

    public NU2(PU2 pu2, String str, URL url, C1089mR2 c1089mR2) {
        this.u = pu2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(c1089mR2);
        this.t = url;
        this.v = c1089mR2;
    }

    public final void a(final int i, final IOException iOException, final byte[] bArr, final Map map) {
        C0899jR2 c0899jR2 = this.u.a.j;
        C1391rR2.k(c0899jR2);
        c0899jR2.o(new Runnable(i, iOException, bArr, map) { // from class: LU2
            public final /* synthetic */ int u;
            public final /* synthetic */ IOException v;
            public final /* synthetic */ byte[] w;

            /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void run() {
                /*
                    Method dump skipped, instruction units count: 274
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: defpackage.LU2.run():void");
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a2  */
    /* JADX WARN: Type inference failed for: r10v0, types: [NU2] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.Throwable {
        /*
            r10 = this;
            PU2 r0 = r10.u
            rR2 r1 = r0.a
            rR2 r0 = r0.a
            jR2 r1 = r1.j
            defpackage.C1391rR2.k(r1)
            r1.k()
            r1 = 0
            r2 = 0
            java.net.URL r3 = r10.t     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L87
            java.net.URLConnection r3 = r3.openConnection()     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L87
            boolean r4 = r3 instanceof java.net.HttpURLConnection     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L87
            if (r4 == 0) goto L89
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L87
            r3.setDefaultUseCaches(r1)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L87
            r0.getClass()     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L87
            r4 = 60000(0xea60, float:8.4078E-41)
            r3.setConnectTimeout(r4)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L87
            r0.getClass()     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L87
            r0 = 61000(0xee48, float:8.5479E-41)
            r3.setReadTimeout(r0)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L87
            r3.setInstanceFollowRedirects(r1)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L87
            r0 = 1
            r3.setDoInput(r0)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L87
            int r0 = r3.getResponseCode()     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7f
            java.util.Map r4 = r3.getHeaderFields()     // Catch: java.lang.Throwable -> L73 java.io.IOException -> L76
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L6b
            r5.<init>()     // Catch: java.lang.Throwable -> L6b
            java.io.InputStream r6 = r3.getInputStream()     // Catch: java.lang.Throwable -> L6b
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L57
        L4d:
            int r8 = r6.read(r7)     // Catch: java.lang.Throwable -> L57
            if (r8 <= 0) goto L59
            r5.write(r7, r1, r8)     // Catch: java.lang.Throwable -> L57
            goto L4d
        L57:
            r1 = move-exception
            goto L6d
        L59:
            byte[] r1 = r5.toByteArray()     // Catch: java.lang.Throwable -> L57
            r6.close()     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L69
            r3.disconnect()
            r10.a(r0, r2, r1, r4)
            return
        L67:
            r1 = move-exception
            goto L94
        L69:
            r1 = move-exception
            goto La0
        L6b:
            r1 = move-exception
            r6 = r2
        L6d:
            if (r6 == 0) goto L72
            r6.close()     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L69
        L72:
            throw r1     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L69
        L73:
            r1 = move-exception
            r4 = r2
            goto L94
        L76:
            r1 = move-exception
            r4 = r2
            goto La0
        L79:
            r0 = move-exception
            r4 = r2
        L7b:
            r9 = r1
            r1 = r0
            r0 = r9
            goto L94
        L7f:
            r0 = move-exception
            r4 = r2
        L81:
            r9 = r1
            r1 = r0
            r0 = r9
            goto La0
        L85:
            r0 = move-exception
            goto L91
        L87:
            r0 = move-exception
            goto L9d
        L89:
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L87
            java.lang.String r3 = "Failed to obtain HTTP connection"
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L87
            throw r0     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L87
        L91:
            r3 = r2
            r4 = r3
            goto L7b
        L94:
            if (r3 == 0) goto L99
            r3.disconnect()
        L99:
            r10.a(r0, r2, r2, r4)
            throw r1
        L9d:
            r3 = r2
            r4 = r3
            goto L81
        La0:
            if (r3 == 0) goto La5
            r3.disconnect()
        La5:
            r10.a(r0, r1, r2, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.NU2.run():void");
    }
}
