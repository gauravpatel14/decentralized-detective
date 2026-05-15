package defpackage;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: renamed from: xU2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1735xU2 implements Serializable, InterfaceC1394rU2 {
    public final Object t;

    public C1735xU2(Object obj) {
        this.t = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1735xU2)) {
            return false;
        }
        Object obj2 = ((C1735xU2) obj).t;
        Object obj3 = this.t;
        return obj3 == obj2 || obj3.equals(obj2);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.t});
    }

    public final String toString() {
        return "Suppliers.ofInstance(" + this.t + ")";
    }

    @Override // defpackage.InterfaceC1394rU2
    public final Object zza() {
        return this.t;
    }
}
