package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.SeekBar;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;
import com.google.android.gms.common.util.PlatformVersion;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Gy extends View.AccessibilityDelegate {
    public final /* synthetic */ CastSeekBar a;

    public Gy(CastSeekBar castSeekBar) {
        this.a = castSeekBar;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(SeekBar.class.getName());
        CastSeekBar castSeekBar = this.a;
        accessibilityEvent.setItemCount(castSeekBar.t.a);
        castSeekBar.t.getClass();
        accessibilityEvent.setCurrentItemIndex(0);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(SeekBar.class.getName());
        if (PlatformVersion.isAtLeastJellyBean() && view.isEnabled()) {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (!view.isEnabled()) {
            return false;
        }
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        if (PlatformVersion.isAtLeastJellyBean() && (i == 4096 || i == 8192)) {
            int i2 = CastSeekBar.C;
            CastSeekBar castSeekBar = this.a;
            castSeekBar.getClass();
            Fy fy = castSeekBar.t;
            int i3 = fy.a;
            fy.getClass();
            castSeekBar.t.getClass();
        }
        return false;
    }
}
