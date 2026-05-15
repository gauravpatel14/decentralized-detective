package defpackage;

import J.N;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.view.ViewConfiguration;
import org.chromium.ui.gfx.ViewConfigurationHelper;

/* JADX INFO: renamed from: ho2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ComponentCallbacksC0804ho2 implements ComponentCallbacks {
    public final /* synthetic */ ViewConfigurationHelper t;

    public ComponentCallbacksC0804ho2(ViewConfigurationHelper viewConfigurationHelper) {
        this.t = viewConfigurationHelper;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        ViewConfigurationHelper viewConfigurationHelper = this.t;
        viewConfigurationHelper.getClass();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(AbstractC1499tM.a);
        if (viewConfigurationHelper.a == viewConfiguration) {
            return;
        }
        viewConfigurationHelper.a = viewConfiguration;
        viewConfigurationHelper.b = AbstractC1499tM.a.getResources().getDisplayMetrics().density;
        N._V_FFFFFO(0, viewConfigurationHelper.getMaximumFlingVelocity(), viewConfigurationHelper.getMinimumFlingVelocity(), viewConfigurationHelper.getTouchSlop(), viewConfigurationHelper.getDoubleTapSlop(), viewConfigurationHelper.getMinScalingSpan(), viewConfigurationHelper);
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }
}
