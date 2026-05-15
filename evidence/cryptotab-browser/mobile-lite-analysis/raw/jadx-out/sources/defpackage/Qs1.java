package defpackage;

import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Qs1 implements InterfaceC0564eF0 {
    public final InterfaceC0692gF0 t;
    public final jF u;

    public Qs1(InterfaceC0692gF0 interfaceC0692gF0) {
        this.t = interfaceC0692gF0;
        C1011lF c1011lF = C1011lF.c;
        Class<?> cls = interfaceC0692gF0.getClass();
        jF jFVar = (jF) c1011lF.a.get(cls);
        this.u = jFVar == null ? c1011lF.a(cls, null) : jFVar;
    }

    @Override // defpackage.InterfaceC0564eF0
    public final void c(InterfaceC0762hF0 interfaceC0762hF0, bF0 bf0) {
        HashMap map = this.u.a;
        List list = (List) map.get(bf0);
        InterfaceC0692gF0 interfaceC0692gF0 = this.t;
        jF.a(list, interfaceC0762hF0, bf0, interfaceC0692gF0);
        jF.a((List) map.get(bF0.ON_ANY), interfaceC0762hF0, bf0, interfaceC0692gF0);
    }
}
