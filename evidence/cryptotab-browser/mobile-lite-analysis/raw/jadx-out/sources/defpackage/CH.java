package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CH {
    public static final AtomicReference a = new AtomicReference();

    public static CH c() {
        return (CH) a.get();
    }

    public static void f(String[] strArr) {
        String str;
        AtomicReference atomicReference = a;
        AH ah = new AH();
        ah.b = new HashMap();
        ArrayList arrayList = new ArrayList();
        ah.c = arrayList;
        ah.d = 1;
        if (strArr == null || strArr.length == 0 || (str = strArr[0]) == null) {
            arrayList.add("");
        } else {
            arrayList.add(str);
            int i = 1;
            boolean z = true;
            for (String str2 : strArr) {
                if (i > 0) {
                    i--;
                } else {
                    if (str2.equals("--")) {
                        z = false;
                    }
                    if (z && str2.startsWith("--")) {
                        String[] strArrSplit = str2.split("=", 2);
                        ah.b(strArrSplit[0].substring(2), strArrSplit.length > 1 ? strArrSplit[1] : null);
                    } else {
                        ah.c.add(str2);
                    }
                }
            }
        }
        atomicReference.set(ah);
    }

    public abstract void a(String str);

    public abstract void b(String str, String str2);

    public abstract String d(String str);

    public abstract boolean e(String str);

    public abstract void g();
}
