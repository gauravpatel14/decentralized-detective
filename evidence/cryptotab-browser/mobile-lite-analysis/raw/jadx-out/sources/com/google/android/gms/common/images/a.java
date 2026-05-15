package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.images.ImageManager.ImageReceiver;
import com.google.android.gms.common.internal.Asserts;
import defpackage.C0110Iz2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Runnable {
    public final zag t;
    public final /* synthetic */ ImageManager u;

    public a(ImageManager imageManager, zag zagVar) {
        this.u = imageManager;
        this.t = zagVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Asserts.checkMainThread("LoadImageRunnable must be executed on the main thread");
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) this.u.zah.get(this.t);
        if (imageReceiver != null) {
            ImageManager imageManager = this.u;
            imageManager.zah.remove(this.t);
            zag zagVar = this.t;
            Asserts.checkMainThread("ImageReceiver.removeImageRequest() must be called in the main thread");
            imageReceiver.u.remove(zagVar);
        }
        zag zagVar2 = this.t;
        C0110Iz2 c0110Iz2 = zagVar2.zaa;
        Uri uri = c0110Iz2.a;
        if (uri == null) {
            ImageManager imageManager2 = this.u;
            zagVar2.zab(imageManager2.zad, imageManager2.zag, true);
            return;
        }
        Long l = (Long) this.u.zaj.get(uri);
        if (l != null) {
            if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                zag zagVar3 = this.t;
                ImageManager imageManager3 = this.u;
                zagVar3.zab(imageManager3.zad, imageManager3.zag, true);
                return;
            } else {
                ImageManager imageManager4 = this.u;
                imageManager4.zaj.remove(c0110Iz2.a);
            }
        }
        this.t.zaa(null, false, true, false);
        ImageManager imageManager5 = this.u;
        ImageManager.ImageReceiver imageReceiver2 = (ImageManager.ImageReceiver) imageManager5.zai.get(c0110Iz2.a);
        if (imageReceiver2 == null) {
            ImageManager.ImageReceiver imageReceiver3 = this.u.new ImageReceiver(c0110Iz2.a);
            ImageManager imageManager6 = this.u;
            imageManager6.zai.put(c0110Iz2.a, imageReceiver3);
            imageReceiver2 = imageReceiver3;
        }
        zag zagVar4 = this.t;
        Asserts.checkMainThread("ImageReceiver.addImageRequest() must be called in the main thread");
        imageReceiver2.u.add(zagVar4);
        zag zagVar5 = this.t;
        if (!(zagVar5 instanceof zaf)) {
            this.u.zah.put(zagVar5, imageReceiver2);
        }
        synchronized (ImageManager.zaa) {
            try {
                if (!ImageManager.zab.contains(c0110Iz2.a)) {
                    ImageManager.zab.add(c0110Iz2.a);
                    imageReceiver2.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
