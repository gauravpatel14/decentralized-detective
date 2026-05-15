package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class dx extends N {
    public final /* synthetic */ C0611ex z;

    public dx(C0611ex c0611ex) {
        this.z = c0611ex;
    }

    @Override // defpackage.N
    public final String f() {
        C0440bx c0440bx = (C0440bx) this.z.t.get();
        if (c0440bx == null) {
            return "Completer object has been garbage collected, future will fail soon";
        }
        return "tag=[" + c0440bx.a + "]";
    }
}
