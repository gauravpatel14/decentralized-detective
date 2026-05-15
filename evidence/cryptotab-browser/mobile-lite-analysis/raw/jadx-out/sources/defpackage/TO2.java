package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TO2 extends YM2 {
    public boolean b;

    public TO2(C1391rR2 c1391rR2) {
        super(c1391rR2);
        this.a.E++;
    }

    public final void h() {
        if (!this.b) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void i() {
        if (this.b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (j()) {
            return;
        }
        this.a.a();
        this.b = true;
    }

    public abstract boolean j();
}
