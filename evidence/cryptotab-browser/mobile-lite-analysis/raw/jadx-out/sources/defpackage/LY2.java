package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class LY2 extends MY2 {
    @Override // defpackage.MY2
    public final double a(long j, Object obj) {
        return Double.longBitsToDouble(k(j, obj));
    }

    @Override // defpackage.MY2
    public final float b(long j, Object obj) {
        return Float.intBitsToFloat(j(j, obj));
    }

    @Override // defpackage.MY2
    public final void c(Object obj, long j, boolean z) {
        if (NY2.g) {
            NY2.b(obj, j, z ? (byte) 1 : (byte) 0);
        } else {
            NY2.c(obj, j, z ? (byte) 1 : (byte) 0);
        }
    }

    @Override // defpackage.MY2
    public final void d(Object obj, long j, byte b) {
        if (NY2.g) {
            NY2.b(obj, j, b);
        } else {
            NY2.c(obj, j, b);
        }
    }

    @Override // defpackage.MY2
    public final void e(Object obj, long j, double d) {
        o(obj, j, Double.doubleToLongBits(d));
    }

    @Override // defpackage.MY2
    public final void f(float f, long j, Object obj) {
        n(Float.floatToIntBits(f), j, obj);
    }

    @Override // defpackage.MY2
    public final boolean g(long j, Object obj) {
        return NY2.g ? NY2.p(j, obj) : NY2.q(j, obj);
    }
}
