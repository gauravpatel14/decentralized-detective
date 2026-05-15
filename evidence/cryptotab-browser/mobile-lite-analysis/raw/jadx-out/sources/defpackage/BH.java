package defpackage;

import J.N;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BH extends CH {
    @Override // defpackage.CH
    public final void a(String str) {
        N._V_O(0, str);
    }

    @Override // defpackage.CH
    public final void b(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        N._V_OO(0, str, str2);
    }

    @Override // defpackage.CH
    public final String d(String str) {
        String str2 = (String) N._O_O(0, str);
        if (str2.isEmpty()) {
            return null;
        }
        return str2;
    }

    @Override // defpackage.CH
    public final boolean e(String str) {
        return N._Z_O(0, str);
    }

    @Override // defpackage.CH
    public final void g() {
        N._V_O(3, "use-mobile-user-agent");
    }
}
