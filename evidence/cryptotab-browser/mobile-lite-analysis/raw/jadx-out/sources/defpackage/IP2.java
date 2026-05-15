package defpackage;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class IP2 extends PP2 {
    public IP2(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // defpackage.PP2
    public final double a(long j, Object obj) {
        return Double.longBitsToDouble(this.a.getLong(obj, j));
    }

    @Override // defpackage.PP2
    public final float b(long j, Object obj) {
        return Float.intBitsToFloat(this.a.getInt(obj, j));
    }

    @Override // defpackage.PP2
    public final void c(Object obj, long j, boolean z) {
        if (SP2.g) {
            SP2.b(obj, j, z ? (byte) 1 : (byte) 0);
        } else {
            SP2.c(obj, j, z ? (byte) 1 : (byte) 0);
        }
    }

    @Override // defpackage.PP2
    public final void d(Object obj, long j, byte b) {
        if (SP2.g) {
            SP2.b(obj, j, b);
        } else {
            SP2.c(obj, j, b);
        }
    }

    @Override // defpackage.PP2
    public final void e(Object obj, long j, double d) {
        this.a.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // defpackage.PP2
    public final void f(float f, long j, Object obj) {
        this.a.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // defpackage.PP2
    public final boolean g(long j, Object obj) {
        return SP2.g ? SP2.q(j, obj) : SP2.r(j, obj);
    }
}
