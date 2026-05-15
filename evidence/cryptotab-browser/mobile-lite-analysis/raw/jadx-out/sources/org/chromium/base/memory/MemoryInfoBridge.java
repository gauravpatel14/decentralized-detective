package org.chromium.base.memory;

import android.app.ActivityManager;
import android.os.Debug;
import android.os.Process;
import defpackage.AbstractC1499tM;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class MemoryInfoBridge {
    public static Debug.MemoryInfo getActivityManagerMemoryInfoForSelf() {
        try {
            Debug.MemoryInfo[] processMemoryInfo = ((ActivityManager) AbstractC1499tM.a.getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()});
            if (processMemoryInfo == null) {
                return null;
            }
            return processMemoryInfo[0];
        } catch (SecurityException unused) {
            return null;
        }
    }
}
