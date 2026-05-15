package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Wa extends AbstractC1293pp2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ Wa(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.InterfaceC1236op2
    public final void a() {
        Object obj = this.b;
        switch (this.a) {
            case 0:
                Ua ua = (Ua) obj;
                ua.u.O.setAlpha(1.0f);
                LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb = ua.u;
                layoutInflaterFactory2C0658fb.R.d(null);
                layoutInflaterFactory2C0658fb.R = null;
                break;
            case 1:
                LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb2 = (LayoutInflaterFactory2C0658fb) obj;
                layoutInflaterFactory2C0658fb2.O.setAlpha(1.0f);
                layoutInflaterFactory2C0658fb2.R.d(null);
                layoutInflaterFactory2C0658fb2.R = null;
                break;
            default:
                Xa xa = (Xa) obj;
                xa.b.O.setVisibility(8);
                LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb3 = xa.b;
                PopupWindow popupWindow = layoutInflaterFactory2C0658fb3.P;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (layoutInflaterFactory2C0658fb3.O.getParent() instanceof View) {
                    View view = (View) layoutInflaterFactory2C0658fb3.O.getParent();
                    WeakHashMap weakHashMap = AbstractC0604eo2.a;
                    view.requestApplyInsets();
                }
                layoutInflaterFactory2C0658fb3.O.e();
                layoutInflaterFactory2C0658fb3.R.d(null);
                layoutInflaterFactory2C0658fb3.R = null;
                ViewGroup viewGroup = layoutInflaterFactory2C0658fb3.U;
                WeakHashMap weakHashMap2 = AbstractC0604eo2.a;
                viewGroup.requestApplyInsets();
                break;
        }
    }

    @Override // defpackage.AbstractC1293pp2, defpackage.InterfaceC1236op2
    public void c() {
        Object obj = this.b;
        switch (this.a) {
            case 0:
                ((Ua) obj).u.O.setVisibility(0);
                break;
            case 1:
                LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb = (LayoutInflaterFactory2C0658fb) obj;
                layoutInflaterFactory2C0658fb.O.setVisibility(0);
                if (layoutInflaterFactory2C0658fb.O.getParent() instanceof View) {
                    View view = (View) layoutInflaterFactory2C0658fb.O.getParent();
                    WeakHashMap weakHashMap = AbstractC0604eo2.a;
                    view.requestApplyInsets();
                }
                break;
        }
    }
}
