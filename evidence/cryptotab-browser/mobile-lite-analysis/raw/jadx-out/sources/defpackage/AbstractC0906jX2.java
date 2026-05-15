package defpackage;

/* JADX INFO: renamed from: jX2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0906jX2 extends AbstractC0782hX2 {
    public boolean c;

    public AbstractC0906jX2(QX2 qx2) {
        super(qx2);
        this.b.q++;
    }

    public final void h() {
        if (!this.c) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void i() {
        if (this.c) {
            throw new IllegalStateException("Can't initialize twice");
        }
        j();
        this.b.r++;
        this.c = true;
    }

    public abstract void j();
}
