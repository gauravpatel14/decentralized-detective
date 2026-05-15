package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: bE2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class C0394bE2 implements InterfaceC1601vE2, SD2 {
    public final HashMap t = new HashMap();

    @Override // defpackage.InterfaceC1601vE2
    public final Double b() {
        return Double.valueOf(Double.NaN);
    }

    @Override // defpackage.SD2
    public final boolean e(String str) {
        return this.t.containsKey(str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0394bE2) {
            return this.t.equals(((C0394bE2) obj).t);
        }
        return false;
    }

    @Override // defpackage.InterfaceC1601vE2
    public final Iterator f() {
        return new MD2(this.t.keySet().iterator());
    }

    @Override // defpackage.SD2
    public final InterfaceC1601vE2 g(String str) {
        HashMap map = this.t;
        return map.containsKey(str) ? (InterfaceC1601vE2) map.get(str) : InterfaceC1601vE2.l;
    }

    @Override // defpackage.SD2
    public final void h(String str, InterfaceC1601vE2 interfaceC1601vE2) {
        HashMap map = this.t;
        if (interfaceC1601vE2 == null) {
            map.remove(str);
        } else {
            map.put(str, interfaceC1601vE2);
        }
    }

    public final int hashCode() {
        return this.t.hashCode();
    }

    @Override // defpackage.InterfaceC1601vE2
    public InterfaceC1601vE2 i(String str, IQ2 iq2, ArrayList arrayList) {
        return "toString".equals(str) ? new OE2(toString()) : GD2.a(this, new OE2(str), iq2, arrayList);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        HashMap map = this.t;
        if (!map.isEmpty()) {
            for (String str : map.keySet()) {
                sb.append(String.format("%s: %s,", str, map.get(str)));
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // defpackage.InterfaceC1601vE2
    public final InterfaceC1601vE2 zzd() {
        C0394bE2 c0394bE2 = new C0394bE2();
        for (Map.Entry entry : this.t.entrySet()) {
            boolean z = entry.getValue() instanceof SD2;
            HashMap map = c0394bE2.t;
            if (z) {
                map.put((String) entry.getKey(), (InterfaceC1601vE2) entry.getValue());
            } else {
                map.put((String) entry.getKey(), ((InterfaceC1601vE2) entry.getValue()).zzd());
            }
        }
        return c0394bE2;
    }

    @Override // defpackage.InterfaceC1601vE2
    public final Boolean zzg() {
        return Boolean.TRUE;
    }

    @Override // defpackage.InterfaceC1601vE2
    public final String zzi() {
        return "[object Object]";
    }
}
