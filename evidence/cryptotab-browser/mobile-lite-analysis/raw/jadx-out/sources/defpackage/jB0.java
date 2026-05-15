package defpackage;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class jB0 {
    public static final C0688gB0 e;
    public static final C0688gB0 f;
    public final HashMap a;
    public final HashMap b;
    public final C0622fB0 c;
    public static final C0622fB0 d = new C0622fB0();
    public static final iB0 g = new iB0();

    /* JADX WARN: Type inference failed for: r0v1, types: [gB0] */
    /* JADX WARN: Type inference failed for: r0v2, types: [gB0] */
    static {
        final int i = 0;
        e = new InterfaceC0198Qm2() { // from class: gB0
            @Override // defpackage.j70
            public final void a(Object obj, uB0 ub0) throws IOException {
                switch (i) {
                    case 0:
                        ub0.c();
                        ub0.b.value((String) obj);
                        break;
                    default:
                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                        ub0.c();
                        ub0.b.value(zBooleanValue);
                        break;
                }
            }
        };
        final int i2 = 1;
        f = new InterfaceC0198Qm2() { // from class: gB0
            @Override // defpackage.j70
            public final void a(Object obj, uB0 ub0) throws IOException {
                switch (i2) {
                    case 0:
                        ub0.c();
                        ub0.b.value((String) obj);
                        break;
                    default:
                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                        ub0.c();
                        ub0.b.value(zBooleanValue);
                        break;
                }
            }
        };
    }

    public jB0() {
        HashMap map = new HashMap();
        this.a = map;
        HashMap map2 = new HashMap();
        this.b = map2;
        this.c = d;
        map2.put(String.class, e);
        map.remove(String.class);
        map2.put(Boolean.class, f);
        map.remove(Boolean.class);
        map2.put(Date.class, g);
        map.remove(Date.class);
    }
}
