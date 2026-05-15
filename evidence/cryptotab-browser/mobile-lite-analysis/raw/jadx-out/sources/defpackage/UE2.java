package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class UE2 implements InterfaceC1601vE2 {
    @Override // defpackage.InterfaceC1601vE2
    public final Double b() {
        return Double.valueOf(Double.NaN);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj instanceof UE2;
    }

    @Override // defpackage.InterfaceC1601vE2
    public final Iterator f() {
        return null;
    }

    @Override // defpackage.InterfaceC1601vE2
    public final InterfaceC1601vE2 i(String str, IQ2 iq2, ArrayList arrayList) {
        throw new IllegalStateException("Undefined has no function ".concat(str));
    }

    @Override // defpackage.InterfaceC1601vE2
    public final InterfaceC1601vE2 zzd() {
        return InterfaceC1601vE2.l;
    }

    @Override // defpackage.InterfaceC1601vE2
    public final Boolean zzg() {
        return Boolean.FALSE;
    }

    @Override // defpackage.InterfaceC1601vE2
    public final String zzi() {
        return "undefined";
    }
}
