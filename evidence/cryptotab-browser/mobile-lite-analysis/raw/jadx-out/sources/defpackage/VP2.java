package defpackage;

import com.google.android.gms.internal.play_billing.zzdc;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class VP2 {
    public static /* bridge */ /* synthetic */ void a(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws zzdc {
        if (!e(b2)) {
            if ((((b2 + 112) + (b << 28)) >> 30) == 0 && !e(b3) && !e(b4)) {
                int i2 = ((b & 7) << 18) | ((b2 & 63) << 12) | ((b3 & 63) << 6) | (b4 & 63);
                cArr[i] = (char) ((i2 >>> 10) + 55232);
                cArr[i + 1] = (char) ((i2 & 1023) + 56320);
                return;
            }
        }
        throw zzdc.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0016 A[PHI: r2
      0x0016: PHI (r2v3 byte) = (r2v2 byte), (r2v9 byte) binds: [B:9:0x0011, B:11:0x0015] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* bridge */ /* synthetic */ void b(byte r2, byte r3, byte r4, char[] r5, int r6) throws com.google.android.gms.internal.play_billing.zzdc {
        /*
            boolean r0 = e(r3)
            if (r0 != 0) goto L2c
            r0 = -96
            r1 = -32
            if (r2 != r1) goto Lf
            if (r3 < r0) goto L2c
            r2 = r1
        Lf:
            r1 = -19
            if (r2 != r1) goto L16
            if (r3 >= r0) goto L2c
            r2 = r1
        L16:
            boolean r0 = e(r4)
            if (r0 != 0) goto L2c
            r2 = r2 & 15
            r3 = r3 & 63
            r4 = r4 & 63
            int r2 = r2 << 12
            int r3 = r3 << 6
            r2 = r2 | r3
            r2 = r2 | r4
            char r2 = (char) r2
            r5[r6] = r2
            return
        L2c:
            com.google.android.gms.internal.play_billing.zzdc r2 = com.google.android.gms.internal.play_billing.zzdc.a()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.VP2.b(byte, byte, byte, char[], int):void");
    }

    public static /* bridge */ /* synthetic */ void c(byte b, byte b2, char[] cArr, int i) throws zzdc {
        if (b < -62 || e(b2)) {
            throw zzdc.a();
        }
        cArr[i] = (char) (((b & 31) << 6) | (b2 & 63));
    }

    public static /* bridge */ /* synthetic */ boolean d(byte b) {
        return b >= 0;
    }

    public static boolean e(byte b) {
        return b > -65;
    }
}
