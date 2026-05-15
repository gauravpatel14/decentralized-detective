package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class HC0 implements Cloneable {
    public final boolean t;
    public final float u;
    public final float v;

    public HC0(float f) {
        this.u = f;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final HC0 clone() {
        boolean z = this.t;
        float f = this.u;
        return z ? new HC0(f, this.v) : new HC0(f);
    }

    public HC0(float f, float f2) {
        this.u = f;
        this.v = f2;
        this.t = true;
    }
}
