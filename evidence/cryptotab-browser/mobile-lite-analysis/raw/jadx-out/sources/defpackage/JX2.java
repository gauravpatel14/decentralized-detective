package defpackage;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class JX2 {
    public static final void a(Object obj, Object obj2) {
        HX2 hx2 = (HX2) obj;
        if (obj2 != null) {
            throw new ClassCastException();
        }
        if (hx2.isEmpty()) {
            return;
        }
        Iterator it = hx2.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            entry.getKey();
            entry.getValue();
            throw null;
        }
    }

    public static final HX2 b(Object obj, Object obj2) {
        HX2 hx2B = (HX2) obj;
        HX2 hx2 = (HX2) obj2;
        if (!hx2.isEmpty()) {
            if (!hx2B.t) {
                hx2B = hx2B.b();
            }
            hx2B.d();
            if (!hx2.isEmpty()) {
                hx2B.putAll(hx2);
            }
        }
        return hx2B;
    }
}
