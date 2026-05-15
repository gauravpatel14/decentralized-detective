package defpackage;

import android.os.Build;
import android.os.Looper;
import android.os.Parcel;
import android.os.WorkSource;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.location.zzd;
import com.google.android.gms.internal.location.zzdb;
import com.google.android.gms.internal.location.zzdd;
import com.google.android.gms.internal.location.zzdf;
import com.google.android.gms.location.LocationRequest;

/* JADX INFO: renamed from: nH2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1139nH2 extends GoogleApi {
    public static final Api a = new Api("LocationServices.API", new C0398bH2(), new Api.ClientKey());

    public final G62 a(final LocationRequest locationRequest, vI0 vi0, Looper looper) {
        if (looper == null) {
            looper = Looper.myLooper();
            Preconditions.checkNotNull(looper, "invalid null looper");
        }
        ListenerHolder listenerHolderCreateListenerHolder = ListenerHolders.createListenerHolder(vi0, looper, vI0.class.getSimpleName());
        final kH2 kh2 = new kH2(this, listenerHolderCreateListenerHolder, C0626fF2.a);
        return doRegisterEventListener(RegistrationMethods.builder().register(new RemoteCall() { // from class: nF2
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v1, types: [H62] */
            /* JADX WARN: Type inference failed for: r4v2 */
            /* JADX WARN: Type inference failed for: r4v3 */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws Throwable {
                BinderC0461cK2 binderC0461cK2;
                int i;
                int i2;
                int i3;
                UJ1 uj1;
                long j;
                long jMin;
                kH2 kh22 = kh2;
                LocationRequest locationRequest2 = locationRequest;
                UK2 uk2 = (UK2) obj;
                ?? r4 = (H62) obj2;
                Api api = C1139nH2.a;
                uk2.getClass();
                ListenerHolder listenerHolderA = kh22.a();
                ListenerHolder.ListenerKey listenerKey = listenerHolderA.getListenerKey();
                listenerKey.getClass();
                boolean zC = uk2.c(BY2.a);
                UJ1 uj12 = uk2.u;
                synchronized (uj12) {
                    try {
                        try {
                            BinderC0461cK2 binderC0461cK22 = (BinderC0461cK2) uk2.u.get(listenerKey);
                            if (binderC0461cK22 == null || zC) {
                                BinderC0461cK2 binderC0461cK23 = new BinderC0461cK2(kh22);
                                uk2.u.put(listenerKey, binderC0461cK23);
                                binderC0461cK2 = binderC0461cK23;
                            } else {
                                kH2 kh23 = binderC0461cK22.t;
                                synchronized (kh23) {
                                    ListenerHolder listenerHolder = kh23.b;
                                    if (listenerHolder != listenerHolderA) {
                                        listenerHolder.clear();
                                        kh23.b = listenerHolderA;
                                    }
                                }
                                binderC0461cK2 = binderC0461cK22;
                                binderC0461cK22 = null;
                            }
                            uk2.getContext();
                            String idString = listenerKey.toIdString();
                            if (zC) {
                                C0654fZ2 c0654fZ2 = (C0654fZ2) uk2.getService();
                                zzdb zzdbVar = new zzdb(2, binderC0461cK22 == null ? null : binderC0461cK22, binderC0461cK2, null, null, idString);
                                BinderC0767hJ2 binderC0767hJ2 = new BinderC0767hJ2(null, r4);
                                c0654fZ2.getClass();
                                Parcel parcelObtain = Parcel.obtain();
                                parcelObtain.writeInterfaceToken(c0654fZ2.u);
                                int i4 = WH2.a;
                                parcelObtain.writeInt(1);
                                zzdbVar.writeToParcel(parcelObtain, 0);
                                parcelObtain.writeInt(1);
                                locationRequest2.writeToParcel(parcelObtain, 0);
                                parcelObtain.writeStrongBinder(binderC0767hJ2.asBinder());
                                c0654fZ2.W0(88, parcelObtain);
                                uj1 = uj12;
                            } else {
                                C0654fZ2 c0654fZ22 = (C0654fZ2) uk2.getService();
                                int i5 = locationRequest2.t;
                                long j2 = locationRequest2.u;
                                long j3 = locationRequest2.v;
                                long j4 = locationRequest2.w;
                                long j5 = locationRequest2.x;
                                int i6 = locationRequest2.y;
                                float f = locationRequest2.z;
                                boolean z = locationRequest2.A;
                                long j6 = locationRequest2.B;
                                int i7 = locationRequest2.C;
                                int i8 = locationRequest2.D;
                                BinderC0461cK2 binderC0461cK24 = binderC0461cK2;
                                String str = locationRequest2.E;
                                boolean z2 = locationRequest2.F;
                                WorkSource workSource = locationRequest2.G;
                                zzd zzdVar = locationRequest2.H;
                                String str2 = Build.VERSION.SDK_INT < 30 ? null : str;
                                if (j3 == -1) {
                                    i = i7;
                                    i3 = i6;
                                    uj1 = uj12;
                                    j = j2;
                                    jMin = j;
                                    i2 = i5;
                                } else {
                                    i = i7;
                                    i2 = i5;
                                    if (i2 == 105) {
                                        i3 = i6;
                                        uj1 = uj12;
                                        jMin = j3;
                                        j = j2;
                                    } else {
                                        i3 = i6;
                                        uj1 = uj12;
                                        j = j2;
                                        jMin = Math.min(j3, j);
                                    }
                                }
                                zzdf zzdfVar = new zzdf(1, new zzdd(new LocationRequest(i2, j, jMin, Math.max(j4, j), Long.MAX_VALUE, j5, i3, f, z, j6 == -1 ? j : j6, i, i8, str2, z2, new WorkSource(workSource), zzdVar), null, false, false, null, false, false, null, Long.MAX_VALUE), null, binderC0461cK24, null, new BJ2(r4, binderC0461cK24), idString);
                                c0654fZ22.getClass();
                                Parcel parcelObtain2 = Parcel.obtain();
                                parcelObtain2.writeInterfaceToken(c0654fZ22.u);
                                int i9 = WH2.a;
                                parcelObtain2.writeInt(1);
                                zzdfVar.writeToParcel(parcelObtain2, 0);
                                c0654fZ22.W0(59, parcelObtain2);
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        r4 = uj12;
                        throw th;
                    }
                }
            }
        }).unregister(kh2).withHolder(listenerHolderCreateListenerHolder).setMethodKey(2436).build());
    }

    public final G62 b(final LocationRequest locationRequest, xI0 xi0) {
        Looper looperMyLooper = Looper.myLooper();
        Preconditions.checkNotNull(looperMyLooper, "invalid null looper");
        ListenerHolder listenerHolderCreateListenerHolder = ListenerHolders.createListenerHolder(xi0, looperMyLooper, xI0.class.getSimpleName());
        final kH2 kh2 = new kH2(this, listenerHolderCreateListenerHolder, C1260pG2.a);
        return doRegisterEventListener(RegistrationMethods.builder().register(new RemoteCall() { // from class: BG2
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws Throwable {
                BinderC1496tK2 binderC1496tK2;
                int i;
                UJ1 uj1;
                long j;
                long jMin;
                kH2 kh22 = kh2;
                LocationRequest locationRequest2 = locationRequest;
                UK2 uk2 = (UK2) obj;
                H62 h62 = (H62) obj2;
                Api api = C1139nH2.a;
                uk2.getClass();
                ListenerHolder listenerHolderA = kh22.a();
                ListenerHolder.ListenerKey listenerKey = listenerHolderA.getListenerKey();
                listenerKey.getClass();
                boolean zC = uk2.c(BY2.a);
                UJ1 uj12 = uk2.t;
                synchronized (uj12) {
                    try {
                        try {
                            BinderC1496tK2 binderC1496tK22 = (BinderC1496tK2) uk2.t.get(listenerKey);
                            if (binderC1496tK22 == null || zC) {
                                BinderC1496tK2 binderC1496tK23 = new BinderC1496tK2(kh22);
                                uk2.t.put(listenerKey, binderC1496tK23);
                                binderC1496tK2 = binderC1496tK23;
                            } else {
                                kH2 kh23 = binderC1496tK22.t;
                                synchronized (kh23) {
                                    ListenerHolder listenerHolder = kh23.b;
                                    if (listenerHolder != listenerHolderA) {
                                        listenerHolder.clear();
                                        kh23.b = listenerHolderA;
                                    }
                                }
                                binderC1496tK2 = binderC1496tK22;
                                binderC1496tK22 = null;
                            }
                            uk2.getContext();
                            String idString = listenerKey.toIdString();
                            if (zC) {
                                C0654fZ2 c0654fZ2 = (C0654fZ2) uk2.getService();
                                zzdb zzdbVar = new zzdb(1, binderC1496tK22 == null ? null : binderC1496tK22, binderC1496tK2, null, null, idString);
                                BinderC0767hJ2 binderC0767hJ2 = new BinderC0767hJ2(null, h62);
                                c0654fZ2.getClass();
                                Parcel parcelObtain = Parcel.obtain();
                                parcelObtain.writeInterfaceToken(c0654fZ2.u);
                                int i2 = WH2.a;
                                parcelObtain.writeInt(1);
                                zzdbVar.writeToParcel(parcelObtain, 0);
                                parcelObtain.writeInt(1);
                                locationRequest2.writeToParcel(parcelObtain, 0);
                                parcelObtain.writeStrongBinder(binderC0767hJ2.asBinder());
                                c0654fZ2.W0(88, parcelObtain);
                                uj1 = uj12;
                            } else {
                                C0654fZ2 c0654fZ22 = (C0654fZ2) uk2.getService();
                                int i3 = locationRequest2.t;
                                long j2 = locationRequest2.u;
                                long j3 = locationRequest2.v;
                                long j4 = locationRequest2.w;
                                long j5 = locationRequest2.x;
                                int i4 = locationRequest2.y;
                                float f = locationRequest2.z;
                                boolean z = locationRequest2.A;
                                long j6 = locationRequest2.B;
                                int i5 = locationRequest2.C;
                                BinderC1496tK2 binderC1496tK24 = binderC1496tK2;
                                int i6 = locationRequest2.D;
                                String str = locationRequest2.E;
                                boolean z2 = locationRequest2.F;
                                WorkSource workSource = locationRequest2.G;
                                zzd zzdVar = locationRequest2.H;
                                String str2 = Build.VERSION.SDK_INT < 30 ? null : str;
                                if (j3 == -1) {
                                    i = i4;
                                    uj1 = uj12;
                                    j = j2;
                                    jMin = j;
                                } else if (i3 == 105) {
                                    jMin = j3;
                                    i = i4;
                                    uj1 = uj12;
                                    j = j2;
                                } else {
                                    i = i4;
                                    uj1 = uj12;
                                    j = j2;
                                    jMin = Math.min(j3, j);
                                }
                                zzdf zzdfVar = new zzdf(1, new zzdd(new LocationRequest(i3, j, jMin, Math.max(j4, j), Long.MAX_VALUE, j5, i, f, z, j6 == -1 ? j : j6, i5, i6, str2, z2, new WorkSource(workSource), zzdVar), null, false, false, null, false, false, null, Long.MAX_VALUE), binderC1496tK24, null, null, new BinderC1723xJ2(h62, binderC1496tK24), idString);
                                c0654fZ22.getClass();
                                Parcel parcelObtain2 = Parcel.obtain();
                                parcelObtain2.writeInterfaceToken(c0654fZ22.u);
                                int i7 = WH2.a;
                                parcelObtain2.writeInt(1);
                                zzdfVar.writeToParcel(parcelObtain2, 0);
                                c0654fZ22.W0(59, parcelObtain2);
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        obj2 = uj12;
                        throw th;
                    }
                }
            }
        }).unregister(kh2).withHolder(listenerHolderCreateListenerHolder).setMethodKey(2435).build());
    }
}
