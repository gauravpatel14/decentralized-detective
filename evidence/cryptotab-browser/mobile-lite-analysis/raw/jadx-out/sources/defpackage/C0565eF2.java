package defpackage;

import android.util.Log;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

/* JADX INFO: renamed from: eF2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0565eF2 implements BM2 {
    public final /* synthetic */ Lt1 a;

    public C0565eF2(Lt1 lt1) {
        this.a = lt1;
    }

    @Override // defpackage.BM2
    public final void a(long j) {
        try {
            Lt1 lt1 = this.a;
            Status status = new Status(2103);
            lt1.getClass();
            lt1.setResult((Result) new C0826iF2(status));
        } catch (IllegalStateException e) {
            Log.e("RemoteMediaClient", "Result already set when calling onRequestReplaced", e);
        }
    }

    @Override // defpackage.BM2
    public final void b(long j, int i, JSONObject jSONObject) {
        try {
            this.a.setResult((Result) new Mt1(new Status(i)));
        } catch (IllegalStateException e) {
            Log.e("RemoteMediaClient", "Result already set when calling onRequestCompleted", e);
        }
    }
}
