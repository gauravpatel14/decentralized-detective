package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import org.chromium.base.ContentUriUtils;
import org.chromium.ui.base.SelectFileDialog;
import org.chromium.ui.base.WindowAndroid;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class vD1 extends AbstractC1103mg {
    public final Boolean h;
    public final WindowAndroid i;
    public final InterfaceC0932jv2 j;
    public final /* synthetic */ SelectFileDialog k;

    public vD1(SelectFileDialog selectFileDialog, Boolean bool, WindowAndroid windowAndroid, InterfaceC0932jv2 interfaceC0932jv2) {
        this.k = selectFileDialog;
        this.h = bool;
        this.i = windowAndroid;
        this.j = interfaceC0932jv2;
    }

    @Override // defpackage.AbstractC1103mg
    public final Object b() {
        try {
            Context context = AbstractC1499tM.a;
            SelectFileDialog selectFileDialog = this.k;
            String[] strArr = SelectFileDialog.E;
            selectFileDialog.getClass();
            return ContentUriUtils.b(File.createTempFile(String.valueOf(System.currentTimeMillis()), ".jpg", AbstractC1632vj2.b(context)));
        } catch (IOException e) {
            Log.e("cr_SelectFileDialog", "Cannot retrieve content uri from file", e);
            return null;
        }
    }

    @Override // defpackage.AbstractC1103mg
    public final void k(Object obj) {
        Uri uri = (Uri) obj;
        SelectFileDialog selectFileDialog = this.k;
        selectFileDialog.x = uri;
        Boolean bool = this.h;
        Intent intentB = null;
        if (uri == null) {
            if (selectFileDialog.e() || bool.booleanValue()) {
                selectFileDialog.l();
                return;
            } else {
                selectFileDialog.k(null);
                return;
            }
        }
        if (!bool.booleanValue()) {
            selectFileDialog.k(SelectFileDialog.b(selectFileDialog));
            return;
        }
        if (selectFileDialog.c("video")) {
            boolean zHasPermission = selectFileDialog.y.hasPermission("android.permission.CAMERA");
            if (selectFileDialog.A && zHasPermission) {
                intentB = new Intent("android.media.action.VIDEO_CAPTURE");
            }
        } else {
            intentB = SelectFileDialog.b(selectFileDialog);
        }
        this.i.u(intentB, this.j, Integer.valueOf(AbstractC0275Wp1.low_memory_error));
    }
}
