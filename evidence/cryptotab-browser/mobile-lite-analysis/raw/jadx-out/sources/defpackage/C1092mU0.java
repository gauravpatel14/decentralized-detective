package defpackage;

/* JADX INFO: renamed from: mU0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1092mU0 implements QG0 {
    public final /* synthetic */ nU0 t;

    public C1092mU0(nU0 nu0) {
        this.t = nu0;
    }

    @Override // defpackage.QG0
    public final void e(SG0 sg0, int i, int i2, Object obj) {
        this.t.notifyDataSetChanged();
    }

    @Override // defpackage.QG0
    public final void f(int i, int i2) {
        this.t.notifyDataSetChanged();
    }

    @Override // defpackage.QG0
    public final void h(int i, int i2) {
        this.t.notifyDataSetChanged();
    }

    @Override // defpackage.QG0
    public final void j(SG0 sg0, int i, int i2) {
        this.t.notifyDataSetChanged();
    }
}
