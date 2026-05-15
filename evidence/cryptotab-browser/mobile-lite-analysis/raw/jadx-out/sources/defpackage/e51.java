package defpackage;

import org.chromium.base.Callback;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class e51 implements d51 {
    public final Hm1 t = new Hm1();

    public e51() {
        int i = AbstractC1872zv.a;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = AbstractC1872zv.a;
        Hm1 hm1 = this.t;
        if (hm1.d()) {
            return hm1.b;
        }
        return null;
    }

    public final void h(Object obj) {
        int i = AbstractC1872zv.a;
        this.t.b(obj);
    }

    @Override // defpackage.d51
    public final Object p(Callback callback) {
        int i = AbstractC1872zv.a;
        this.t.g(callback);
        return get();
    }
}
