package defpackage;

import com.google.android.gms.common.api.Batch;
import com.google.android.gms.common.api.BatchResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* JADX INFO: renamed from: Xy2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0297Xy2 implements PendingResult.StatusListener {
    public final /* synthetic */ Batch a;

    public C0297Xy2(Batch batch) {
        this.a = batch;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        synchronized (this.a.zai) {
            try {
                if (this.a.isCanceled()) {
                    return;
                }
                if (status.isCanceled()) {
                    this.a.zag = true;
                } else if (!status.isSuccess()) {
                    this.a.zaf = true;
                }
                Batch batch = this.a;
                batch.zae--;
                Batch batch2 = this.a;
                if (batch2.zae == 0) {
                    if (batch2.zag) {
                        super/*com.google.android.gms.common.api.internal.BasePendingResult*/.cancel();
                    } else {
                        Status status2 = batch2.zaf ? new Status(13) : Status.RESULT_SUCCESS;
                        Batch batch3 = this.a;
                        batch3.setResult(new BatchResult(status2, batch3.zah));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
