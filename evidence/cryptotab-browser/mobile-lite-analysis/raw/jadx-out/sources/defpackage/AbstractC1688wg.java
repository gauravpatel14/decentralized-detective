package defpackage;

import android.content.res.Resources;
import android.util.TypedValue;

/* JADX INFO: renamed from: wg, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1688wg {
    public static int a(Resources.Theme theme, int i) {
        TypedValue typedValue = new TypedValue();
        theme.resolveAttribute(i, typedValue, true);
        return typedValue.resourceId != 0 ? theme.getResources().getColor(typedValue.resourceId, theme) : typedValue.data;
    }

    public static int b(Resources.Theme theme, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        return theme.resolveAttribute(i, typedValue, true) ? typedValue.data : theme.getResources().getColor(i2, theme);
    }
}
