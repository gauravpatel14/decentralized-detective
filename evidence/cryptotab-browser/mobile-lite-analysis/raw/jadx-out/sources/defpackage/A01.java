package defpackage;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class A01 {
    public final IconCompat a;
    public final CharSequence b;
    public final PendingIntent c;
    public final boolean d;
    public final Bundle e;
    public ArrayList f;
    public final boolean g;

    public A01(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
        this(iconCompat, charSequence, pendingIntent, new Bundle());
    }

    public final B01 a() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<Gt1> arrayList3 = this.f;
        if (arrayList3 != null) {
            for (Gt1 gt1 : arrayList3) {
                gt1.getClass();
                arrayList2.add(gt1);
            }
        }
        return new B01(this.a, this.b, this.c, this.e, arrayList2.isEmpty() ? null : (Gt1[]) arrayList2.toArray(new Gt1[arrayList2.size()]), arrayList.isEmpty() ? null : (Gt1[]) arrayList.toArray(new Gt1[arrayList.size()]), this.d, this.g);
    }

    public A01(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        this.d = true;
        this.g = true;
        this.a = iconCompat;
        this.b = F01.b(charSequence);
        this.c = pendingIntent;
        this.e = bundle;
        this.f = null;
        this.d = true;
        this.g = true;
    }
}
