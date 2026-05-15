package defpackage;

import android.R;
import android.content.Context;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class oP0 {
    public static final /* synthetic */ int a = 0;

    public static ContextThemeWrapper a(int i, Context context, boolean z) {
        if (i == 0) {
            i = g(!z ? Ep1.dialogTheme : Ep1.alertDialogTheme, context);
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
        return g(Ep1.mediaRouteTheme, contextThemeWrapper) != 0 ? new ContextThemeWrapper(contextThemeWrapper, e(contextThemeWrapper)) : contextThemeWrapper;
    }

    public static int b(ContextThemeWrapper contextThemeWrapper) {
        int iG = g(Ep1.mediaRouteTheme, contextThemeWrapper);
        return iG == 0 ? e(contextThemeWrapper) : iG;
    }

    public static int c(Context context) {
        return AbstractC1721xH.d(-1, f(Ep1.colorPrimary, context)) >= 3.0d ? -1 : -570425344;
    }

    public static float d(Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValue, true)) {
            return typedValue.getFloat();
        }
        return 0.5f;
    }

    public static int e(Context context) {
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(Ep1.isLightTheme, typedValue, true) && typedValue.data != 0 ? c(context) == -570425344 ? AbstractC0292Xp1.Theme_MediaRouter_Light : AbstractC0292Xp1.Theme_MediaRouter_Light_DarkControlPanel : c(context) == -570425344 ? AbstractC0292Xp1.Theme_MediaRouter_LightControlPanel : AbstractC0292Xp1.Theme_MediaRouter;
    }

    public static int f(int i, Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId != 0 ? context.getResources().getColor(typedValue.resourceId) : typedValue.data;
    }

    public static int g(int i, Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue.resourceId;
        }
        return 0;
    }
}
