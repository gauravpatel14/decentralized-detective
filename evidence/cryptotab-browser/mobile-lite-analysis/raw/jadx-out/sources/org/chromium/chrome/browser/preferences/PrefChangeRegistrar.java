package org.chromium.chrome.browser.preferences;

import J.N;
import android.util.ArrayMap;
import defpackage.rj1;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class PrefChangeRegistrar {
    public final ArrayMap a = new ArrayMap();
    public long b = N._J_O(26, this);

    public final void a(String str, rj1 rj1Var) {
        this.a.put(str, rj1Var);
        N._V_JOO(40, this.b, this, str);
    }

    public final void b() {
        long j = this.b;
        if (j != 0) {
            N._V_JO(92, j, this);
        }
        this.b = 0L;
    }

    public final void onPreferenceChange(String str) {
        ((rj1) this.a.get(str)).c();
    }
}
