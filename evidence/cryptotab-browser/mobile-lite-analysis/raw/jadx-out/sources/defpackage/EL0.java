package defpackage;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class EL0 {
    public static Object a(LinkedHashMap linkedHashMap, Object obj) {
        Object obj2 = linkedHashMap.get(obj);
        if (obj2 != null || linkedHashMap.containsKey(obj)) {
            return obj2;
        }
        throw new NoSuchElementException("Key " + obj + " is missing in the map.");
    }

    public static int b(int i) {
        return i < 0 ? i : i < 3 ? i + 1 : i < 1073741824 ? (int) ((i / 0.75f) + 1.0f) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static Map c(ArrayList arrayList) {
        V60 v60 = V60.t;
        int size = arrayList.size();
        if (size == 0) {
            return v60;
        }
        if (size == 1) {
            I81 i81 = (I81) arrayList.get(0);
            return Collections.singletonMap(i81.t, i81.u);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(b(arrayList.size()));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            I81 i812 = (I81) it.next();
            linkedHashMap.put(i812.t, i812.u);
        }
        return linkedHashMap;
    }
}
