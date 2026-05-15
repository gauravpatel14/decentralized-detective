package defpackage;

/* JADX INFO: renamed from: xl0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class C1750xl0 implements Cloneable {
    public final AbstractC0003Al0 t;
    public AbstractC0003Al0 u;
    public boolean v = false;

    public C1750xl0(AbstractC0003Al0 abstractC0003Al0) {
        this.t = abstractC0003Al0;
        this.u = (AbstractC0003Al0) abstractC0003Al0.f(EnumC1862zl0.w, null, null);
    }

    public final AbstractC0003Al0 a() {
        if (this.v) {
            return this.u;
        }
        AbstractC0003Al0 abstractC0003Al0 = this.u;
        abstractC0003Al0.getClass();
        C0734gn1 c0734gn1 = C0734gn1.c;
        c0734gn1.getClass();
        c0734gn1.a(abstractC0003Al0.getClass()).d(abstractC0003Al0);
        this.v = true;
        return this.u;
    }

    public final void b() {
        if (this.v) {
            AbstractC0003Al0 abstractC0003Al0 = (AbstractC0003Al0) this.u.f(EnumC1862zl0.w, null, null);
            AbstractC0003Al0 abstractC0003Al02 = this.u;
            C0734gn1 c0734gn1 = C0734gn1.c;
            c0734gn1.getClass();
            c0734gn1.a(abstractC0003Al0.getClass()).c(abstractC0003Al0, abstractC0003Al02);
            this.u = abstractC0003Al0;
            this.v = false;
        }
    }

    public final void c(AbstractC0003Al0 abstractC0003Al0) {
        b();
        AbstractC0003Al0 abstractC0003Al02 = this.u;
        C0734gn1 c0734gn1 = C0734gn1.c;
        c0734gn1.getClass();
        c0734gn1.a(abstractC0003Al02.getClass()).c(abstractC0003Al02, abstractC0003Al0);
    }

    public final Object clone() {
        C1750xl0 c1750xl0 = (C1750xl0) this.t.f(EnumC1862zl0.x, null, null);
        c1750xl0.c(a());
        return c1750xl0;
    }
}
