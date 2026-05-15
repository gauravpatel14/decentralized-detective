package org.chromium.chrome.browser;

import android.content.Context;
import defpackage.AbstractServiceC1578ul0;
import defpackage.T62;
import defpackage.bN1;
import org.chromium.base.BundleUtils;
import org.chromium.chrome.browser.base.SplitChromeApplication;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ChromeBackgroundService extends AbstractServiceC1578ul0 {
    public String A = "KB";
    public bN1 B;

    @Override // defpackage.AbstractServiceC1578ul0
    public final void a() {
        this.B.a();
    }

    @Override // android.app.Service, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Context contextB = SplitChromeApplication.b(context);
        bN1 bn1 = (bN1) BundleUtils.g(contextB, this.A);
        this.B = bn1;
        bn1.a = this;
        super.attachBaseContext(contextB);
    }

    @Override // defpackage.AbstractServiceC1578ul0
    public final int b(T62 t62) {
        this.B.b(t62);
        return 0;
    }
}
