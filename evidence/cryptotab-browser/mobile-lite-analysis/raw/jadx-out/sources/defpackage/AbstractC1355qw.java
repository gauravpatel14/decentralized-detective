package defpackage;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: qw, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1355qw {
    public static void a(List... listArr) {
        vH1 vh1B = AbstractC1532tw.a().b();
        for (List list : listArr) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((AbstractC1239ow) it.next()).b(vh1B);
            }
        }
        vh1B.apply();
    }

    public static void b(List... listArr) {
        vH1 vh1B = AbstractC1532tw.a().b();
        for (List<C1298pw> list : listArr) {
            for (C1298pw c1298pw : list) {
                AbstractC0080Gb0 abstractC0080Gb0 = c1298pw.a;
                String str = c1298pw.b;
                boolean zF = abstractC0080Gb0.f(str);
                if (c1298pw.d == null) {
                    c1298pw.d = AbstractC1532tw.a.b(str);
                }
                vh1B.putBoolean(c1298pw.d, zF);
            }
        }
        vh1B.apply();
    }
}
