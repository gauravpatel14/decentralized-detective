package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Gt0 extends y {
    public final It0 v;

    public Gt0(It0 it0, int i) {
        super(it0.size(), i);
        this.v = it0;
    }

    @Override // defpackage.y
    public final Object a(int i) {
        return this.v.get(i);
    }
}
