package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Ci1 extends Ai1 {
    public final Object c;

    public Ci1(int i) {
        super(i);
        this.c = new Object();
    }

    @Override // defpackage.Ai1
    public final Object a() {
        Object objA;
        synchronized (this.c) {
            objA = super.a();
        }
        return objA;
    }

    @Override // defpackage.Ai1
    public final boolean b(Object obj) {
        boolean zB;
        synchronized (this.c) {
            zB = super.b(obj);
        }
        return zB;
    }
}
