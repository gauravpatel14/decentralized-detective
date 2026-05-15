package defpackage;

import android.view.View;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: rv2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1413rv2 extends AbstractC1293pp2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ C1586uv2 b;

    public /* synthetic */ C1413rv2(C1586uv2 c1586uv2, int i) {
        this.a = i;
        this.b = c1586uv2;
    }

    @Override // defpackage.InterfaceC1236op2
    public final void a() {
        View view;
        C1586uv2 c1586uv2 = this.b;
        switch (this.a) {
            case 0:
                if (c1586uv2.o && (view = c1586uv2.g) != null) {
                    view.setTranslationY(0.0f);
                    c1586uv2.d.setTranslationY(0.0f);
                }
                c1586uv2.d.setVisibility(8);
                ActionBarContainer actionBarContainer = c1586uv2.d;
                actionBarContainer.t = false;
                actionBarContainer.setDescendantFocusability(262144);
                c1586uv2.s = null;
                Xa xa = c1586uv2.k;
                if (xa != null) {
                    xa.a(c1586uv2.j);
                    c1586uv2.j = null;
                    c1586uv2.k = null;
                }
                ActionBarOverlayLayout actionBarOverlayLayout = c1586uv2.c;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = AbstractC0604eo2.a;
                    actionBarOverlayLayout.requestApplyInsets();
                }
                break;
            default:
                c1586uv2.s = null;
                c1586uv2.d.requestLayout();
                break;
        }
    }
}
