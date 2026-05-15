package com.android.installreferrer.api;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public interface InstallReferrerStateListener {
    void onInstallReferrerServiceDisconnected();

    void onInstallReferrerSetupFinished(int i);
}
