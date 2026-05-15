package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: zD2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1823zD2 implements InterfaceC1601vE2, SD2 {
    public final String t;
    public final HashMap u = new HashMap();

    public AbstractC1823zD2(String str) {
        this.t = str;
    }

    public abstract InterfaceC1601vE2 a(IQ2 iq2, List list);

    @Override // defpackage.InterfaceC1601vE2
    public final Double b() {
        return Double.valueOf(Double.NaN);
    }

    @Override // defpackage.SD2
    public final boolean e(String str) {
        return this.u.containsKey(str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractC1823zD2)) {
            return false;
        }
        AbstractC1823zD2 abstractC1823zD2 = (AbstractC1823zD2) obj;
        String str = this.t;
        if (str != null) {
            return str.equals(abstractC1823zD2.t);
        }
        return false;
    }

    @Override // defpackage.InterfaceC1601vE2
    public final Iterator f() {
        return new MD2(this.u.keySet().iterator());
    }

    @Override // defpackage.SD2
    public final InterfaceC1601vE2 g(String str) {
        HashMap map = this.u;
        return map.containsKey(str) ? (InterfaceC1601vE2) map.get(str) : InterfaceC1601vE2.l;
    }

    @Override // defpackage.SD2
    public final void h(String str, InterfaceC1601vE2 interfaceC1601vE2) {
        HashMap map = this.u;
        if (interfaceC1601vE2 == null) {
            map.remove(str);
        } else {
            map.put(str, interfaceC1601vE2);
        }
    }

    public final int hashCode() {
        String str = this.t;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // defpackage.InterfaceC1601vE2
    public final InterfaceC1601vE2 i(String str, IQ2 iq2, ArrayList arrayList) {
        return "toString".equals(str) ? new OE2(this.t) : GD2.a(this, new OE2(str), iq2, arrayList);
    }

    @Override // defpackage.InterfaceC1601vE2
    public final Boolean zzg() {
        return Boolean.TRUE;
    }

    @Override // defpackage.InterfaceC1601vE2
    public final String zzi() {
        return this.t;
    }

    @Override // defpackage.InterfaceC1601vE2
    public InterfaceC1601vE2 zzd() {
        return this;
    }
}
