package defpackage;

import java.util.function.Function;
import org.chromium.base.Callback;

/* JADX INFO: renamed from: Dk2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0046Dk2 implements F21 {
    public final H21 t = new H21();
    public final C0033Ck2 u = new Callback() { // from class: Ck2
        @Override // org.chromium.base.Callback
        /* JADX INFO: renamed from: onResult */
        public final void a0(Object obj) {
            C0046Dk2 c0046Dk2 = this.t;
            c0046Dk2.t.d(c0046Dk2.w.apply(obj));
        }
    };
    public final H21 v;
    public final Function w;

    /* JADX WARN: Type inference failed for: r0v1, types: [Ck2] */
    public C0046Dk2(H21 h21, Function function) {
        this.v = h21;
        this.w = function;
    }

    @Override // defpackage.F21
    public final void b(Callback callback) {
        H21 h21 = this.t;
        h21.b(callback);
        if (h21.v.isEmpty()) {
            this.v.b(this.u);
        }
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return this.w.apply(this.v.get());
    }

    @Override // defpackage.F21
    public final Object k(Callback callback) {
        H21 h21 = this.t;
        if (h21.v.isEmpty()) {
            h21.d(this.w.apply(this.v.k(this.u)));
        }
        return h21.k(callback);
    }
}
