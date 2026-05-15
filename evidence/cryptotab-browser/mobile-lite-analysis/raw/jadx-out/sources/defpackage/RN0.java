package defpackage;

import android.util.Log;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RN0 implements ResultCallback {
    public final /* synthetic */ int a;
    public final /* synthetic */ UN0 b;

    public /* synthetic */ RN0(UN0 un0, int i) {
        this.a = i;
        this.b = un0;
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void onResult(Result result) {
        switch (this.a) {
            case 0:
                Status status = ((It1) result).getStatus();
                int statusCode = status.getStatusCode();
                UN0 un0 = this.b;
                if (statusCode != 0) {
                    YL2 yl2 = un0.a;
                    Log.w(yl2.a, yl2.b("Error fetching queue items, statusCode=" + statusCode + ", statusMessage=" + status.getStatusMessage(), new Object[0]));
                }
                un0.l = null;
                if (!un0.i.isEmpty()) {
                    C1279pW2 c1279pW2 = un0.k;
                    HandlerC0957kO2 handlerC0957kO2 = un0.j;
                    handlerC0957kO2.removeCallbacks(c1279pW2);
                    handlerC0957kO2.postDelayed(un0.k, 500L);
                }
                break;
            default:
                Status status2 = ((It1) result).getStatus();
                int statusCode2 = status2.getStatusCode();
                UN0 un02 = this.b;
                if (statusCode2 != 0) {
                    YL2 yl22 = un02.a;
                    Log.w(yl22.a, yl22.b("Error fetching queue item ids, statusCode=" + statusCode2 + ", statusMessage=" + status2.getStatusMessage(), new Object[0]));
                }
                un02.m = null;
                if (!un02.i.isEmpty()) {
                    C1279pW2 c1279pW22 = un02.k;
                    HandlerC0957kO2 handlerC0957kO22 = un02.j;
                    handlerC0957kO22.removeCallbacks(c1279pW22);
                    handlerC0957kO22.postDelayed(un02.k, 500L);
                }
                break;
        }
    }
}
