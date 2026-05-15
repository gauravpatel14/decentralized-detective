package defpackage;

import java.io.Serializable;

/* JADX INFO: renamed from: qk2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1348qk2 implements lE0, Serializable {
    public RC0 t;
    public Object u;

    /* JADX WARN: Type inference failed for: r0v2, types: [RC0, hk0] */
    @Override // defpackage.lE0
    public final Object getValue() {
        if (this.u == C0797hj2.a) {
            this.u = this.t.c();
            this.t = null;
        }
        return this.u;
    }

    public final String toString() {
        return this.u != C0797hj2.a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
