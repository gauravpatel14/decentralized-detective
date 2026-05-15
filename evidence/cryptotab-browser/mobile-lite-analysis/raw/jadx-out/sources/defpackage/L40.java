package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class L40 {
    /* JADX WARN: Removed duplicated region for block: B:12:0x0052 A[PHI: r4
      0x0052: PHI (r4v4 long) = (r4v2 long), (r4v3 long) binds: [B:11:0x0050, B:14:0x005b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long a(defpackage.M40 r8) {
        /*
            M40 r0 = defpackage.M40.SECONDS
            int r0 = r8.compareTo(r0)
            r1 = 1
            r2 = 30
            java.util.concurrent.TimeUnit r8 = r8.t
            if (r0 > 0) goto L1d
            long r2 = (long) r2
            M40 r0 = defpackage.M40.NANOSECONDS
            java.util.concurrent.TimeUnit r0 = r0.t
            long r2 = r0.convert(r2, r8)
            long r0 = r2 << r1
            int r8 = defpackage.J40.v
            int r8 = defpackage.K40.a
            goto L67
        L1d:
            long r2 = (long) r2
            M40 r0 = defpackage.M40.NANOSECONDS
            java.util.concurrent.TimeUnit r4 = r0.t
            r5 = 4611686018426999999(0x3ffffffffffa14bf, double:1.9999999999138678)
            long r4 = r8.convert(r5, r4)
            long r6 = -r4
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 > 0) goto L41
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 > 0) goto L41
            java.util.concurrent.TimeUnit r0 = r0.t
            long r2 = r0.convert(r2, r8)
            long r0 = r2 << r1
            int r8 = defpackage.J40.v
            int r8 = defpackage.K40.a
            goto L67
        L41:
            M40 r0 = defpackage.M40.MILLISECONDS
            java.util.concurrent.TimeUnit r0 = r0.t
            long r2 = r0.convert(r2, r8)
            r4 = -4611686018427387903(0xc000000000000001, double:-2.0000000000000004)
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 >= 0) goto L54
        L52:
            r2 = r4
            goto L5e
        L54:
            r4 = 4611686018427387903(0x3fffffffffffffff, double:1.9999999999999998)
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 <= 0) goto L5e
            goto L52
        L5e:
            long r0 = r2 << r1
            r2 = 1
            long r0 = r0 + r2
            int r8 = defpackage.J40.v
            int r8 = defpackage.K40.a
        L67:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.L40.a(M40):long");
    }
}
