package defpackage;

import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.api.internal.GoogleApiManager;

/* JADX INFO: renamed from: lz2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1058lz2 implements BackgroundDetector.BackgroundStateChangeListener {
    public final /* synthetic */ GoogleApiManager a;

    public C1058lz2(GoogleApiManager googleApiManager) {
        this.a = googleApiManager;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void onBackgroundStateChanged(boolean z) {
        GoogleApiManager googleApiManager = this.a;
        googleApiManager.zar.sendMessage(googleApiManager.zar.obtainMessage(1, Boolean.valueOf(z)));
    }
}
