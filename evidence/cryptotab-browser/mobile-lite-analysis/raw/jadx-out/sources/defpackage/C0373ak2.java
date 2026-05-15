package defpackage;

import com.google.protobuf.InvalidProtocolBufferException;

/* JADX INFO: renamed from: ak2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0373ak2 {
    public static boolean a(Object obj, zG zGVar) throws InvalidProtocolBufferException {
        int iB = zGVar.b();
        int i = iB >>> 3;
        int i2 = iB & 7;
        if (i2 == 0) {
            ((Zj2) obj).c(i << 3, Long.valueOf(zGVar.v()));
            return true;
        }
        if (i2 == 1) {
            ((Zj2) obj).c((i << 3) | 1, Long.valueOf(zGVar.n()));
            return true;
        }
        if (i2 == 2) {
            ((Zj2) obj).c((i << 3) | 2, zGVar.e());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw InvalidProtocolBufferException.c();
            }
            ((Zj2) obj).c((i << 3) | 5, Integer.valueOf(zGVar.l()));
            return true;
        }
        Zj2 zj2B = Zj2.b();
        int i3 = i << 3;
        int i4 = i3 | 4;
        while (zGVar.a() != Integer.MAX_VALUE && a(zj2B, zGVar)) {
        }
        if (i4 != zGVar.b()) {
            throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
        }
        zj2B.e = false;
        ((Zj2) obj).c(i3 | 3, zj2B);
        return true;
    }

    public static Zj2 b() {
        return Zj2.b();
    }

    public static void c(Object obj, Object obj2) {
        ((AbstractC0003Al0) obj).b = (Zj2) obj2;
    }
}
