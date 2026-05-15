package defpackage;

import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class vp {
    public String a;
    public String b;
    public ArrayList c;
    public boolean d;
    public yp e;

    public final Ap a() {
        AD2 ad2U;
        boolean z = true;
        ArrayList arrayList = this.c;
        boolean z2 = (arrayList == null || arrayList.isEmpty()) ? false : true;
        if (!z2) {
            throw new IllegalArgumentException("Details of the products must be provided.");
        }
        xp xpVar = (xp) this.c.get(0);
        for (int i = 0; i < this.c.size(); i++) {
            xp xpVar2 = (xp) this.c.get(i);
            if (xpVar2 == null) {
                throw new IllegalArgumentException("ProductDetailsParams cannot be null.");
            }
            if (i != 0) {
                C0801hm1 c0801hm1 = xpVar2.a;
                if (!c0801hm1.d.equals(xpVar.a.d) && !c0801hm1.d.equals("play_pass_subs")) {
                    throw new IllegalArgumentException("All products should have same ProductType.");
                }
            }
        }
        String strOptString = xpVar.a.b.optString("packageName");
        for (xp xpVar3 : this.c) {
            if (!xpVar.a.d.equals("play_pass_subs") && !xpVar3.a.d.equals("play_pass_subs") && !strOptString.equals(xpVar3.a.b.optString("packageName"))) {
                throw new IllegalArgumentException("All products must have the same package name.");
            }
        }
        Ap ap = new Ap();
        ap.a = z2 && !((xp) this.c.get(0)).a.b.optString("packageName").isEmpty();
        ap.b = this.a;
        ap.c = this.b;
        yp ypVar = this.e;
        ypVar.getClass();
        if (TextUtils.isEmpty(null) && TextUtils.isEmpty(null)) {
            z = false;
        }
        boolean zIsEmpty = TextUtils.isEmpty(null);
        if (z && !zIsEmpty) {
            throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
        }
        if (!ypVar.a && !z && zIsEmpty) {
            throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
        }
        ap.d = new zp();
        ap.f = new ArrayList();
        ap.g = this.d;
        ArrayList arrayList2 = this.c;
        if (arrayList2 != null) {
            ad2U = AD2.u(arrayList2);
        } else {
            C0884jD2 c0884jD2 = AD2.u;
            ad2U = C1196oE2.x;
        }
        ap.e = ad2U;
        return ap;
    }
}
