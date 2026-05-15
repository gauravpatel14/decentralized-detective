package defpackage;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Process;
import org.chromium.base.Callback;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PM1 implements Callback {
    @Override // org.chromium.base.Callback
    /* JADX INFO: renamed from: onResult */
    public final void a0(Object obj) {
        UnsatisfiedLinkError unsatisfiedLinkError = (UnsatisfiedLinkError) obj;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(AbstractC1499tM.a, "org.chromium.chrome.browser.init.LaunchFailedActivity"));
        intent.addFlags(268435456);
        zy0.w(AbstractC1499tM.a, intent, null);
        OE0 oe0 = OE0.h;
        Process.is64Bit();
        if (!Process.is64Bit()) {
            throw new RuntimeException("Starting in 32-bit mode requires the 32-bit native library.", unsatisfiedLinkError);
        }
        throw unsatisfiedLinkError;
    }
}
