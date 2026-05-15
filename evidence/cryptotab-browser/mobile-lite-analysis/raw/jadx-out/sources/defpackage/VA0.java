package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class VA0 extends UA0 {
    public final Object A;
    public final YA0 x;
    public final WA0 y;
    public final Pz z;

    public VA0(YA0 ya0, WA0 wa0, Pz pz, Object obj) {
        this.x = ya0;
        this.y = wa0;
        this.z = pz;
        this.A = obj;
    }

    @Override // defpackage.InterfaceC0926jk0
    public final /* bridge */ /* synthetic */ Object j(Object obj) {
        x((Throwable) obj);
        return C0302Yj2.a;
    }

    @Override // defpackage.UA0
    public final void x(Throwable th) {
        Pz pz = this.z;
        YA0 ya0 = this.x;
        ya0.getClass();
        Pz pzF = YA0.F(pz);
        WA0 wa0 = this.y;
        Object obj = this.A;
        if (pzF != null) {
            while (PA0.a(pzF.x, false, new VA0(ya0, wa0, pzF, obj), 1) == C1123n01.t) {
                pzF = YA0.F(pzF);
                if (pzF == null) {
                }
            }
            return;
        }
        ya0.e(ya0.o(wa0, obj));
    }
}
