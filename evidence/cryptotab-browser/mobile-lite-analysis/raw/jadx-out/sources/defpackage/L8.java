package defpackage;

import org.chromium.ui.permissions.PermissionCallback;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class L8 implements Runnable {
    public final /* synthetic */ String[] t;
    public final /* synthetic */ PermissionCallback u;
    public final /* synthetic */ Q3 v;

    public L8(Q3 q3, String[] strArr, PermissionCallback permissionCallback) {
        this.v = q3;
        this.t = strArr;
        this.u = permissionCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String[] strArr = this.t;
        int[] iArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            iArr[i] = this.v.hasPermission(strArr[i]) ? 0 : -1;
        }
        this.u.b(iArr, strArr);
    }
}
