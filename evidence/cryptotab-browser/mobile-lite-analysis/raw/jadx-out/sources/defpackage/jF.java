package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class jF {
    public final HashMap a = new HashMap();
    public final HashMap b;

    public jF(HashMap map) {
        this.b = map;
        for (Map.Entry entry : map.entrySet()) {
            bF0 bf0 = (bF0) entry.getValue();
            List arrayList = (List) this.a.get(bf0);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.a.put(bf0, arrayList);
            }
            arrayList.add((kF) entry.getKey());
        }
    }

    public static void a(List list, InterfaceC0762hF0 interfaceC0762hF0, bF0 bf0, InterfaceC0692gF0 interfaceC0692gF0) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                kF kFVar = (kF) list.get(size);
                kFVar.getClass();
                try {
                    int i = kFVar.a;
                    Method method = kFVar.b;
                    if (i == 0) {
                        method.invoke(interfaceC0692gF0, null);
                    } else if (i == 1) {
                        method.invoke(interfaceC0692gF0, interfaceC0762hF0);
                    } else if (i == 2) {
                        method.invoke(interfaceC0692gF0, interfaceC0762hF0, bf0);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException("Failed to call observer method", e2.getCause());
                }
            }
        }
    }
}
