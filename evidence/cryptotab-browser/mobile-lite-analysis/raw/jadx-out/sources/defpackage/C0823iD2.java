package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: iD2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0823iD2 implements InterfaceC1601vE2 {
    public final InterfaceC1601vE2 t;
    public final String u;

    public C0823iD2(String str) {
        this.t = InterfaceC1601vE2.l;
        this.u = str;
    }

    @Override // defpackage.InterfaceC1601vE2
    public final Double b() {
        throw new IllegalStateException("Control is not a double");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0823iD2)) {
            return false;
        }
        C0823iD2 c0823iD2 = (C0823iD2) obj;
        return this.u.equals(c0823iD2.u) && this.t.equals(c0823iD2.t);
    }

    @Override // defpackage.InterfaceC1601vE2
    public final Iterator f() {
        return null;
    }

    public final int hashCode() {
        return this.t.hashCode() + (this.u.hashCode() * 31);
    }

    @Override // defpackage.InterfaceC1601vE2
    public final InterfaceC1601vE2 i(String str, IQ2 iq2, ArrayList arrayList) {
        throw new IllegalStateException("Control does not have functions");
    }

    @Override // defpackage.InterfaceC1601vE2
    public final InterfaceC1601vE2 zzd() {
        return new C0823iD2(this.u, this.t.zzd());
    }

    @Override // defpackage.InterfaceC1601vE2
    public final Boolean zzg() {
        throw new IllegalStateException("Control is not a boolean");
    }

    @Override // defpackage.InterfaceC1601vE2
    public final String zzi() {
        throw new IllegalStateException("Control is not a String");
    }

    public C0823iD2(String str, InterfaceC1601vE2 interfaceC1601vE2) {
        this.t = interfaceC1601vE2;
        this.u = str;
    }
}
