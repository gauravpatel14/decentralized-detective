package defpackage;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.vision.zzs;
import com.google.android.gms.vision.face.internal.client.FaceParcel;
import com.google.android.gms.vision.face.internal.client.LandmarkParcel;
import com.google.android.gms.vision.face.internal.client.zza;
import com.google.android.gms.vision.face.internal.client.zzf;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class DF2 extends AbstractC1651w23 {
    public final zzf i;

    public DF2(Context context, zzf zzfVar) {
        super(context, "FaceNativeHandle", "face");
        this.i = zzfVar;
        e();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001c  */
    @Override // defpackage.AbstractC1651w23
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(defpackage.m50 r5, android.content.Context r6) throws com.google.android.gms.dynamite.DynamiteModule$LoadingException {
        /*
            r4 = this;
            java.lang.String r0 = "com.google.android.gms.vision.dynamite.face"
            int r0 = defpackage.m50.a(r6, r0)
            java.lang.String r1 = "com.google.android.gms.vision.dynamite"
            r2 = 0
            int r1 = defpackage.m50.d(r6, r1, r2)
            java.lang.String r2 = "com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator"
            r3 = 0
            if (r0 <= r1) goto L2f
            java.lang.String r0 = "com.google.android.gms.vision.face.NativeFaceDetectorV2Creator"
            android.os.IBinder r5 = r5.b(r0)
            int r0 = defpackage.AbstractBinderC1097mX2.t
            if (r5 != 0) goto L1e
        L1c:
            r0 = r3
            goto L4a
        L1e:
            android.os.IInterface r0 = r5.queryLocalInterface(r2)
            boolean r1 = r0 instanceof defpackage.RT2
            if (r1 == 0) goto L29
            RT2 r0 = (defpackage.RT2) r0
            goto L4a
        L29:
            iW2 r0 = new iW2
            r0.<init>(r5, r2)
            goto L4a
        L2f:
            java.lang.String r0 = "com.google.android.gms.vision.face.ChimeraNativeFaceDetectorCreator"
            android.os.IBinder r5 = r5.b(r0)
            int r0 = defpackage.AbstractBinderC1097mX2.t
            if (r5 != 0) goto L3a
            goto L1c
        L3a:
            android.os.IInterface r0 = r5.queryLocalInterface(r2)
            boolean r1 = r0 instanceof defpackage.RT2
            if (r1 == 0) goto L45
            RT2 r0 = (defpackage.RT2) r0
            goto L4a
        L45:
            iW2 r0 = new iW2
            r0.<init>(r5, r2)
        L4a:
            if (r0 != 0) goto L4d
            return r3
        L4d:
            com.google.android.gms.dynamic.ObjectWrapper r5 = new com.google.android.gms.dynamic.ObjectWrapper
            r5.<init>(r6)
            com.google.android.gms.vision.face.internal.client.zzf r6 = r4.i
            java.lang.Object r6 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)
            com.google.android.gms.vision.face.internal.client.zzf r6 = (com.google.android.gms.vision.face.internal.client.zzf) r6
            iW2 r0 = (defpackage.C0846iW2) r0
            android.os.Parcel r1 = r0.W0()
            defpackage.AbstractC1777yK2.a(r1, r5)
            defpackage.AbstractC1777yK2.b(r1, r6)
            r5 = 1
            android.os.Parcel r5 = r0.X0(r5, r1)
            android.os.IBinder r6 = r5.readStrongBinder()
            if (r6 != 0) goto L72
            goto L85
        L72:
            java.lang.String r0 = "com.google.android.gms.vision.face.internal.client.INativeFaceDetector"
            android.os.IInterface r1 = r6.queryLocalInterface(r0)
            boolean r2 = r1 instanceof defpackage.C0713gV2
            if (r2 == 0) goto L80
            r3 = r1
            gV2 r3 = (defpackage.C0713gV2) r3
            goto L85
        L80:
            gV2 r3 = new gV2
            r3.<init>(r6, r0)
        L85:
            r5.recycle()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.DF2.a(m50, android.content.Context):java.lang.Object");
    }

    @Override // defpackage.AbstractC1651w23
    public final void b() {
        C0713gV2 c0713gV2 = (C0713gV2) Preconditions.checkNotNull((C0713gV2) e());
        c0713gV2.Y0(3, c0713gV2.W0());
    }

    public final O90[] f(ByteBuffer byteBuffer, zzs zzsVar) {
        TC0[] tc0Arr;
        CN[] cnArr;
        if (!c()) {
            return new O90[0];
        }
        try {
            ObjectWrapper objectWrapper = new ObjectWrapper(byteBuffer);
            C0713gV2 c0713gV2 = (C0713gV2) Preconditions.checkNotNull((C0713gV2) e());
            Parcel parcelW0 = c0713gV2.W0();
            AbstractC1777yK2.a(parcelW0, objectWrapper);
            AbstractC1777yK2.b(parcelW0, zzsVar);
            Parcel parcelX0 = c0713gV2.X0(1, parcelW0);
            FaceParcel[] faceParcelArr = (FaceParcel[]) parcelX0.createTypedArray(FaceParcel.CREATOR);
            parcelX0.recycle();
            O90[] o90Arr = new O90[faceParcelArr.length];
            for (int i = 0; i < faceParcelArr.length; i++) {
                FaceParcel faceParcel = faceParcelArr[i];
                int i2 = faceParcel.u;
                PointF pointF = new PointF(faceParcel.v, faceParcel.w);
                LandmarkParcel[] landmarkParcelArr = faceParcel.C;
                if (landmarkParcelArr == null) {
                    tc0Arr = new TC0[0];
                } else {
                    TC0[] tc0Arr2 = new TC0[landmarkParcelArr.length];
                    for (int i3 = 0; i3 < landmarkParcelArr.length; i3++) {
                        LandmarkParcel landmarkParcel = landmarkParcelArr[i3];
                        tc0Arr2[i3] = new TC0(new PointF(landmarkParcel.u, landmarkParcel.v), landmarkParcel.w);
                    }
                    tc0Arr = tc0Arr2;
                }
                zza[] zzaVarArr = faceParcel.G;
                if (zzaVarArr == null) {
                    cnArr = new CN[0];
                } else {
                    CN[] cnArr2 = new CN[zzaVarArr.length];
                    for (int i4 = 0; i4 < zzaVarArr.length; i4++) {
                        PointF[] pointFArr = zzaVarArr[i4].t;
                        cnArr2[i4] = new CN();
                    }
                    cnArr = cnArr2;
                }
                O90 o90 = new O90();
                o90.a = i2;
                o90.b = pointF;
                o90.c = faceParcel.x;
                o90.d = faceParcel.y;
                o90.e = Arrays.asList(tc0Arr);
                Arrays.asList(cnArr);
                o90Arr[i] = o90;
            }
            return o90Arr;
        } catch (RemoteException e) {
            Log.e("FaceNativeHandle", "Could not call native face detector", e);
            return new O90[0];
        }
    }
}
