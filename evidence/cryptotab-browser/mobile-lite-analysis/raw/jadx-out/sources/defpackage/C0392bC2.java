package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: renamed from: bC2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0392bC2 implements InterfaceC1023lN1 {
    public final C0765hG2 a;
    public final C1189o33 b;
    public final Z13 c;
    public final C1491tG2 d;
    public final Handler e = new Handler(Looper.getMainLooper());

    public C0392bC2(C0765hG2 c0765hG2, C1189o33 c1189o33, Z13 z13, C1491tG2 c1491tG2) {
        this.a = c0765hG2;
        this.b = c1189o33;
        this.c = z13;
        this.d = c1491tG2;
    }

    public static ArrayList h(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Locale) it.next()).toLanguageTag());
        }
        return arrayList;
    }

    @Override // defpackage.InterfaceC1023lN1
    public final G62 a(List list) {
        ArrayList arrayListH = h(list);
        C0765hG2 c0765hG2 = this.a;
        C0562eD2 c0562eD2 = c0765hG2.b;
        if (c0562eD2 == null) {
            return C0765hG2.e();
        }
        C0765hG2.c.c("deferredLanguageInstall(%s)", arrayListH);
        H62 h62 = new H62();
        c0562eD2.c(new C1315qE2(c0765hG2, h62, arrayListH, h62), h62);
        return h62.a;
    }

    @Override // defpackage.InterfaceC1023lN1
    public final Set b() {
        return this.c.b();
    }

    @Override // defpackage.InterfaceC1023lN1
    public final synchronized void c(InterfaceC1267pN1 interfaceC1267pN1) {
        C1189o33 c1189o33 = this.b;
        synchronized (c1189o33) {
            c1189o33.a.c("unregisterListener", new Object[0]);
            if (interfaceC1267pN1 == null) {
                throw new NullPointerException("Unregistered Play Core listener should not be null.");
            }
            c1189o33.d.remove(interfaceC1267pN1);
            c1189o33.a();
        }
    }

    @Override // defpackage.InterfaceC1023lN1
    public final Set d() {
        HashSet hashSetC = this.c.c();
        return hashSetC == null ? Collections.emptySet() : hashSetC;
    }

    @Override // defpackage.InterfaceC1023lN1
    public final synchronized void e(InterfaceC1267pN1 interfaceC1267pN1) {
        C1189o33 c1189o33 = this.b;
        synchronized (c1189o33) {
            c1189o33.a.c("registerListener", new Object[0]);
            if (interfaceC1267pN1 == null) {
                throw new NullPointerException("Registered Play Core listener should not be null.");
            }
            c1189o33.d.add(interfaceC1267pN1);
            c1189o33.a();
        }
    }

    @Override // defpackage.InterfaceC1023lN1
    public final G62 f(List list) {
        C0765hG2 c0765hG2 = this.a;
        C0562eD2 c0562eD2 = c0765hG2.b;
        if (c0562eD2 == null) {
            return C0765hG2.e();
        }
        C0765hG2.c.c("deferredInstall(%s)", list);
        H62 h62 = new H62();
        c0562eD2.c(new C0885jE2(c0765hG2, h62, list, h62), h62);
        return h62.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004e  */
    @Override // defpackage.InterfaceC1023lN1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.G62 g(defpackage.C1207oN1 r12) {
        /*
            Method dump skipped, instruction units count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0392bC2.g(oN1):G62");
    }
}
