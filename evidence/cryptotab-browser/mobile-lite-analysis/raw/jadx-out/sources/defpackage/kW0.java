package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class kW0 extends lW0 {
    public final C1703wx x;
    public final /* synthetic */ pW0 y;

    public kW0(pW0 pw0, C1703wx c1703wx) {
        this.y = pw0;
        this.x = c1703wx;
    }

    @Override // defpackage.PI0
    public final String toString() {
        return "LockCont[null, " + this.x + "] for " + this.y;
    }

    @Override // defpackage.lW0
    public final void w() {
        C1703wx c1703wx = this.x;
        c1703wx.m(c1703wx.v);
    }

    @Override // defpackage.lW0
    public final boolean x() {
        if (!lW0.w.compareAndSet(this, 0, 1)) {
            return false;
        }
        return this.x.w(new jW0(this.y, this), C0302Yj2.a) != null;
    }
}
