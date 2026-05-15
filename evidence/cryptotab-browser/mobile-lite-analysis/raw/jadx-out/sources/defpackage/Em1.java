package defpackage;

import org.chromium.base.Callback;
import org.chromium.base.Promise$UnhandledRejectionException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Em1 implements Callback {
    @Override // org.chromium.base.Callback
    /* JADX INFO: renamed from: onResult */
    public final void a0(Object obj) {
        throw new Promise$UnhandledRejectionException("Promise was rejected without a rejection handler.", (Exception) obj);
    }
}
