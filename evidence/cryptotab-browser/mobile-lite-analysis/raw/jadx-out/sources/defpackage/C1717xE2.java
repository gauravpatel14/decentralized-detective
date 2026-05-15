package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: xE2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1717xE2 implements InterfaceC1601vE2 {
    public final String t;
    public final ArrayList u;

    public C1717xE2(String str, ArrayList arrayList) {
        this.t = str;
        ArrayList arrayList2 = new ArrayList();
        this.u = arrayList2;
        arrayList2.addAll(arrayList);
    }

    @Override // defpackage.InterfaceC1601vE2
    public final Double b() {
        throw new IllegalStateException("Statement cannot be cast as Double");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1717xE2)) {
            return false;
        }
        C1717xE2 c1717xE2 = (C1717xE2) obj;
        String str = this.t;
        if (str == null ? c1717xE2.t == null : str.equals(c1717xE2.t)) {
            return this.u.equals(c1717xE2.u);
        }
        return false;
    }

    @Override // defpackage.InterfaceC1601vE2
    public final Iterator f() {
        return null;
    }

    public final int hashCode() {
        String str = this.t;
        return this.u.hashCode() + ((str != null ? str.hashCode() : 0) * 31);
    }

    @Override // defpackage.InterfaceC1601vE2
    public final InterfaceC1601vE2 i(String str, IQ2 iq2, ArrayList arrayList) {
        throw new IllegalStateException("Statement is not an evaluated entity");
    }

    @Override // defpackage.InterfaceC1601vE2
    public final Boolean zzg() {
        throw new IllegalStateException("Statement cannot be cast as Boolean");
    }

    @Override // defpackage.InterfaceC1601vE2
    public final String zzi() {
        throw new IllegalStateException("Statement cannot be cast as String");
    }

    @Override // defpackage.InterfaceC1601vE2
    public final InterfaceC1601vE2 zzd() {
        return this;
    }
}
