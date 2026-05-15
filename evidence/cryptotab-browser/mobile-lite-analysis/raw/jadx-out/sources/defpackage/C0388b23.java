package defpackage;

import android.os.Bundle;

/* JADX INFO: renamed from: b23, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0388b23 extends AbstractC0999l13 {
    @Override // defpackage.AbstractC0999l13
    public final void a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        this.b.b(bundle2);
    }

    @Override // defpackage.AbstractC0999l13
    public final boolean b() {
        return false;
    }
}
