package defpackage;

import J.N;
import android.content.Context;
import org.chromium.ui.base.SelectFileDialog;
import org.chromium.ui.base.WindowAndroid;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class uD1 extends AbstractC1103mg {
    public final Context h;
    public final String i;
    public final /* synthetic */ SelectFileDialog j;

    public uD1(SelectFileDialog selectFileDialog, Context context, String str) {
        this.j = selectFileDialog;
        this.h = context;
        this.i = str;
    }

    @Override // defpackage.AbstractC1103mg
    public final Object b() {
        Context context = this.h;
        String str = this.i;
        return Boolean.valueOf((SelectFileDialog.i(context, str) || ((String) N._O_O(2, str)).isEmpty()) ? false : true);
    }

    @Override // defpackage.AbstractC1103mg
    public final void k(Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        SelectFileDialog selectFileDialog = this.j;
        if (!zBooleanValue) {
            String[] strArr = SelectFileDialog.E;
            selectFileDialog.l();
            return;
        }
        selectFileDialog.m(selectFileDialog.t, this.i, "");
        int i = AbstractC0275Wp1.opening_file_error;
        Lt0 lt0 = WindowAndroid.P;
        String string = AbstractC1499tM.a.getString(i);
        if (string != null) {
            C0064Fa2.c(AbstractC1499tM.a, string, 0).e();
        }
    }
}
