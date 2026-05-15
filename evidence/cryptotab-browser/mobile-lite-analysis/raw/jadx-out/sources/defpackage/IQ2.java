package defpackage;

import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class IQ2 {
    public final IQ2 a;
    public final C0693gF2 b;
    public final HashMap c = new HashMap();
    public final HashMap d = new HashMap();

    public IQ2(IQ2 iq2, C0693gF2 c0693gF2) {
        this.a = iq2;
        this.b = c0693gF2;
    }

    public final IQ2 a() {
        return new IQ2(this, this.b);
    }

    public final InterfaceC1601vE2 b(InterfaceC1601vE2 interfaceC1601vE2) {
        return this.b.a(this, interfaceC1601vE2);
    }

    public final InterfaceC1601vE2 c(PC2 pc2) {
        InterfaceC1601vE2 interfaceC1601vE2A = InterfaceC1601vE2.l;
        Iterator itM = pc2.m();
        while (itM.hasNext()) {
            interfaceC1601vE2A = this.b.a(this, pc2.k(((Integer) itM.next()).intValue()));
            if (interfaceC1601vE2A instanceof C0823iD2) {
                break;
            }
        }
        return interfaceC1601vE2A;
    }

    public final InterfaceC1601vE2 d(String str) {
        HashMap map = this.c;
        if (map.containsKey(str)) {
            return (InterfaceC1601vE2) map.get(str);
        }
        IQ2 iq2 = this.a;
        if (iq2 != null) {
            return iq2.d(str);
        }
        throw new IllegalArgumentException(F.a(str, " is not defined"));
    }

    public final void e(String str, InterfaceC1601vE2 interfaceC1601vE2) {
        if (this.d.containsKey(str)) {
            return;
        }
        HashMap map = this.c;
        if (interfaceC1601vE2 == null) {
            map.remove(str);
        } else {
            map.put(str, interfaceC1601vE2);
        }
    }

    public final void f(String str, InterfaceC1601vE2 interfaceC1601vE2) {
        IQ2 iq2;
        HashMap map = this.c;
        if (!map.containsKey(str) && (iq2 = this.a) != null && iq2.g(str)) {
            iq2.f(str, interfaceC1601vE2);
        } else {
            if (this.d.containsKey(str)) {
                return;
            }
            if (interfaceC1601vE2 == null) {
                map.remove(str);
            } else {
                map.put(str, interfaceC1601vE2);
            }
        }
    }

    public final boolean g(String str) {
        if (this.c.containsKey(str)) {
            return true;
        }
        IQ2 iq2 = this.a;
        if (iq2 != null) {
            return iq2.g(str);
        }
        return false;
    }
}
