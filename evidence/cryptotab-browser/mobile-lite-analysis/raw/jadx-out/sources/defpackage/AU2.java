package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class AU2 implements Runnable {
    public final /* synthetic */ CD2 t;
    public final /* synthetic */ int u;
    public final /* synthetic */ long v;
    public final /* synthetic */ boolean w;
    public final /* synthetic */ CD2 x;
    public final /* synthetic */ IU2 y;

    public AU2(IU2 iu2, CD2 cd2, int i, long j, boolean z, CD2 cd22) {
        this.y = iu2;
        this.t = cd2;
        this.u = i;
        this.v = j;
        this.w = z;
        this.x = cd22;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IU2 iu2 = this.y;
        CD2 cd2 = this.t;
        iu2.u(cd2);
        IU2.C(this.y, this.t, this.u, this.v, false, this.w);
        Y03.a();
        if (iu2.a.g.p(null, AbstractC0579eO2.C0)) {
            IU2.B(iu2, cd2, this.x);
        }
    }
}
