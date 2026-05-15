package defpackage;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class AH extends CH {
    public HashMap b;
    public ArrayList c;
    public int d;

    @Override // defpackage.CH
    public final void a(String str) {
        b(str, null);
    }

    @Override // defpackage.CH
    public final void b(String str, String str2) {
        this.b.put(str, str2 == null ? "" : str2);
        String strB = "--" + str;
        if (str2 != null && !str2.isEmpty()) {
            strB = F.b(strB, "=", str2);
        }
        int i = this.d;
        this.d = i + 1;
        this.c.add(i, strB);
    }

    @Override // defpackage.CH
    public final String d(String str) {
        String str2 = (String) this.b.get(str);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2;
    }

    @Override // defpackage.CH
    public final boolean e(String str) {
        return this.b.containsKey(str);
    }

    @Override // defpackage.CH
    public final void g() {
        this.b.remove("use-mobile-user-agent");
        for (int i = this.d - 1; i > 0; i--) {
            ArrayList arrayList = this.c;
            if (((String) arrayList.get(i)).equals("--use-mobile-user-agent") || ((String) arrayList.get(i)).startsWith("--use-mobile-user-agent=")) {
                this.d--;
                arrayList.remove(i);
            }
        }
    }
}
