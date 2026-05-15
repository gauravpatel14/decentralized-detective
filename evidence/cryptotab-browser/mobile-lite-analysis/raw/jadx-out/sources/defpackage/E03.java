package defpackage;

import android.os.Bundle;
import com.google.android.play.core.install.InstallException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class E03 extends PZ2 {
    @Override // defpackage.PZ2, defpackage.InterfaceC1509tS2
    public final void zzb(Bundle bundle) {
        super.zzb(bundle);
        int i = bundle.getInt("error.code", -2);
        H62 h62 = this.u;
        if (i != 0) {
            h62.c(new InstallException(bundle.getInt("error.code", -2)));
        } else {
            h62.d(null);
        }
    }
}
