package defpackage;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class O23 implements JO2 {
    public final /* synthetic */ IB2 a;
    public final /* synthetic */ Intent b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ C1189o33 d;

    public O23(C1189o33 c1189o33, IB2 ib2, Intent intent, Context context) {
        this.d = c1189o33;
        this.a = ib2;
        this.b = intent;
        this.c = context;
    }

    @Override // defpackage.JO2
    public final void a(int i) {
        IB2 ib2 = this.a;
        C1189o33 c1189o33 = this.d;
        c1189o33.g.post(new RunnableC0330a33(c1189o33, ib2, 6, i));
    }

    @Override // defpackage.JO2
    public final void zza() {
        IB2 ib2 = this.a;
        C1189o33 c1189o33 = this.d;
        c1189o33.g.post(new RunnableC0330a33(c1189o33, ib2, 5, 0));
    }

    @Override // defpackage.JO2
    public final void zzc() {
        Intent intent = this.b;
        if (intent.getBooleanExtra("triggered_from_app_after_verification", false)) {
            this.d.a.a("Splits copied and verified more than once.", new Object[0]);
        } else {
            intent.putExtra("triggered_from_app_after_verification", true);
            this.c.sendBroadcast(intent);
        }
    }
}
