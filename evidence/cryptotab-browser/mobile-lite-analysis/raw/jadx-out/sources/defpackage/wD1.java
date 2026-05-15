package defpackage;

import J.N;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import org.chromium.base.ContentUriUtils;
import org.chromium.ui.base.SelectFileDialog;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class wD1 extends AbstractC1103mg {
    public String[] h;
    public final Context i;
    public final boolean j;
    public final Uri[] k;
    public final /* synthetic */ SelectFileDialog l;

    public wD1(SelectFileDialog selectFileDialog, Context context, boolean z, Uri[] uriArr) {
        this.l = selectFileDialog;
        this.i = context;
        this.j = z;
        this.k = uriArr;
    }

    @Override // defpackage.AbstractC1103mg
    public final Object b() {
        boolean zEquals;
        Context context;
        Uri[] uriArr = this.k;
        this.h = new String[uriArr.length];
        String[] strArr = new String[uriArr.length];
        for (int i = 0; i < uriArr.length; i++) {
            try {
                zEquals = "file".equals(uriArr[i].getScheme());
                context = this.i;
            } catch (SecurityException unused) {
                Log.w("cr_SelectFileDialog", "Unable to extract results from the content provider");
            }
            if (zEquals) {
                if (SelectFileDialog.i(context, uriArr[i].getSchemeSpecificPart())) {
                    return null;
                }
                this.h[i] = uriArr[i].getSchemeSpecificPart();
                strArr[i] = ContentUriUtils.c(context, uriArr[i]);
            } else {
                if ("content".equals(uriArr[i].getScheme()) && SelectFileDialog.h(context, uriArr[i])) {
                    return null;
                }
                this.h[i] = uriArr[i].toString();
                strArr[i] = ContentUriUtils.c(context, uriArr[i]);
            }
        }
        return strArr;
    }

    @Override // defpackage.AbstractC1103mg
    public final void k(Object obj) {
        String[] strArr = (String[]) obj;
        SelectFileDialog selectFileDialog = this.l;
        if (strArr == null) {
            String[] strArr2 = SelectFileDialog.E;
            selectFileDialog.l();
        } else {
            if (!this.j) {
                selectFileDialog.m(selectFileDialog.t, this.h[0], strArr[0]);
                return;
            }
            long j = selectFileDialog.t;
            String[] strArr3 = this.h;
            selectFileDialog.o(strArr3);
            if (j != 0) {
                N._V_JOOO(57, j, selectFileDialog, strArr3, strArr);
            }
        }
    }
}
