package defpackage;

/* JADX INFO: renamed from: yU2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1790yU2 implements Runnable {
    public final /* synthetic */ CD2 t;
    public final /* synthetic */ long u;
    public final /* synthetic */ int v;
    public final /* synthetic */ long w;
    public final /* synthetic */ boolean x;
    public final /* synthetic */ CD2 y;
    public final /* synthetic */ IU2 z;

    public RunnableC1790yU2(IU2 iu2, CD2 cd2, long j, int i, long j2, boolean z, CD2 cd22) {
        this.z = iu2;
        this.t = cd2;
        this.u = j;
        this.v = i;
        this.w = j2;
        this.x = z;
        this.y = cd22;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IU2 iu2 = this.z;
        CD2 cd2 = this.t;
        iu2.u(cd2);
        iu2.q(this.u, false);
        IU2.C(this.z, this.t, this.v, this.w, true, this.x);
        Y03.a();
        if (iu2.a.g.p(null, AbstractC0579eO2.C0)) {
            IU2.B(iu2, cd2, this.y);
        }
    }
}
