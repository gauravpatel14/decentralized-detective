package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RS0 implements Cz1 {
    public final InterfaceC1787yS0 a;
    public final C0373ak2 b;
    public final C1252p90 c;

    public RS0(C0373ak2 c0373ak2, C1252p90 c1252p90, InterfaceC1787yS0 interfaceC1787yS0) {
        this.b = c0373ak2;
        c1252p90.getClass();
        this.c = c1252p90;
        this.a = interfaceC1787yS0;
    }

    @Override // defpackage.Cz1
    public final void a(Object obj, DG dg) {
        this.c.getClass();
        yi1.a(obj);
        throw null;
    }

    @Override // defpackage.Cz1
    public final int b(AbstractC0003Al0 abstractC0003Al0) {
        this.b.getClass();
        return abstractC0003Al0.b.hashCode();
    }

    @Override // defpackage.Cz1
    public final void c(AbstractC0003Al0 abstractC0003Al0, AbstractC0003Al0 abstractC0003Al02) {
        Fz1.B(this.b, abstractC0003Al0, abstractC0003Al02);
    }

    @Override // defpackage.Cz1
    public final void d(Object obj) {
        this.b.getClass();
        ((AbstractC0003Al0) obj).b.e = false;
        this.c.getClass();
        yi1.a(obj);
        throw null;
    }

    @Override // defpackage.Cz1
    public final boolean e(AbstractC0003Al0 abstractC0003Al0, Object obj) {
        this.b.getClass();
        return abstractC0003Al0.b.equals(((AbstractC0003Al0) obj).b);
    }

    @Override // defpackage.Cz1
    public final boolean f(Object obj) {
        this.c.getClass();
        yi1.a(obj);
        throw null;
    }

    @Override // defpackage.Cz1
    public final void g(Object obj, byte[] bArr, int i, int i2, We we) {
        AbstractC0003Al0 abstractC0003Al0 = (AbstractC0003Al0) obj;
        if (abstractC0003Al0.b == Zj2.f) {
            abstractC0003Al0.b = Zj2.b();
        }
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // defpackage.Cz1
    public final int h(A a) {
        this.b.getClass();
        Zj2 zj2 = ((AbstractC0003Al0) a).b;
        int i = zj2.d;
        if (i != -1) {
            return i;
        }
        int iC = 0;
        for (int i2 = 0; i2 < zj2.a; i2++) {
            int i3 = zj2.b[i2] >>> 3;
            iC += CG.c(3, (C0199Qv) zj2.c[i2]) + CG.u(2, i3) + (CG.t(1) * 2);
        }
        zj2.d = iC;
        return iC;
    }

    @Override // defpackage.Cz1
    public final void i(Object obj, zG zGVar, C1191o90 c1191o90) {
        this.b.getClass();
        AbstractC0003Al0 abstractC0003Al0 = (AbstractC0003Al0) obj;
        if (abstractC0003Al0.b == Zj2.f) {
            abstractC0003Al0.b = Zj2.b();
        }
        this.c.getClass();
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // defpackage.Cz1
    public final Object j() {
        return ((C1750xl0) ((AbstractC0003Al0) this.a).f(EnumC1862zl0.x, null, null)).a();
    }
}
