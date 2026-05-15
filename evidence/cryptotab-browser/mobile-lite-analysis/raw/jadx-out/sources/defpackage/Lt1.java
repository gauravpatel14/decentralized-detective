package defpackage;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.cast.zzds;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Lt1 extends AbstractC0698gJ2 {
    public final C0565eF2 a;
    public final boolean b;
    public final /* synthetic */ Nt1 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Lt1(Nt1 nt1, GoogleApiClient googleApiClient, boolean z) {
        super(googleApiClient);
        this.c = nt1;
        this.b = z;
        this.a = new C0565eF2(this);
    }

    public abstract void b();

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new C0826iF2(status);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        if (!this.b) {
            Iterator it = this.c.g.iterator();
            while (it.hasNext()) {
                ((C1256pD2) it.next()).getClass();
            }
            Iterator it2 = this.c.h.iterator();
            while (it2.hasNext()) {
                ((Ht1) it2.next()).getClass();
            }
        }
        try {
            synchronized (this.c.a) {
                b();
            }
        } catch (zzds unused) {
            setResult((Result) new C0826iF2(new Status(2100)));
        }
    }
}
