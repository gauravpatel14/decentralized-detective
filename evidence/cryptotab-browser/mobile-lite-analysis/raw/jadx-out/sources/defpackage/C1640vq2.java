package defpackage;

import android.media.VolumeProvider;

/* JADX INFO: renamed from: vq2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1640vq2 extends VolumeProvider {
    public final /* synthetic */ Yl0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1640vq2(Yl0 yl0, int i, int i2, int i3, String str) {
        super(i, i2, i3, str);
        this.a = yl0;
    }

    @Override // android.media.VolumeProvider
    public final void onAdjustVolume(int i) {
        Yl0 yl0 = this.a;
        bm0 bm0Var = yl0.f.c;
        bm0Var.a.post(new Xl0(yl0, i, 1));
    }

    @Override // android.media.VolumeProvider
    public final void onSetVolumeTo(int i) {
        Yl0 yl0 = this.a;
        bm0 bm0Var = yl0.f.c;
        bm0Var.a.post(new Xl0(yl0, i, 0));
    }
}
