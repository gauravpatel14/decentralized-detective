package defpackage;

import org.chromium.mojo.system.impl.CoreImpl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Sm extends Ly0 {
    @Override // defpackage.Ly0
    public final Ky0 c(CoreImpl coreImpl, C0491ci c0491ci) {
        return new Ym(coreImpl, c0491ci);
    }

    @Override // defpackage.Ly0
    public final My0 d(CoreImpl coreImpl, Ny0 ny0) {
        return new Zm(coreImpl, (Qm) ny0);
    }

    @Override // defpackage.Ly0
    public final String e() {
        return "shape_detection.mojom.BarcodeDetectionProvider";
    }
}
