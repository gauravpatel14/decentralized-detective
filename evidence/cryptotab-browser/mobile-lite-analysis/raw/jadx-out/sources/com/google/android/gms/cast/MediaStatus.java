package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import defpackage.AbstractC0700gL2;
import defpackage.C1728xN0;
import defpackage.HE2;
import defpackage.WN0;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@VisibleForTesting
@SafeParcelable.Class(creator = "MediaStatusCreator")
@SafeParcelable.Reserved({1})
public class MediaStatus extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new HE2();
    public long A;
    public double B;
    public boolean C;
    public long[] D;
    public int E;
    public int F;
    public String G;
    public JSONObject H;
    public int I;
    public boolean K;
    public AdBreakStatus L;
    public VideoInfo M;
    public C1728xN0 N;
    public WN0 O;
    public MediaInfo t;
    public long u;
    public int v;
    public double w;
    public int x;
    public int y;
    public long z;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final ArrayList f22J = new ArrayList();
    public final SparseArray P = new SparseArray();

    public MediaStatus(MediaInfo mediaInfo, long j, int i, double d, int i2, int i3, long j2, long j3, double d2, boolean z, long[] jArr, int i4, int i5, String str, int i6, ArrayList arrayList, boolean z2, AdBreakStatus adBreakStatus, VideoInfo videoInfo) {
        this.t = mediaInfo;
        this.u = j;
        this.v = i;
        this.w = d;
        this.x = i2;
        this.y = i3;
        this.z = j2;
        this.A = j3;
        this.B = d2;
        this.C = z;
        this.D = jArr;
        this.E = i4;
        this.F = i5;
        this.G = str;
        if (str != null) {
            try {
                this.H = new JSONObject(this.G);
            } catch (JSONException unused) {
                this.H = null;
                this.G = null;
            }
        } else {
            this.H = null;
        }
        this.I = i6;
        if (arrayList != null && !arrayList.isEmpty()) {
            h2((MediaQueueItem[]) arrayList.toArray(new MediaQueueItem[arrayList.size()]));
        }
        this.K = z2;
        this.L = adBreakStatus;
        this.M = videoInfo;
    }

    public final boolean equals(Object obj) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaStatus)) {
            return false;
        }
        MediaStatus mediaStatus = (MediaStatus) obj;
        return (this.H == null) == (mediaStatus.H == null) && this.u == mediaStatus.u && this.v == mediaStatus.v && this.w == mediaStatus.w && this.x == mediaStatus.x && this.y == mediaStatus.y && this.z == mediaStatus.z && this.B == mediaStatus.B && this.C == mediaStatus.C && this.E == mediaStatus.E && this.F == mediaStatus.F && this.I == mediaStatus.I && Arrays.equals(this.D, mediaStatus.D) && AbstractC0700gL2.a(Long.valueOf(this.A), Long.valueOf(mediaStatus.A)) && AbstractC0700gL2.a(this.f22J, mediaStatus.f22J) && AbstractC0700gL2.a(this.t, mediaStatus.t) && ((jSONObject = this.H) == null || (jSONObject2 = mediaStatus.H) == null || JsonUtils.areJsonValuesEquivalent(jSONObject, jSONObject2)) && this.K == mediaStatus.K && AbstractC0700gL2.a(this.L, mediaStatus.L) && AbstractC0700gL2.a(this.M, mediaStatus.M) && AbstractC0700gL2.a(this.N, mediaStatus.N) && Objects.equal(this.O, mediaStatus.O);
    }

    public final boolean f2(long j) {
        return (j & this.A) != 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01ec A[PHI: r0
      0x01ec: PHI (r0v12 int) = (r0v11 int), (r0v44 int) binds: [B:114:0x01c9, B:121:0x01e7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0378 A[PHI: r9 r25
      0x0378: PHI (r9v18 int) = (r9v3 int), (r9v19 int) binds: [B:227:0x038c, B:222:0x0376] A[DONT_GENERATE, DONT_INLINE]
      0x0378: PHI (r25v2 java.lang.String) = (r25v0 java.lang.String), (r25v4 java.lang.String) binds: [B:227:0x038c, B:222:0x0376] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x0640  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x0649  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x0697  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x06a0  */
    /* JADX WARN: Removed duplicated region for block: B:435:0x06bd  */
    /* JADX WARN: Removed duplicated region for block: B:438:0x06cf  */
    /* JADX WARN: Removed duplicated region for block: B:439:0x06dc  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x06ff  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x0704  */
    /* JADX WARN: Removed duplicated region for block: B:466:0x042e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:491:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v58 */
    /* JADX WARN: Type inference failed for: r3v65, types: [int] */
    /* JADX WARN: Type inference failed for: r3v66 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int g2(int r37, org.json.JSONObject r38) {
        /*
            Method dump skipped, instruction units count: 2046
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaStatus.g2(int, org.json.JSONObject):int");
    }

    public final void h2(MediaQueueItem[] mediaQueueItemArr) {
        ArrayList arrayList = this.f22J;
        arrayList.clear();
        SparseArray sparseArray = this.P;
        sparseArray.clear();
        for (int i = 0; i < mediaQueueItemArr.length; i++) {
            MediaQueueItem mediaQueueItem = mediaQueueItemArr[i];
            arrayList.add(mediaQueueItem);
            sparseArray.put(mediaQueueItem.u, Integer.valueOf(i));
        }
    }

    public final int hashCode() {
        return Objects.hashCode(this.t, Long.valueOf(this.u), Integer.valueOf(this.v), Double.valueOf(this.w), Integer.valueOf(this.x), Integer.valueOf(this.y), Long.valueOf(this.z), Long.valueOf(this.A), Double.valueOf(this.B), Boolean.valueOf(this.C), Integer.valueOf(Arrays.hashCode(this.D)), Integer.valueOf(this.E), Integer.valueOf(this.F), String.valueOf(this.H), Integer.valueOf(this.I), this.f22J, Boolean.valueOf(this.K), this.L, this.M, this.N, this.O);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        JSONObject jSONObject = this.H;
        this.G = jSONObject == null ? null : jSONObject.toString();
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.t, i, false);
        SafeParcelWriter.writeLong(parcel, 3, this.u);
        SafeParcelWriter.writeInt(parcel, 4, this.v);
        SafeParcelWriter.writeDouble(parcel, 5, this.w);
        SafeParcelWriter.writeInt(parcel, 6, this.x);
        SafeParcelWriter.writeInt(parcel, 7, this.y);
        SafeParcelWriter.writeLong(parcel, 8, this.z);
        SafeParcelWriter.writeLong(parcel, 9, this.A);
        SafeParcelWriter.writeDouble(parcel, 10, this.B);
        SafeParcelWriter.writeBoolean(parcel, 11, this.C);
        SafeParcelWriter.writeLongArray(parcel, 12, this.D, false);
        SafeParcelWriter.writeInt(parcel, 13, this.E);
        SafeParcelWriter.writeInt(parcel, 14, this.F);
        SafeParcelWriter.writeString(parcel, 15, this.G, false);
        SafeParcelWriter.writeInt(parcel, 16, this.I);
        SafeParcelWriter.writeTypedList(parcel, 17, this.f22J, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.K);
        SafeParcelWriter.writeParcelable(parcel, 19, this.L, i, false);
        SafeParcelWriter.writeParcelable(parcel, 20, this.M, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
