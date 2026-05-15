package defpackage;

import java.util.ArrayList;

/* JADX INFO: renamed from: oN1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1207oN1 {
    public final ArrayList a;
    public final ArrayList b;

    public /* synthetic */ C1207oN1(C1145nN1 c1145nN1) {
        this.a = new ArrayList(c1145nN1.a);
        this.b = new ArrayList(c1145nN1.b);
    }

    public final String toString() {
        return String.format("SplitInstallRequest{modulesNames=%s,languages=%s}", this.a, this.b);
    }
}
