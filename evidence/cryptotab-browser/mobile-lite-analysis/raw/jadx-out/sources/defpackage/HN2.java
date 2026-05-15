package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class HN2 implements InterfaceC0773hO2 {
    public final AbstractC0948kF2 a;
    public final C1331qP2 b;
    public final OI2 c;

    public HN2(C1331qP2 c1331qP2, OI2 oi2, AbstractC0948kF2 abstractC0948kF2) {
        this.b = c1331qP2;
        this.c = oi2;
        this.a = abstractC0948kF2;
    }

    @Override // defpackage.InterfaceC0773hO2
    public final LJ2 a() {
        AbstractC0948kF2 abstractC0948kF2 = this.a;
        return abstractC0948kF2 instanceof LJ2 ? (LJ2) ((LJ2) abstractC0948kF2).k(4) : ((AbstractC1495tJ2) ((LJ2) abstractC0948kF2).k(5)).b();
    }

    @Override // defpackage.InterfaceC0773hO2
    public final void b(Object obj) {
        this.b.getClass();
        C1331qP2.c(obj);
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // defpackage.InterfaceC0773hO2
    public final boolean d(Object obj) {
        this.c.getClass();
        yi1.a(obj);
        throw null;
    }

    @Override // defpackage.InterfaceC0773hO2
    public final void e(Object obj, Object obj2) {
        AbstractC1025lO2.u(this.b, obj, obj2);
    }

    @Override // defpackage.InterfaceC0773hO2
    public final int f(LJ2 lj2) {
        this.b.getClass();
        return lj2.zzc.hashCode();
    }

    @Override // defpackage.InterfaceC0773hO2
    public final int g(LJ2 lj2) {
        this.b.getClass();
        C1088mP2 c1088mP2 = lj2.zzc;
        int i = c1088mP2.d;
        if (i != -1) {
            return i;
        }
        int iA = 0;
        for (int i2 = 0; i2 < c1088mP2.a; i2++) {
            int i3 = c1088mP2.b[i2] >>> 3;
            C0519dH2 c0519dH2 = (C0519dH2) c1088mP2.c[i2];
            int iS = DH2.s(8);
            int iS2 = DH2.s(i3) + DH2.s(16);
            int iS3 = DH2.s(24);
            int iJ = c0519dH2.j();
            iA += iS + iS + iS2 + EN2.a(iJ, iJ, iS3);
        }
        c1088mP2.d = iA;
        return iA;
    }

    @Override // defpackage.InterfaceC0773hO2
    public final void h(Object obj, OH2 oh2) {
        this.c.getClass();
        yi1.a(obj);
        throw null;
    }

    @Override // defpackage.InterfaceC0773hO2
    public final boolean i(LJ2 lj2, Object obj) {
        this.b.getClass();
        return lj2.zzc.equals(((LJ2) obj).zzc);
    }

    @Override // defpackage.InterfaceC0773hO2
    public final void j(Object obj, byte[] bArr, int i, int i2, C0628fG2 c0628fG2) {
        LJ2 lj2 = (LJ2) obj;
        if (lj2.zzc == C1088mP2.f) {
            lj2.zzc = C1088mP2.b();
        }
        obj.getClass();
        throw new ClassCastException();
    }
}
