package defpackage;

import J.N;
import android.graphics.SurfaceTexture;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class tS1 implements SurfaceTexture.OnFrameAvailableListener {
    public final long a;

    public tS1(long j) {
        this.a = j;
    }

    public final void finalize() throws Throwable {
        try {
            N._V_JO(287, this.a, this);
        } finally {
            super.finalize();
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        N._V_JO(288, this.a, this);
    }
}
