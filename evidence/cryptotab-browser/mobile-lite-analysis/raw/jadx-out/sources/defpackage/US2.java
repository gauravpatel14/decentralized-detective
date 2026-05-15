package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class US2 extends QS2 {
    public boolean b;

    public US2(C1391rR2 c1391rR2) {
        super(c1391rR2);
        this.a.E++;
    }

    public abstract boolean h();

    public final void i() {
        if (!this.b) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void j() {
        if (this.b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (h()) {
            return;
        }
        this.a.a();
        this.b = true;
    }
}
