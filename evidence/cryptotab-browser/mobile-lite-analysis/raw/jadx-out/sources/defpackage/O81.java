package defpackage;

import android.util.SparseBooleanArray;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class O81 {
    public static final L81 e = new L81();
    public final ArrayList a;
    public final N81 d;
    public final SparseBooleanArray c = new SparseBooleanArray();
    public final UJ1 b = new UJ1(0);

    public O81(ArrayList arrayList, ArrayList arrayList2) {
        this.a = arrayList;
        int size = arrayList.size();
        int i = Integer.MIN_VALUE;
        N81 n81 = null;
        for (int i2 = 0; i2 < size; i2++) {
            N81 n812 = (N81) arrayList.get(i2);
            int i3 = n812.e;
            if (i3 > i) {
                n81 = n812;
                i = i3;
            }
        }
        this.d = n81;
    }
}
