package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class IS2 {
    public final Context a;
    public final InterfaceC1394rU2 b;

    public IS2(Context context, InterfaceC1394rU2 interfaceC1394rU2) {
        this.a = context;
        this.b = interfaceC1394rU2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof IS2) {
            IS2 is2 = (IS2) obj;
            if (this.a.equals(is2.a)) {
                InterfaceC1394rU2 interfaceC1394rU2 = is2.b;
                InterfaceC1394rU2 interfaceC1394rU22 = this.b;
                if (interfaceC1394rU22 != null ? interfaceC1394rU22.equals(interfaceC1394rU2) : interfaceC1394rU2 == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        InterfaceC1394rU2 interfaceC1394rU2 = this.b;
        return iHashCode ^ (interfaceC1394rU2 == null ? 0 : interfaceC1394rU2.hashCode());
    }

    public final String toString() {
        return "FlagsContext{context=" + this.a.toString() + ", hermeticFileOverrides=" + String.valueOf(this.b) + "}";
    }
}
