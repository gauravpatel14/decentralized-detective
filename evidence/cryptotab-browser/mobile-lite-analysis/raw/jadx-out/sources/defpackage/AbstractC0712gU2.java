package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: gU2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0712gU2 {
    public static InterfaceC1601vE2 a(eS2 es2) {
        if (es2 == null) {
            return InterfaceC1601vE2.l;
        }
        int iT = es2.t() - 1;
        if (iT == 1) {
            return es2.s() ? new OE2(es2.n()) : InterfaceC1601vE2.s;
        }
        if (iT == 2) {
            return es2.r() ? new C1369rD2(Double.valueOf(es2.l())) : new C1369rD2(null);
        }
        if (iT == 3) {
            return es2.q() ? new ZC2(Boolean.valueOf(es2.p())) : new ZC2(null);
        }
        if (iT != 4) {
            throw new IllegalArgumentException("Unknown type found. Cannot convert entity");
        }
        LW2 lw2O = es2.o();
        ArrayList arrayList = new ArrayList();
        Iterator it = lw2O.iterator();
        while (it.hasNext()) {
            arrayList.add(a((eS2) it.next()));
        }
        return new C1717xE2(es2.m(), arrayList);
    }

    public static InterfaceC1601vE2 b(Object obj) {
        if (obj == null) {
            return InterfaceC1601vE2.m;
        }
        if (obj instanceof String) {
            return new OE2((String) obj);
        }
        if (obj instanceof Double) {
            return new C1369rD2((Double) obj);
        }
        if (obj instanceof Long) {
            return new C1369rD2(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Integer) {
            return new C1369rD2(Double.valueOf(((Integer) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return new ZC2((Boolean) obj);
        }
        if (!(obj instanceof Map)) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            PC2 pc2 = new PC2();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                pc2.p(pc2.j(), b(it.next()));
            }
            return pc2;
        }
        C0394bE2 c0394bE2 = new C0394bE2();
        Map map = (Map) obj;
        for (Object string : map.keySet()) {
            InterfaceC1601vE2 interfaceC1601vE2B = b(map.get(string));
            if (string != null) {
                if (!(string instanceof String)) {
                    string = string.toString();
                }
                c0394bE2.h((String) string, interfaceC1601vE2B);
            }
        }
        return c0394bE2;
    }
}
