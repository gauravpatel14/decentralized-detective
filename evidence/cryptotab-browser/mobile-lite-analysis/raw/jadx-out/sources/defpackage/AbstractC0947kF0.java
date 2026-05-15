package defpackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/* JADX INFO: renamed from: kF0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0947kF0 {
    public static final HashMap a = new HashMap();
    public static final HashMap b = new HashMap();

    public static void a(Constructor constructor, InterfaceC0692gF0 interfaceC0692gF0) {
        try {
            constructor.newInstance(interfaceC0692gF0);
            throw new ClassCastException();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    public static final String b(String str) {
        StringBuilder sb = new StringBuilder();
        int iE = cQ1.e(str, ".", 0, false);
        if (iE >= 0) {
            int length = str.length();
            if (length < 0) {
                throw new OutOfMemoryError();
            }
            StringBuilder sb2 = new StringBuilder(length);
            int i = 0;
            do {
                sb2.append((CharSequence) str, i, iE);
                sb2.append("_");
                i = iE + 1;
                if (iE >= str.length()) {
                    break;
                }
                iE = cQ1.e(str, ".", iE + 1, false);
            } while (iE > 0);
            sb2.append((CharSequence) str, i, str.length());
            str = sb2.toString();
        }
        return S3.a(sb, str, "_LifecycleAdapter");
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0116 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(java.lang.Class r13) {
        /*
            Method dump skipped, instruction units count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AbstractC0947kF0.c(java.lang.Class):int");
    }
}
