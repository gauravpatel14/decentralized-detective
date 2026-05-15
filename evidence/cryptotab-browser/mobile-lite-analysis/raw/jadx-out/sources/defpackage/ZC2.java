package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ZC2 implements InterfaceC1601vE2 {
    public final boolean t;

    public ZC2(Boolean bool) {
        this.t = bool == null ? false : bool.booleanValue();
    }

    @Override // defpackage.InterfaceC1601vE2
    public final Double b() {
        return Double.valueOf(true != this.t ? 0.0d : 1.0d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ZC2) && this.t == ((ZC2) obj).t;
    }

    @Override // defpackage.InterfaceC1601vE2
    public final Iterator f() {
        return null;
    }

    public final int hashCode() {
        return Boolean.valueOf(this.t).hashCode();
    }

    @Override // defpackage.InterfaceC1601vE2
    public final InterfaceC1601vE2 i(String str, IQ2 iq2, ArrayList arrayList) {
        boolean zEquals = "toString".equals(str);
        boolean z = this.t;
        if (zEquals) {
            return new OE2(Boolean.toString(z));
        }
        throw new IllegalArgumentException(Boolean.toString(z) + "." + str + " is not a function.");
    }

    public final String toString() {
        return String.valueOf(this.t);
    }

    @Override // defpackage.InterfaceC1601vE2
    public final InterfaceC1601vE2 zzd() {
        return new ZC2(Boolean.valueOf(this.t));
    }

    @Override // defpackage.InterfaceC1601vE2
    public final Boolean zzg() {
        return Boolean.valueOf(this.t);
    }

    @Override // defpackage.InterfaceC1601vE2
    public final String zzi() {
        return Boolean.toString(this.t);
    }
}
