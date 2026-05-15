package defpackage;

import android.os.Parcel;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.cast.zzcj;
import com.google.android.gms.internal.cast.zzdb;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class WJ2 extends AbstractBinderC1598vB2 {
    public final AtomicReference t;
    public final HandlerC0957kO2 u;

    public WJ2(OJ2 oj2) {
        super("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        this.t = new AtomicReference(oj2);
        this.u = new HandlerC0957kO2(oj2.getLooper());
    }

    @Override // defpackage.AbstractBinderC1598vB2
    public final boolean W0(int i, Parcel parcel, Parcel parcel2) {
        OJ2 oj2 = null;
        switch (i) {
            case 1:
                int i2 = parcel.readInt();
                OJ2 oj22 = (OJ2) this.t.getAndSet(null);
                if (oj22 != null) {
                    oj22.E = false;
                    oj22.H = -1;
                    oj22.I = -1;
                    oj22.t = null;
                    oj22.A = null;
                    oj22.F = 0.0d;
                    oj22.l();
                    oj22.B = false;
                    oj22.G = null;
                    oj2 = oj22;
                }
                if (oj2 != null) {
                    OJ2.Q.getClass();
                    if (i2 != 0) {
                        oj2.triggerConnectionSuspended(2);
                    }
                }
                return true;
            case 2:
                ApplicationMetadata applicationMetadata = (ApplicationMetadata) QK2.a(parcel, ApplicationMetadata.CREATOR);
                String string = parcel.readString();
                String string2 = parcel.readString();
                boolean z = parcel.readInt() != 0;
                OJ2 oj23 = (OJ2) this.t.get();
                if (oj23 != null) {
                    oj23.t = applicationMetadata;
                    oj23.K = applicationMetadata.t;
                    oj23.L = string2;
                    oj23.A = string;
                    synchronized (OJ2.R) {
                        try {
                            yy yyVar = oj23.O;
                            if (yyVar != null) {
                                yyVar.setResult((Object) new C0401bK2(new Status(0), applicationMetadata, string, string2, z));
                                oj23.O = null;
                            }
                        } finally {
                        }
                        break;
                    }
                }
                return true;
            case 3:
                int i3 = parcel.readInt();
                OJ2 oj24 = (OJ2) this.t.get();
                if (oj24 != null) {
                    oj24.m(i3);
                }
                return true;
            case 4:
                parcel.readString();
                parcel.readDouble();
                int i4 = QK2.a;
                parcel.readInt();
                OJ2.Q.getClass();
                return true;
            case 5:
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                OJ2 oj25 = (OJ2) this.t.get();
                if (oj25 != null) {
                    OJ2.Q.getClass();
                    this.u.post(new sK2(oj25, string3, string4));
                }
                return true;
            case 6:
                parcel.readString();
                byte[] bArrCreateByteArray = parcel.createByteArray();
                if (((OJ2) this.t.get()) != null) {
                    YL2 yl2 = OJ2.Q;
                    int length = bArrCreateByteArray.length;
                    yl2.getClass();
                }
                return true;
            case 7:
                int i5 = parcel.readInt();
                OJ2 oj26 = (OJ2) this.t.get();
                if (oj26 != null) {
                    oj26.n(i5);
                }
                return true;
            case 8:
                int i6 = parcel.readInt();
                OJ2 oj27 = (OJ2) this.t.get();
                if (oj27 != null) {
                    oj27.n(i6);
                }
                return true;
            case ConnectionResult.SERVICE_INVALID /* 9 */:
                int i7 = parcel.readInt();
                OJ2 oj28 = (OJ2) this.t.get();
                if (oj28 != null) {
                    oj28.K = null;
                    oj28.L = null;
                    oj28.n(i7);
                    if (oj28.v != null) {
                        this.u.post(new RunnableC1378rK2(oj28, i7));
                    }
                }
                return true;
            case 10:
                parcel.readString();
                long j = parcel.readLong();
                int i8 = parcel.readInt();
                OJ2 oj29 = (OJ2) this.t.get();
                if (oj29 != null) {
                    oj29.i(i8, j);
                }
                return true;
            case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                parcel.readString();
                long j2 = parcel.readLong();
                OJ2 oj210 = (OJ2) this.t.get();
                if (oj210 != null) {
                    oj210.i(0, j2);
                }
                return true;
            case 12:
                zzcj zzcjVar = (zzcj) QK2.a(parcel, zzcj.CREATOR);
                OJ2 oj211 = (OJ2) this.t.get();
                if (oj211 != null) {
                    OJ2.Q.getClass();
                    this.u.post(new TK2(oj211, zzcjVar));
                }
                return true;
            case 13:
                zzdb zzdbVar = (zzdb) QK2.a(parcel, zzdb.CREATOR);
                OJ2 oj212 = (OJ2) this.t.get();
                if (oj212 != null) {
                    OJ2.Q.getClass();
                    this.u.post(new RunnableC0768hK2(oj212, zzdbVar));
                }
                return true;
            default:
                return false;
        }
    }
}
