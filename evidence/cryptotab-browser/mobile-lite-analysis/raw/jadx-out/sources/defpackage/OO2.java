package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class OO2 implements l50 {
    @Override // defpackage.l50
    public final k50 a(Context context, String str, j50 j50Var) {
        k50 k50Var = new k50();
        int iB = j50Var.b(context, str, true);
        k50Var.b = iB;
        if (iB != 0) {
            k50Var.c = 1;
        } else {
            int iA = j50Var.a(context, str);
            k50Var.a = iA;
            if (iA != 0) {
                k50Var.c = -1;
            }
        }
        return k50Var;
    }
}
