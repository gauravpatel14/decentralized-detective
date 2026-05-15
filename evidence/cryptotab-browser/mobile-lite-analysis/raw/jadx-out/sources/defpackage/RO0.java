package defpackage;

import android.os.Bundle;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RO0 {
    public final Bundle a;
    public C0468cP0 b;

    public RO0(C0468cP0 c0468cP0, boolean z) {
        if (c0468cP0 == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        Bundle bundle = new Bundle();
        this.a = bundle;
        this.b = c0468cP0;
        bundle.putBundle("selector", c0468cP0.a);
        bundle.putBoolean("activeScan", z);
    }

    public final void a() {
        if (this.b == null) {
            C0468cP0 c0468cP0B = C0468cP0.b(this.a.getBundle("selector"));
            this.b = c0468cP0B;
            if (c0468cP0B == null) {
                this.b = C0468cP0.c;
            }
        }
    }

    public final boolean b() {
        return this.a.getBoolean("activeScan");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof RO0)) {
            return false;
        }
        RO0 ro0 = (RO0) obj;
        a();
        C0468cP0 c0468cP0 = this.b;
        ro0.a();
        return c0468cP0.equals(ro0.b) && b() == ro0.b();
    }

    public final int hashCode() {
        a();
        return this.b.hashCode() ^ (b() ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DiscoveryRequest{ selector=");
        a();
        sb.append(this.b);
        sb.append(", activeScan=");
        sb.append(b());
        sb.append(", isValid=");
        a();
        this.b.a();
        sb.append(!r1.b.contains(null));
        sb.append(" }");
        return sb.toString();
    }
}
