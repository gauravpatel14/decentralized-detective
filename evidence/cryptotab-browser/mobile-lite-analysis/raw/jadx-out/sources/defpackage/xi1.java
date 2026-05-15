package defpackage;

import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class xi1 {
    public static final int a = AbstractC0132Lp1.pooling_container_listener_holder_tag;
    public static final int b = AbstractC0132Lp1.is_pooling_container_tag;

    public static final void a(View view) {
        C1754xo2 c1754xo2 = new C1754xo2(view, null);
        EE1 ee1 = new EE1();
        ee1.w = oz0.a(ee1, ee1, c1754xo2);
        while (ee1.hasNext()) {
            View view2 = (View) ee1.next();
            int i = a;
            C1861zi1 c1861zi1 = (C1861zi1) view2.getTag(i);
            if (c1861zi1 == null) {
                c1861zi1 = new C1861zi1();
                view2.setTag(i, c1861zi1);
            }
            ArrayList arrayList = c1861zi1.a;
            int iC = OG.c(arrayList);
            if (-1 < iC) {
                yi1.a(arrayList.get(iC));
                throw null;
            }
        }
    }
}
