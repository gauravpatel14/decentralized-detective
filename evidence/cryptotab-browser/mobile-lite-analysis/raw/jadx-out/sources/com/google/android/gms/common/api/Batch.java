package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import defpackage.C0297Xy2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Batch extends BasePendingResult {
    private int zae;
    private boolean zaf;
    private boolean zag;
    private final PendingResult[] zah;
    private final Object zai;

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public final class Builder {
        private final List zaa = new ArrayList();
        private final GoogleApiClient zab;

        public Builder(GoogleApiClient googleApiClient) {
            this.zab = googleApiClient;
        }

        @ResultIgnorabilityUnspecified
        public BatchResultToken add(PendingResult pendingResult) {
            BatchResultToken batchResultToken = new BatchResultToken(this.zaa.size());
            this.zaa.add(pendingResult);
            return batchResultToken;
        }

        public Batch build() {
            return new Batch(this.zaa, this.zab, null);
        }
    }

    public /* synthetic */ Batch(List list, GoogleApiClient googleApiClient, zac zacVar) {
        super(googleApiClient);
        this.zai = new Object();
        int size = list.size();
        this.zae = size;
        PendingResult[] pendingResultArr = new PendingResult[size];
        this.zah = pendingResultArr;
        if (list.isEmpty()) {
            setResult(new BatchResult(Status.RESULT_SUCCESS, pendingResultArr));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            PendingResult pendingResult = (PendingResult) list.get(i);
            this.zah[i] = pendingResult;
            pendingResult.addStatusListener(new C0297Xy2(this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult, com.google.android.gms.common.api.PendingResult
    public void cancel() {
        super.cancel();
        int i = 0;
        while (true) {
            PendingResult[] pendingResultArr = this.zah;
            if (i >= pendingResultArr.length) {
                return;
            }
            pendingResultArr[i].cancel();
            i++;
        }
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public BatchResult createFailedResult(Status status) {
        return new BatchResult(status, this.zah);
    }
}
