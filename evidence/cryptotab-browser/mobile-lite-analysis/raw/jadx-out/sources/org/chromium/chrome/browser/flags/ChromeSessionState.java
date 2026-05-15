package org.chromium.chrome.browser.flags;

import android.os.UserManager;
import defpackage.AbstractC1499tM;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ChromeSessionState {
    public static int getMultipleUserProfilesState() {
        return ((UserManager) AbstractC1499tM.a.getSystemService("user")).getUserProfiles().size() > 1 ? 2 : 1;
    }
}
