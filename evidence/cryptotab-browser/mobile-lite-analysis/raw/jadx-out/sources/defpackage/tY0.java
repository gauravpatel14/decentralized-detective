package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class tY0 {
    public static C1223oY0 a(AbstractC1701wu1 abstractC1701wu1, long j, List list) {
        C0994kw c0994kw = abstractC1701wu1.E;
        if (c0994kw == null) {
            return new C1223oY0(304, null, true, j, list);
        }
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(((En0) it.next()).a);
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List list2 = c0994kw.h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (En0 en0 : c0994kw.h) {
                    if (!treeSet.contains(en0.a)) {
                        arrayList.add(en0);
                    }
                }
            }
        } else if (!c0994kw.g.isEmpty()) {
            for (Map.Entry entry : c0994kw.g.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new En0((String) entry.getKey(), (String) entry.getValue()));
                }
            }
        }
        return new C1223oY0(304, c0994kw.a, true, j, arrayList);
    }

    public static byte[] b(InputStream inputStream, int i, C0133Lv c0133Lv) throws Throwable {
        byte[] bArrA;
        wi1 wi1Var = new wi1(c0133Lv, i);
        try {
            bArrA = c0133Lv.a(1024);
            while (true) {
                try {
                    int i2 = inputStream.read(bArrA);
                    if (i2 == -1) {
                        break;
                    }
                    wi1Var.write(bArrA, 0, i2);
                } catch (Throwable th) {
                    th = th;
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                    c0133Lv.b(bArrA);
                    wi1Var.close();
                    throw th;
                }
            }
            byte[] byteArray = wi1Var.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused2) {
            }
            c0133Lv.b(bArrA);
            wi1Var.close();
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            bArrA = null;
        }
    }
}
