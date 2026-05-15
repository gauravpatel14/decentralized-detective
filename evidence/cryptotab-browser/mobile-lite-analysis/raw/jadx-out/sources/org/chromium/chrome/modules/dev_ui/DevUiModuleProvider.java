package org.chromium.chrome.modules.dev_ui;

import defpackage.wX;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class DevUiModuleProvider {
    public static void ensureNativeLoaded() {
        wX.a.a();
    }

    public static void installModule(DevUiInstallListener devUiInstallListener) {
        wX.a.e(devUiInstallListener);
    }

    public static boolean isModuleInstalled() {
        return wX.a.g();
    }
}
