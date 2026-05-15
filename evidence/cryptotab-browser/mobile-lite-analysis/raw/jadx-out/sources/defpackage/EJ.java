package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class EJ implements cx {
    public final /* synthetic */ GJ a;

    @Override // defpackage.cx
    public final Object a(C0440bx c0440bx) throws Exception {
        GJ gj = this.a;
        int i = gj.v;
        if (i == 0) {
            gj.x.add(c0440bx);
        } else {
            if (i != 1) {
                if (i == 2) {
                    throw new IllegalStateException("Service has been disconnected.");
                }
                if (i != 3) {
                    throw new IllegalStateException("Connection state is invalid");
                }
                throw gj.y;
            }
            C0300Yh2 c0300Yh2 = gj.w;
            if (c0300Yh2 == null) {
                throw new IllegalStateException("ConnectionHolder state is incorrect.");
            }
            c0440bx.a(c0300Yh2);
        }
        return "ConnectionHolder, state = " + gj.v;
    }
}
