package defpackage;

import J.N;
import android.os.Handler;
import android.os.Looper;
import android.view.AttachedSurfaceControl;
import android.view.AttachedSurfaceControl$OnBufferTransformHintChangedListener;
import android.view.FrameMetrics;
import android.view.Window;
import java.lang.ref.WeakReference;
import org.chromium.ui.base.WindowAndroid;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class n61 implements AttachedSurfaceControl$OnBufferTransformHintChangedListener, Window.OnFrameMetricsAvailableListener {
    public final WindowAndroid a;
    public final WeakReference b;
    public boolean c;
    public boolean d;

    public n61(WindowAndroid windowAndroid) {
        Window window;
        AttachedSurfaceControl rootSurfaceControl;
        Window window2;
        this.a = windowAndroid;
        WeakReference weakReference = new WeakReference(windowAndroid.q());
        this.b = weakReference;
        Window window3 = (Window) weakReference.get();
        if (window3 == null) {
            return;
        }
        if (window3.getRootSurfaceControl() == null) {
            if (this.d || (window2 = (Window) weakReference.get()) == null) {
                return;
            }
            window2.addOnFrameMetricsAvailableListener(this, new Handler(Looper.myLooper()));
            this.d = true;
            return;
        }
        if (this.c || (window = (Window) weakReference.get()) == null || (rootSurfaceControl = window.getRootSurfaceControl()) == null) {
            return;
        }
        rootSurfaceControl.addOnBufferTransformHintChangedListener(this);
        this.c = true;
    }

    public final void onBufferTransformHintChanged(int i) {
        WindowAndroid windowAndroid = this.a;
        long j = windowAndroid.w;
        if (j != 0) {
            N._V_JO(286, j, windowAndroid);
        }
    }

    @Override // android.view.Window.OnFrameMetricsAvailableListener
    public final void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
        Window window2;
        AttachedSurfaceControl rootSurfaceControl;
        Window window3;
        if (window.getRootSurfaceControl() != null) {
            if (this.d && (window3 = (Window) this.b.get()) != null) {
                window3.removeOnFrameMetricsAvailableListener(this);
                this.d = false;
            }
            if (this.c || (window2 = (Window) this.b.get()) == null || (rootSurfaceControl = window2.getRootSurfaceControl()) == null) {
                return;
            }
            rootSurfaceControl.addOnBufferTransformHintChangedListener(this);
            this.c = true;
        }
    }
}
