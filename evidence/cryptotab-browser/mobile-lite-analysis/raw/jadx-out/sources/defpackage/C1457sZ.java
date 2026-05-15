package defpackage;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.WindowInsets;

/* JADX INFO: renamed from: sZ, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1457sZ {
    public final Activity a;
    public final /* synthetic */ int b;

    public C1457sZ(Activity activity, int i) {
        this.b = i;
        this.a = activity;
    }

    public DisplayMetrics a() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Activity activity = this.a;
        if (activity.isInMultiWindowMode()) {
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        } else {
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public final int b() {
        switch (this.b) {
            case 0:
                Activity activity = this.a;
                int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
                if (identifier > 0) {
                    return activity.getResources().getDimensionPixelSize(identifier);
                }
                return 0;
            default:
                return this.a.getWindowManager().getCurrentWindowMetrics().getWindowInsets().getInsets(WindowInsets.Type.statusBars()).top;
        }
    }

    public final int c() {
        switch (this.b) {
            case 0:
                return a().heightPixels;
            default:
                return this.a.getWindowManager().getCurrentWindowMetrics().getBounds().height();
        }
    }
}
