package defpackage;

/* JADX INFO: renamed from: kk2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0987kk2 extends H21 implements gX, InterfaceC0732gk2 {
    public final C0927jk2 w;
    public final C0589eX x = new C0589eX();

    public AbstractC0987kk2(C0927jk2 c0927jk2) {
        this.w = c0927jk2;
    }

    @Override // defpackage.gX
    public final void destroy() {
        this.x.t = true;
        this.w.b(this);
    }

    public final void g(C0865ik2 c0865ik2) {
        this.x.getClass();
        this.w.a(c0865ik2, this);
    }
}
