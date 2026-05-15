package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Vw implements zB0, Serializable {
    public transient zB0 t;
    public final Object u;
    public final Class v;
    public final String w;
    public final String x;
    public final boolean y;

    public Vw(Object obj, Class cls, String str, String str2, boolean z) {
        this.u = obj;
        this.v = cls;
        this.w = str;
        this.x = str2;
        this.y = z;
    }

    public abstract zB0 a();

    public final hF b() {
        Class cls = this.v;
        if (!this.y) {
            return Gs1.a(cls);
        }
        Gs1.a.getClass();
        return new y61(cls);
    }
}
