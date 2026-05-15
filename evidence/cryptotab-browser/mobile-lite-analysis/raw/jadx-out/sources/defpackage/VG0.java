package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class VG0 implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ ZG0 u;

    public /* synthetic */ VG0(ZG0 zg0, int i) {
        this.t = i;
        this.u = zg0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.t) {
            case 0:
                V30 v30 = this.u.v;
                if (v30 != null) {
                    v30.A = true;
                    v30.requestLayout();
                }
                break;
            default:
                ZG0 zg0 = this.u;
                V30 v302 = zg0.v;
                if (v302 != null && v302.isAttachedToWindow() && zg0.v.getCount() > zg0.v.getChildCount() && zg0.v.getChildCount() <= zg0.F) {
                    zg0.S.setInputMethodMode(2);
                    zg0.a();
                    break;
                }
                break;
        }
    }
}
