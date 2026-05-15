package defpackage;

import java.util.Objects;

/* JADX INFO: renamed from: Rm1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0209Rm1 extends AbstractC0248Um1 {
    public Object a;

    public final boolean equals(Object obj) {
        return obj != null && (obj instanceof C0209Rm1) && Objects.equals(((C0209Rm1) obj).a, this.a);
    }

    public final String toString() {
        return this.a + " in " + C0209Rm1.class.getSimpleName();
    }
}
