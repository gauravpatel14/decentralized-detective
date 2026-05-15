package defpackage;

import org.chromium.ui.dragdrop.DropDataAndroid;

/* JADX INFO: renamed from: p30, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1249p30 {
    public static n30 c;
    public final int a;
    public final DropDataAndroid b;

    public C1249p30(int i, DropDataAndroid dropDataAndroid) {
        this.a = i;
        this.b = dropDataAndroid;
    }

    public static C1249p30 a(C1188o30 c1188o30) {
        n30 n30Var = c;
        if (n30Var == null || !n30Var.b.equals(c1188o30)) {
            return null;
        }
        return c.a;
    }

    public static boolean b() {
        return c != null;
    }

    public final String toString() {
        return "DragDropGlobalState sourceId:" + this.a;
    }
}
