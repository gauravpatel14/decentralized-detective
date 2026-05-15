package defpackage;

import android.graphics.Point;
import android.view.Display;

/* JADX INFO: renamed from: r00, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1360r00 {
    public final Point a;
    public final boolean b;

    public C1360r00(Point point) {
        this.b = true;
        this.a = point;
    }

    public C1360r00(Display.Mode mode, boolean z) {
        if (mode != null) {
            this.b = z;
            this.a = new Point(mode.getPhysicalWidth(), mode.getPhysicalHeight());
            return;
        }
        throw new NullPointerException("Display.Mode == null, can't wrap a null reference");
    }
}
