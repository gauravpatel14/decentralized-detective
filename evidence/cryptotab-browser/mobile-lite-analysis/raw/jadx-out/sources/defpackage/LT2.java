package defpackage;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LT2 {
    public static final Object f = new Object();
    public static volatile IS2 g;
    public static final AtomicInteger h;
    public final IT2 a;
    public final String b;
    public final Object c;
    public volatile int d = -1;
    public volatile Object e;

    static {
        new AtomicReference();
        h = new AtomicInteger();
    }

    public /* synthetic */ LT2(IT2 it2, String str, Object obj) {
        if (it2.a == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.a = it2;
        this.b = str;
        this.c = obj;
    }

    public abstract Object a(String str);

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0100, code lost:
    
        throw r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b() {
        /*
            Method dump skipped, instruction units count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.LT2.b():java.lang.Object");
    }
}
