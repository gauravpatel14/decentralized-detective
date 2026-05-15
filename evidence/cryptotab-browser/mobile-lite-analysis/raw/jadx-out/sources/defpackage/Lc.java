package defpackage;

import org.chromium.chrome.browser.preferences.ChromeSharedPreferences;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Lc implements pD0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ pD0 b;

    public /* synthetic */ Lc(String str, pD0 pd0) {
        this.a = str;
        this.b = pd0;
    }

    @Override // defpackage.pD0
    public final void a(boolean z) {
        if (z) {
            ChromeSharedPreferences.getInstance().writeString("Chrome.Language.ApplicationOverrideLanguage", this.a);
        }
        this.b.a(z);
    }
}
