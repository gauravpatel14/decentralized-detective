package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class g33 extends dP0 {
    public static final YL2 b = new YL2("MediaRouterCallback");
    public final C1569uX2 a;

    public g33(C1569uX2 c1569uX2) {
        this.a = (C1569uX2) Preconditions.checkNotNull(c1569uX2);
    }

    @Override // defpackage.dP0
    public final void d(C0838iP0 c0838iP0) {
        try {
            C1569uX2 c1569uX2 = this.a;
            String str = c0838iP0.c;
            Bundle bundle = c0838iP0.s;
            Parcel parcelW0 = c1569uX2.W0();
            parcelW0.writeString(str);
            QK2.c(parcelW0, bundle);
            c1569uX2.Y0(1, parcelW0);
        } catch (RemoteException unused) {
            b.getClass();
        }
    }

    @Override // defpackage.dP0
    public final void e(C1087mP0 c1087mP0, C0838iP0 c0838iP0) {
        try {
            C1569uX2 c1569uX2 = this.a;
            String str = c0838iP0.c;
            Bundle bundle = c0838iP0.s;
            Parcel parcelW0 = c1569uX2.W0();
            parcelW0.writeString(str);
            QK2.c(parcelW0, bundle);
            c1569uX2.Y0(2, parcelW0);
        } catch (RemoteException unused) {
            b.getClass();
        }
    }

    @Override // defpackage.dP0
    public final void f(C0838iP0 c0838iP0) {
        try {
            C1569uX2 c1569uX2 = this.a;
            String str = c0838iP0.c;
            Bundle bundle = c0838iP0.s;
            Parcel parcelW0 = c1569uX2.W0();
            parcelW0.writeString(str);
            QK2.c(parcelW0, bundle);
            c1569uX2.Y0(3, parcelW0);
        } catch (RemoteException unused) {
            b.getClass();
        }
    }

    @Override // defpackage.dP0
    public final void g(C0838iP0 c0838iP0) {
        try {
            C1569uX2 c1569uX2 = this.a;
            String str = c0838iP0.c;
            Bundle bundle = c0838iP0.s;
            Parcel parcelW0 = c1569uX2.W0();
            parcelW0.writeString(str);
            QK2.c(parcelW0, bundle);
            c1569uX2.Y0(4, parcelW0);
        } catch (RemoteException unused) {
            b.getClass();
        }
    }

    @Override // defpackage.dP0
    public final void i(C1087mP0 c1087mP0, C0838iP0 c0838iP0, int i) {
        try {
            C1569uX2 c1569uX2 = this.a;
            String str = c0838iP0.c;
            Bundle bundle = c0838iP0.s;
            Parcel parcelW0 = c1569uX2.W0();
            parcelW0.writeString(str);
            QK2.c(parcelW0, bundle);
            parcelW0.writeInt(i);
            c1569uX2.Y0(6, parcelW0);
        } catch (RemoteException unused) {
            b.getClass();
        }
    }
}
