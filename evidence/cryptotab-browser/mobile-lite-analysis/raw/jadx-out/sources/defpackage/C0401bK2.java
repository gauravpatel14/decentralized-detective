package defpackage;

import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.api.Status;

/* JADX INFO: renamed from: bK2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0401bK2 implements sy {
    public final Status t;
    public final ApplicationMetadata u;
    public final String v;
    public final String w;
    public final boolean x;

    public C0401bK2(Status status, ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
        this.t = status;
        this.u = applicationMetadata;
        this.v = str;
        this.w = str2;
        this.x = z;
    }

    @Override // defpackage.sy
    public final String J() {
        return this.v;
    }

    @Override // defpackage.sy
    public final ApplicationMetadata c2() {
        return this.u;
    }

    @Override // defpackage.sy
    public final String g1() {
        return this.w;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.t;
    }

    @Override // defpackage.sy
    public final boolean n() {
        return this.x;
    }

    public C0401bK2(Status status) {
        this(status, null, null, null, false);
    }
}
