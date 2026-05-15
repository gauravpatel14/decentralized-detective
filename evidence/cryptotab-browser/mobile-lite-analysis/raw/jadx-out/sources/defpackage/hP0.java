package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class hP0 {
    public final ZO0 a;
    public final ArrayList b = new ArrayList();
    public final boolean c;
    public final WO0 d;
    public C0351aP0 e;

    public hP0(ZO0 zo0, boolean z) {
        this.a = zo0;
        this.d = zo0.u;
        this.c = z;
    }

    public final String toString() {
        return "MediaRouter.RouteProviderInfo{ packageName=" + this.d.a.getPackageName() + " }";
    }
}
