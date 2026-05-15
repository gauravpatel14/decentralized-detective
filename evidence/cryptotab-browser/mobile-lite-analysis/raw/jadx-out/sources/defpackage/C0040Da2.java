package defpackage;

import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;

/* JADX INFO: renamed from: Da2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0040Da2 extends ContextWrapper {
    @Override // android.content.ContextWrapper, android.content.Context
    public final ApplicationInfo getApplicationInfo() {
        ApplicationInfo applicationInfo = new ApplicationInfo(super.getApplicationInfo());
        applicationInfo.flags &= -536870913;
        return applicationInfo;
    }
}
