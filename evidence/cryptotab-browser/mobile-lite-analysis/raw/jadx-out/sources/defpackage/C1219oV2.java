package defpackage;

import android.content.Context;

/* JADX INFO: renamed from: oV2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1219oV2 implements l50 {
    @Override // defpackage.l50
    public final k50 a(Context context, String str, j50 j50Var) {
        int iB;
        k50 k50Var = new k50();
        int iA = j50Var.a(context, str);
        k50Var.a = iA;
        int i = 1;
        int i2 = 0;
        if (iA != 0) {
            iB = j50Var.b(context, str, false);
            k50Var.b = iB;
        } else {
            iB = j50Var.b(context, str, true);
            k50Var.b = iB;
        }
        int i3 = k50Var.a;
        if (i3 == 0) {
            if (iB == 0) {
                i = 0;
            }
            k50Var.c = i;
            return k50Var;
        }
        i2 = i3;
        if (i2 >= iB) {
            i = -1;
        }
        k50Var.c = i;
        return k50Var;
    }
}
