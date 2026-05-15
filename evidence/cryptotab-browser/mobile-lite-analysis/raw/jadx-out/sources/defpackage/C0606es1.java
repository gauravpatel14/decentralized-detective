package defpackage;

import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: renamed from: es1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class C0606es1 {
    public final SparseArray a = new SparseArray();
    public int b = 0;
    public final Set c = Collections.newSetFromMap(new IdentityHashMap());

    public final void a() {
        int i = 0;
        while (true) {
            SparseArray sparseArray = this.a;
            if (i >= sparseArray.size()) {
                return;
            }
            ds1 ds1Var = (ds1) sparseArray.valueAt(i);
            Iterator it = ds1Var.a.iterator();
            while (it.hasNext()) {
                xi1.a(((ps1) it.next()).t);
            }
            ds1Var.a.clear();
            i++;
        }
    }

    public ps1 b(int i) {
        ds1 ds1Var = (ds1) this.a.get(i);
        if (ds1Var == null) {
            return null;
        }
        ArrayList arrayList = ds1Var.a;
        if (arrayList.isEmpty()) {
            return null;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (!((ps1) arrayList.get(size)).i()) {
                return (ps1) arrayList.remove(size);
            }
        }
        return null;
    }

    public final ds1 c(int i) {
        SparseArray sparseArray = this.a;
        ds1 ds1Var = (ds1) sparseArray.get(i);
        if (ds1Var != null) {
            return ds1Var;
        }
        ds1 ds1Var2 = new ds1();
        sparseArray.put(i, ds1Var2);
        return ds1Var2;
    }

    public final void d(ps1 ps1Var) {
        int i = ps1Var.y;
        ArrayList arrayList = c(i).a;
        if (((ds1) this.a.get(i)).b <= arrayList.size()) {
            xi1.a(ps1Var.t);
            return;
        }
        int[] iArr = RecyclerView.W0;
        ps1Var.r();
        arrayList.add(ps1Var);
    }

    public final void e(int i, int i2) {
        ds1 ds1VarC = c(i);
        ds1VarC.b = i2;
        ArrayList arrayList = ds1VarC.a;
        while (arrayList.size() > i2) {
            arrayList.remove(arrayList.size() - 1);
        }
    }
}
