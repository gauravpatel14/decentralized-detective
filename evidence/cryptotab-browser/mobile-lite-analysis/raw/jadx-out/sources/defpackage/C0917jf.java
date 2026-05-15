package defpackage;

/* JADX INFO: renamed from: jf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0917jf extends AbstractC0295Xv0 {
    public final /* synthetic */ C0978kf w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0917jf(C0978kf c0978kf) {
        super(c0978kf.v);
        this.w = c0978kf;
    }

    @Override // defpackage.AbstractC0295Xv0
    public final Object a(int i) {
        return this.w.u[i];
    }

    @Override // defpackage.AbstractC0295Xv0
    public final void b(int i) {
        this.w.e(i);
    }
}
