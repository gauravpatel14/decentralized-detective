package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: renamed from: vM1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC1609vM1 {
    public static final void a(int i, View view, ViewGroup viewGroup) {
        int iB = aM1.b(i);
        if (iB == 0) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup2 != null) {
                viewGroup2.removeView(view);
                return;
            }
            return;
        }
        if (iB == 1) {
            ViewParent parent2 = view.getParent();
            if ((parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null) == null) {
                viewGroup.addView(view);
            }
            view.setVisibility(0);
            return;
        }
        if (iB == 2) {
            view.setVisibility(8);
        } else {
            if (iB != 3) {
                return;
            }
            view.setVisibility(4);
        }
    }
}
