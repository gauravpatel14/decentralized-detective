package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class u4 {
    public final LinkedHashMap a = new LinkedHashMap();
    public final LinkedHashMap b = new LinkedHashMap();
    public final LinkedHashMap c = new LinkedHashMap();
    public final ArrayList d = new ArrayList();
    public final transient LinkedHashMap e = new LinkedHashMap();
    public final LinkedHashMap f = new LinkedHashMap();
    public final Bundle g = new Bundle();

    public final boolean a(int i, int i2, Intent intent) {
        String str = (String) this.a.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        q4 q4Var = (q4) this.e.get(str);
        if ((q4Var != null ? q4Var.a : null) != null) {
            ArrayList arrayList = this.d;
            if (arrayList.contains(str)) {
                q4Var.a.a(q4Var.b.c(intent, i2));
                arrayList.remove(str);
                return true;
            }
        }
        this.f.remove(str);
        this.g.putParcelable(str, new ActivityResult(intent, i2));
        return true;
    }

    public abstract void b(int i, AbstractC1065m4 abstractC1065m4, Object obj);

    public final C1480t4 c(String str, AbstractC1065m4 abstractC1065m4, k4 k4Var) {
        e(str);
        this.e.put(str, new q4(abstractC1065m4, k4Var));
        LinkedHashMap linkedHashMap = this.f;
        if (linkedHashMap.containsKey(str)) {
            Object obj = linkedHashMap.get(str);
            linkedHashMap.remove(str);
            k4Var.a(obj);
        }
        Bundle bundle = this.g;
        ActivityResult activityResult = (ActivityResult) Ev.a(str, bundle);
        if (activityResult != null) {
            bundle.remove(str);
            k4Var.a(abstractC1065m4.c(activityResult.u, activityResult.t));
        }
        return new C1480t4(this, str, abstractC1065m4, 1);
    }

    public final C1480t4 d(final String str, InterfaceC0762hF0 interfaceC0762hF0, final AbstractC1065m4 abstractC1065m4, final k4 k4Var) {
        AbstractC0514dF0 lifecycle = interfaceC0762hF0.getLifecycle();
        C0886jF0 c0886jF0 = (C0886jF0) lifecycle;
        if (c0886jF0.c.a(cF0.w)) {
            throw new IllegalStateException(("LifecycleOwner " + interfaceC0762hF0 + " is attempting to register while current state is " + c0886jF0.c + ". LifecycleOwners must call register before they are STARTED.").toString());
        }
        e(str);
        LinkedHashMap linkedHashMap = this.c;
        r4 r4Var = (r4) linkedHashMap.get(str);
        if (r4Var == null) {
            r4Var = new r4(lifecycle);
        }
        InterfaceC0564eF0 interfaceC0564eF0 = new InterfaceC0564eF0() { // from class: p4
            @Override // defpackage.InterfaceC0564eF0
            public final void c(InterfaceC0762hF0 interfaceC0762hF02, bF0 bf0) {
                bF0 bf02 = bF0.ON_START;
                u4 u4Var = this.t;
                LinkedHashMap linkedHashMap2 = u4Var.e;
                String str2 = str;
                if (bf02 != bf0) {
                    if (bF0.ON_STOP == bf0) {
                        linkedHashMap2.remove(str2);
                        return;
                    } else {
                        if (bF0.ON_DESTROY == bf0) {
                            u4Var.f(str2);
                            return;
                        }
                        return;
                    }
                }
                k4 k4Var2 = k4Var;
                AbstractC1065m4 abstractC1065m42 = abstractC1065m4;
                linkedHashMap2.put(str2, new q4(abstractC1065m42, k4Var2));
                LinkedHashMap linkedHashMap3 = u4Var.f;
                if (linkedHashMap3.containsKey(str2)) {
                    Object obj = linkedHashMap3.get(str2);
                    linkedHashMap3.remove(str2);
                    k4Var2.a(obj);
                }
                Bundle bundle = u4Var.g;
                ActivityResult activityResult = (ActivityResult) Ev.a(str2, bundle);
                if (activityResult != null) {
                    bundle.remove(str2);
                    k4Var2.a(abstractC1065m42.c(activityResult.u, activityResult.t));
                }
            }
        };
        r4Var.a.a(interfaceC0564eF0);
        r4Var.b.add(interfaceC0564eF0);
        linkedHashMap.put(str, r4Var);
        return new C1480t4(this, str, abstractC1065m4, 0);
    }

    public final void e(String str) {
        LinkedHashMap linkedHashMap = this.b;
        if (((Integer) linkedHashMap.get(str)) != null) {
            return;
        }
        for (Number number : new mK(new Cl0(new LE1(1)))) {
            int iIntValue = number.intValue();
            LinkedHashMap linkedHashMap2 = this.a;
            if (!linkedHashMap2.containsKey(Integer.valueOf(iIntValue))) {
                int iIntValue2 = number.intValue();
                linkedHashMap2.put(Integer.valueOf(iIntValue2), str);
                linkedHashMap.put(str, Integer.valueOf(iIntValue2));
                return;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public final void f(String str) {
        Integer num;
        if (!this.d.contains(str) && (num = (Integer) this.b.remove(str)) != null) {
            this.a.remove(num);
        }
        this.e.remove(str);
        LinkedHashMap linkedHashMap = this.f;
        if (linkedHashMap.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + linkedHashMap.get(str));
            linkedHashMap.remove(str);
        }
        Bundle bundle = this.g;
        if (bundle.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + ((ActivityResult) Ev.a(str, bundle)));
            bundle.remove(str);
        }
        LinkedHashMap linkedHashMap2 = this.c;
        r4 r4Var = (r4) linkedHashMap2.get(str);
        if (r4Var != null) {
            ArrayList arrayList = r4Var.b;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                r4Var.a.b((InterfaceC0564eF0) it.next());
            }
            arrayList.clear();
            linkedHashMap2.remove(str);
        }
    }
}
