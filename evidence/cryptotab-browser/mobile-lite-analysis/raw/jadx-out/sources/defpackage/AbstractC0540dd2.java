package defpackage;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: renamed from: dd2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0540dd2 {
    public static View a(Toolbar toolbar) {
        ActionMenuView actionMenuView;
        View childAt;
        int childCount = toolbar.getChildCount();
        while (true) {
            int i = childCount - 1;
            if (childCount <= 0) {
                actionMenuView = null;
                break;
            }
            if (toolbar.getChildAt(i) instanceof ActionMenuView) {
                actionMenuView = (ActionMenuView) toolbar.getChildAt(i);
                break;
            }
            childCount = i;
        }
        if (actionMenuView != null && (childAt = actionMenuView.getChildAt(actionMenuView.getChildCount() - 1)) != null && (childAt instanceof ImageView)) {
            Drawable drawable = ((ImageView) childAt).getDrawable();
            actionMenuView.o();
            C3 c3 = actionMenuView.M;
            B3 b3 = c3.B;
            if (drawable == (b3 != null ? b3.getDrawable() : c3.D ? c3.C : null)) {
                return childAt;
            }
        }
        return null;
    }
}
