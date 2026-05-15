package com.google.android.gms.common.moduleinstall;

import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import defpackage.G62;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public interface ModuleInstallClient extends HasApiKey {
    G62 areModulesAvailable(OptionalModuleApi... optionalModuleApiArr);

    G62 deferredInstall(OptionalModuleApi... optionalModuleApiArr);

    G62 getInstallModulesIntent(OptionalModuleApi... optionalModuleApiArr);

    @ResultIgnorabilityUnspecified
    G62 installModules(ModuleInstallRequest moduleInstallRequest);

    G62 releaseModules(OptionalModuleApi... optionalModuleApiArr);

    @ResultIgnorabilityUnspecified
    G62 unregisterListener(InstallStatusListener installStatusListener);
}
