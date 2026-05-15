package androidx.fragment.app;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ n t;

    public /* synthetic */ i(n nVar) {
        this.t = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n nVar = this.t;
        w wVar = nVar.mViewLifecycleOwner;
        wVar.y.b(nVar.mSavedViewRegistryState);
        nVar.mSavedViewRegistryState = null;
    }
}
