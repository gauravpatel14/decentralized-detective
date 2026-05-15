package defpackage;

import android.media.session.MediaSessionManager;
import android.text.TextUtils;

/* JADX INFO: renamed from: yP0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class C1782yP0 extends wP0 {
    @Override // defpackage.wP0
    public final IP0 c() {
        MediaSessionManager.RemoteUserInfo currentControllerInfo = this.a.getCurrentControllerInfo();
        IP0 ip0 = new IP0();
        String packageName = currentControllerInfo.getPackageName();
        if (packageName == null) {
            throw new NullPointerException("package shouldn't be null");
        }
        if (TextUtils.isEmpty(packageName)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        ip0.a = new KP0(currentControllerInfo.getPid(), currentControllerInfo.getUid(), currentControllerInfo.getPackageName());
        return ip0;
    }

    @Override // defpackage.wP0
    public final void f(IP0 ip0) {
    }
}
