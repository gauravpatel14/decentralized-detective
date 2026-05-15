package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class GH0 implements K21 {
    public final DH0 a;
    public boolean b = false;

    public GH0(AbstractC1230og abstractC1230og, DH0 dh0) {
        this.a = dh0;
    }

    @Override // defpackage.K21
    public final void a(Object obj) {
        this.b = true;
        this.a.a(obj);
    }

    public final String toString() {
        return this.a.toString();
    }
}
