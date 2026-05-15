package defpackage;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RQ0 extends ZG0 {
    public static final Method W;
    public C1300py V;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                W = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    @Override // defpackage.ZG0
    public final V30 b(Context context, boolean z) {
        QQ0 qq0 = new QQ0(context, z);
        qq0.H = this;
        return qq0;
    }
}
