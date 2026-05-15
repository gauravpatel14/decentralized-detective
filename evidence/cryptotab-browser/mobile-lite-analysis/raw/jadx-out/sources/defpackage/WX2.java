package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class WX2 implements InterfaceC0784hY2 {
    public final CU2 a;
    public final FY2 b;
    public final NV2 c;

    public WX2(FY2 fy2, NV2 nv2, CU2 cu2) {
        this.b = fy2;
        this.c = nv2;
        this.a = cu2;
    }

    @Override // defpackage.InterfaceC0784hY2
    public final Object a() {
        return ((AbstractC0360aW2) ((AbstractC1852zW2) this.a).k(5)).e();
    }

    @Override // defpackage.InterfaceC0784hY2
    public final void b(Object obj) {
        this.b.getClass();
        ((AbstractC1852zW2) obj).zzc.e = false;
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // defpackage.InterfaceC0784hY2
    public final int c(Object obj) {
        this.b.getClass();
        EY2 ey2 = ((AbstractC1852zW2) obj).zzc;
        int i = ey2.d;
        if (i != -1) {
            return i;
        }
        int iA = 0;
        for (int i2 = 0; i2 < ey2.a; i2++) {
            int i3 = ey2.b[i2];
            WU2 wu2 = (WU2) ey2.c[i2];
            int iA2 = BV2.a(8);
            int iJ = wu2.j();
            iA += BV2.a(iJ) + iJ + BV2.a(24) + SX2.a(i3 >>> 3, BV2.a(16), iA2 + iA2);
        }
        ey2.d = iA;
        return iA;
    }

    @Override // defpackage.InterfaceC0784hY2
    public final boolean d(Object obj) {
        this.c.getClass();
        yi1.a(obj);
        throw null;
    }

    @Override // defpackage.InterfaceC0784hY2
    public final void e(Object obj, FV2 fv2) {
        this.c.getClass();
        yi1.a(obj);
        throw null;
    }

    @Override // defpackage.InterfaceC0784hY2
    public final boolean f(AbstractC1852zW2 abstractC1852zW2, Object obj) {
        this.b.getClass();
        return abstractC1852zW2.zzc.equals(((AbstractC1852zW2) obj).zzc);
    }

    @Override // defpackage.InterfaceC0784hY2
    public final int g(AbstractC1852zW2 abstractC1852zW2) {
        this.b.getClass();
        return abstractC1852zW2.zzc.hashCode();
    }

    @Override // defpackage.InterfaceC0784hY2
    public final void h(AbstractC1852zW2 abstractC1852zW2, AbstractC1852zW2 abstractC1852zW22) {
        AbstractC0849iY2.b(this.b, abstractC1852zW2, abstractC1852zW22);
    }

    @Override // defpackage.InterfaceC0784hY2
    public final void i(Object obj, byte[] bArr, int i, int i2, HU2 hu2) {
        AbstractC1852zW2 abstractC1852zW2 = (AbstractC1852zW2) obj;
        if (abstractC1852zW2.zzc == EY2.f) {
            abstractC1852zW2.zzc = EY2.b();
        }
        obj.getClass();
        throw new ClassCastException();
    }
}
