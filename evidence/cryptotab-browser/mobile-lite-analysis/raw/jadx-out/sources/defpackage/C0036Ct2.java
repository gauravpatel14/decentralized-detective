package defpackage;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: Ct2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0036Ct2 {
    public final String a;
    public final String b;
    public final C1700wt2 c;
    public final boolean d;

    public C0036Ct2(String str, String str2, C1700wt2 c1700wt2, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = c1700wt2;
        this.d = z;
    }

    public static Parcelable[] a(ArrayList arrayList) {
        Parcelable[] parcelableArr = new Parcelable[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            C0036Ct2 c0036Ct2 = (C0036Ct2) it.next();
            c0036Ct2.getClass();
            Bundle bundle = new Bundle();
            bundle.putString("id", c0036Ct2.a);
            bundle.putString("label", c0036Ct2.b);
            C1700wt2 c1700wt2 = c0036Ct2.c;
            c1700wt2.getClass();
            Bundle bundle2 = new Bundle();
            bundle2.putString("currency", c1700wt2.a);
            bundle2.putString("value", c1700wt2.b);
            bundle.putBundle("amount", bundle2);
            bundle.putBoolean("selected", c0036Ct2.d);
            parcelableArr[i] = bundle;
            i++;
        }
        return parcelableArr;
    }
}
