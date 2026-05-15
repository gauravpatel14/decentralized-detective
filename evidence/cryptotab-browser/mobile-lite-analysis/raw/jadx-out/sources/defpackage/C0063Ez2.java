package defpackage;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;

/* JADX INFO: renamed from: Ez2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0063Ez2 extends TaskApiCall {
    public final /* synthetic */ TaskApiCall.Builder a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0063Ez2(TaskApiCall.Builder builder, Feature[] featureArr, boolean z, int i) {
        super(featureArr, z, i);
        this.a = builder;
    }

    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final void doExecute(Api.AnyClient anyClient, H62 h62) {
        this.a.zaa.accept(anyClient, h62);
    }
}
