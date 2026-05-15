package org.chromium.chrome.modules.dev_ui;

import J.N;
import defpackage.fx0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class DevUiInstallListener implements fx0 {
    public long a;

    public DevUiInstallListener(long j) {
        this.a = j;
    }

    @Override // defpackage.fx0
    public final void a(boolean z) {
        long j = this.a;
        if (j == 0) {
            return;
        }
        N._V_ZJ(17, z, j);
    }

    public final void onNativeDestroy() {
        this.a = 0L;
    }
}
