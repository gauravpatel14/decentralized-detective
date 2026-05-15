package defpackage;

import android.view.View;
import com.google.android.gms.common.api.Api;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class xF0 {
    public boolean a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public List k;
    public boolean l;

    public final void a(View view) {
        int iF;
        int size = this.k.size();
        View view2 = null;
        int i = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (int i2 = 0; i2 < size; i2++) {
            View view3 = ((ps1) this.k.get(i2)).t;
            C0321Zr1 c0321Zr1 = (C0321Zr1) view3.getLayoutParams();
            if (view3 != view && !c0321Zr1.a.m() && (iF = (c0321Zr1.a.f() - this.d) * this.e) >= 0 && iF < i) {
                view2 = view3;
                if (iF == 0) {
                    break;
                } else {
                    i = iF;
                }
            }
        }
        if (view2 == null) {
            this.d = -1;
        } else {
            this.d = ((C0321Zr1) view2.getLayoutParams()).a.f();
        }
    }

    public final View b(C0738gs1 c0738gs1) {
        List list = this.k;
        if (list == null) {
            View view = c0738gs1.k(this.d, Long.MAX_VALUE).t;
            this.d += this.e;
            return view;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            View view2 = ((ps1) this.k.get(i)).t;
            C0321Zr1 c0321Zr1 = (C0321Zr1) view2.getLayoutParams();
            if (!c0321Zr1.a.m() && this.d == c0321Zr1.a.f()) {
                a(view2);
                return view2;
            }
        }
        return null;
    }
}
