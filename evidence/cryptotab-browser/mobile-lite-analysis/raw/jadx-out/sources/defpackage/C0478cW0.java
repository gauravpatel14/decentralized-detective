package defpackage;

/* JADX INFO: renamed from: cW0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0478cW0 extends hW0 {
    public final boolean a() {
        Object objValueOf = this.e;
        if (objValueOf == null) {
            if (AbstractC0065Fb0.a()) {
                boolean zBooleanValue = ((Boolean) this.d).booleanValue();
                objValueOf = Boolean.valueOf(this.a.c(this.b, this.c, zBooleanValue));
                this.e = objValueOf;
            } else {
                objValueOf = this.d;
            }
        }
        return ((Boolean) objValueOf).booleanValue();
    }
}
