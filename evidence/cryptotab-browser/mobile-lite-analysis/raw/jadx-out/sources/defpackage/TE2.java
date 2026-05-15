package defpackage;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class TE2 implements ResultCallback {
    public final long a;
    public final /* synthetic */ Jt1 b;

    public TE2(Jt1 jt1, long j) {
        this.b = jt1;
        this.a = j;
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void onResult(Result result) {
        Status status = (Status) result;
        if (status.isSuccess()) {
            return;
        }
        UL2 ul2 = this.b.c.c;
        int statusCode = status.getStatusCode();
        Iterator it = ul2.c.iterator();
        while (it.hasNext()) {
            ((C1501tM2) it.next()).e(this.a, statusCode, null);
        }
    }
}
