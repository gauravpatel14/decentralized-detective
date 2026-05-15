package defpackage;

import android.app.Activity;
import org.chromium.base.ApplicationStatus;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Nd implements Wd {
    @Override // defpackage.Wd
    public final void c(Activity activity, boolean z) {
        int iB;
        if (!z || activity == ApplicationStatus.d || (iB = ApplicationStatus.b(activity)) == 6 || iB == 5) {
            return;
        }
        ApplicationStatus.d = activity;
    }
}
