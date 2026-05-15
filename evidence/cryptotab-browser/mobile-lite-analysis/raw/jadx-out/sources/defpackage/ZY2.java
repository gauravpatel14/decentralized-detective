package defpackage;

import android.os.Bundle;
import com.google.android.gms.cloudmessaging.zzp;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ZY2 extends AbstractC0999l13 {
    @Override // defpackage.AbstractC0999l13
    public final void a(Bundle bundle) {
        boolean z = bundle.getBoolean("ack", false);
        H62 h62 = this.b;
        if (z) {
            h62.b(null);
        } else {
            h62.a(new zzp("Invalid response to one way request"));
        }
    }

    @Override // defpackage.AbstractC0999l13
    public final boolean b() {
        return true;
    }
}
