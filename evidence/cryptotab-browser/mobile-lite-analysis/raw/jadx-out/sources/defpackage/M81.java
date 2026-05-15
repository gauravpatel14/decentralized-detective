package defpackage;

import android.graphics.Bitmap;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class M81 {
    public final Bitmap a;
    public final ArrayList b;
    public int c;
    public final int d;
    public final int e;
    public final ArrayList f;

    public M81(Bitmap bitmap) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.c = 16;
        this.d = 12544;
        this.e = -1;
        ArrayList arrayList2 = new ArrayList();
        this.f = arrayList2;
        if (bitmap.isRecycled()) {
            throw new IllegalArgumentException("Bitmap is not valid");
        }
        arrayList2.add(O81.e);
        this.a = bitmap;
        arrayList.add(C1596v62.d);
        arrayList.add(C1596v62.e);
        arrayList.add(C1596v62.f);
        arrayList.add(C1596v62.g);
        arrayList.add(C1596v62.h);
        arrayList.add(C1596v62.i);
    }
}
