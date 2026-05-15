package defpackage;

import org.chromium.ui.base.SelectFileDialog;
import org.chromium.ui.permissions.PermissionCallback;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class sD1 implements PermissionCallback {
    public final /* synthetic */ SelectFileDialog a;

    @Override // org.chromium.ui.permissions.PermissionCallback
    public final void b(int[] iArr, String[] strArr) {
        String[] strArr2 = SelectFileDialog.E;
        SelectFileDialog selectFileDialog = this.a;
        selectFileDialog.getClass();
        if (iArr.length == 0 || iArr[0] == -1) {
            return;
        }
        new vD1(selectFileDialog, Boolean.TRUE, selectFileDialog.y, selectFileDialog).c(AbstractC1103mg.e);
    }
}
