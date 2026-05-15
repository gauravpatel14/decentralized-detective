package defpackage;

import android.os.Parcel;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.internal.location.zzdb;
import com.google.android.gms.internal.location.zzdf;

/* JADX INFO: renamed from: pG2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1260pG2 implements InterfaceC0696gH2 {
    public static final /* synthetic */ C1260pG2 a = new C1260pG2();

    @Override // defpackage.InterfaceC0696gH2
    public final void a(UK2 uk2, ListenerHolder.ListenerKey listenerKey, boolean z, H62 h62) {
        synchronized (uk2.t) {
            try {
                BinderC1496tK2 binderC1496tK2 = (BinderC1496tK2) uk2.t.remove(listenerKey);
                if (binderC1496tK2 == null) {
                    h62.b(Boolean.FALSE);
                    return;
                }
                binderC1496tK2.t.a().clear();
                if (!z) {
                    h62.b(Boolean.TRUE);
                } else if (uk2.c(BY2.a)) {
                    C0654fZ2 c0654fZ2 = (C0654fZ2) uk2.getService();
                    zzdb zzdbVar = new zzdb(1, null, binderC1496tK2, null, null, null);
                    BinderC0767hJ2 binderC0767hJ2 = new BinderC0767hJ2(Boolean.TRUE, h62);
                    c0654fZ2.getClass();
                    Parcel parcelObtain = Parcel.obtain();
                    parcelObtain.writeInterfaceToken(c0654fZ2.u);
                    int i = WH2.a;
                    parcelObtain.writeInt(1);
                    zzdbVar.writeToParcel(parcelObtain, 0);
                    parcelObtain.writeStrongBinder(binderC0767hJ2.asBinder());
                    c0654fZ2.W0(89, parcelObtain);
                } else {
                    C0654fZ2 c0654fZ22 = (C0654fZ2) uk2.getService();
                    zzdf zzdfVar = new zzdf(2, null, binderC1496tK2, null, null, new BinderC1377rJ2(h62), null);
                    c0654fZ22.getClass();
                    Parcel parcelObtain2 = Parcel.obtain();
                    parcelObtain2.writeInterfaceToken(c0654fZ22.u);
                    int i2 = WH2.a;
                    parcelObtain2.writeInt(1);
                    zzdfVar.writeToParcel(parcelObtain2, 0);
                    c0654fZ22.W0(59, parcelObtain2);
                }
            } finally {
            }
        }
    }
}
