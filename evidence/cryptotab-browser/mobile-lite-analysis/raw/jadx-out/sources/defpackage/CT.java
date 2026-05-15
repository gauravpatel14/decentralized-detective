package defpackage;

import com.google.firebase.components.DependencyCycleException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CT {
    public static void a(ArrayList arrayList) {
        HashMap map = new HashMap(arrayList.size());
        Iterator it = arrayList.iterator();
        while (true) {
            int i = 0;
            if (!it.hasNext()) {
                Iterator it2 = map.values().iterator();
                while (it2.hasNext()) {
                    for (AT at : (Set) it2.next()) {
                        for (TW tw : at.a.b) {
                            if (tw.c == 0) {
                                Set<AT> set = (Set) map.get(new BT(tw.a, tw.b == 2));
                                if (set != null) {
                                    for (AT at2 : set) {
                                        at.b.add(at2);
                                        at2.c.add(at);
                                    }
                                }
                            }
                        }
                    }
                }
                HashSet<AT> hashSet = new HashSet();
                Iterator it3 = map.values().iterator();
                while (it3.hasNext()) {
                    hashSet.addAll((Set) it3.next());
                }
                HashSet hashSet2 = new HashSet();
                for (AT at3 : hashSet) {
                    if (at3.c.isEmpty()) {
                        hashSet2.add(at3);
                    }
                }
                while (!hashSet2.isEmpty()) {
                    AT at4 = (AT) hashSet2.iterator().next();
                    hashSet2.remove(at4);
                    i++;
                    for (AT at5 : at4.b) {
                        at5.c.remove(at4);
                        if (at5.c.isEmpty()) {
                            hashSet2.add(at5);
                        }
                    }
                }
                if (i == arrayList.size()) {
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                for (AT at6 : hashSet) {
                    if (!at6.c.isEmpty() && !at6.b.isEmpty()) {
                        arrayList2.add(at6.a);
                    }
                }
                throw new DependencyCycleException("Dependency cycle detected: " + Arrays.toString(arrayList2.toArray()));
            }
            UH uh = (UH) it.next();
            AT at7 = new AT(uh);
            for (Class cls : uh.a) {
                boolean z = uh.d == 0;
                BT bt = new BT(cls, !z);
                if (!map.containsKey(bt)) {
                    map.put(bt, new HashSet());
                }
                Set set2 = (Set) map.get(bt);
                if (!set2.isEmpty() && z) {
                    throw new IllegalArgumentException("Multiple components provide " + cls + ".");
                }
                set2.add(at7);
            }
        }
    }
}
