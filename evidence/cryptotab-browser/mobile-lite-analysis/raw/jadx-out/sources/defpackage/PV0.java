package defpackage;

import android.util.SparseArray;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class PV0 {
    public NV0 a;
    public SparseArray b;
    public int c;

    public final void a(sX sXVar) {
        SparseArray sparseArray;
        SparseArray sparseArray2;
        int i = 0;
        while (true) {
            sparseArray = sXVar.a;
            int size = sparseArray.size();
            sparseArray2 = this.b;
            if (i >= size) {
                break;
            }
            int iKeyAt = sparseArray.keyAt(i);
            Object objValueAt = sparseArray.valueAt(i);
            if (sparseArray2.get(iKeyAt) == null) {
                OV0 ov0 = new OV0();
                ov0.b = 0;
                AbstractC1859zf2 abstractC1859zf2A = this.a.a(objValueAt);
                ov0.a = abstractC1859zf2A;
                abstractC1859zf2A.a(objValueAt);
                sparseArray2.append(iKeyAt, ov0);
            }
            i++;
        }
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < sparseArray2.size(); i2++) {
            int iKeyAt2 = sparseArray2.keyAt(i2);
            if (sparseArray.get(iKeyAt2) == null) {
                OV0 ov02 = (OV0) sparseArray2.valueAt(i2);
                int i3 = ov02.b + 1;
                ov02.b = i3;
                if (i3 >= this.c) {
                    ov02.a.getClass();
                    hashSet.add(Integer.valueOf(iKeyAt2));
                } else {
                    ov02.a.getClass();
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            sparseArray2.delete(((Integer) it.next()).intValue());
        }
        for (int i4 = 0; i4 < sparseArray.size(); i4++) {
            int iKeyAt3 = sparseArray.keyAt(i4);
            sparseArray.valueAt(i4);
            OV0 ov03 = (OV0) sparseArray2.get(iKeyAt3);
            ov03.b = 0;
            ov03.a.getClass();
        }
    }
}
