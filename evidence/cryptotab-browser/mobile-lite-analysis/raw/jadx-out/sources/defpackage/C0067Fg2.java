package defpackage;

import java.util.function.Function;
import org.chromium.base.Callback;

/* JADX INFO: renamed from: Fg2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0067Fg2 implements F21 {
    public final H21 t = new H21();
    public final C0057Eg2 u;
    public final C0057Eg2 v;
    public final H21 w;
    public final Function x;
    public F21 y;

    /* JADX WARN: Type inference failed for: r0v1, types: [Eg2] */
    /* JADX WARN: Type inference failed for: r0v2, types: [Eg2] */
    public C0067Fg2(H21 h21, Function function) {
        final int i = 0;
        this.u = new Callback(this) { // from class: Eg2
            public final /* synthetic */ C0067Fg2 u;

            {
                this.u = this;
            }

            @Override // org.chromium.base.Callback
            /* JADX INFO: renamed from: onResult */
            public final void a0(Object obj) {
                switch (i) {
                    case 0:
                        this.u.a(obj);
                        break;
                    default:
                        this.u.t.d(obj);
                        break;
                }
            }
        };
        final int i2 = 1;
        this.v = new Callback(this) { // from class: Eg2
            public final /* synthetic */ C0067Fg2 u;

            {
                this.u = this;
            }

            @Override // org.chromium.base.Callback
            /* JADX INFO: renamed from: onResult */
            public final void a0(Object obj) {
                switch (i2) {
                    case 0:
                        this.u.a(obj);
                        break;
                    default:
                        this.u.t.d(obj);
                        break;
                }
            }
        };
        this.w = h21;
        this.x = function;
    }

    public final void a(Object obj) {
        F21 f21 = this.y;
        C0057Eg2 c0057Eg2 = this.v;
        if (f21 != null) {
            f21.b(c0057Eg2);
        }
        F21 f212 = obj == null ? null : (F21) this.x.apply(obj);
        this.y = f212;
        H21 h21 = this.t;
        if (f212 == null) {
            h21.d(null);
        } else {
            h21.d(f212.k(c0057Eg2));
        }
    }

    @Override // defpackage.F21
    public final void b(Callback callback) {
        H21 h21 = this.t;
        h21.b(callback);
        if (h21.v.isEmpty()) {
            this.w.b(this.u);
            F21 f21 = this.y;
            if (f21 != null) {
                f21.b(this.v);
                this.y = null;
            }
        }
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        F21 f21;
        H21 h21 = this.t;
        if (!h21.v.isEmpty()) {
            int i = AbstractC1872zv.a;
            return h21.u;
        }
        Object obj = this.w.get();
        if (obj == null || (f21 = (F21) this.x.apply(obj)) == null) {
            return null;
        }
        return f21.get();
    }

    @Override // defpackage.F21
    public final Object k(Callback callback) {
        H21 h21 = this.t;
        if (h21.v.isEmpty()) {
            a(this.w.k(this.u));
        }
        return h21.k(callback);
    }
}
