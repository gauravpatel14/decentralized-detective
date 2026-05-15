package defpackage;

import org.chromium.base.Callback;

/* JADX INFO: renamed from: sE0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1430sE0 {
    public final Hm1 a = new Hm1();
    public boolean b;

    public AbstractC1430sE0() {
        int i = AbstractC1872zv.a;
    }

    public abstract void a();

    public final Object b() {
        int i = AbstractC1872zv.a;
        Hm1 hm1 = this.a;
        if (!hm1.d() && !this.b) {
            a();
            this.b = true;
        }
        if (hm1.d()) {
            return hm1.b;
        }
        return null;
    }

    public final void c(Callback callback) {
        int i = AbstractC1872zv.a;
        this.a.g(callback);
    }

    public final void d(Object obj) {
        int i = AbstractC1872zv.a;
        this.a.b(obj);
    }
}
